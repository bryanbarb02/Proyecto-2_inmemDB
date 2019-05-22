/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteDatos;

import AVL.ArbolAVL;
import ArbolBinario.ArbolBinario;
import Arboles.AVL.*;
import Arboles.ArbolBinario.*;
import Arboles.B.*;
import Arboles.BMas.*;
import Arboles.RojoNegro.*;
import Arboles.Splay.*;
import B.ArbolB;
import BMas.ArbolBMas;
import PaqueteDatos.Esquema;
import RojoNegro.ArbolRojoNegro;
import Splay.ArbolSplay;
import Splay.Entrada;



/**
 *
 * @author Bryan
 */
public class Interactuar {
    
    public void BuscarDato(int key, String nombre){
        if (esquema.getNombre() == nombre){
            if (esquema.getTipoArbol() == "AVL"){
                avl.add(esquema.getDatos());
                avl.contains(key);
            }

            if (esquema.getTipoArbol() == "BinarioBusqueda"){
                ab.insertar(esquema.getDatos());
                ab.contains(key);

            }

            if (esquema.getTipoArbol() == "RojoNegro"){
                
                rn.anadir(esquema.getDatos());
                rn.encontrar(key);

            }

            if (esquema.getTipoArbol() == "Splay"){ 
                splay.insertar(new Entrada(esquema.getDatos()));
                splay.encontrar(key);

            }

            if (esquema.getTipoArbol() == "B"){
                b.anadir(esquema.getDatos());
                b.contains(key);

            }
        }
    }
    
    public void eliminarDato(int key, String nombre){
        if (esquema.getNombre() == nombre){
            if (esquema.getTipoArbol() == "AVL"){
                avl.removeAll(avl);
            }

            if (esquema.getTipoArbol() == "BinarioBusqueda"){
                ab.isEmpty();
            }

            if (esquema.getTipoArbol() == "RojoNegro"){
                rn.eliminarTodo();
            }

            if (esquema.getTipoArbol() == "Splay"){
                splay.limpiar();
            }

            if (esquema.getTipoArbol() == "B"){
                b.limpiar();
            }
        }
    }
    
    
    Esquema esquema;
    ArbolAVL avl = new ArbolAVL();
    ArbolBinario ab = new ArbolBinario();
    ArbolRojoNegro rn = new ArbolRojoNegro();
    ArbolSplay splay = new ArbolSplay();
    ArbolB b = new ArbolB();
}
