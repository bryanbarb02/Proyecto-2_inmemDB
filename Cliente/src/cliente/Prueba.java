/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kejor
 */
public class Prueba {
    ArrayList<List> Matriz = new ArrayList<>();
    ArrayList<String> Mat= new ArrayList<>();
    ArrayList<String> Triz= new ArrayList<>();
    
    public void Prueba (){
        Mat.add("a");
        Mat.add("s");
        Triz.add("d");
        Triz.add("f");
        Matriz.add(Mat);
        Matriz.add(Triz);
        int r = Matriz.size();
        int t = Matriz.get(0).size();
        String [][] Datos;
        Datos = new String[r][t];        
        for (int j=0;j<Matriz.size();j++) {
        System.out.println("kakak");
            for (int k=0; k<Matriz.get(j).size();k++){
                System.out.println(Matriz.get(j).get(k));
                Datos[j][k]=(String) Matriz.get(j).get(k);
            }
         
        }
        for (String [] Dato:Datos ){
        System.out.println(Arrays.toString(Dato));
        }
    }
    
    
}

