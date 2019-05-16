package B;

public interface ITree<T> {

    /**
     * caminoCompletoAgrega un valor al árbol. Un árbol puede contener varios valores idénticos.
     */
    public boolean anadir(T value);

    /**
     * Elimina el primer valor encontrado del árbol.
     */
    public T remover(T value);

    /**
     * Elimina un árbol entero.
     */
    public void limpiar();

    /**
     * Hace tal valor en el árbol.
     */
    public boolean contains(T value);

    /**
     * Devuelve el número de nodos en el árbol.
     */
    public int tamano();

    /**
     * Devuelve el orden del árbol.
     */
    public int orden();

    /**
     * Comprueba que un árbol no coincida con la invariancia.
     */
    public boolean validar();

    /**
     * Tome un árbol y conviértalo en una representación compatible con la colección.
     */
    public java.util.Collection<T> toCollection();

}
