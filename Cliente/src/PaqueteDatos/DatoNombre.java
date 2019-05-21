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
public class DatoNombre {
    String Nombre;
    public DatoNombre (Encabezados datos){
        //Nombre= Datos.name;
        clientSend(datos.name, "DatoNombre");
        System.out.println(datos.name);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
