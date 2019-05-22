/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;

import static cliente.Cliente.clientSend;

/**
 *
 * @author kejor
 */
public class TipoArbol {
    String TipoArbol;
    public void TipoArbol(int val){
        if (val ==0){
            TipoArbol = "B";
        }
        else if (val==1){
            TipoArbol = "B+";    
        }
        else if (val == 2){
            TipoArbol = "BinarioBusqueda";
        }
        else if (val == 3 ){
            TipoArbol = "RojoNegro";
        }
        else if (val == 4 ){
            TipoArbol = "ALV";
        }
        else{
            TipoArbol = "Splay";
        }
        System.out.println(TipoArbol);
        clientSend(TipoArbol, "DatoFila");
        System.out.println(TipoArbol + "Se envian estos datos Arbol");
    }

    public String getTipoArbol() {
        return TipoArbol;
    }

    public void setTipoArbol(String TipoArbol) {
        this.TipoArbol = TipoArbol;
    }
    
}