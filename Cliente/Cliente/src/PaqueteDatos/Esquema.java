/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kejor
 */
public class Esquema {
    String name;
    ArrayList<String> tableNames;
    ArrayList<List> Fila;
    
    public Esquema(String name, ArrayList<String> tableNames,ArrayList<List> Fila){
    this.name=name;
    this.tableNames=tableNames;
    this.Fila=Fila;
    }
}
