package Logica;

/**
 * Class that stores all the data needed for the players of the game. 
 * @author Erick Barrantes
 */
public class ClienteIP {
    private String clienteIp;    
    
    /**
     * Player Constructor. Receives a string to assign it to the nickname attribute
     * and gives the initial value of 0 to the score.
     * @param nickname
     * @param playerIp
     * @param playerNumber
     */
    public ClienteIP( String clienteIp) {

        this.clienteIp = clienteIp;
    }

 
    /**
     * Getter for playerIp attribute.
     * @return playerIp attribute.
     */
    public String getclienteIp() {
        return clienteIp;
    }

    /**
     * Setter for playerIp attribute
     * @param playerIp
     */
    public void setclienteIp(String clienteIp) {
        this.clienteIp = clienteIp;
    }

 
}