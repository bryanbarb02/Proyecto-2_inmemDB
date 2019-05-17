
package PaqueteDatos;

import java.io.Serializable;

/**
 * Clase utilizada para registrar un nuevo jugador.
 */
public class PaqueteRegistro implements Serializable{
    
    /**
      * Dirección Ip del jugador.
      */
    private String JugadorIP;
    
    /**
      * Nombre del jugador.
      */
    private String nombreServidor;
    
    /**
      * Número del jugador.
      */
    private int numeroJugador;
    
    /**
      * Nombre del otro jugador.
      */
    private String nombreOtroJugador;
    
    /**
     * Constructor por defecto de la clase RegisterPack.
     */
    public PaqueteRegistro(){}
    
    /**
     * Constructor de la clase RegisterPack.
     * @param JugadorIP {@link RegisterPack#JugadorIP}
     * @param nombreJugador {@link RegisterPack#nombreServidor}
     * @param numeroJugador {@link RegisterPack#numeroJugador}
     */
    public PaqueteRegistro(String JugadorIP, String nombreJugador,int numeroJugador){
        this.JugadorIP = JugadorIP;
        this.nombreServidor = nombreJugador;
        this.numeroJugador = numeroJugador;
    }

    /**
     * Devuelve la variable playerIp.
     * @return {@link PaqueteRegistro#JugadorIP}
     */
    public String getPlayerIp() {
        return JugadorIP;
    }

    /**
     * Establece la variable playerIp.
     * @param playerIp {@link PaqueteRegistro#JugadorIP}
     */
    public void setPlayerIp(String playerIp) {
        this.JugadorIP = playerIp;
    }

    /**
     * Devuelve la variable playerName.
     * @return {@link PaqueteRegistro#nombreServidor}
     */
    public String getPlayerName() {
        return nombreServidor;
    }

    /**
     * Establece la variable playerName.
     * @param playerName {@link PaqueteRegistro#nombreServidor}
     */
    public void setPlayerName(String playerName) {
        this.nombreServidor = playerName;
    }

    /**
     * Devuelve la variable playerNumber.
     * @return {@link PaqueteRegistro#numeroJugador}
     */
    public int getPlayerNumber() {
        return numeroJugador;
    }

    /**
     * Establece la variable playerNumber.
     * @param playerNumber {@link PaqueteRegistro#numeroJugador}
     */
    public void setPlayerNumber(int playerNumber) {
        this.numeroJugador = playerNumber;
    }
    
    /**
     * Devuelve la variable playerNumber.
     * @return {@link PaqueteRegistro#nombreOtroJugador}
     */
    public String getOtherPlayerName() {
        return nombreOtroJugador;
    }

    /**
     * Establece la variable otherPlayerName.
     * @param otherPlayerName
     */
    public void setOtherPlayerName(String otherPlayerName) {
        this.nombreOtroJugador = otherPlayerName;
    }
}
