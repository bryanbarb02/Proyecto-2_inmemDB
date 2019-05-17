/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jsonLogic.JSONUtil;
import PaqueteDatos.DatoColumna;
import PaqueteDatos.ClassReference;
import PaqueteDatos.DatoFila;
import PaqueteDatos.TipoArbol;
import PaqueteDatos.RegistroCliente;

/**
 *
 * @author kejor
 */
public class Cliente  implements Runnable{
    
    public String IP;
    public static DatoColumna columna;
    public static DatoFila fila;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Ingreso().setVisible(true);
    }
  
        public static void clientSend(Object object, Object classReference){
        try {

            Socket clientSocket = new  Socket(menu.getServerIp(), 9090);
            
            String sendObject = JSONUtil.convertJavaToJson(object);
            String sendClassReference = JSONUtil.convertJavaToJson(classReference);
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            out.println(sendObject);
            out.println(sendClassReference);
            
            System.out.println("Message was sent from the client");
            
            out.close();
            clientSocket.close();
        } 
        catch (UnknownHostException ex) {
         
        } 
        catch (IOException ex) {
        
        }
    }

    /**
     * This method listens to incoming messages from the server.
     */
    @Override
    public void run() {
        try {
            int portNumber = 9099;
            ServerSocket clientAsServer = new ServerSocket(portNumber);
            
            System.out.println("Client waiting for a connection on port: " + portNumber);
            
            while (true){
                Socket fromClientSocket = clientAsServer.accept();
                              
                BufferedReader in = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
                
                String recievedObjectAsString = in.readLine();
                String recievedClassReferenceAsString = in.readLine();
                
                in.close();
                fromClientSocket.close();
                
                while (recievedObjectAsString != null && recievedClassReferenceAsString != null){
                    ClassReference reference = JSONUtil.convertJsonToJava(recievedClassReferenceAsString, ClassReference.class);

                    if (reference.getReference().equals("RegisterPack")){
                        System.out.println("Client recieved a server response: RegisterPack");
                        RegistroCliente register = JSONUtil.convertJsonToJava(recievedObjectAsString, RegistroCliente.class);
                        this.IP = register.getClienteIp();
                        break;
                    }
                    
                    
                    if (reference.getReference().equals("DatoColumna")){
                        System.out.println("Client recieved a server response: DotConnectionPack");
                        DatoColumna reciveColumnas = JSONUtil.convertJsonToJava(recievedObjectAsString, DatoColumna.class);
                        columna.ObtenerLista(reciveColumnas.getEsquema());
                        break;
                    }
                    
                    if (reference.getReference().equals("DatoColumna")){
                        System.out.println("Client recieved a server response: DotConnectionPack");
                        DatoFila reciveFilas = JSONUtil.convertJsonToJava(recievedObjectAsString, DatoFila.class);
                        fila.ObtenerLista(reciveFilas.getEsquema());
                        break;
                    }
                    /*
                    if (reference.getReference().equals("DataPack")){
                        System.out.println("Client recieved a server response: DataPack");
                        DataPack data = JSONUtil.convertJsonToJava(recievedObjectAsString, DataPack.class);
                        
                        if(data.getWinner() == null){
                            turnNumber++;
                            info.setP1Score(data.getScore1());
                            info.setP2Score(data.getScore2());
                        }else{
                            finalPack = data;
                        }
                        break;
                    }*/
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

