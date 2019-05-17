package BMas;

import java.util.ArrayList;

public class NativeMethods<E extends Comparable<E>> {

    public void insertarOrdenado(E key, Object record, NodoBMas<E> N) {
        ArrayList<E> dato = N.getKeys();
        ArrayList<Object> punteros = N.getPunteros();
        if (dato.isEmpty()) {
            dato.add(key);
            punteros.add(record);
            return;
        } else {
            if (key.compareTo(dato.get(0)) < 0) {
                dato.add(0, key);
                punteros.add(0, record);
            } else {
                boolean flag = true;
                for (int i = 0; i < dato.size(); i++) {
                    if (key.compareTo(dato.get(i)) < 0) {
                        flag = false;
                        dato.add(i, key);
                        punteros.add(i, record);
                        break;
                    }
                }
                if (flag) {
                    dato.add(key);
                    punteros.add(record);
                }
            }
        }
    }

    public void sortedInsertarInterna(E key, Object record, NodoBMas<E> N) {
        ArrayList<E> dato = N.getKeys();
        ArrayList<Object> punteros = N.getPunteros();
        if (key.compareTo(dato.get(0)) < 0) {
            dato.add(0, key);
            punteros.add(1, record);
        } else {
            boolean flag = true;
            for (int i = 0; i < dato.size(); i++) {
                if (key.compareTo(dato.get(i)) < 0) {
                    dato.add(i, key);
                    punteros.add(i + 1, record);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                dato.add(key);
                punteros.add(record);
            }
        }
    }

    public void eliminarNodo(NodoBMas<E> n, E k) {
        for (int i = 0; i < n.getKeys().size(); i++) {
            if (k.compareTo(n.getKeys().get(i)) == 0) {
                n.getKeys().remove(i);
                n.getPunteros().remove(i);
            }
        }
    }

    public void internalDelete(E key, NodoBMas<E> n, NodoBMas<E> temp) {
        for (int i = 0; i < n.getKeys().size(); i++) {
            if (n.getKeys().get(i).compareTo(key) == 0) {
                n.getKeys().remove(i);
                n.getPunteros().remove(i + 1);
            }
        }
    }

    public int mismoPadre(NodoBMas<E> n, NodoBMas<E> padre, int tamano) {
        ArrayList<E> keys = padre.getKeys();
        boolean _siguiente = false;
        boolean _prev = false;
        NodoBMas<E> siguiente = n.getSiguiente();
        NodoBMas<E> prev = n.getPrev();
        if (mismoPadre2(padre, n)) {
            for (int i = 0; i < padre.getPunteros().size(); i++) {
                if (siguiente == padre.getPunteros().get(i)) {
                    _siguiente = true;
                    break;
                }
            }
        }
        if (!mismoPadre2(padre, n)) {
            for (int i = 0; i < padre.getPunteros().size(); i++) {
                if (prev == padre.getPunteros().get(i)) {
                    _prev = true;
                    break;
                }
            }
        }
        if (_siguiente && siguiente.getKeys().size() - 1 >= Math.ceil(tamano / 2.0)) {
            return 1;
        } else if (_prev && prev.getKeys().size() - 1 >= Math.ceil(tamano / 2.0)) {
            return 2;
        } else {
            return 0;
        }
    }

    public int siguienteOrprev(NodoBMas<E> n, NodoBMas<E> padre, int tamano) {
        boolean _siguiente = false;
        boolean _prev = false;
        NodoBMas<E> siguiente = n.getSiguiente();
        NodoBMas<E> prev = n.getPrev();
        if (siguiente != null) {
            for (int i = 0; i < padre.getPunteros().size(); i++) {
                if (siguiente == padre.getPunteros().get(i)) {
                    _siguiente = true;
                    break;
                }
            }
        }
        if (prev != null) {
            for (int i = 0; i < padre.getPunteros().size(); i++) {
                if (prev == padre.getPunteros().get(i)) {
                    _prev = true;
                    break;
                }
            }
        }
        if (siguiente != null && _siguiente && siguiente.getKeys().size() - 1 >= 1) {
            return 1;
        } else if (prev != null && _prev && prev.getKeys().size() - 1 >= 1) {
            return 2;
        } else {
            return 0;
        }
    }

    public boolean mismoPadre2(NodoBMas<E> padre, NodoBMas<E> n) {
        boolean _siguiente = false;
        boolean _prev = false;
        NodoBMas<E> siguiente = n.getSiguiente();
        NodoBMas<E> prev = n.getPrev();
        if (siguiente != null) {
            for (int i = 0; i < padre.getPunteros().size(); i++) {
                if (siguiente == padre.getPunteros().get(i)) {
                    _siguiente = true;
                    break;
                }
            }
        }
        if (prev != null) {
            for (int i = 0; i < padre.getPunteros().size(); i++) {
                if (prev == padre.getPunteros().get(i)) {
                    _prev = true;
                    break;
                }
            }
        }
        if (_siguiente) {
            return true;
        } else {
            return false;
        }


    }
}
