/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colecciones;

import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class ListaClientes {
    public static ArrayList<Cliente> lista =new ArrayList();
    
    public static void agregarCliente(Cliente cli){ lista.add(cli); }
    public static Cliente obtenerCliente(int pos){ return lista.get(pos); }
    public static int cantidadClientes(){ return lista.size(); }
    public static void limpiarClientes(){ lista.removeAll(lista); }
    
    public static int verificarLogueo(String user, String pass){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUsuario().equals(user) && lista.get(i).getPass().equals(pass)) {
                return i;
            }
        }
        return -1;
    }
    
    public static Cliente recuperarCliente(String user, String pass){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUsuario().equals(user) && lista.get(i).getPass().equals(pass)) {
                return lista.get(i);
            }
        }
        return null;
    }
}
