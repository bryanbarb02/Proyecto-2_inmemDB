package AVL;

class NodoAVL<T extends Comparable<? super T>> {
    private NodoAVL<T> padre;
    private NodoAVL<T> derecha;
    private NodoAVL<T> izquierda;
    private T dato;

    public NodoAVL(T dato) {
        this(dato, null, null, null);
    }

    public NodoAVL(T dato, NodoAVL<T> padre, NodoAVL<T> izquierda, NodoAVL<T> derecha) {
        this.dato = dato;
        this.padre = padre;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public NodoAVL<T> padre() {
        return padre;
    }

    public NodoAVL<T> izquierda() {
        return izquierda;
    }

    public NodoAVL<T> masIzquierda() {
        if (izquierda != null) {
            return izquierda().masIzquierda();
        } else {
            return this;
        }
    }

    public NodoAVL<T> derecha() {
        return derecha;
    }

    public NodoAVL<T> masDerecha() {
        if (derecha != null) {
            return derecha.masDerecha();
        } else {
            return this;
        }
    }

    public T dato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setPadre(NodoAVL<T> padre) {
        this.padre = padre;

        if (this.izquierda != null && this.izquierda.padre != this) {
            this.izquierda.setPadre(this);
        }

        if (this.derecha != null && this.derecha.padre != this) {
            this.derecha.setPadre(this);
        }
    }

    public void setDerecha(NodoAVL<T> derecha) {
        if (!((derecha == null) || (dato.compareTo(derecha.dato()) == -1))) {
            throw new RuntimeException("Cannot set " + derecha.dato + " to be right of " + dato);
        }

        this.derecha = derecha;

        if (this.derecha != null) {
            this.derecha.setPadre(this);
        }
    }

    public void setIzquierda(NodoAVL<T> izquierda) {
        if (!((izquierda == null) || (dato.compareTo(izquierda.dato()) == 1))) {
            throw new RuntimeException("Cannot set " + derecha.dato + " to be left of " + dato);
        }

        this.izquierda = izquierda;

        if (this.izquierda != null) {
            this.izquierda.setPadre(this);
        }
    }

    public boolean esHoja() {
        return ((izquierda == null) && (derecha == null));
    }

    public int alturaIzquierda() {
        if (izquierda == null) {
            return 0;
        } else {
            return izquierda.height();
        }
    }

    public int alturaDerecha() {
        if (derecha == null) {
            return 0;
        } else {
            return derecha.height();
        }
    }

    public int height() {
        return 1 + Math.max(alturaIzquierda(), alturaDerecha());
    }

    public int depth() {
        if (padre == null) {
            return 0;
        } else {
            return 1 + padre.depth();
        }
    }

    public boolean esBalanceado() {
        if (esHoja()) {
            return true;
        } else {
            boolean izquierdaEsBalanceado = (izquierda == null || izquierda.esBalanceado());
            boolean derechaEsBalanceado = (derecha == null || derecha.esBalanceado());
            boolean currentEsBalanceado = (Math.abs(alturaDerecha() - alturaIzquierda()) <= 1);

            return currentEsBalanceado && izquierdaEsBalanceado && derechaEsBalanceado;
        }
    }

    public reemplazoNodoHijo reemplazo(NodoAVL<T> hijoViejo) {
        return new reemplazoNodoHijo(hijoViejo);
    }

    public class reemplazoNodoHijo {
        private NodoAVL<T> hijoViejo;

        public reemplazoNodoHijo(NodoAVL<T> hijoviejo) {
            if ((hijoviejo == izquierda || hijoviejo == derecha)) {
                this.hijoViejo = hijoviejo;
            }
        }

        public void with(NodoAVL<T> newHijo) {
            if (hijoViejo == izquierda) {
                setIzquierda(newHijo);
            } else if (hijoViejo == derecha) {
                setDerecha(newHijo);
            }
        }
    }
}
