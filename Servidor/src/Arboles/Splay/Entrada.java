package Splay;


public class Entrada implements Comparable<Entrada> {
    private int key;
    private String valor;

    @Override
    public String toString() {
        return "Entrada{" + "key=" + key +", valor='" + valor + '\'' +'}';
    }

    public Entrada(int key, String valor) {
        this.key = key;
        this.valor = valor;
    }

    public int getKey() {
        return key;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public int compareTo(Entrada that) {
        if (this.key > that.key) {
            return 1;
        } else if (that.key > this.key) {
            return -1;
        } else {
            return 0;
        }
    }


}
