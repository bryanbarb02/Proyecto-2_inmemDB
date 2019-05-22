/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;

/**
 *
 * @author Bryan
 */
public class crearEsquema {
    public NombreEsquema nombreEsquema;
    public NombreColumna nombreColumna;
    
    public crearEsquema(){
        Esquema esquema = new Esquema(nombreEsquema.getNOMBRE_ESQUEMA(), nombreColumna.getNOMBRE_COLUMNA());
        
    }

    public void setNombreEsquema(NombreEsquema nombreEsquema) {
        this.nombreEsquema = nombreEsquema;
    }

    public void setNombreColumna(NombreColumna nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public NombreEsquema getNombreEsquema() {
        return nombreEsquema;
    }

    public NombreColumna getNombreColumna() {
        return nombreColumna;
    }
    
     
    
}
