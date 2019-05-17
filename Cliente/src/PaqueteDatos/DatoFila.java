package PaqueteDatos;

import java.util.List;

/**
 *
 * @author kejor
 */
public class DatoFila {
     List Fila=null;
    public void ObtenerLista (List fila){
        System.out.println(fila);
        Fila = fila;
        System.out.print(Fila);
    }

    public List getEsquema() {
        return Fila;
    }

    public void setEsquema(List Fila) {
        this.Fila = Fila;
    }
       
}
