/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;

import java.util.ArrayList;

/**
 *
 * @author kejor
 */
public class Encabezados {
    
    String name;
    ArrayList<String> tableNames;
    
    public Encabezados(String name, ArrayList<String> tableNames){
    this.name=name;
    this.tableNames=tableNames;
    }
    
}
