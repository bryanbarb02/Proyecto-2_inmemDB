package Servidor;

import com.fasterxml.jackson.databind.ObjectMapper;
import PaqueteDatos.ClaseReferencia;
//import dataPackages.DataPack;
//import dataPackages.DotConnectionPack;
//mport dataPackages.ToFigurePack;
//import gameLogic.LinkedList;
//import gameLogic.Grid;
//import gameLogic.LinkedListNode;
import Logica.ClienteIP;
//import gameLogic.Queue;
import jsonLogic.JSONUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import PaqueteDatos.DatoColumna;
import PaqueteDatos.RegistroCliente;
import java.util.List;

/**
 *
 * @author Fabian Fallas
 */
public class ServerController implements Runnable{
    
   // Cuadrícula de rejilla estática privada;
    final ObjectMapper mapearObjetos = new ObjectMapper();
   // cola estática privada playerQueue;
    private ClienteIP cliente;
    // private static int turnNumber;
    // int estático privado maxTurnNumber;
    private DatoColumna Columna;
    
    /**
     * Método principal para serverController. Inicializa todos los atributos y comienza el hilo.
     * Para escuchar conexiones.
     * @param args
     * @throws Exception
     */
    public static void main (String[] args) throws Exception{
        Thread recibirPaquetes = new Thread(new ServerController());
        recibirPaquetes.start();
      //  grid = new Grid(5, 5);
        //playerQueue = new Queue();
       // turnNumber = 1;
        //maxTurnNumber = 16;
    }
    
    /**
     * After receiving a DotConnectionPack from a client, this method creates the
     * received connection in the grid, creates a string figure and send a 
     * ToFigurePack if a figure was created in the grid, sends the DotConnectionPack 
     * to the other player and finally, sends the DataPack with all the data updated.
     * 
     * @param connection
     * @throws Exception
     */
    /*
    public void createConnection(DotConnectionPack connection) throws Exception{
        int initalDotPosition = connection.getInitialDot();
        int finalDotPosition = connection.getFinalDot();
        if(initalDotPosition != 0 && finalDotPosition != 0){
            LinkedList figureList = grid.createConnection(initalDotPosition, finalDotPosition);
            String strFigure = figureToString(figureList);
            ClienteIP player = null;

            if(connection.getPlayerNumber() == 1){
                player = player1;
                sendDotConnectionPack(connection, player2.getPlayerIp());
            }
            else{
                player = player2;
                sendDotConnectionPack(connection, player1.getPlayerIp());
            }

            int score = 0;
            if(!strFigure.equals("")){
                score = figureList.getSize() * 2;
                sendToFigurePack(strFigure, player.getPlayerNumber());
            }

            player.setScore(player.getScore() + score);

            sendDataPacks(getWinnerName());
        }
    }
    */
   
    /**
     * Receives a LinkedList representing a figure and it converts it to a String
     * @param figure
     * @return
     */
    /*public String figureToString(LinkedList figure){
        String strFigure = "";
        if(figure != null){
            for(LinkedListNode node = figure.getFirstNode(); node != null; 
                node = node.getNextNode()){
                strFigure += node.getPosition() + ".";
            }
        }return strFigure;
    }*/
    
    /**
     * If a new figure was created, send a ToFigurePack to both players.
     * @param strFigure
     * @param playerNumber
     */
    /*
    public void sendToFigurePack(String strFigure, int playerNumber){
        ToFigurePack figurePack = new ToFigurePack(strFigure, playerNumber);
        ClassReference classReference = new ClassReference("ToFigurePack");
        serverSend(figurePack, classReference, player1.getPlayerIp());
        serverSend(figurePack, classReference, player2.getPlayerIp());
    }
    */
    public void enviaListaColumnas(List Esquema){
        DatoColumna Columnas = new DatoColumna(Esquema);
        ClaseReferencia claseReferencia = new ClaseReferencia("DatoColumna");
        servidorEnviar(Columnas, claseReferencia, cliente.getclienteIp());
    
    /**
     * Sends a DotConnectionPack to the IP received as a parameter.
     * @param dotConnectionPack
     * @param ip
     */
    
    
    }
    
    public void registroCliente(RegistroCliente registrocliente){
        String clienteIp = registrocliente.getClienteIp();
            ClienteIP cliente = new ClienteIP(clienteIp);
   
    }
    
    /**
     * Updates all the data needed for the clients and sends DataPacks to both players.
     * Sends the name of the winner if the maxTurnNumber is reached.
     * @param winnerName
     */
    /*/
    public void sendDataPacks(String winnerName){
        ClassReference classReference = new ClassReference("DataPack");
        int score1 = player1.getScore();
        int score2 = player2.getScore();
        String ip1 = player1.getPlayerIp();
        String ip2 = player2.getPlayerIp();
        
        DataPack packPlayer1 = new DataPack(winnerName, score1, score2, 1);
        serverSend(packPlayer1, classReference, ip1);
        
        DataPack packPlayer2 = new DataPack(winnerName, score1, score2, 2);
        serverSend(packPlayer2, classReference, ip2);
        
        turnNumber++;
        if (winnerName != null) resetData();
    }
    
    /**
     * When a RegisterPack arrives, a new player is added to the player Queue with
     * the information received and also checks if there are two players available 
     * to start a new match.
     * @param registerPack
     */
    /*
    public void registerNewPlayer(RegistroCliente registerPack){
        String playerName = registerPack.getPlayerName();
        String playerIp = registerPack.getPlayerIp();
        if(!playerQueue.contains(playerIp)){
            int playerNumber = registerPack.getPlayerNumber();

            ClienteIP player = new ClienteIP(playerName, playerIp, playerNumber);
            playerQueue.enqueue(player);

            if(playerQueue.getSize() == 2 && player1 == null && player2 == null){
                startNewMatch();
            }
        }
    }
    */
    
    
    /**
     * Dequeues the first two players in the Queue, sends registerPacks to both of them
     * and this starts a new match.
     */
    /*
    public void startNewMatch(){
        player1 = playerQueue.dequeue().getPlayer();
        player1.setPlayerNumber(1);
        player2 = playerQueue.dequeue().getPlayer();
        player2.setPlayerNumber(2);
        sendRegisterPack();
    }
    
    /**
     * Gets the data needed to send RegisterPacks to both players.
     */
    public void enviarRegistroCliente(){
        ClaseReferencia claseRederencia = new ClaseReferencia("RegistroCliente");
        String clienteIp = cliente.getclienteIp();
        RegistroCliente registrocliente = new RegistroCliente(clienteIp);
        servidorEnviar(registrocliente, claseRederencia, clienteIp);
        
    }
    
    /**
     * 
     * @return
     */
    /*
    public String getWinnerName(){
        String winner = null;
        if(turnNumber == maxTurnNumber){
            if(player1.getScore() > player2.getScore()) winner = player1.getNickname();
            else if(player1.getScore() < player2.getScore()) winner = player2.getNickname();
            else winner = "Draw";
        }return winner;
    }
    
    public void resetData(){
        turnNumber = 1;
        grid = new Grid(5, 5);
        player1 = null;
        player2 = null;
    }
    
    public void playerDisconnected(DataPack receivedDataPack){
        String winner = receivedDataPack.getWinner();
        sendDataPacks(winner);
    }
    /**
     * Sent data to the clients through sockets and in a JSON format. 
     * @param object1 Object that contains the data that will be sent.
     * @param object2 Identifier of the class sent.
     * @param ipAddress IP address of the client.
     */
    public void servidorEnviar(Object objeto1, Object objeto2, String DireccionIP){
  
        try {
            Socket serverSocket = new Socket(DireccionIP, 9099);
            
            String enviarObjeto1 = JSONUtil.convertJavaToJson(objeto1);
            String enviarObjeto2 = JSONUtil.convertJavaToJson(objeto2);                       
            
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            
            out.println(enviarObjeto1);
            out.println(enviarObjeto2);
            
            System.out.println("Mensaje enviado desde el servidor.");
           
            out.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método escucha los mensajes entrantes de los clientes.
     */
    @Override
    public void run() {
        try {
            int portNumber = 9090;
            ServerSocket server = new ServerSocket(portNumber);
            
            System.out.println("Servidor en espera de una conexión en el puerto:" + portNumber);
            
            while (true){
                Socket fromServerSocket = server.accept();
                
                BufferedReader in = new BufferedReader(new InputStreamReader(fromServerSocket.getInputStream()));
                
                String objetoRecibidoComoString = in.readLine();
                String referenciaRecibidaComoString = in.readLine();
                
                in.close();
                fromServerSocket.close();
                
                while (objetoRecibidoComoString != null && referenciaRecibidaComoString != null){
                    ClaseReferencia referencia = JSONUtil.convertJsonToJava(referenciaRecibidaComoString, ClaseReferencia.class);
                    
                    // Entrada al servidor del nombre del esquema
                    if (referencia.getReferencia().equals("NombreEsquema")){
                        NombreEsquema nombreEsq = JSONUtil.convertJsonToJava(objetoRecibidoComoString, NombreEsquema.class); 

                        System.out.println("Llegó el dato: NOMBRE_ESQUEMA ");
                        NombreEsquema nombreEsquema= new NombreEsquema(objetoRecibidoComoString); //Guarda el nombre del esquema en la clase NombreEsquema
                        System.out.println(nombreEsquema.getNOMBRE_ESQUEMA() + "\n");
                        break;                 
                    }
                    // Entrada al servidor del nombre del nombre de la columna 
                    if (referencia.getReferencia().equals("NombreColumna")){
                        NombreColumna nombreColum = JSONUtil.convertJsonToJava(objetoRecibidoComoString, NombreColumna.class); 

                        System.out.println("Llego le dato: NOMBRE_COLUMNA ");
                        NombreColumna nombreColumna= new NombreColumna(objetoRecibidoComoString);//Guarda el nombre del esquema en la clase NombreColumna
                        System.out.println(nombreColumna.getNOMBRE_COLUMNA() + "\n");
                        break;
                    }
                    /**
                    if(referencia.getReferencia().equals("RegidtroCliente")){
                        System.out.println("Llego para registrar cliente");
                        RegistroCliente receivedRegisterPack = JSONUtil.convertJsonToJava(objetoRecibidoComoString, RegistroCliente.class);                        
                        registroCliente(receivedRegisterPack);
                        break;
                    }*/
                    /*
                    if(reference.getReference().equals("DataPack")){
                        System.out.println("Data pack arrived");
                        DataPack receivedDataPack = JSONUtil.convertJsonToJava(recievedObjectAsString, DataPack.class);                        
                        playerDisconnected(receivedDataPack);
                        break;
                    }*/
                }  
            }
        } catch (Exception ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
