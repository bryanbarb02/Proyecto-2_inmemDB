package PaqueteDatos;

import java.io.Serializable;

/**
 * Clase utilizada para registrar un nuevo jugador.
 */
public class RegistroCliente implements Serializable{
    
    /**
      * Dirección IP del jugador.
      */
    private String clienteIp;
        
    /**
     * Constructor por defecto de la clase RegistroCliente.
     */
    public RegistroCliente(){}
    
    /**
     * Constructor de la clase RegisterPack
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
     * @param clienteIp {@link RegistroCliente#playerIp}
     */
    public void setClienteIp(String clienteIp) {
        this.clienteIp = clienteIp;
    }

    
}
