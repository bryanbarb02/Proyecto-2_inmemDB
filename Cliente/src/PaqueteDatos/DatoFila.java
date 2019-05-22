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
        
        clientSend(tb.getFilas(), "DatoFila");
       
        System.out.println(tb.getFilas() + " Estas son las filas");
      
     }
    

    public ArrayList<List> getFila() {
        return fila;
    }

    public void setFila(List Fila) {
        this.fila = fila;
    }
       
}
