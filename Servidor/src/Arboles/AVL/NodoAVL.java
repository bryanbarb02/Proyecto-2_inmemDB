
package AVL;

/**
 *
 * @author Bryan
 */
public class NodoAVL<T extends Comparable<T>> {
    T key;
    NodoAVL izquierda;
    NodoAVL derecha;
    int altura;

    public NodoAVL(T valor){
        key = valor;
        izquierda = null;
        derecha = null;
        altura = 0;
    }
    public NodoAVL(NodoAVL<T> nodo){
        this.key = nodo.key;
        this.derecha = nodo.derecha;
        this.izquierda = nodo.izquierda;
        this.altura = 0;

    }
}