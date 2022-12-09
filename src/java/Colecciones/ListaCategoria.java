/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecciones;

import Modelo.Categoria;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class ListaCategoria {
    public static ArrayList<Categoria> lista=new ArrayList();
    
    public static void agregarCategoria(Categoria cat){ lista.add(cat); }
    public static Categoria obtenerCategoria(int pos){ return lista.get(pos); }
    public static int cantidadCategoria(){ return lista.size(); }
    public static void limpiarCategoria(){ lista.removeAll(lista); }
    
    public static int obtenerIdCategoria(String nomCat){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDescripcion().equals(nomCat)) {
                return lista.get(i).getIdcat();
            }
        }
        return -1;
    }
}
