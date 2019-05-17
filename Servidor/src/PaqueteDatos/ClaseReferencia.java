

package PaqueteDatos;

import java.io.Serializable;

/**
 * Clase auxiliar utilizada para especificar la clase de un paquete enviado a través de sockets.
 */
public class ClaseReferencia implements Serializable{
    
    /**
     * El nombre de una clase de datos.
     */
    private String referencia;

    /**
     * Devuelve la variable de referencia.
     * @return {@link ClaseReferencia#referencia}
     */
    public String getReferencia() {
        return referencia;
    }
    
    /**
     * Constructor por defecto de la clase ClassReference.
     */
    public ClaseReferencia() {
    }
    
    /**
     * Establece el valor de la referencia de variable.
     * @param reference {@link ClassReference#reference}
     */
    public ClaseReferencia(String reference) {
        this.referencia = reference;
    }
}
