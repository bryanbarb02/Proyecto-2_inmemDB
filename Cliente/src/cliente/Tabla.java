package cliente;

import java.util.ArrayList;
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
    public Tabla(String name, ArrayList<String> columnas) 
    { 
        
        // Frame initiallization 
        f = new JFrame(); 
  
        // Frame Title
        String Name=name;
        String[] NombreColumnas = new String[columnas.size()];
//        String[] NombreColumnas = { "Jugador", "Salario", "Numero","Estatus" };
        int i=0;
        for (String columna : columnas) {
            NombreColumnas[i]=columna;
            System.out.println("Nombre de la columna:"+columna);
            i++;
            
        }
        
        String [] [] Datos= { 
            { "Messe", "TU", "10","activo" }, 
            { "Suares", "PINCHE", "9","Activo" },
            { "Umtiti", "MADRE", "23","Activo"},
            {"Dembele", "WEY", "11","Lesionado"},
             
        }; 
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
} 


