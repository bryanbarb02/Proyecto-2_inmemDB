/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;

/**
 *
 * @author Fabián Fallas
 */
public class NombreListas {
    private String NombreListas;
    
    public NombreListas(String NombreListas){
        this.NombreListas = NombreListas.replaceAll("\"", "");
    } 

    /**
     * @return the NombreListas
     */
    public String getNombreListas() {
        return NombreListas.replaceAll("\"","");
    }

    /**
     * @param NombreListas the NombreListas to set
     */
    public void setNombreListas(String NombreListas) {
        this.NombreListas = NombreListas;
    }
    
}
