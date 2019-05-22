package RojoNegro;

/* Class RBTree */
public class ArbolRojoNegro<K extends Comparable<K>>{

    //the root node
    private NodoRojoNegro<K> mRaiz = null;

    public K encontrar(K k) {
        NodoRojoNegro<K> nodo = search(k);
        if (nodo == null) {
            return null;
        } else {
            return search(k).getKey();
        }
    }

    public boolean eliminar(K k) {
        NodoRojoNegro<K> nodo = search(k);
        if (nodo == null) {
            return false;
        } else {
            eliminar(nodo);
            return true;
        }
    }

    public boolean anadir(K k) {
        NodoRojoNegro<K> nodo = search(k);
        if (nodo == null) {
            insertar(new NodoRojoNegro<K>(k));
            return true;
        } else {
            return false;
        }
    }

    public boolean update(K k) {
        // encontrar el nodo con la clave dada
        NodoRojoNegro<K> actualizarNodo = search(k);
        if (actualizarNodo == null) {
            return false;
        } else {
            actualizarNodo.setKey(k);
            return true;
        }
    }

    /**
     * inserta un nuevo nodo en nuestro árbol negro rojo
     * @param newNodo
     */
    private void insertar(NodoRojoNegro<K> newNodo) {
        verificarNull(newNodo);
        NodoRojoNegro<K> y = null;
        NodoRojoNegro<K> x = mRaiz;
        while (x != null) {
            y = x;
            if (newNodo.getKey().compareTo(x.getKey()) < 0) {
                x = x.getIzquierda();
            }else{
                x = x.getDerecha();
            }
        }
        // establece que el padre de x sea el padre de newNodo
        newNodo.setPadre(y);
        // si el padre de newNodo es nulo, entonces newNode es la raíz
        if (y == null) {
            mRaiz = newNodo;
//            place the newNode as the left/right child of its parent according to its value
        } else if (newNodo.getKey().compareTo(y.getKey()) < 0) {
            y.setIzquierda(newNodo);
        }else{
            y.setDerecha(newNodo);
        }
        //fix the tree
        insertarCcorreccion(newNodo);
    }


    /**
     * fijar el árbol después de la inserción de un nuevo nodo
     * @param newNodo
     */
    private void insertarCcorreccion(NodoRojoNegro<K> newNodo) {
        NodoRojoNegro<K> tio;
        while (esRojo(newNodo.getPadre())) {
            if (newNodo.getPadre() == newNodo.getPadre().getPadre().getIzquierda()) {
                //the uncle is grandfather's right son
                tio = newNodo.getPadre().getPadre().getDerecha();
                if (esRojo(tio)) {
                    // case 1
                    newNodo.getPadre().setColor(Color.BLACK);
                    tio.setColor(Color.BLACK);
                    newNodo.getPadre().getPadre().setColor(Color.RED);
                    newNodo = newNodo.getPadre().getPadre();
                } else if (newNodo == newNodo.getPadre().getDerecha()) {
                    // case 2
                    newNodo = newNodo.getPadre();
                    girarIzquierda(newNodo);
                } else {
                    // case 3
                    newNodo.getPadre().setColor(Color.BLACK);
                    newNodo.getPadre().getPadre().setColor(Color.RED);
                    girarDerecha(newNodo.getPadre().getPadre());
                }
            } else {   
                // estamos en una rama inclinada hacia la derecha
                // el tío es la rama izquierda del abuelo
                tio = newNodo.getPadre().getPadre().getIzquierda();
                if (esRojo(tio)) {
//                    case 1
                    newNodo.getPadre().setColor(Color.BLACK);
                    tio.setColor(Color.BLACK);
                    newNodo.getPadre().getPadre().setColor(Color.RED);
                    newNodo = newNodo.getPadre().getPadre();
                } else if (newNodo == newNodo.getPadre().getIzquierda()) {
//                    case 2
                    newNodo = newNodo.getPadre();
                    girarDerecha(newNodo);
                } else {
//                    case 3
                    newNodo.getPadre().setColor(Color.BLACK);
                    newNodo.getPadre().getPadre().setColor(Color.RED);
                    girarIzquierda(newNodo.getPadre().getPadre());
                }
            }
        }
        mRaiz.setColor(Color.BLACK);
    }

    /**
     * Método de eliminación de árbol.
     * ¡El nodo a eliminar no debe ser nulo y debe estar dentro del árbol!
     */
    private void eliminar(NodoRojoNegro<K> delNodo) {
        verificarNull(delNodo);
        NodoRojoNegro<K> y;
        NodoRojoNegro<K> x;
        Color tempColor = null;
        if (delNodo.getIzquierda() == null || delNodo.getDerecha() == null) {
            y = delNodo;
        } else {
            y = arbolSucesor(delNodo);
        }
        if (y.getIzquierda() != null) {
            x = y.getIzquierda();
        } else {
            x = y.getDerecha();
        }
        if (x != null) {
            x.setPadre(y.getPadre());
        }

        if (y.getPadre() == null) {
            mRaiz = x;
        } else if (y == y.getPadre().getIzquierda()) {
            y.getPadre().setIzquierda(x);
        } else {
            y.getPadre().setDerecha(x);
        }
        if (y != delNodo) {
            delNodo.setKey(y.getKey());
        }
        if (esNegro(y) && x != null) {
            eliminarCorregir(x);
        }
    }

    /**
     * ayuda de reparación.
     *
     * @param x Node to fix.
     */
    private void eliminarCorregir(NodoRojoNegro<K> x) {
        NodoRojoNegro<K> w;
        while (x != mRaiz && esNegro(x)) {
            if (x == x.getPadre().getIzquierda()) {
                w = x.getPadre().getDerecha();
                if (w.getColor() == Color.RED) {
//                    case 1
                    w.setColor(Color.BLACK);
                    x.getPadre().setColor(Color.RED);
                    girarIzquierda(x.getPadre());
                    w = x.getPadre().getDerecha();
                }
                if (w.getIzquierda().getColor() == Color.BLACK && w.getDerecha().getColor() == Color.BLACK) {
//                    case 2
                    w.setColor(Color.RED);
                    x = x.getPadre();
                } else {
                    if (w.getDerecha().getColor() == Color.BLACK) {
//                        case 3
                        w.getIzquierda().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        girarDerecha(w);
                        w = x.getPadre().getDerecha();
                    }
//                    case 4
                    w.setColor(x.getPadre().getColor());
                    x.getPadre().setColor(Color.BLACK);
                    w.getDerecha().setColor(Color.BLACK);
                    girarIzquierda(x.getPadre());
                    x = mRaiz;
                }
            } else {
                w = x.getPadre().getIzquierda();
                if (w.getColor() == Color.RED) {
//                    case 1
                    w.setColor(Color.BLACK);
                    x.getPadre().setColor(Color.RED);
                    girarDerecha(x.getPadre());
                    w = x.getPadre().getIzquierda();
                }
                if (w.getDerecha().getColor() == Color.BLACK && w.getIzquierda().getColor() == Color.BLACK) {
//                    case 2
                    w.setColor(Color.RED);
                    x = x.getPadre();
                } else {
                    if (w.getIzquierda().getColor() == Color.BLACK) {
//                        case 3
                        w.getDerecha().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        girarIzquierda(w);
                        w = x.getPadre().getIzquierda();
                    }
//                    case 4
                    w.setColor(x.getPadre().getColor());
                    x.getPadre().setColor(Color.BLACK);
                    w.getIzquierda().setColor(Color.BLACK);
                    girarDerecha(x.getPadre());
                    x = mRaiz;
                }
            }
        }
    }

    /**
     * comprueba si un nodo es rojo (un nodo nulo es negro)
     */
    private boolean esRojo(NodoRojoNegro<K> nodo) {
        return nodo != null && nodo.getColor() == Color.RED;
    }

    /**
     * compruebe si un nodo es negro (un nodo nulo es negro)
     */
    private boolean esNegro(NodoRojoNegro<K> nodo) {
        return nodo == null || nodo.getColor() == Color.BLACK;
    }

    /**
     * devuelve el nodo en el árbol que contiene la clave dada como parámetro, de lo contrario, nulo
     */
    private NodoRojoNegro<K> search(K key) {
        verificarNull((NodoRojoNegro<K>) key);
        NodoRojoNegro<K> currentNodo;
        currentNodo = mRaiz;

        while (currentNodo != null && key.compareTo(currentNodo.getKey()) != 0) {
            if (key.compareTo(currentNodo.getKey()) < 0) {
                currentNodo = currentNodo.getIzquierda();
            } else {
                currentNodo = currentNodo.getDerecha();
            }
        }
        return currentNodo;
    }

    /**
     * Encuentra el árbol sucesor de un nodo dado como parámetro.
     */
    private NodoRojoNegro<K> arbolSucesor(NodoRojoNegro<K> x) {
        NodoRojoNegro<K> y;
        if (x.getDerecha() != null) {
            return arbolMinumo(x.getDerecha());
        }
        y = x.getPadre();
        while (y != null && x == y.getDerecha()) {
            x = y;
            y = y.getPadre();
        }
        return y;
    }

    /**
     * Encuentra la llave mínima del árbol.
     */
    private NodoRojoNegro<K> arbolMinumo(NodoRojoNegro<K> x) {
        while (x.getIzquierda() != null) {
            x = x.getIzquierda();
        }
        return x;
    }


    /**
     * rotación derecha
     * @param x
     */
    private void girarDerecha(NodoRojoNegro<K> x) {
        verificarNull(x);
        NodoRojoNegro<K> y;
        y = x.getIzquierda();
        x.setIzquierda(y.getDerecha());
        if (y.getDerecha() != null) {
            y.getDerecha().setPadre(x);
        }
        y.setPadre(x.getPadre());
        if (x.getPadre() == null) {
            mRaiz = y;
        } else {
            if (x == x.getPadre().getDerecha()) {
                x.getPadre().setDerecha(y);
            } else {
                x.getPadre().setIzquierda(y);
            }
        }
        y.setDerecha(x);
        x.setPadre(y);
    }

    /**
     * rotacion izquierda
     * @param x
     */
    private void girarIzquierda(NodoRojoNegro<K> x) {
        NodoRojoNegro<K> y;
        y = x.getDerecha();
        x.setDerecha(y.getIzquierda());
        if (y.getIzquierda() != null) {
            y.getIzquierda().setPadre(x);
        }
        y.setPadre(x.getPadre());
        if (x.getPadre() == null) {
            mRaiz = y;
        } else {
            if (x == x.getPadre().getIzquierda()) {
                x.getPadre().setIzquierda(y);
            } else {
                x.getPadre().setDerecha(y);
            }
        }
        y.setIzquierda(x);
        x.setPadre(y);
    }
    
    public boolean eliminarTodo() {      
        return false;
    }
    
    private void verificarNull(NodoRojoNegro<K> newNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
