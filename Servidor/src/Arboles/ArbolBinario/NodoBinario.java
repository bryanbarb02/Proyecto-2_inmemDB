/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author Bryan
 */
public class NodoBinario<T extends Comparable<? super T>> {
    public T elemento;
    public NodoBinario<T> izquierda;
    public NodoBinario<T> derecha;

    public NodoBinario(T element) {
        this(element, null, null);
    }

    public NodoBinario(T elemento, NodoBinario<T> left, NodoBinario<T> derecha) {
        this.elemento = elemento;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

}
