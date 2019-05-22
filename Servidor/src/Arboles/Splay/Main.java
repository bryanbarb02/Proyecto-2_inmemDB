package Splay;

public class Main {

    public static void main(String[] args) {

        ArbolSplay splayTree = new ArbolSplay();
        //Insert values
        splayTree.insertar(new Entrada("Jack"));
        splayTree.insertar(new Entrada("Tom"));
        splayTree.insertar(new Entrada("Raj"));
        splayTree.insertar(new Entrada( "Kareena"));
        splayTree.insertar(new Entrada("John"));
        splayTree.insertar(new Entrada("Susan"));
        splayTree.insertar(new Entrada("Linda"));
        splayTree.insertar(new Entrada("Peter"));

        //Find
        System.out.println(splayTree.encontrar(6));
        System.out.println(splayTree.encontrar(1));
        System.out.println(splayTree.encontrar(7));

        //Sort
        System.out.println("--Print sorted--");
        splayTree.printOrdenados();


    }
}
