package BMas;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArbolBMas<E extends Comparable<E>> {

    private int tamanoHoja;
    private int tamanoInterno;
    private NodoBMas<E> raiz;
    private int tamano;
    private NativeMethods<E> nm;
    private LinkedList<NodoBMas<E>> buffer;
    private int bufferboolTam;

    public ArbolBMas(int tamanoHoja, int tamanoInterno, int bufferbool) {
        super();
        this.tamanoHoja = tamanoHoja;
        this.tamanoInterno = tamanoInterno;
        this.raiz = new NodoBMas<E>(tamanoHoja, true);
        nm = new NativeMethods<E>();
        buffer = new LinkedList<NodoBMas<E>>();
        this.bufferboolTam = bufferbool;
    }

    // ======================================================================
    // ===========================INSERCIÓN==================================
    @SuppressWarnings("unchecked")
    public void insertarNodo(E key, Object dato) {
        LinkedList<NodoBMas<E>> stack = new LinkedList<NodoBMas<E>>();
        NodoBMas<E> n = raiz;
        while (!n.esHoja) {
            stack.push(n);
            // ===================================================
            if (key.compareTo(n.getKeys().get(0)) < 0) { 
                n = (NodoBMas<E>) n.getPunteros().get(0);
            } else if (key.compareTo(n.getKeys().get(n.getKeys().size() - 1)) >= 0) {
                n = (NodoBMas<E>) n.getPunteros().get(n.getPunteros().size() - 1);
            } else {
                for (int i = 0; i < n.getKeys().size() - 1; i++) {
                    if (n.getKeys().size() > 1 && key.compareTo(n.getKeys().get(i)) >= 0 && key.compareTo(n.getKeys().get(i + 1)) < 0) {
                        n = (NodoBMas) n.getPunteros().get(i + 1);
                        break;
                    }
                }
            }
        }
        
        for (int i = 0; i < n.getKeys().size(); i++) {
            if (key == n.getKeys().get(i)) {
                return;
            }
        }

        if (n.getKeys().size() < tamanoHoja) {
            nm.insertarOrdenado(key, dato, n);
        } else {

            NodoBMas<E> temp = new NodoBMas(tamanoHoja, true);
            temp.setKeys(new ArrayList<E>(n.getKeys()));
            temp.setPunteros(new ArrayList<Object>(n.getPunteros()));
            nm.insertarOrdenado(key, dato, temp);
            NodoBMas newNodo = new NodoBMas(tamanoHoja, true);
            int j = (int) Math.ceil(n.getPunteros().size() / (double) 2);

            n.setKeys(new ArrayList<E>(temp.getKeys().subList(0, j)));
            n.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(0, j)));

            if (n.getSiguiente() != null) {
                n.getSiguiente().setPrev(newNodo);
            }
            newNodo.setSiguiente(n.getSiguiente());
            n.setSiguiente(newNodo);

            newNodo.setPrev(n);
            newNodo.setKeys(new ArrayList<E>(temp.getKeys().subList(j, temp.getKeys().size())));
            newNodo.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(j, temp.getPunteros().size())));

            key = temp.getKeys().get(j);
            boolean terminado = false;
            do {

                if (stack.isEmpty()) {
                    raiz = new NodoBMas(tamanoInterno, false);
                    ArrayList<Object> punto = new ArrayList<Object>();
                    punto.add(n);
                    punto.add(newNodo);
                    ArrayList<E> keys_ = new ArrayList<E>();
                    keys_.add(key);
                    raiz.setKeys(keys_);
                    raiz.setPunteros(punto);
                    terminado = true;
                } else {
                    n = stack.pop();
                    if (n.getKeys().size() < tamanoInterno) {
                        nm.sortedInsertarInterna(key, newNodo, n);
                        terminado = true;
                    } else {
                        temp.setHoja(false);
                        temp.setKeys(new ArrayList<E>(n.getKeys()));
                        temp.setPunteros(new ArrayList<Object>(n.getPunteros()));

                        nm.sortedInsertarInterna(key, newNodo, temp);
                        newNodo = new NodoBMas(tamanoInterno, false);
                        j = (int) Math.ceil(temp.getPunteros().size() / (double) 2);

                        n.setKeys(new ArrayList<E>(temp.getKeys().subList(0, j - 1)));
                        n.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(0, j)));
                        if (n.getSiguiente() != null) {
                            n.getSiguiente().setPrev(newNodo);
                        }
                        newNodo.setSiguiente(n.getSiguiente());
                        n.setSiguiente(newNodo);
                        newNodo.setPrev(n);
                        newNodo.setKeys(new ArrayList<E>(temp.getKeys().subList(j, temp.getKeys().size())));
                        newNodo.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(j, temp.getPunteros().size())));

                        key = temp.getKeys().get(j - 1);
                    }
                }
            } while (!terminado);
        }
    }
//======================================BULK INSERTION=================================================

    @SuppressWarnings("unchecked")
    public void insertarBulk(ArrayList<E> keys, ArrayList<Object> records) {
        E key;
        boolean primerInsertado = true;
        int primero = 0;
        int segundo = 0;
        for (int i = 0; i < Math.ceil(keys.size() / (double) tamanoHoja); i++) {
            
            LinkedList<NodoBMas<E>> stack = new LinkedList<NodoBMas<E>>();
            NodoBMas<E> n = raiz;
            primero = segundo;
            segundo = segundo + tamanoHoja;
            if (segundo > keys.size()) {
                segundo = keys.size();
            }
            ArrayList<E> newKeys = new ArrayList<E>(keys.subList(primero, segundo));
            ArrayList<Object> newRegistros = new ArrayList<Object>(records.subList(primero, segundo));

            while (!n.esHoja) {
                stack.push(n);
                n = (NodoBMas<E>) n.getPunteros().get(n.getPunteros().size() - 1);
            }

            if (primerInsertado) {
                raiz.setKeys(newKeys);
                raiz.setPunteros(newRegistros);
                primerInsertado = false;
            } else {

                NodoBMas<E> temp = new NodoBMas(tamanoHoja, true);
                temp.setKeys(new ArrayList<E>(n.getKeys()));
                temp.setPunteros(new ArrayList<Object>(n.getPunteros()));
                temp.getKeys().addAll(newKeys);
                temp.getPunteros().addAll(newRegistros);
                NodoBMas newNodo = new NodoBMas(tamanoHoja, true);
                int j = (int) Math.ceil(temp.getPunteros().size() / (double) 2);

                n.setKeys(new ArrayList<E>(temp.getKeys().subList(0, j)));
                n.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(0, j)));
                if (n.getSiguiente() != null) {
                    n.getSiguiente().setPrev(newNodo);
                }
                newNodo.setSiguiente(n.getSiguiente());
                n.setSiguiente(newNodo);

                newNodo.setPrev(n);
                newNodo.setKeys(new ArrayList<E>(temp.getKeys().subList(j, temp.getKeys().size())));
                newNodo.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(j, temp.getPunteros().size())));
                key = temp.getKeys().get(j);
                boolean terminado = false;

                do {
                    if (stack.isEmpty()) {
                        raiz = new NodoBMas(tamanoInterno, false);
                        ArrayList<Object> punto = new ArrayList<Object>();
                        punto.add(n);
                        punto.add(newNodo);
                        ArrayList<E> keys_ = new ArrayList<E>();
                        keys_.add(key);
                        raiz.setKeys(keys_);
                        raiz.setPunteros(punto);
                        terminado = true;
                    } else {
                        n = stack.pop();
                        if (n.getKeys().size() < tamanoInterno) {
                            nm.sortedInsertarInterna(key, newNodo, n);
                            terminado = true;
                        } else {
                            temp.setHoja(false);
                            temp.setKeys(new ArrayList<E>(n.getKeys()));
                            temp.setPunteros(new ArrayList<Object>(n.getPunteros()));
                            nm.sortedInsertarInterna(key, newNodo, temp);
                            newNodo = new NodoBMas(tamanoInterno, false);
                            j = (int) Math.ceil(temp.getPunteros().size() / (double) 2);
                            n.setKeys(new ArrayList<E>(temp.getKeys().subList(0, j - 1)));
                            n.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(0, j)));
                            if (n.getSiguiente() != null) {
                                n.getSiguiente().setPrev(newNodo);
                            }
                            newNodo.setSiguiente(n.getSiguiente());
                            n.setSiguiente(newNodo);
                            newNodo.setPrev(n);
                            newNodo.setKeys(new ArrayList<E>(temp.getKeys().subList(j, temp.getKeys().size())));
                            newNodo.setPunteros(new ArrayList<Object>(temp.getPunteros().subList(j, temp.getPunteros().size())));
                            key = temp.getKeys().get(j - 1);
                        }
                    }
                } while (!terminado);
            }
        }
    }

    // ======================================================================
    // =============================SEARCHING================================
    @SuppressWarnings("unchecked")
    public NodoBMas<E> search(E key) {
        for (int i = 0; i < buffer.size(); i++) {
            ArrayList<E> encontrar = buffer.get(i).getKeys();
            if (encontrar.contains(key)) {
                return buffer.get(i);
            }
        }
        NodoBMas<E> n = raiz;
        while (!n.esHoja) {
            if (key.compareTo(n.getKeys().get(0)) < 0) {// if in the first pointer
                n = (NodoBMas<E>) n.getPunteros().get(0);
            } else if (key.compareTo(n.getKeys().get(n.getKeys().size() - 1)) >= 0) {// if in the last pointer
                n = (NodoBMas<E>) n.getPunteros().get(n.getPunteros().size() - 1);
            } else {
                for (int i = 0; i < n.getKeys().size() - 1; i++) {
                    if (n.getKeys().size() > 1 && key.compareTo(n.getKeys().get(i)) >= 0 && key.compareTo(n.getKeys().get(i + 1)) < 0) {// general case
                        n = (NodoBMas) n.getPunteros().get(i + 1);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n.getKeys().size(); i++) {
            if (key.compareTo(n.getKeys().get(i)) == 0) {
                if (buffer.size() == bufferboolTam) {
                    buffer.removeFirst();
                    buffer.add(n);
                } else {
                    buffer.add(n);
                }
                return n;
            }
        }
        return null;
    }

    // ======================================================================
    // ==============================DELETION================================
    @SuppressWarnings("unchecked")
    public void eliminar(E key) {
        LinkedList<NodoBMas<E>> stack = new LinkedList<NodoBMas<E>>();
        NodoBMas<E> n = raiz;
        while (!n.esHoja) {
            stack.push(n);
            // ===================================================
            if (key.compareTo(n.getKeys().get(0)) < 0) {
                n = (NodoBMas<E>) n.getPunteros().get(0);
            } else if (key.compareTo(n.getKeys().get(n.getKeys().size() - 1)) >= 0) {
                n = (NodoBMas) n.getPunteros().get(n.getPunteros().size() - 1);
            } else {
                for (int i = 0; i < n.getKeys().size(); i++) {
                    if (key.compareTo(n.getKeys().get(i)) >= 0 && key.compareTo(n.getKeys().get(i + 1)) < 0) {
                        n = (NodoBMas) n.getPunteros().get(i + 1);
                        break;
                    }
                }
            }
        }

        boolean flag = false;
        for (int i = 0; i < n.getKeys().size(); i++) {
            if (n == raiz && key == n.getKeys().get(i)) {
                nm.eliminarNodo(n, key);
                return;
            } else if (key == n.getKeys().get(i)) {
                flag = true;
                break;
            }
        }
        // encontrado en el nodo de la hoja
        if (flag) {
            if (n.getKeys().size() - 1 >= Math.ceil(tamanoHoja / 2.0)) {
                nm.eliminarNodo(n, key);
                NodoBMas<E> padre = stack.peek();
                for (int i = 0; i < padre.getKeys().size(); i++) {
                    if (key.compareTo(padre.getKeys().get(i)) == 0) {
                        padre.getKeys().set(i, n.getKeys().get(0));
                        break;
                    }
                }
            } else {
                NodoBMas<E> padre = stack.peek();
                int deter = nm.mismoPadre(n, stack.peek(), tamanoHoja);
                if (deter == 1) {
                    nm.eliminarNodo(n, key);
                    E elemento = n.getSiguiente().getKeys().remove(0);
                    Object obj = n.getSiguiente().getPunteros().remove(0);
                    n.getKeys().add(elemento);
                    n.getPunteros().add(obj);
                    for (int i = 0; i < padre.getKeys().size(); i++) {
                        if (elemento.compareTo(padre.getKeys().get(i)) == 0) {
                            padre.getKeys().set(i, n.getSiguiente().getKeys().get(0));
                            break;
                        }
                    }
                    for (int i = 0; i < padre.getKeys().size(); i++) {
                        if (key.compareTo(padre.getKeys().get(i)) == 0) {
                            padre.getKeys().set(i, n.getKeys().get(0));
                            break;
                        }
                    }
                    return;
                } else if (deter == 2) {
                    nm.eliminarNodo(n, key);
                    E element = n.getPrev().getKeys().remove(n.getPrev().getKeys().size() - 1);
                    Object obj = n.getPrev().getPunteros().remove(n.getPrev().getPunteros().size() - 1);
                    n.getKeys().add(0, element);
                    n.getPunteros().add(0, obj);
                    for (int i = 0; i < padre.getKeys().size(); i++) {
                        if (element.compareTo(padre.getKeys().get(i)) == 0) {
                            padre.getKeys().set(i, n.getPrev().getKeys().get(n.getPrev().getKeys().size() - 1));
                            break;
                        }
                    }
                    for (int i = 0; i < padre.getKeys().size(); i++) {
                        if (key.compareTo(padre.getKeys().get(i)) == 0) {
                            padre.getKeys().set(i, n.getKeys().get(0));
                            break;
                        }
                    }
                    return;
                } else {
                    boolean prevB = true;
                    if (key == n.getKeys().get(0)) {
                        prevB = false;
                    }

                    nm.eliminarNodo(n, key);
                    int tempKey = 0;
                    int punteroTemp=  0;   
                    // si la fusión será con el siguiente nodo
                    // luego copiando todo el nodo actual en el siguiente nodo
                    // elimina en el nodo padre
                    if (nm.mismoPadre2(padre, n)) {
                        NodoBMas<E> siguiente = n.getSiguiente();
                        if (n.getPrev() != null) {
                            n.getPrev().setSiguiente(siguiente);
                        }
                        if (siguiente != null) {
                            siguiente.setPrev(n.getPrev());
                        }
                        n.setSiguiente(null);
                        n.setPrev(null);
                        siguiente.getKeys().addAll(0, n.getKeys());
                        siguiente.getPunteros().addAll(0, n.getPunteros());
                        for (int i = 0; i < padre.getKeys().size(); i++) {
                            if (siguiente.getKeys().get(n.getKeys().size()).compareTo(padre.getKeys().get(i)) == 0) {
                                tempKey = i;
                                punteroTemp = i;
                                break;
                            }
                        }
                        if (tempKey > 0 && padre.getKeys().get(tempKey - 1) == key) {
                            padre.getKeys().set(tempKey - 1, siguiente.getKeys().get(0));
                        }
                    } else {
                        
                        // si la fusión será con el nodo anterior
                        // luego copiando todos los nodos
                        // eliminar el primer elemento del nodo actual en el nodo principal
                        NodoBMas<E> prev = n.getPrev();
                        if (prev != null) {
                            prev.setSiguiente(n.getSiguiente());
                        }
                        if (n.getSiguiente() != null) {
                            n.getSiguiente().setPrev(prev);
                        }
                        n.setSiguiente(null);
                        n.setPrev(null);
                        prev.getKeys().addAll(n.getKeys());
                        prev.getPunteros().addAll(n.getPunteros());
                        if (prevB) {
                            for (int i = 0; i < padre.getKeys().size(); i++) {
                                if (n.getKeys().get(0).compareTo(padre.getKeys().get(i)) == 0) {
                                    tempKey = i;
                                    punteroTemp = i + 1;
                                    break;
                                }
                            }
                        } else {
                            for (int i = 0; i < padre.getKeys().size(); i++) {
                                if (key.compareTo(padre.getKeys().get(i)) == 0) {
                                    tempKey = i;
                                    punteroTemp = i + 1;
                                    break;
                                }
                            }
                        }
                    }
                    boolean terminado = false;
                    do {
                        if (stack.isEmpty()) {
                            raiz.getKeys().remove(tempKey);
                            raiz.getPunteros().remove(punteroTemp);
                            terminado = true;
                        } else {
                            n = stack.pop();
                            if (n.getKeys().size() - 1 >= 1) {
                                n.getKeys().remove(tempKey);
                                n.getPunteros().remove(punteroTemp);
                                terminado = true;
                            } else {
                                // el nivel del árbol disminuirá
                                if (n == raiz) {
                                    n.getKeys().remove(tempKey);
                                    n.getPunteros().remove(punteroTemp);
                                    if (n.getPunteros().size() == 1) {
                                        raiz = (NodoBMas<E>) n.getPunteros().get(0);
                                    }
                                    terminado = true;
                                } else {
                                    n.getKeys().remove(tempKey);
                                    n.getPunteros().remove(punteroTemp);
                                    deter = nm.siguienteOrprev(n, stack.peek(), tamanoInterno);
                                    padre = stack.peek();
                                    if (deter == 1) {
                                        int indice = -1;
                                        for (int i = 0; i < padre.getPunteros().size(); i++) {
                                            if (padre.getPunteros().get(i) == n.getSiguiente()) {
                                                indice = i;
                                                break;
                                            }
                                        }
                                        E tempkey = padre.getKeys().remove(indice - 1);
                                        n.getKeys().add(tempkey);
                                        NodoBMas<E> tempSiguiente = (NodoBMas<E>) n.getSiguiente().getPunteros().remove(0);
                                        E nextKey = n.getSiguiente().getKeys().remove(0);
                                        n.getPunteros().add(tempSiguiente);
                                        padre.getKeys().add(indice - 1, nextKey);
                                        terminado = true;
                                    } else if (deter == 2) {
                                        int indice = -1;
                                        for (int i = 0; i < padre.getPunteros().size(); i++) {
                                            if (padre.getPunteros().get(i) == n) {
                                                indice = i;
                                                break;
                                            }
                                        }
                                        E tempkey = padre.getKeys().remove(indice - 1);
                                        n.getKeys().add(0, tempkey);
                                        NodoBMas<E> tempPrev = (NodoBMas<E>) n.getPrev().getPunteros().remove(n.getPrev().getPunteros().size() - 1);
                                        E prevKey = n.getPrev().getKeys().remove(n.getPrev().getKeys().size() - 1);
                                        n.getPunteros().add(0, tempPrev);
                                        padre.getKeys().add(indice - 1, prevKey);
                                        terminado = true;
                                    } else {
                                        if (nm.mismoPadre2(padre, n)) {
                                            for (int i = 0; i < padre.getPunteros().size(); i++) {
                                                if (n == padre.getPunteros().get(i)) {
                                                    tempKey = i;
                                                    punteroTemp = i;
                                                    break;
                                                }
                                            }
                                            NodoBMas<E> siguiente = n.getSiguiente();
                                            if (n.getPrev() != null) {
                                                n.getPrev().setSiguiente(siguiente);
                                            }
                                            if (siguiente != null) {
                                                siguiente.setPrev(n.getPrev());
                                            }
                                            siguiente.getKeys().add(0, padre.getKeys().get(tempKey));
                                            siguiente.getKeys().addAll(0, n.getKeys());
                                            siguiente.getPunteros().addAll(0, n.getPunteros());

                                        } else {
                                            for (int i = 0; i < padre.getPunteros().size(); i++) {
                                                if (n == padre.getPunteros().get(i)) {
                                                    tempKey = i - 1;
                                                    punteroTemp = i;
                                                    break;
                                                }
                                            }
                                            NodoBMas<E> prev = n.getPrev();
                                            if (prev != null) {
                                                prev.setSiguiente(n.getSiguiente());
                                            }
                                            if (n.getSiguiente() != null) {
                                                n.getSiguiente().setPrev(prev);
                                            }
                                            prev.getKeys().add(padre.getKeys().get(tempKey));
                                            prev.getKeys().addAll(n.getKeys());
                                            prev.getPunteros().addAll(n.getPunteros());
                                        }
                                    }
                                }
                            }
                        }
                    } while (!terminado);

                }
            }
        } else { // si no se encuentra el elemento
            return;
        }
    }

// ======================================================================
// ===========================GETTERS AND SETTERS========================
    public int getTamanoHoja() {
        return tamanoHoja;
    }

    public void setTamanoHoja(int tamanoHoja) {
        this.tamanoHoja = tamanoHoja;
    }

    public int getTamInterno() {
        return tamanoInterno;
    }

    public void setTamInterno(int tamanoInterno) {
        this.tamanoInterno = tamanoInterno;
    }

    public NodoBMas<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoBMas<E> raiz) {
        this.raiz = raiz;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;


    }

    @SuppressWarnings("unchecked")
    public String print() {
        String s = "";
        LinkedList<NodoBMas<E>> ver = new LinkedList<NodoBMas<E>>();
        ver.add(raiz);
        while (!ver.isEmpty()) {
            NodoBMas<E> e = ver.pop();
            for (int i = 0; i
                    < e.getKeys().size(); i++) {
                s += (e.getKeys().get(i) + " ");
            }
            for (int i = 0; i < e.getPunteros().size(); i++) {
                try {
                    ver.add((NodoBMas<E>) e.getPunteros().get(i));
                } catch (Exception e1) {
                }
            }
            s += "\n";
        }
        return s;
    }
}
