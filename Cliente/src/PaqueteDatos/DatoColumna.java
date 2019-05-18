/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import cliente.Tabla;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kevin 
 */
public class DatoColumna {
    
    Encabezados Esquema;
    public DatoColumna(Encabezados datos){
        //this.equals(columna);
        Esquema=datos;
        System.out.println("Name:"+datos.name);
        
        for (String columna : datos.tableNames) {
            System.out.println("Nombre de la columna:"+columna);
        }
        
        //////Diagmos que es un clic
        Tabla test= new Tabla(datos.name, datos.tableNames);
        
        ///
        
//        System.out.println("Columna in new class:"+this.Esquema);
    }
    public Encabezados getEsquema() {
        return  Esquema;
    }

    public void setEsquema(List Fila) {
        this.Esquema = Esquema;
    }
    
    
      
}

