
package B;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class ArbolB<T extends Comparable<T>> implements ITree<T> {

    // Por defecto para 2-3 árboles (árbol bs)
    private int KeyTamMin = 1;
    private int HijoTamMin = KeyTamMin + 1; // 2 
    private int KeyTamMax = 2 * KeyTamMin; // 2
    private int HijoTamMax = KeyTamMax + 1; // 3

    private Nodo<T> raiz = null;
    private int tamano = 0;

    /**
     * El constructor para BTree es estándar para el constructor de 2-3 árboles.
     */
    public ArbolB() { }

    /**
     *
     * Constructor para BTree, orden significa el número mínimo de claves, excepto la raíz
     *
     * @param order
     *            orden BTree.
     */
    public ArbolB(int order) {
        this.KeyTamMin = order;
        this.HijoTamMin = KeyTamMin + 1;
        this.KeyTamMax = 2 * KeyTamMin;
        this.HijoTamMax = KeyTamMax + 1;
    }

    @Override
    public boolean anadir(T valor) {
        if (raiz == null) {
            raiz = new Nodo<T>(null, KeyTamMax, HijoTamMax);
            raiz.anadirKey(valor);
        } else {
            Nodo<T> nodo = raiz;
            while (nodo != null) {
                if (nodo.numeroHijos() == 0) {
                    nodo.anadirKey(valor);
                    if (nodo.numeroKeys() <= KeyTamMax) {
                        break;
                    }
                    // Necesidad de dividir el nodo
                    split(nodo);
                    break;
                }

                // Menor o igual que
                T menor = nodo.getKey(0);
                if (valor.compareTo(menor) <= 0) {
                    nodo = nodo.getHijo(0);
                    continue;
                }

                int numeroKeys = nodo.numeroKeys();
                int ultimo = numeroKeys - 1;
                T mayor = nodo.getKey(ultimo);
                if (valor.compareTo(mayor) > 0) {
                    nodo = nodo.getHijo(numeroKeys);
                    continue;
                }

                // Búsqueda interna de nodos
                for (int i = 1; i < nodo.numeroKeys(); i++) {
                    T prev = nodo.getKey(i - 1);
                    T sig = nodo.getKey(i);
                    if (valor.compareTo(prev) > 0 && valor.compareTo(sig) <= 0) {
                        nodo = nodo.getHijo(i);
                        break;
                    }
                }
            }
        }

        tamano++;

        return true;
    }

    /**
     * El tamaño del nodo clave es más grande que maxKeySize, compartir
     *
     * @param nodoSplit
     *            separado
     */
    private void split(Nodo<T> nodoSplit) {
        Nodo<T> nodo = nodoSplit;
        int numeroKeys = nodo.numeroKeys();
        int indiceMedio = numeroKeys / 2;
        T valorMedio = nodo.getKey(indiceMedio); 

        Nodo<T> izquierda = new Nodo<T>(null, KeyTamMax, HijoTamMax);
        for (int i = 0; i < indiceMedio; i++) {
            izquierda.anadirKey(nodo.getKey(i));
        }
        if (nodo.numeroHijos() > 0) {
            for (int j = 0; j <= indiceMedio; j++) {
                Nodo<T> c = nodo.getHijo(j);
                izquierda.anadirHijo(c);
            }
        }

        Nodo<T> derecha = new Nodo<T>(null, KeyTamMax, HijoTamMax);
        for (int i = indiceMedio + 1; i < numeroKeys; i++) {
            derecha.anadirKey(nodo.getKey(i));
        }
        if (nodo.numeroHijos() > 0) {
            for (int j = indiceMedio + 1; j < nodo.numeroHijos(); j++) {
                Nodo<T> c = nodo.getHijo(j);
                derecha.anadirHijo(c);
            }
        }

        if (nodo.padre == null) {
            // Nueva raíz, aumenta la altura del árbol.
            Nodo<T> newRaiz = new Nodo<T>(null, KeyTamMax, HijoTamMax);
            newRaiz.anadirKey(valorMedio);
            nodo.padre = newRaiz;
            raiz = newRaiz;
            nodo = raiz;
            nodo.anadirHijo(izquierda);
            nodo.anadirHijo(derecha);
        } else {
            // Llevando la media hasta su padre
            Nodo<T> padre = nodo.padre;
            padre.anadirKey(valorMedio);
            padre.removerHijo(nodo);
            padre.anadirHijo(izquierda);
            padre.anadirHijo(derecha);

            if (padre.numeroKeys() > KeyTamMax) split(padre);
        }
    }

    @Override
    public T remover(T value) {
        T removed = null;
        Nodo<T> node = this.getNode(value);
        removed = remover(value,node);
        return removed;
    }

    /**
     * Eliminar valor del nodo y comprobar invariante.
     */
    private T remover(T valor, Nodo<T> nodo) {
        if (nodo == null) return null;

        T eliminado = null;
        int indice = nodo.indiceDe(valor);
        eliminado = nodo.removerKey(valor);
        if (nodo.numeroHijos() == 0) {
            // hoja del nodo
            if (nodo.padre != null && nodo.numeroKeys() < KeyTamMin) {
                this.combinados(nodo);
            } else if (nodo.padre == null && nodo.numeroKeys() == 0) {
                // Eliminación de raíz sin llaves o hijos.
                raiz = null;
            }
        } else {
            // nodo interno
            Nodo<T> menor = nodo.getHijo(indice);
            Nodo<T> mayor = this.getNodoMayor(menor);
            T remplazarValor = this.removerValorMayor(mayor);
            nodo.anadirKey(remplazarValor);
            if (mayor.padre != null && mayor.numeroKeys() < KeyTamMin) {
                this.combinados(mayor);
            }
            if (mayor.numeroHijos() > HijoTamMax) {
                this.split(mayor);
            }
        }
        tamano--;

        return eliminado;
    }

    /**
     * Eliminando la clave más grande con un valor de un nodo
     */
    private T removerValorMayor(Nodo<T> node) {
        T valor = null;
        if (node.numeroKeys() > 0) {
            valor = node.removerKey(node.numeroKeys() - 1);
        }
        return valor;
    }

    @Override
    public void limpiar() {
        raiz = null;
        tamano = 0;
    }

    @Override
    public boolean contains(T value) {
        Nodo<T> node = getNode(value);
        return (node != null);
    }

    /**
     * 
     * Toma un nodo con un valor.
     *
     */
    private Nodo<T> getNode(T valor) {
        Nodo<T> nodo = raiz;
        while (nodo != null) {
            T menor = nodo.getKey(0);
            if (valor.compareTo(menor) < 0) {
                if (nodo.numeroHijos() > 0)
                    nodo = nodo.getHijo(0);
                else
                    nodo = null;
                continue;
            }

            int numeroKeys = nodo.numeroKeys();
            int ultimo = numeroKeys - 1;
            T mayor = nodo.getKey(ultimo);
            if (valor.compareTo(mayor) > 0) {
                if (nodo.numeroHijos() > numeroKeys)
                    nodo = nodo.getHijo(numeroKeys);
                else
                    nodo = null;
                continue;
            }

            for (int i = 0; i < numeroKeys; i++) {
                T valorActual = nodo.getKey(i);
                if (valorActual.compareTo(valor) == 0) {
                    return nodo;
                }

                int siguiente = i + 1;
                if (siguiente <= ultimo) {
                    T siguienteValor = nodo.getKey(siguiente); 
                    if (valorActual.compareTo(valor) < 0 && siguienteValor.compareTo(valor) > 0) {
                        if (siguiente < nodo.numeroHijos()) {
                            nodo = nodo.getHijo(siguiente);
                            break;
                        }
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 
     * Tomando al hijo del nodo con el valor más alto.
     *
     */
    private Nodo<T> getNodoMayor(Nodo<T> nodoToGet) {
        Nodo<T> nodo = nodoToGet;
        while (nodo.numeroHijos() > 0) {
            nodo = nodo.getHijo(nodo.numeroHijos() - 1);
        }
        return nodo;
    }

    /**
     * 
     * Conecte descendientes a claves principales cuando el tamaño sea menor que minKeySize
     *
     */
    private boolean combinados(Nodo<T> nodo) {
        Nodo<T> padre = nodo.padre;
        int indice = padre.indiceDe(nodo);
        int indiceVecinoIzquierdo = indice - 1;
        int indiceVecinoDerecho = indice + 1;

        Nodo<T> vecinoDerecha = null;
        int vecinoDerechaTamano = -HijoTamMin;
        if (indiceVecinoDerecho < padre.numeroHijos()) {
            vecinoDerecha = padre.getHijo(indiceVecinoDerecho);
            vecinoDerechaTamano = vecinoDerecha.numeroKeys();
        }

        if (vecinoDerecha != null && vecinoDerechaTamano > KeyTamMin) {
            // A la derecha
            T removerValor = vecinoDerecha.getKey(0);
            int prev = getIndiceValorAnterior(padre, removerValor); 
            T padreValor = padre.removerKey(prev);
            T vecinoValor = vecinoDerecha.removerKey(0);
            nodo.anadirKey(padreValor);
            padre.anadirKey(vecinoValor);
            if (vecinoDerecha.numeroHijos() > 0) {
                nodo.anadirHijo(vecinoDerecha.removerHijo(0));
            }
        } else {
            Nodo<T> vecinoIzquierdo = null;
            int vecinoIzquierdoTamano = -HijoTamMin;
            if (indiceVecinoIzquierdo >= 0) {
                vecinoIzquierdo = padre.getHijo(indiceVecinoIzquierdo);
                vecinoIzquierdoTamano = vecinoIzquierdo.numeroKeys();
            }

            if (vecinoIzquierdo != null && vecinoIzquierdoTamano > KeyTamMin) {
                // Izquierda
                T removerValor = vecinoIzquierdo.getKey(vecinoIzquierdo.numeroKeys() - 1);
                int prev = getIndiceSiguienteValor(padre, removerValor);
                T valorPadre = padre.removerKey(prev);
                T valorVecino = vecinoIzquierdo.removerKey(vecinoIzquierdo.numeroKeys() - 1);
                nodo.anadirKey(valorPadre);
                padre.anadirKey(valorVecino);
                if (vecinoIzquierdo.numeroHijos() > 0) {
                    nodo.anadirHijo(vecinoIzquierdo.removerHijo(vecinoIzquierdo.numeroHijos() - 1));
                }
            } else if (vecinoDerecha != null && padre.numeroKeys() > 0) {
                // Intentar fusionarse con el derecho.
                T removerValor = vecinoDerecha.getKey(0);
                int prev = getIndiceValorAnterior(padre, removerValor);
                T padreValor = padre.removerKey(prev);
                padre.removerHijo(vecinoDerecha);
                nodo.anadirKey(padreValor);
                for (int i = 0; i < vecinoDerecha.tamKey; i++) {
                    T v = vecinoDerecha.getKey(i);
                    nodo.anadirKey(v);
                }
                for (int i = 0; i < vecinoDerecha.tamHijo; i++) {
                    Nodo<T> c = vecinoDerecha.getHijo(i);
                    nodo.anadirHijo(c);
                }

                if (padre.padre != null && padre.numeroKeys() < KeyTamMin) {
                    // La clave eliminada hizo al padre demasiado pequeño, Com. el arbol
                    this.combinados(padre);
                } else if (padre.numeroKeys() == 0) {
                    // El padre ya no tiene claves, hacemos que este nodo sea una nueva raíz.
                    // longitud reducida
                    nodo.padre = null;
                    raiz = nodo;
                }
            } else if (vecinoIzquierdo != null && padre.numeroKeys() > 0) {
                // Intentar fusionarse con el derecho.
                T removerValor = vecinoIzquierdo.getKey(vecinoIzquierdo.numeroKeys() - 1);
                int prev = getIndiceSiguienteValor(padre, removerValor);
                T parentValue = padre.removerKey(prev);
                padre.removerHijo(vecinoIzquierdo);
                nodo.anadirKey(parentValue);
                for (int i = 0; i < vecinoIzquierdo.tamKey; i++) {
                    T v = vecinoIzquierdo.getKey(i);
                    nodo.anadirKey(v);
                }
                for (int i = 0; i < vecinoIzquierdo.tamHijo; i++) {
                    Nodo<T> c = vecinoIzquierdo.getHijo(i);
                    nodo.anadirHijo(c);
                }

                if (padre.padre != null && padre.numeroKeys() < KeyTamMin) {
                    // La clave eliminada hizo al padre demasiado pequeño, Com. el arbol
                    this.combinados(padre);
                } else if (padre.numeroKeys() == 0) {
                    // El padre ya no tiene claves, hacer de este nodo una nueva raíz
                    // disminuye la longitud
                    nodo.padre = null;
                    raiz = nodo;
                }
            }
        }
        return true;
    }

    /**
     * 
     * Tome el índice de la clave anterior en el nodo.
     *
     */
    private int getIndiceValorAnterior(Nodo<T> node, T value) {
        for (int i = 1; i < node.numeroKeys(); i++) {
            T t = node.getKey(i);
            if (t.compareTo(value) >= 0)
                return i - 1;
        }
        return node.numeroKeys() - 1;
    }

    /**
     * 
     * Tome el índice de la siguiente clave en el nodo.
     *
     */
    private int getIndiceSiguienteValor(Nodo<T> node, T value) {
        for (int i = 0; i < node.numeroKeys(); i++) {
            T t = node.getKey(i);
            if (t.compareTo(value) >= 0)
                return i;
        }
        return node.numeroKeys() - 1;
    }

    @Override
    public int tamano() {
        return tamano;
    }

    @Override
    public int orden() {
        return KeyTamMin;
    }

    @Override
    public boolean validar() {
        if (raiz == null) return true;
        return validarNodo(raiz);
    }

    private boolean validarNodo(Nodo<T> nodo) {
        int tamKey = nodo.numeroKeys();
        if (tamKey > 1) {
            // Asegúrate de que las llaves estén ordenadas
            for (int i = 1; i < tamKey; i++) {
                T p = nodo.getKey(i - 1);
                T n = nodo.getKey(i);
                if (p.compareTo(n) > 0)
                    return false;
            }
        }
        int tamanoHijo = nodo.numeroHijos();
        if (nodo.padre == null) {
            // корень
            if (tamKey > KeyTamMax) {
                // Compruebe la clave máxima. La raíz no tiene un tamaño de clave mínimo.
                return false;
            } else if (tamanoHijo == 0) {
                // Si la raíz, no hay descendientes, y las claves son válidas
                return true;
            } else if (tamanoHijo < 2) {
                // La raíz debe tener cero o al menos dos descendientes.
                return false;
            } else if (tamanoHijo > HijoTamMax) {
                return false;
            }
        } else {
            if (tamKey < KeyTamMin) {
                return false;
            } else if (tamKey > KeyTamMax) {
                return false;
            } else if (tamanoHijo == 0) {
                return true;
                
            } else if (tamKey != (tamanoHijo - 1)) {
                return false;
            } else if (tamanoHijo < HijoTamMin) {
                return false;
            } else if (tamanoHijo > HijoTamMax) {
                return false;
            }
        }

        Nodo<T> primero = nodo.getHijo(0);
        // La última clave del primer hijo debe ser menor que la primera clave del nodo.
        if (primero.getKey(primero.numeroKeys() - 1).compareTo(nodo.getKey(0)) > 0)
            return false;

        Nodo<T> ultimo = nodo.getHijo(nodo.numeroHijos() - 1);
        // La primera clave del último hijo debe ser mayor que la última clave del nodo.
        if (ultimo.getKey(0).compareTo(nodo.getKey(nodo.numeroKeys() - 1)) < 0)
            return false;

        // Verificamos que cada primer y último elemento del nodo nodo conserva su invariancia.
        for (int i = 1; i < nodo.numeroKeys(); i++) {
            T p = nodo.getKey(i - 1);
            T n = nodo.getKey(i);
            Nodo<T> c = nodo.getHijo(i);
            if (p.compareTo(c.getKey(0)) > 0)
                return false;
            if (n.compareTo(c.getKey(c.numeroKeys() - 1)) < 0)
                return false;
        }

        for (int i = 0; i < nodo.tamHijo; i++) {
            Nodo<T> c = nodo.getHijo(i);
            boolean valid = this.validarNodo(c);
            if (!valid)
                return false;
        }
        return true;
    }

    @Override
    public java.util.Collection<T> toCollection() {
        return (new JavaCompatibleArbolB<T>(this));
    }

    @Override
    public String toString() {
        return pintarArbol.getString(this);
    }

    private static class Nodo<T extends Comparable<T>> {

        private T[] keys = null;
        private int tamKey = 0;
        private Nodo<T>[] hijo = null;
        private int tamHijo = 0;
        private Comparator<Nodo<T>> comparator = new Comparator<Nodo<T>>() {
            @Override
            public int compare(Nodo<T> arg0, Nodo<T> arg1) {
                return arg0.getKey(0).compareTo(arg1.getKey(0));
            }
        };

        protected Nodo<T> padre = null;

        private Nodo(Nodo<T> padre, int tamMaxKey, int tamMaxHijo) {
            this.padre = padre;
            this.keys = (T[]) new Comparable[tamMaxKey + 1];
            this.tamKey = 0;
            this.hijo = new Nodo[tamMaxHijo + 1];
            this.tamHijo = 0;
        }

        private T getKey(int index) {
            return keys[index];
        }

        private int indiceDe(T value) {
            for (int i = 0; i < tamKey; i++) {
                if (keys[i].equals(value)) return i;
            }
            return -1;
        }

        private void anadirKey(T valor) {
            keys[tamKey++] = valor;
            Arrays.sort(keys, 0, tamKey);
        }

        private T removerKey(T valor) {
            T eliminado = null;
            boolean encontrado = false;
            if (tamKey == 0) return null;
            for (int i = 0; i < tamKey; i++) {
                if (keys[i].equals(valor)) {
                    encontrado = true;
                    eliminado = keys[i];
                } else if (encontrado) {
                    // Desplazar las teclas restantes
                    keys[i - 1] = keys[i];
                }
            }
            if (encontrado) {
                tamKey--;
                keys[tamKey] = null;
            }
            return eliminado;
        }

        private T removerKey(int indice) {
            if (indice >= tamKey)
                return null;
            T valor = keys[indice];
            for (int i = indice + 1; i < tamKey; i++) {
                // Desplazar las teclas restantes
                keys[i - 1] = keys[i];
            }
            tamKey--;
            keys[tamKey] = null;
            return valor;
        }

        private int numeroKeys() {
            return tamKey;
        }

        private Nodo<T> getHijo(int indice) {
            if (indice >= tamHijo)
                return null;
            return hijo[indice];
        }

        private int indiceDe(Nodo<T> h) {
            for (int i = 0; i < tamHijo; i++) {
                if (hijo[i].equals(h))
                    return i;
            }
            return -1;
        }

        private boolean anadirHijo(Nodo<T> h) {
            h.padre = this;
            hijo[tamHijo++] = h;
            Arrays.sort(hijo, 0, tamHijo, comparator);
            return true;
        }

        private boolean removerHijo(Nodo<T> child) {
            boolean encontrado = false;
            if (tamHijo == 0)
                return encontrado;
            for (int i = 0; i < tamHijo; i++) {
                if (hijo[i].equals(child)) {
                    encontrado = true;
                } else if (encontrado) {
                    hijo[i - 1] = hijo[i];
                }
            }
            if (encontrado) {
                tamHijo--;
                hijo[tamHijo] = null;
            }
            return encontrado;
        }

        private Nodo<T> removerHijo(int indice) {
            if (indice >= tamHijo)
                return null;
            Nodo<T> valor = hijo[indice];
            hijo[indice] = null;
            for (int i = indice + 1; i < tamHijo; i++) {
                hijo[i - 1] = hijo[i];
            }
            tamHijo--;
            hijo[tamHijo] = null;
            return valor;
        }

        private int numeroHijos() {
            return tamHijo;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("keys=[");
            for (int i = 0; i < numeroKeys(); i++) {
                T valor = getKey(i);
                builder.append(valor);
                if (i < numeroKeys() - 1)
                    builder.append(", ");
            }
            builder.append("]\n");

            if (padre != null) {
                builder.append("parent=[");
                for (int i = 0; i < padre.numeroKeys(); i++) {
                    T value = padre.getKey(i);
                    builder.append(value);
                    if (i < padre.numeroKeys() - 1)
                        builder.append(", ");
                }
                builder.append("]\n");
            }

            if (hijo != null) {
                builder.append("keySize=").append(numeroKeys()).append(" children=").append(numeroHijos()).append("\n");
            }
            return builder.toString();
        }
    }

    private static class pintarArbol {

        public static <T extends Comparable<T>> String getString(ArbolB<T> arbol) {
            if (arbol.raiz == null) return "У B-Tree no hay artículos";
            return getString(arbol.raiz, "", true);
        }

        private static <T extends Comparable<T>> String getString(Nodo<T> nodo, String prefijo, boolean esCola) {
            StringBuilder construir = new StringBuilder();

            construir.append(prefijo).append((esCola ? "└── " : "├── "));
            for (int i = 0; i < nodo.numeroKeys(); i++) {
                T valor = nodo.getKey(i);
                construir.append(valor);
                if (i < nodo.numeroKeys() - 1)
                    construir.append(", ");
            }
            construir.append("\n");

            if (nodo.hijo != null) {
                for (int i = 0; i < nodo.numeroHijos() - 1; i++) {
                    Nodo<T> obj = nodo.getHijo(i);
                    construir.append(getString(obj, prefijo + (esCola ? "    " : "│   "), false));
                }
                if (nodo.numeroHijos() >= 1) {
                    Nodo<T> obj = nodo.getHijo(nodo.numeroHijos() - 1);
                    construir.append(getString(obj, prefijo + (esCola ? "    " : "│   "), true));
                }
            }
            return construir.toString();
        }
    }

    public static class JavaCompatibleArbolB<T extends Comparable<T>> extends java.util.AbstractCollection<T> {

        private ArbolB<T> arbol = null;

        public JavaCompatibleArbolB(ArbolB<T> arbol) {
            this.arbol = arbol;
        }

        @Override
        public boolean add(T value) {
            return arbol.anadir(value);
        }

        @Override
        public boolean remove(Object value) {
            return (arbol.remover((T)value)!=null);
        }

        @Override
        public boolean contains(Object value) {
            return arbol.contains((T)value);
        }

        @Override
        public int size() {
            return arbol.tamano();
        }

        @Override
        public java.util.Iterator<T> iterator() {
            return (new arbolBIterator<T>(this.arbol));
        }

        private static class arbolBIterator<C extends Comparable<C>> implements java.util.Iterator<C> {

            private ArbolB<C> arbol = null;
            private ArbolB.Nodo<C> ultimoNodo = null;
            private C ultimoValor = null;
            private int indice = 0;
            private Deque<Nodo<C>> toVisitar = new ArrayDeque<Nodo<C>>();

            protected arbolBIterator(ArbolB<C> arbol) {
                this.arbol = arbol;
                if (arbol.raiz!=null && arbol.raiz.tamKey>0) {
                    toVisitar.add(arbol.raiz);
                }
            }

            @Override
            public boolean hasNext() {
                if ((ultimoNodo!=null && indice<ultimoNodo.tamKey)||(toVisitar.size()>0)) return true;
                return false;
            }

            @Override
            public C next() {
                if (ultimoNodo!=null && (indice < ultimoNodo.tamKey)) {
                    ultimoValor = ultimoNodo.getKey(indice++);
                    return ultimoValor;
                }
                while (toVisitar.size()>0) {
                    // Ir a través del nodo actual
                    ArbolB.Nodo<C> n = toVisitar.pop();

                    // Añadir un descendiente no vacío
                    for (int i=0; i<n.tamHijo; i++) {
                        toVisitar.add(n.getHijo(i));
                    }

                    // Actualizar el último nodo
                    indice = 0;
                    ultimoNodo = n;
                    ultimoValor = ultimoNodo.getKey(indice++);
                    return ultimoValor;
                }
                return null;
            }

            @Override
            public void remove() {
                if (ultimoNodo!=null && ultimoValor!=null) {
                    // По удалению сбрасываем итератор
                    arbol.remover(ultimoValor, ultimoNodo);
                    ultimoNodo = null;
                    ultimoValor = null;
                    indice = 0;
                    toVisitar.clear();
                    if (arbol.raiz!=null && arbol.raiz.tamKey>0) {
                        toVisitar.add(arbol.raiz);
                    }
                }
            }
        }
    }
}