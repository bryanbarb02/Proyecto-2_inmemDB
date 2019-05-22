package PaqueteDatos;

import static cliente.Cliente.clientSend;
import java.util.List;
//abajo
import PaqueteDatos.TableInformation;
import java.util.ArrayList;

/**
 *
 * @author kejor
 */
public class DatoFila {
    public static TableInformation tb;
    
     ArrayList<List> fila ;
    public DatoFila(Fila datos){
        //abajo
        tb = TableInformation.getInstanceSingletonTableInformation();
        //fila=tb.getFilas();
        clientSend(tb.getFilas(), "DatoFila");
        //System.out.println(datos.name);
        System.out.println(tb.getFilas() + " Estas son las filas");
      //  for (List Filax : datos.Fila) {
            //System.out.println("Nombre de la Fila:"+Filax);
        //}
      //  DatoEsquema enviarfila = new DatoEsquema();
        //enviarfila.ObtenerFila(datos);
         //System.out.println("Filas: "+datos.Fila);
     }
    

    public ArrayList<List> getFila() {
        return fila;
    }

    public void setFila(List Fila) {
        this.fila = fila;
    }
       
}
