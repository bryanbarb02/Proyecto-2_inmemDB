
package AVL;

import static java.lang.Math.max;

/**
 * 
 * @author Bryan
 */
public class ArbolAVL<T extends Comparable<T>>{

    NodoAVL raiz;

    public ArbolAVL(T raiz){
        this.raiz = new NodoAVL(raiz);
    }


    public void insertar(NodoAVL nodo){
        insertar(raiz, nodo);
    }
    public NodoAVL<T> insertar(NodoAVL current, NodoAVL nodo){
        if(current == null){
            current = nodo;
            return current;
        }
        else if(current.key.compareTo(nodo.key) < 0){
            current.derecha = insertar(current.derecha, nodo);
        }
        else if(current.key.compareTo(nodo.key) > 0){
            current.izquierda = insertar(current.izquierda, nodo);
        }

        calcularAltura(current);
        if(current.izquierda == null){
            if(current.derecha == null){
                return current;
            }
            else{
                if(current.derecha.altura > 0){
                    current = balance(current);
                }
            }
        }
        else if(current.derecha == null){
            if(current.izquierda.altura > 0){
                current = balance(current);
            }
        }
        else if (Math.abs(current.izquierda.altura - current.derecha.altura) > 1){
            current = balance(current);
        }
        return current;
    }
    public void calcularAltura(NodoAVL nodo){
        int altura = 0;
        if(nodo.izquierda != null){
            altura = nodo.izquierda.altura +1; 
            //altura = nodo.izquierda.NodoAVL.this.altura + 1;
        }
        if(nodo.derecha != null) {
            altura = max(altura, nodo.derecha.altura + 1);
            //altura = max(altura, nodo.derecha.NodoAVL.this.altura + 1);
        }
        nodo.altura = altura;
        //nodo.NodoAVL.this.altura = altura;
    }

    public NodoAVL<T> balance(NodoAVL pivot){
        if(pivot.izquierda == null){
            if(pivot.derecha.izquierda != null) {
                pivot.derecha = rotarDerecha(pivot.derecha);
            }
            pivot = rotarIzquierda(pivot);
        }
        else if (pivot.derecha == null){
            if(pivot.izquierda.derecha != null) {
                pivot.izquierda = rotarIzquierda(pivot.izquierda);
            }
            pivot = rotarDerecha(pivot);
        }
        else{
            if(pivot.izquierda.altura - pivot.derecha.altura > 1){
                pivot = rotarDerecha(pivot);
            }
            else{
                pivot = rotarIzquierda(pivot);
            }
        }
        calcularAltura(pivot);
        return pivot;
    }
    public void inOrder(NodoAVL node){
        if(node == null){
            return;
        }
        inOrder(node.izquierda);
        System.out.println(node.key);
        inOrder(node.derecha);
    }
    public void postOrder(NodoAVL node){

    }

    public NodoAVL<T> rotarDerecha(NodoAVL pivot){
       boolean check = (pivot == raiz);
       NodoAVL temp = new NodoAVL(pivot);
       temp.izquierda = pivot.izquierda.derecha;
       pivot = pivot.izquierda;
       pivot.derecha = temp;
       if(check){
           raiz = pivot;
       }
       calcularAltura(temp);
       return pivot;
    }

    public NodoAVL<T> rotarIzquierda(NodoAVL pivot){
        boolean check = pivot == raiz;
        NodoAVL temp = new NodoAVL(pivot);
        pivot = pivot.derecha;
        temp.derecha = pivot.izquierda;
        pivot.izquierda = temp;
        if(check == true){
            raiz = pivot;
        }
        calcularAltura(temp);
        return pivot;
    }
}
