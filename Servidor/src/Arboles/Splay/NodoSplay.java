package Splay;

public class NodoSplay implements Comparable<NodoSplay> {
    private NodoSplay padre;
    private NodoSplay hijoIzquierda;
    private NodoSplay hijoDerecha;
    private Entrada entrada;

    public NodoSplay(Entrada entrada) {
        this.entrada = entrada;
    }

    public NodoSplay getPadre() {
        return padre;
    }

    public void setPadre(NodoSplay padre) {
        this.padre = padre;
    }

    public NodoSplay getHijoIzquierda() {
        return hijoIzquierda;
    }

    public void setHijoIzquierda(NodoSplay hijoIzquierda) {
        this.hijoIzquierda = hijoIzquierda;
    }

    public NodoSplay getHijoDerecha() {
        return hijoDerecha;
    }

    public void setHijoDerecha(NodoSplay hijoDerecha) {
        this.hijoDerecha = hijoDerecha;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntry(Entrada entrada) {
        this.entrada = entrada;
    }

    @Override
    public int compareTo(NodoSplay that) {
        return this.entrada.compareTo(that.entrada);

    }

    public void inOrder() {
        if (this.getHijoIzquierda() != null) {
            this.getHijoIzquierda().inOrder();
        }
        this.visitar();
        if (this.getHijoDerecha() != null) {
            this.getHijoDerecha().inOrder();
        }
    }


    private void visitar() {
        System.out.println(this.entrada);
    }

    public cualHijo encontrarHijo() {
        NodoSplay padre = this.getPadre();
        if (padre == null) {
            return cualHijo.NO_ES_HIJO;
        }

        if (padre.getHijoIzquierda()!=null &&  padre.getHijoIzquierda().equals(this)) {
            return cualHijo.HIJOIZQUIERDA;
        } else {
            return cualHijo.HIJODERECHA;
        }

    }

    public boolean tieneAbuelo() {
        boolean tieneAbuelo=  false;
        NodoSplay padre = this.getPadre();
        if (padre != null) {
            tieneAbuelo = padre.getPadre() != null ? true : false;
        }
        return tieneAbuelo;
    }

    @Override
    public String toString() {
        return this.entrada.toString();
    }


}
