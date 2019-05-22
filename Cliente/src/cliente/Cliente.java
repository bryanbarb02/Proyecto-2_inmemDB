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
import PaqueteDatos.ClassReference;
import PaqueteDatos.DatoColumna;
import PaqueteDatos.GetIP;
import PaqueteDatos.TipoArbol;
import PaqueteDatos.DatoFila;
import PaqueteDatos.DatoNombre;
import jsonLogic.JSONUtil;
import PaqueteDatos.RegistroCliente;
import PaqueteDatos.SingletonIP;



/**
 *
 * @author 
 */
    
public class Cliente  implements Runnable{
    
    public String IP;
    public static DatoColumna columna;
    public static DatoFila fila;
    public static GetIP menu; 
    public static DatoNombre nombre;
    public static SingletonIP SIP;
    public static TipoArbol TA;
    

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        
       Thread comenzar = new Thread(new Cliente());
        comenzar.start();
        System.out.println("1"); 
        new Ingreso().setVisible(true);
        menu = new GetIP();
        SIP = SingletonIP.getInstanceSingletonIP();
        
        }
        
        
        
        public static void clientSend(Object object, Object classReference){
        try {
            System.out.println(SIP.getIP() + " llego ip");
            Socket clientSocket = new  Socket(SIP.getIP(), 9090);
            
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
                //List recievedObjectAsString = in.readLine();
                
                in.close();
                fromClientSocket.close();
                
                while (recievedObjectAsString != null && recievedClassReferenceAsString != null){
                    ClassReference reference = JSONUtil.convertJsonToJava(recievedClassReferenceAsString, ClassReference.class);

                    if (reference.getReference().equals("NombreEsquema")){
                        System.out.println("Client recieved a server response: NombreEsquema");
                        DatoNombre reciveNombre = JSONUtil.convertJsonToJava(recievedObjectAsString, DatoNombre.class);
                        nombre.getNombre();
                        break;
                    }
                    
                    if (reference.getReference().equals("NombreColumna")){
                        System.out.println("Client recieved a server response: NombreColumna");
                        DatoColumna reciveColumna = JSONUtil.convertJsonToJava(recievedObjectAsString, DatoColumna.class);
                        columna.getEsquema();
                        break;
                    }
                    if (reference.getReference().equals("NombreListas")){
                        System.out.println("Client recieved a server response: NombreListas");
                        DatoFila reciveFila = JSONUtil.convertJsonToJava(recievedObjectAsString, DatoFila.class);
                        fila.getFila();
                        break;
                    }
                    
                    if (reference.getReference().equals("NombreArbol")){
                        System.out.println("Client recieved a server response: NombreArbol");
                        TipoArbol reciveArbol = JSONUtil.convertJsonToJava(recievedObjectAsString, TipoArbol.class);
                       // System.out.println(TA + "Tipo de arbol");
                        TA.getTipoArbol();
                        break;
                    }
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
