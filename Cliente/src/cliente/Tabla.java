package cliente;
/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Packages to import 
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
  
public class Tabla { 
    // frame 
    JFrame f; 
    // Table 
    JTable j; 
  
    // Constructor 
    Tabla() 
    { 
        
        // Frame initiallization 
        f = new JFrame(); 
  
        // Frame Title
        String Name="Barcelona";
        String[] NombreColumnas = { "Jugador", "Salario", "Numero","Estatus" };
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
        new Tabla(); 
    } 
} 


