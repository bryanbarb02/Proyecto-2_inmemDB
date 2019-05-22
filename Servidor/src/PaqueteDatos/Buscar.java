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
public class Buscar {
    
    Esquema esquema;
    
    
    public void BuscarDato(int key){
        if (esquema.getTipoArbol() == "AVL"){
            ArbolAVL avl = new ArbolAVL();
            avl.add(esquema.getDatos());
            avl.contains(key);
        }
        
        if (esquema.getTipoArbol() == "BinarioBusqueda"){
            ArbolBinario ab = new ArbolBinario();
            ab.insertar(esquema.getDatos());
            ab.contains(key);
            
        }
        
        if (esquema.getTipoArbol() == "RojoNegro"){
            ArbolRojoNegro rn = new ArbolRojoNegro();
            rn.anadir(esquema.getDatos());
            rn.encontrar(key);
            
        }
        
        if (esquema.getTipoArbol() == "Splay"){
            ArbolSplay splay = new ArbolSplay();
            splay.insertar(new Entrada(esquema.getDatos()));
            splay.encontrar(key);
            
        }
        
        if (esquema.getTipoArbol() == "B"){
            ArbolB b = new ArbolB();
            b.anadir(esquema.getDatos());
            b.contains(key);
            
        }
    
    }
    
}
