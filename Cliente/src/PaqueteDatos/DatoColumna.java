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
    
    ArrayList<String> NombreColumna;
    public DatoColumna(Encabezados datos){
        //this.equals(columna);
        NombreColumna=datos.tableNames;
        //System.out.println("Name:"+datos.name);
        System.out.println("nombre de las columnas: "+datos.tableNames);
        for (String columna : datos.tableNames) {
            System.out.println("Nombre de la columna:"+columna);
        }
                
        //clientSend(datos.name, "NombreEsquema");
        clientSend(datos.tableNames, "NombreColumna");
        //System.out.println(datos.name);
        System.out.println(datos.tableNames);
        
        //////Diagmos que es un clic
        //Tabla test= new Tabla(datos.name, datos.tableNames);
        
        ///
        
//        System.out.println("Columna in new class:"+this.Esquema);
       
    }
    public ArrayList<String> getEsquema() {
        return  NombreColumna;
    }

    public void setEsquema(List Fila) {
        this.NombreColumna = NombreColumna;
    }
    
    
      
}

