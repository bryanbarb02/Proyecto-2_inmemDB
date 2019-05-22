package cliente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
/**
 * @author Kevin Rodríguez
 * @version 3.0
 * @param Strings
 * Esta clase crea las tablas-esquemas.
 */
public class Tabla { 
    // frame 
    JFrame f; 
    // Table 
    JTable j; 
  
    // Constructor 
    public Tabla(String name, ArrayList<String> columnas, ArrayList<List> Filas) 
    { 
        
        // Frame initiallization 
        f = new JFrame(); 
  
        // Frame Title
        String Name=name;
        String[] NombreColumnas = new String[columnas.size()];
//        String[] NombreColumnas = { "Jugador", "Salario", "Numero","Estatus" };
        int r = Filas.size();
        int t = Filas.get(0).size();
        String [][] Datos;
        Datos = new String[r][t];
        int i=0;
        for (String columna : columnas) {
            NombreColumnas[i]=columna;
            System.out.println("Nombre de la columna:"+columna);
            i++;
            
        }
        for (int j=0;j<Filas.size();j++) {
        System.out.println("llego bien a tabla");
            for (int k=0; k<Filas.get(j).size();k++){
                System.out.println(Filas.get(j).get(k));
                Datos[j][k]=(String) Filas.get(j).get(k);
            }
         
        }
        
    
        /**String [] [] Datos= { 
            { "Messe", "TU", "10","activo" }, 
            { "Suares", "PINCHE", "9","Activo" },
            { "Umtiti", "MADRE", "23","Activo"},
            {"Dembele", "WEY", "11","Lesionado"},
             
        }; **/
        f.setTitle(""+Name); 
  
        // Data to be displayed in the JTable 
        String[][] data = Datos; 
         // Column Names 
        String[] columnNames = NombreColumnas; 
  
        // Initializing the JTable 
        j = new JTable(data, columnNames); 
        j.setBounds(100, 150, 200, 300); 
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        // Frame Size 
        f.setSize(1000,1000); 
        // Frame Visible = true 
        f.setVisible(true); 
    } 
  
    // Driver  method 
    public static void main(String[] args) 
    { 
//        new Tabla(); 
    } 

   /** public Tabla(String name, ArrayList<String> tableNames,ArrayList<List> Filas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}**/
}


