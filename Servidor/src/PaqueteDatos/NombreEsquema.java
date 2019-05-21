/**
 * 
 * Almacena el nombre de los esquemas creados
 * 
 */
package PaqueteDatos;

import java.util.List;

/**
 *
 * @author Bryan
 */
public class NombreEsquema {
    public String NOMBRE_ESQUEMA;
    
    public NombreEsquema(String NOMBRE_ESQUEMA){
        this.NOMBRE_ESQUEMA = NOMBRE_ESQUEMA;
    
    }

    public String getNOMBRE_ESQUEMA() {
        return NOMBRE_ESQUEMA;
    }

    public void setNOMBRE_ESQUEMA(String NOMBRE_ESQUEMA) {
        this.NOMBRE_ESQUEMA = NOMBRE_ESQUEMA;
    }

    
    
}
