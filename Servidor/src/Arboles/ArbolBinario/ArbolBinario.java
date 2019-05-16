
package ArbolBinario;

/**
 *
 * @author Bryan
 */
public class ArbolBinario<T extends Comparable<? super T>> {
    NodoBinario<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public boolean contains(T elemento) {
        return this.contains(elemento, this.raiz);
    }

    private boolean contains(T elemento, NodoBinario<T> NodoB) {
        if (NodoB == null) {
            return false;
        } else {
            int compararResultado = elemento.compareTo(NodoB.elemento);

            if (compararResultado < 0)
                return contains(elemento, NodoB.izquierda);
            else if (compararResultado > 0)
                return contains(elemento, NodoB.derecha);
            else
                return true;
        }
    }

    NodoBinario<T> findMin(NodoBinario<T> NodoB) {
        if (NodoB == null)
            return null;
        else if (NodoB.izquierda == null)
            return NodoB;
        else
            return findMin(NodoB.izquierda);
    }
    private NodoBinario<T> findMax(NodoBinario<T> NodoB) {
        if (NodoB!= null)
            while (NodoB.derecha != null) {
                NodoB = NodoB.derecha;
            }
        return NodoB;
    }

    public void insertar(T elemento) {
        this.raiz = this.insertar(elemento, this.raiz);
    }

    public NodoBinario<T> insertar(T elemento, NodoBinario<T> current) {
        if (current == null)
            return new NodoBinario<T>(elemento, null, null);

        int compararResultado = elemento.compareTo(current.elemento);

        if (compararResultado < 0)
            current.izquierda = this.insertar(elemento, current.izquierda);
        else if (compararResultado > 0)
            current.derecha = this.insertar(elemento, current.derecha);

        return current;
    }

    public void remover(T elemento) {
        this.raiz = this.remover(elemento, this.raiz);
    }

    public NodoBinario<T> remover(T elemento, NodoBinario<T> NodoB) {
        if (NodoB == null)
            return NodoB;

        int compararResultado = elemento.compareTo(NodoB.elemento);

        if (compararResultado < 0)
            NodoB.izquierda= remover(elemento, NodoB.izquierda);
        else if (compararResultado > 0)
            NodoB.derecha = remover(elemento, NodoB.derecha);
        else if (NodoB.izquierda != null && NodoB.derecha != null){
            NodoB.elemento = findMin(NodoB.derecha).elemento;
            NodoB.derecha = remover(NodoB.elemento, NodoB.derecha);
        } else {
            NodoB = NodoB.izquierda != null ? NodoB.izquierda : NodoB.derecha;
        }
        return NodoB;
    }
}