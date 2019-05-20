/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;

/**
 *
 * @author kejor
 */
public class GetIP {
    String IP;
    public void GetIP(String Ip){
        System.out.println(Ip);
        IP=Ip;
}

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
    
}
