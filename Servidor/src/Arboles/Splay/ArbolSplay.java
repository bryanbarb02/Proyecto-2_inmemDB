package Splay;

public class ArbolSplay {
    NodoSplay raiz;

    public ArbolSplay() {

    }

    public void insertar(Entrada entry) {
        NodoSplay newNodo = new NodoSplay(entry);
        if (raiz == null) {
            raiz = newNodo;
        } else {
            NodoSplay ultimoNodoNulo = encontrarUltimoNodoBusqueda(entry.getKey());
            if (entry.compareTo(ultimoNodoNulo.getEntrada()) > 0) {
                // La nueva entrada es más grande, por lo tanto será un niño adecuado.
                ultimoNodoNulo.setHijoDerecha(newNodo);
            } else {
                // Entradas iguales o menores van a la izquierda
                ultimoNodoNulo.setHijoIzquierda(newNodo);
            }
            newNodo.setPadre(ultimoNodoNulo);
            balancearArbol(newNodo);
        }

    }

    public Entrada encontrar(int key) {
        NodoSplay untimoNodoEnBusqueda = encontrarUltimoNodoBusqueda(key);
        balancearArbol(untimoNodoEnBusqueda);
        Entrada entrdaMasCercana = untimoNodoEnBusqueda.getEntrada();

        return entrdaMasCercana;
    }

    private void balancearArbol(NodoSplay nodoToSplay) {
        NodoSplay padre = nodoToSplay.getPadre();
        NodoSplay abuelo = null;
        if (padre != null) {
            abuelo = padre.getPadre();
        }

        if (abuelo == null) {
            rotarAtravesPadre(nodoToSplay);
        } else {
            splayNodoConAbuelo(nodoToSplay);
        }

    }

    private void splayNodoConAbuelo(NodoSplay nodoToSplay) {
        NodoSplay padre = nodoToSplay.getPadre();
        NodoSplay abuelo = padre.getPadre();

        if (nodoToSplay.encontrarHijo().equals(cualHijo.HIJOIZQUIERDA) && padre.encontrarHijo().equals(cualHijo.HIJOIZQUIERDA)
                ||
                nodoToSplay.encontrarHijo().equals(cualHijo.HIJODERECHA) && padre.encontrarHijo().equals(cualHijo.HIJODERECHA)) {
            // Hijo izquierdo de un hijo izquierdo o derecho o un hijo derecho
            rotarAtravesPadre(padre);
        } else {
            rotarAtravesPadre(nodoToSplay);
        }

        rotarAtravesPadre(nodoToSplay);

        if (nodoToSplay.tieneAbuelo()) {
            splayNodoConAbuelo(nodoToSplay);
        } else if (nodoToSplay.getPadre() != null) {
            rotarAtravesPadre(nodoToSplay);
        }
    }

    private NodoSplay encontrarUltimoNodoBusqueda(Comparable key) {
        NodoSplay nodo = raiz;
        NodoSplay ultimoNodoNoNulo = nodo;

        while (nodo != null) {
            if (key.compareTo(ultimoNodoNoNulo.getEntrada().getKey()) == 0) {
                return ultimoNodoNoNulo;
            }

            if (key.compareTo(nodo.getEntrada().getKey()) > 0) {
                // La entrada es más grande. Ir a la derecha para encontrar un partido
                nodo = nodo.getHijoDerecha();
            } else {
                // Hemos decidido introducir claves iguales en el lado izquierdo.
                // Por lo tanto, vamos a la izquierda por menos o igual
                nodo = nodo.getHijoIzquierda();
            }

            if (nodo != null) {
                ultimoNodoNoNulo = nodo;
            }

        }
        return ultimoNodoNoNulo;
    }

    public void printOrdenados() {
        raiz.inOrder();
    }

    // todo mueve esto a la clase de nodo de árbol
    private void rotarAtravesPadre(NodoSplay splayNodo) {

        // Conservar todas las referencias a los nodos.
        NodoSplay padre = splayNodo.getPadre();
        NodoSplay abuelo = padre.getPadre();
        cualHijo cualHijoEsPadre = cualHijo.NO_ES_HIJO;
        if (abuelo != null) {
            cualHijoEsPadre = padre.encontrarHijo();
        }

        if (splayNodo.encontrarHijo().equals(cualHijo.HIJOIZQUIERDA)) {
            NodoSplay HijoDerechoSplayNodo = splayNodo.getHijoDerecha();
            padre.setHijoIzquierda(HijoDerechoSplayNodo);
            if (HijoDerechoSplayNodo != null) {
                HijoDerechoSplayNodo.setPadre(padre);
            }


            splayNodo.setHijoDerecha(padre);
        } else if (splayNodo.encontrarHijo().equals(cualHijo.HIJODERECHA)) {
            NodoSplay HijoIzquierdaSplayNodo = splayNodo.getHijoIzquierda();

            padre.setHijoDerecha(HijoIzquierdaSplayNodo);
            if (HijoIzquierdaSplayNodo != null) {
                HijoIzquierdaSplayNodo.setPadre(padre);
            }
            splayNodo.setHijoIzquierda(padre);
        }

        padre.setPadre(splayNodo);

        // establecer referencias hacia y desde el abuelo
        if (abuelo != null) {
            if (cualHijoEsPadre == cualHijo.HIJOIZQUIERDA) {
                abuelo.setHijoIzquierda(splayNodo);
            } else if (cualHijoEsPadre == cualHijo.HIJODERECHA) {
                abuelo.setHijoDerecha(splayNodo);
            }
            splayNodo.setPadre(abuelo);
        } else {
            splayNodo.setPadre(null);
            raiz = splayNodo;
        }

    }
    
        public void limpiar(){
    }


}
