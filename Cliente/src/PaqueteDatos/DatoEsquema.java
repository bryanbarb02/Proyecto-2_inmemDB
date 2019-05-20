/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import PaqueteDatos.DatoColumna;
import PaqueteDatos.DatoFila;
import cliente.Tabla;
import java.util.List;
/**
 *
 * @author kejor
 */

public class DatoEsquema {
    Esquema Esquema;
   // datos datos;
   // public DatoEsquema(Fila datos || Encabezados datos){
    public DatoEsquema(){    
       // Tabla test= new Tabla(datos.name, datos.tableNames, datos.Fila);
    //    Tabla test= new Tabla(Encabezados.name, Encabezados.tableNames, Fila.Fila);
    }
    public Fila ObtenerFila(Fila Fila){
       return Fila; 
    }
    public String ObtenerNombre(Encabezados Encabezados){
        return Encabezados.name;
    }
    public List ObtenerNombreColumna (Encabezados Encabezados){
        return Encabezados.tableNames;
    }
    
}
