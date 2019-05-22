/*
 * cuando se agrega información a un esquema se tiene que envíar el nombre 
 * del esquema para ingresar la informació a ese esquema especifíco.
 */
package PaqueteDatos;

import java.util.List;

/**
 *
 * @author Bryan
 */
public class Esquema {
    String tipoArbol, nombre, Datos;
    //List Datos;
    
    public Esquema(String nombre, String Datos){
     this.tipoArbol  = tipoArbol;
     this.nombre  = nombre;
     this.Datos  = Datos;
    }
    
    
    // función añadir nuevos datos a la lista

    Esquema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    public String getTipoArbol() {
        return tipoArbol;
    }

    public void setTipoArbol(String tipoArbol) {
        this.tipoArbol = tipoArbol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDatos() {
        return Datos;
    }

    public void setDatos(String Datos) {
        this.Datos = Datos;
    }
}
