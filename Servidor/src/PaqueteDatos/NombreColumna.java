/**
 * 
 * Almacena el nombre de las columnas de los esquemas
 * 
 */
package PaqueteDatos;

/**
 *
 * @author Bryan
 */
public class NombreColumna {
    public String nombreColumna;
    
    
    public NombreColumna(String nombreColumna){
        //this.nombreColumna = nombreColumna;
        this.nombreColumna = nombreColumna.replaceAll("\"", ""); // quita las comillas a toda la lista
    }

    
    public String getNOMBRE_COLUMNA() {
        return nombreColumna.replaceAll("\"", "");
    }

    public void setDatosCliente(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }
    
}
