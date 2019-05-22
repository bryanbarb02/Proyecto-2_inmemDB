package Servidor;

import com.fasterxml.jackson.databind.ObjectMapper;
import PaqueteDatos.ClaseReferencia;
import Logica.ClienteIP;
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
import PaqueteDatos.Esquema;
import PaqueteDatos.NombreArbol;
import PaqueteDatos.NombreColumna;
import PaqueteDatos.NombreEsquema;
import PaqueteDatos.NombreListas;
import PaqueteDatos.RegistroCliente;
import PaqueteDatos.crearEsquema;
import java.util.List;

/**
 *
 * @author Fabian Fallas
 */
public class ServerController implements Runnable{

    final ObjectMapper mapearObjetos = new ObjectMapper();
    private ClienteIP cliente;
    private DatoColumna Columna;
    public Esquema ESQUEMA;
    
    /**
     * Método principal para serverController. Inicializa todos los atributos y comienza el hilo.
     * Para escuchar conexiones.
     * @param args
     * @throws Exception
     */
    public static void main (String[] args) throws Exception{
        Thread recibirPaquetes = new Thread(new ServerController());
        recibirPaquetes.start();
    }

    public void enviaListaColumnas(List Esquema){
        DatoColumna Columnas = new DatoColumna(Esquema);
        ClaseReferencia claseReferencia = new ClaseReferencia("DatoColumna");
        servidorEnviar(Columnas, claseReferencia, cliente.getclienteIp());  
    }
    
    public void registroCliente(RegistroCliente registrocliente){
        String clienteIp = registrocliente.getClienteIp();
            ClienteIP cliente = new ClienteIP(clienteIp);
   
    }
    
    /**
     * Obtiene los datos necesarios para enviar RegisterPacks a ambos jugadores.
     */
    public void enviarRegistroCliente(){
        ClaseReferencia claseRederencia = new ClaseReferencia("RegistroCliente");
        String clienteIp = cliente.getclienteIp();
        RegistroCliente registrocliente = new RegistroCliente(clienteIp);
        servidorEnviar(registrocliente, claseRederencia, clienteIp);
        
    }
    
    /**
     * Envíe datos a los clientes a través de sockets y en un formato JSON.
     * @param object1 Objeto que contiene los datos que se enviarán.
     * @param object2 Identificador de la clase enviada.
     * @param ipAddress dirección IP del cliente.
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
                                                
                        //nombreEsq.setNOMBRE_ESQUEMA(objetoRecibidoComoString);
                        System.out.println("Llegó el dato: NOMBRE_ESQUEMA ");
                        NombreEsquema nombreEsquema= new NombreEsquema(objetoRecibidoComoString); //Guarda el nombre del esquema en la clase NombreEsquema
                        nombreEsquema.setNOMBRE_ESQUEMA(objetoRecibidoComoString);
                        System.out.println(nombreEsquema.getNOMBRE_ESQUEMA() + "\n");
                        break;                 
                    }

                    
                    // Entrada al servidor del nombre de la columna 
                    if (referencia.getReferencia().equals("NombreColumna")){
                        NombreColumna nombreColum = JSONUtil.convertJsonToJava(objetoRecibidoComoString, NombreColumna.class); 

                        System.out.println("Llego le dato: NOMBRE_COLUMNA ");
                        NombreColumna nombreColumna= new NombreColumna(objetoRecibidoComoString);//Guarda el nombre del esquema en la clase NombreColumna
                        nombreColumna.setDatosCliente(objetoRecibidoComoString);
                        System.out.println(nombreColumna.getNOMBRE_COLUMNA() + "\n");
                        break;
                    }
                    if (referencia.getReferencia().equals("NombreArbol")){
                        NombreArbol nombreArbo = JSONUtil.convertJsonToJava(objetoRecibidoComoString, NombreArbol.class); 

                        System.out.println("Llego le dato: Nombres_Arbol ");
                        NombreArbol nombreArbol= new NombreArbol(objetoRecibidoComoString);//Guarda el nombre del esquema en la clase NombreColumna
                        nombreArbol.setGetNombre_Arbol(objetoRecibidoComoString);
                        System.out.println(nombreArbol.getGetNombre_Arbol() + "\n");
                        break;
                    }
                    if (referencia.getReferencia().equals("NombreListas")){
                        NombreListas nombreList = JSONUtil.convertJsonToJava(objetoRecibidoComoString, NombreListas.class); 

                        System.out.println("Llego le dato: NombresListas ");
                        NombreListas nombreListas= new NombreListas(objetoRecibidoComoString);//Guarda el nombre del esquema en la clase NombreColumna
                        nombreListas.setNombreListas(objetoRecibidoComoString);
                        System.out.println(nombreListas.getNombreListas() + "\n");
                        break;
                    }

                    
                    
                }  
            }
        } catch (Exception ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

