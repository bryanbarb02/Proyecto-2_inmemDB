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
public class TableInformation {
    
    private static TableInformation tableInformation = null;
    private String nombre;
    private ArrayList<String> nombredecolumnas;
    private ArrayList<List> filas;
    
    private TableInformation(){}
    
    public static TableInformation getInstanceSingletonTableInformation(){
        if (tableInformation == null){            
            tableInformation = new TableInformation();
        } 
        System.out.println("LLego aqui la table");
            return tableInformation; 
            
            
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombredecolumnas
     */
    public ArrayList<String> getNombredecolumnas() {
        return nombredecolumnas;
    }

    /**
     * @return the filas
     */
    public ArrayList<List> getFilas() {
        return filas;
    }

    /**
     * @param nombredecolumnas the nombredecolumnas to set
     */
    public void setNombredecolumnas(ArrayList<String> nombredecolumnas) {
        this.nombredecolumnas = nombredecolumnas;
    }

    /**
     * @param filas the filas to set
     */
    public void setFilas(ArrayList<List> filas) {
        this.filas = filas;
    }
    
}
