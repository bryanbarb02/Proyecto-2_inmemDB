
package AVL;

/**
 *
 * @author Bryan
 */
public class Main {

    
    public static void main(String []args){
        ArbolAVL<Integer> tree = new ArbolAVL<>(100);
        tree.insertar(new NodoAVL(90));
        tree.insertar(new NodoAVL(95));
        //        tree.insert(tree.root, new Node(28));
        tree.insertar(new NodoAVL(12));
        tree.insertar(new NodoAVL(5));
        tree.insertar(new NodoAVL(3));
        tree.insertar(new NodoAVL(4));
//        tree.insert(tree.root, new Node(2));
//        tree.insert(tree.root, new Node(1));
        tree.inOrder(tree.raiz);
        System.out.println("root = " +tree.raiz.key);



    }
}
