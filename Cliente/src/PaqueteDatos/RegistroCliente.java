package PaqueteDatos;

import java.io.Serializable;

/**
 * Class used to register a new player.
 */
public class RegistroCliente implements Serializable{
    
    /**
      * Ip adress of the player.
      */
    private String clienteIp;
        
    /**
     * Default constructor of the class RegisterPack.
     */
    public RegistroCliente(){}
    
    /**
     * Constructor of the class RegisterPack.
     * @param playerIp {@link RegisterPack#playerIp}
 
     */
    public RegistroCliente(String clienteIp){
        this.clienteIp = clienteIp;

    }

   
    /**
     * Returns the variable playerIp.
     * @return {@link RegistroCliente#playerIp}
     */
    public String getClienteIp() {
        return clienteIp;
    }

    /**
     * Sets the variable playerIp.
     * @param playerIp {@link RegistroCliente#playerIp}
     */
    public void setClienteIp(String clienteIp) {
        this.clienteIp = clienteIp;
    }

    
}
