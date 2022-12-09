/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecciones;

import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class ListaProductos {
    public static ArrayList<Producto> lista=new ArrayList();
    
    public static void agregarProducto(Producto prod){ lista.add(prod); }
    public static Producto obtenerProducto(int pos){ return lista.get(pos); }
    public static int cantidadProducto(){ return lista.size(); }
    public static void limpiarProductos(){ lista.removeAll(lista); }
}
