package BMas;


import java.util.ArrayList;

public class NodoBMas<E> {

    private ArrayList<E> keys;
    private ArrayList<Object> punteros;
    private NodoBMas<E> siguiente;
    private NodoBMas<E> prev;
    boolean esHoja;
    int tamNodo;

    public NodoBMas(int tamNodo, boolean esHoja) {
        super();
        keys = new ArrayList<E>();
        punteros = new ArrayList<Object>();
        this.tamNodo = tamNodo;
        this.esHoja = esHoja;
    }

    public ArrayList<E> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<E> keys) {
        this.keys = keys;
    }

    public ArrayList<Object> getPunteros() {
        return punteros;
    }

    public void setPunteros(ArrayList<Object> punteros) {
        this.punteros = punteros;
    }

    public NodoBMas<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBMas<E> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoBMas<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoBMas<E> prev) {
        this.prev = prev;
    }

    public boolean esHoja() {
        return esHoja;
    }

    public void setHoja(boolean esHoja) {
        this.esHoja = esHoja;
    }

    public int getTamNodo() {
        return tamNodo;
    }

    public void setTamNodo(int tamNodo) {
        this.tamNodo = tamNodo;
    }
}
