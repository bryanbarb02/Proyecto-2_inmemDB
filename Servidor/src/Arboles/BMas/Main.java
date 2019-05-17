/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMas;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class Main {

    public static void main(String[] args) {
        ArbolBMas<Integer> t = new ArbolBMas<Integer>(4, 4, 3);
        ArrayList<Integer> keys = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            keys.add(i);
        }
        ArrayList<Object> pointers = new ArrayList<Object>();
        for (int i = 0; i < 2; i++) {
            pointers.add(i + "");
        }
        t.insertarBulk(keys, pointers);
        System.out.println(t.print());
        System.out.println("b+");
//        System.out.println("===========================================");
        //System.out.println(t.search(10).getKeys());
//        BPTree<Integer> tr = new BPTree<Integer>(2, 2);
//        int temp = 0;
//        for (int i = 0; i < 100; i++) {
//            tr.insertNode((int) (Math.random() * 100), i + "");
//            tr.print();
//            System.out.println("==========================================");
//        }
//        tr.delete(2);
//        tr.print();
//        tr.insertNode(10, "3");
//        tr.insertNode(8, "5");
//        tr.insertNode(15, "15");
//        tr.insertNode(19, "27");
//        tr.insertNode(8, "30");
//        tr.insertNode(30, "45");
//        tr.insertNode(37, "22");
//        tr.insertNode(38, "17");
//        tr.insertNode(100, "19");
////        tr.insertNode(20, "20");
////        tr.insertNode(28, "28");
////        tr.insertNode(29, "29");
////        tr.insertNode(40, "40");
////        tr.insertNode(47, "47");
////        tr.insertNode(23, "23");
////        tr.insertNode(24, "24");
////        tr.insertNode(100, "100");
////        tr.insertNode(77, "77");
////        tr.insertNode(60, "60");
////        tr.insertNode(36, "36");
////        tr.insertNode(37, "37");
//        tr.delete(100);
//        tr.delete(38);
//        tr.delete(37);
////        tr.delete(28);
////        tr.delete(15);
////        tr.delete(19);
////        tr.delete(27);
////        tr.delete(47);
////        tr.delete(40);
////        tr.delete(23);
////        tr.delete(17);
////        tr.delete(5);
////        tr.delete(3);
////        tr.insertNode(45, "45");
////        tr.delete(24);
////        tr.delete(29);
////        tr.delete(30);
////        tr.delete(36);
////        tr.delete(45);
////        tr.delete(60);
////        tr.insertNode(33, "33");
////        tr.delete(77);
////        tr.delete(100);
////        tr.delete(100);
//        System.out.println(tr.print());

    }
    
}
