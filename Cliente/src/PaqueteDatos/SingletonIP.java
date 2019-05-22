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
public class SingletonIP {
    
    
    private static SingletonIP singletonip = null;
    private String IP;
    
    private SingletonIP(){}
    
    public static SingletonIP getInstanceSingletonIP(){
        if (singletonip == null){            
            singletonip = new SingletonIP();
        } 
            return singletonip;        
    }

    /**
     * @return the ip
     */
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the ip to set
     */
    public void setIP(String IP) {
        this.IP = IP;
    }

}

