/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fallas
 */
public class DatoColumna {
    List Esquema=null;
    
    public DatoColumna(List Esquema){
     this.Esquema = Esquema;
    }
    
    public void ObtenerLista (List Esquema){
        System.out.println(Esquema);
        Esquema = Esquema;
        System.out.print(Esquema);
    }

    public List getEsquema() {
        return Esquema;
    }

    public void setEsquema(List Esquema) {
        this.Esquema = Esquema;
    }
    
    
}

