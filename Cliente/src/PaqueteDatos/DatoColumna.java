/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import cliente.Tabla;
import java.util.ArrayList;
import java.util.List;
import cliente.Cliente;
import static cliente.Cliente.clientSend;
/**
 *
 * @author Kevin 
 */
public class DatoColumna {
    List Esquema=null;
    
    public DatoColumna(Encabezados datos){
        //this.equals(columna);
        System.out.println("Name:"+datos.name);
        System.out.println("columnas: "+ datos.tableNames);
        
        for (String columna : datos.tableNames) {
            System.out.println("Nombre de la columna:"+columna);
            
        }
        clientSend(datos.name, "DatoColumna");
        clientSend(datos.tableNames, "DatoColumna");
        System.out.println(datos.name);
        System.out.println(datos.tableNames);
        //////Diagmos que es un clic
        Tabla test= new Tabla(datos.name, datos.tableNames);
        
        ///
        
//        System.out.println("Columna in new class:"+this.Esquema);
    }
    /*
    public void ObtenerLista (List esquema){
        System.out.println(esquema);
        Esquema = esquema;
        System.out.print(Esquema);
    }
*/
    public List getEsquema() {
        return Esquema;
    }

    public void setEsquema(List Esquema) {
        this.Esquema = Esquema;
    }
      
}

