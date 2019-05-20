/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import PaqueteDatos.DatoColumna;
import cliente.Tabla;
import java.util.List;
/**
 *
 * @author kejor
 */

public class DatoEsquema {
    Esquema Esquema;
    public DatoEsquema(){
        //Tabla test= new Tabla(datos.name, datos.tableNames);
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
