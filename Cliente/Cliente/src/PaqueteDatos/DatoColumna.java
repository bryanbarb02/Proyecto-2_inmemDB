/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import static cliente.Cliente.clientSend;
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
        System.out.println("nombre de las columnas: "+datos.tableNames);
        for (String columna : datos.tableNames) {
            System.out.println("Nombre de la columna:"+columna);
        }
        
        clientSend(datos.name, "DatoColumna");
        clientSend(datos.tableNames, "DatoColumna");
        System.out.println(datos.name);
        System.out.println(datos.tableNames);
        
   
        //Tabla test= new Tabla(datos.name, datos.tableNames);
        
 
    }
    public Encabezados getEsquema() {
        return  Esquema;
    }

    public void setEsquema(List Fila) {
        this.Esquema = Esquema;
    }
    
    
      
}

