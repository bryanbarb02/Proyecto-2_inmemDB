/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author Bryan
 */
public class Main {

    /**
    /**
     * 
     * 
     * PRUEBA
     *  
     */
    public static void main(String[] args){
        ArbolBinario bt = new ArbolBinario();


        bt.insertar(10);
        bt.insertar(13);
        bt.insertar(11);
        bt.insertar(12);
        bt.insertar(7);
        bt.insertar(8);
        bt.insertar(6);
        bt.remover(7);
        System.out.println(bt.contains(12));

        System.out.println(bt.findMin(bt.raiz).elemento);
    }

}
