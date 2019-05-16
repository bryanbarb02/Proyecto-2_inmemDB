package B;

public class NodoB implements Comparable<NodoB> {
    private String caminoCompleto; 
    private int tamanoArchivo; 
    private boolean directorio; 


    public NodoB(String caminoCompleto){
        this.caminoCompleto = caminoCompleto;
        this.tamanoArchivo = -1;
        this.directorio = true;
    }

    /**
     * Constructor de archivos.
     */
    public NodoB(String rutaArchivo, int caminoCompleto){
        this.caminoCompleto = rutaArchivo;
        this.tamanoArchivo = caminoCompleto;
        this.directorio = false;
    }

    /**
     * Diseñador de archivos o carpetas.
     * con la tarea del tamaño y la propiedad, si la estructura es una carpeta
     */
    public NodoB(String caminoCompleto, int tamanoArchivo, boolean directorio){
        this.caminoCompleto = caminoCompleto;
        this.tamanoArchivo = tamanoArchivo;
        this.directorio = directorio;
    }

    public String getCaminoCompleto(){
        return caminoCompleto;
    }

    public int getTamanoArchivo(){
        return tamanoArchivo;
    }

    public boolean directorio(){
        return directorio==true;
    }

    public String toString(){
        //return fullPath + " " + fileSize;
        return caminoCompleto;
    }

    @Override
    public int compareTo(NodoB o) {
        int result;
        result = this.caminoCompleto.compareTo(o.caminoCompleto);
        if (result != 0) return result;
        result = this.caminoCompleto.length() - o.caminoCompleto.length();
        return result;

//        int result;
//        result = this.caminoCompleto.length() - o.caminoCompleto.length();
//        if (result != 0) return result;
//        result = this.caminoCompleto.compareTo(o.fullPath);
//        return result;

//        return this.caminoCompleto.compareTo(o.caminoCompleto);

//        Collections.sort(copy, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o2.getQuantity()-o1.getQuantity();
//            }
//        });
//
//        Collections.sort(prod_v, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return (o1.getCode()).compareTo(o2.getCode());
//            }
//        });
    }
}
