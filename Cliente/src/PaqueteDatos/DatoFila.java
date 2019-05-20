package PaqueteDatos;

import java.util.List;

/**
 *
 * @author kejor
 */
public class DatoFila {
     Fila fila;
     public DatoFila(Fila datos){
        fila=datos;
        
        
        for (List Filax : datos.Fila) {
            System.out.println("Nombre de la Fila:"+Filax);
        }
        DatoEsquema enviarfila = new DatoEsquema();
        //enviarfila.ObtenerFila(datos);
         
     }
    

    public Fila getEsquema() {
        return fila;
    }

    public void setEsquema(List Fila) {
        this.fila = fila;
    }
       
}
