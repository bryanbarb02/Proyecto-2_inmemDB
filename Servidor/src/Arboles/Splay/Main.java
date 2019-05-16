package Splay;

public class Main {

    public static void main(String[] args) {

        ArbolSplay splayTree = new ArbolSplay();
        //Insert values
        splayTree.insertar(new Entrada(1, "Jack"));
        splayTree.insertar(new Entrada(6, "Tom"));
        splayTree.insertar(new Entrada(4, "Raj"));
        splayTree.insertar(new Entrada(7, "Kareena"));
        splayTree.insertar(new Entrada(8, "John"));
        splayTree.insertar(new Entrada(10, "Susan"));
        splayTree.insertar(new Entrada(5, "Linda"));
        splayTree.insertar(new Entrada(9, "Peter"));

        //Find
        System.out.println(splayTree.encontrar(6));
        System.out.println(splayTree.encontrar(1));
        System.out.println(splayTree.encontrar(7));

        //Sort
        System.out.println("--Print sorted--");
        splayTree.printOrdenados();


    }
}
