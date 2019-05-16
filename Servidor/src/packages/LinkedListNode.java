
package packages;

import java.awt.Point;
import packages.LinkedList;


public class LinkedListNode<GenericType> {
   
    private String NomTabla;
    /** nombre de la tabla que se crea**/
    
    private String Nomcolumna;
    /** nombre de la columna que se crea**/
    
    /** tipo de dato que lleva**/
    public int entero;
    
    public String letra;
    
    public float flotador;
    
    public long largo;
    
    public double doble;
    
    /** apuntador al siguiente nodo **/
    private LinkedListNode nextNode;
    
    
    public LinkedListNode(String NomTabla,String Nomcolumna,int entero,String letra,float flotador,long largo, double doble){
        this.NomTabla = null;
        this.Nomcolumna = null;
        this.doble = 0;
        this.entero= 0;
        this.flotador = 0;
        this.largo = 0;
        this.letra = null;
        this.nextNode = null;
    }
    
    /** Get y Set del nombre de la tabla **/
    public String getNomTabla(){
        return NomTabla;
    }
   
    public void setNomTabla(String NomTabla) {
        this.NomTabla = NomTabla;
    }
    
    
    /** Get y Set del nombre de la columna **/
    public String getNomcolumna(){
        return Nomcolumna;
    }
    public void setNomcolumna(String Nomcolumna) {
        this.Nomcolumna = Nomcolumna;
    }
    
    
    /** Get y Set del double**/
    public double getdoble(){
        return doble;
    }
    public void setdoble(double getdoble) {
        this.doble = doble;
    }


    /** Get y Set del int**/
    public int getentero(){
        return entero;
    }
    public void setentero(int entero) {
        this.entero = entero;
    }
    
    
    /** Get y Set del float**/
    public float getflotador(){
        return flotador;
    }
    public void flotador(float flotador) {
        this.Nomcolumna = Nomcolumna;
    }
    
    
    /** Get y Set del long**/
    public long getlargo(){
        return largo;
    }
    public void setlargo(long largo) {
        this.largo = largo;
    }
    
    /** Get y Set del String**/
    public String getletra(){
        return letra ;
    }
    public void setletra(String letra) {
        this.letra = letra;
    }
    
    /** Get y Set del Nodo Siguiente**/
    public LinkedListNode getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

}
