package AVL;


import java.util.*;

public class ArbolAVL<T extends Comparable<? super T>> implements Collection<T> {
    private NodoAVL<T> raiz;
    private int tamano=  0;

    public ArbolAVL() {
        tamano = 0;
    }

    @Override
    public int size() {
        return tamano;
    }

    @Override
    public boolean add(T dato) {
        if (isEmpty()) {
            raiz = new NodoAVL<T>(dato);
            tamano++;
            return true;
        } else {
            boolean addition = add(dato, raiz);
            balance(raiz);
            return addition;
        }
    }

    private boolean add(T dato, NodoAVL<T> current) {
        switch (current.dato().compareTo(dato)) {
            case 1:
                NodoAVL<T> izquierda = current.izquierda();
                if (izquierda != null) {
                    return add(dato, izquierda);
                } else {
                    current.setIzquierda(new NodoAVL<T>(dato));
                    tamano++;
                    return true;
                }
            case -1:
                NodoAVL<T> derecha = current.derecha();
                if (derecha != null) {
                    return add(dato, derecha);
                } else {
                    current.setDerecha(new NodoAVL<T>(dato));
                    tamano++;
                    return true;
                }
            default:
                return false;
        }
    }

    private void balance(NodoAVL<T> nodo) {
        if (nodo == null) {
            return;
        }

        balance(nodo.izquierda());
        balance(nodo.derecha());

        int leftHeight = nodo.alturaIzquierda();
        int rightHeight = nodo.alturaDerecha();
        boolean needsBalancing = Math.abs(leftHeight - rightHeight) > 1;

        if (needsBalancing) {
            if (rightHeight > leftHeight) {
                rotateLeft(nodo);
            } else if (leftHeight > rightHeight) {
                rotateRight(nodo);
            }
        }
    }

    private void rotateLeft(NodoAVL<T> oldNode) {
        NodoAVL<T> newNode;
        NodoAVL<T> parent = oldNode.padre();

        if (oldNode.derecha().derecha() != null) {
            newNode = detachRightChildFrom(oldNode);
            if (newNode.izquierda() != null) {
                oldNode.setDerecha(newNode.izquierda());
            }
            newNode.setIzquierda(oldNode);
        } else {
            newNode = detachLeftChildFrom(oldNode.derecha());
            newNode.setDerecha(detachRightChildFrom(oldNode));
            newNode.setIzquierda(oldNode);
        }

        setNewChildNodeOf(parent, oldNode, newNode);
    }

    private void rotateRight(NodoAVL<T> oldNode) {
        NodoAVL<T> newNode, parent = oldNode.padre();

        if (oldNode.izquierda().izquierda() != null) {
            newNode = detachLeftChildFrom(oldNode);
            if (newNode.derecha() != null) {
                oldNode.setIzquierda(newNode.derecha());
            }
            newNode.setDerecha(oldNode);
        } else {
            newNode = detachRightChildFrom(oldNode.izquierda());
            newNode.setIzquierda(detachLeftChildFrom(oldNode));
            newNode.setDerecha(oldNode);
        }

        setNewChildNodeOf(parent, oldNode, newNode);
    }

    private NodoAVL<T> detachLeftChildFrom(NodoAVL<T> node) {
        NodoAVL<T> leftChild = node.izquierda();
        node.setIzquierda(null);
        return leftChild;
    }

    private NodoAVL<T> detachRightChildFrom(NodoAVL<T> node) {
        NodoAVL<T> rightChild = node.derecha();
        node.setDerecha(null);
        return rightChild;
    }

    private void setNewChildNodeOf(NodoAVL<T> parent, NodoAVL<T> oldChild, NodoAVL<T> newChild) {
        if (parent == null) {
            newChild.setPadre(null);
            raiz = newChild;
        } else {
            parent.reemplazo(oldChild).with(newChild);
        }
    }

    public boolean remove(T data) {
        final boolean removal = contains(data) && removeNodeContaining(data, raiz);
        balance(raiz);
        return removal;
    }

    private boolean removeNodeContaining(T data, NodoAVL<T> searchNode) {
        switch (searchNode.dato().compareTo(data)) {
            case 1:
                return ((searchNode.izquierda() != null) && (removeNodeContaining(data, searchNode.izquierda())));
            case -1:
                return ((searchNode.derecha() != null) && (removeNodeContaining(data, searchNode.derecha())));
            case 0:
            default:
                removeNode(searchNode);
                return true;
        }
    }

    private void removeNode(NodoAVL<T> current) {
        NodoAVL<T> parent = current.padre();
        NodoAVL<T> left = current.izquierda();
        NodoAVL<T> right = current.derecha();

        if (current.esHoja()) {
            if (parent == null) {
                raiz = null;
            } else {
                parent.reemplazo(current).with(null);
            }
        } else if ((left == null || right == null)) {
            if (right == null) {
                if (parent == null) {
                    raiz = left;
                    raiz.setPadre(null);
                } else {
                    parent.reemplazo(current).with(left);
                }
            } else {
                if (parent == null) {
                    raiz = right;
                    raiz.setPadre(null);
                } else {
                    parent.reemplazo(current).with(right);
                }
            }
        } else {
            T newData;

            if (current.alturaDerecha() > current.alturaIzquierda()) {
                newData = deleteMinimumSubNodeOf(right);
            } else {
                newData = deleteMaximumSubNodeOf(left);
            }

            current.setDato(newData);
        }

        tamano--;
    }

    private T deleteMaximumSubNodeOf(NodoAVL<T> node) {
        if (node.derecha() != null) {
            return deleteMaximumSubNodeOf(node.derecha());
        } else if (node.izquierda() != null) {
            node.padre().reemplazo(node).with(node.izquierda());
        } else {
            node.padre().reemplazo(node).with(null);
        }
        return node.dato();
    }

    private T deleteMinimumSubNodeOf(NodoAVL<T> node) {
        if (node.izquierda() != null) {
            return deleteMinimumSubNodeOf(node.izquierda());
        } else if (node.derecha() != null) {
            node.padre().reemplazo(node).with(node.derecha());
        } else {
            node.padre().reemplazo(node).with(null);
        }
        return node.dato();
    }

    @Override
    public boolean isEmpty() {
        return tamano == 0;
    }

    public T min() {
        if (raiz == null) {
            return null;
        } else {
            return raiz.masIzquierda().dato();
        }
    }

    public T max() {
        if (raiz == null) {
            return null;
        } else {
            return raiz.masDerecha().dato();
        }
    }

    NodoAVL<T> root() {
        return raiz;
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        NodoAVL<T> current = raiz;

        while (current != null) {
            switch (current.dato().compareTo(data)) {
                case 1:
                    current = current.izquierda();
                    break;
                case -1:
                    current = current.derecha();
                    break;
                case 0:
                default:
                    return true;
            }
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        return contains((T) o);
    }

    @Override
    public Iterator<T> iterator() {
        return asInorderList().iterator();
    }

    @Override
    public Object[] toArray() {
        return asInorderList().toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < tamano) {
            return (T[]) Arrays.copyOf(toArray(), tamano, a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, tamano);

        if (a.length > tamano) {
            a[tamano] = null;
        }

        return a;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        return remove((T) o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsAll(Collection<?> c) {
        for (Object data : c) {
            if (!contains(data)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;

        for (T item : c) {
            modified = add(item) || modified;
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object data : c) {
            modified = remove(data) || modified;
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        for (T data : this) {
            if (!c.contains(data)) {
                modified = remove(data) || modified;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        for (T data : postorderTraversal()) {
            remove(data);
        }
    }

    public List<T> asPreorderList() {
        List<T> preorderList = new LinkedList<T>();
        for (T data : preorderTraversal()) {
            preorderList.add(data);
        }
        return preorderList;
    }

    public List<T> asInorderList() {
        List<T> inorderList = new LinkedList<T>();
        for (T data : inorderTraversal()) {
            inorderList.add(data);
        }
        return inorderList;
    }

    public List<T> asPostorderList() {
        List<T> postorderList = new LinkedList<T>();
        for (T data : postorderTraversal()) {
            postorderList.add(data);
        }
        return postorderList;
    }

    public List<T> asLevelOrderList() {
        List<T> levelOrderList = new LinkedList<T>();
        for (T data : levelOrderTraversal()) {
            levelOrderList.add(data);
        }
        return levelOrderList;
    }

    abstract class TreeTraversal implements Iterable<T> {
        protected Stack<NodoAVL<T>> nodeStack;

        public TreeTraversal() {
            nodeStack = new Stack<NodoAVL<T>>();
        }

        public void pushOntoStack(NodoAVL<T> node) {
            if (node != null) {
                nodeStack.push(node);
            }
        }

        abstract class TreeIterator implements Iterator<T> {
            @Override
            public boolean hasNext() {
                return (!nodeStack.isEmpty());
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }

    private Iterable<? extends T> preorderTraversal() {
        return new TreeTraversal() {
            {
                pushOntoStack(raiz);
            }

            @Override
            public Iterator<T> iterator() {
                return new TreeIterator() {
                    @Override
                    public T next() {
                        NodoAVL<T> nextNode = nodeStack.pop();
                        pushOntoStack(nextNode.derecha());
                        pushOntoStack(nextNode.izquierda());
                        return nextNode.dato();
                    }
                };
            }
        };
    }

    private Iterable<? extends T> inorderTraversal() {
        return new TreeTraversal() {
            {
                pushLeftMostNodesOf(raiz);
            }

            @Override
            public Iterator<T> iterator() {
                return new TreeIterator() {
                    @Override
                    public T next() {
                        NodoAVL<T> nextNode = nodeStack.pop();
                        pushLeftMostNodesOf(nextNode.derecha());
                        return nextNode.dato();
                    }
                };
            }

            private void pushLeftMostNodesOf(NodoAVL<T> node) {
                while (node != null && !nodeStack.contains(node)) {
                    nodeStack.push(node);
                    node = node.izquierda();
                }
            }
        };
    }

    private Iterable<? extends T> postorderTraversal() {
        return new TreeTraversal() {
            Map<T, NodoAVL<T>> iteratedNodes;

            {
                nodeStack.push(raiz);
                iteratedNodes = new HashMap<T, NodoAVL<T>>();
            }

            @Override
            public Iterator<T> iterator() {
                return new TreeIterator() {
                    @Override
                    public T next() {
                        NodoAVL<T> next = null;
                        NodoAVL<T> current = nodeStack.peek();

                        while (next == null) {
                            NodoAVL<T> left = current.izquierda();
                            NodoAVL<T> right = current.derecha();

                            if (current.esHoja()) {
                                next = popNextNode();
                            } else {
                                boolean needToBacktrack = true;
                                if (shouldPush(right)) {
                                    nodeStack.push(right);
                                    current = right;
                                    needToBacktrack = false;
                                }
                                if (shouldPush(left)) {
                                    nodeStack.push(left);
                                    current = left;
                                    needToBacktrack = false;
                                }
                                if (needToBacktrack) {
                                    next = popNextNode();
                                }
                            }
                        }

                        return next.dato();
                    }

                    private boolean shouldPush(NodoAVL<T> node) {
                        return !(node == null || nodeStack.contains(node) || iteratedNodes.containsKey(node.dato()));
                    }

                    private NodoAVL<T> popNextNode() {
                        NodoAVL<T> next = nodeStack.pop();
                        iteratedNodes.put(next.dato(), next);
                        return next;
                    }
                };
            }
        };
    }

    private Iterable<? extends T> levelOrderTraversal() {
        return new TreeTraversal() {
            protected Queue<NodoAVL<T>> nodeQueue = new LinkedList<NodoAVL<T>>();

            @Override
            public Iterator<T> iterator() {
                return new TreeIterator() {
                    {
                        addToQueue(raiz);
                    }

                    @Override
                    public boolean hasNext() {
                        return !nodeQueue.isEmpty();
                    }

                    @Override
                    public T next() {
                        NodoAVL<T> nextNode = nodeQueue.poll();
                        addToQueue(nextNode.izquierda());
                        addToQueue(nextNode.derecha());
                        return nextNode.dato();
                    }
                };
            }

            private void addToQueue(NodoAVL<T> node) {
                if (node != null) {
                    nodeQueue.offer(node);
                }
            }
        };
    }
}
