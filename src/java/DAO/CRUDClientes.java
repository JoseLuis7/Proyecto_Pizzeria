/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Formato.Mensajes;
import Modelo.Cliente;

/**
 *
 * @author jorge
 */
public class CRUDClientes extends ConectarDB{
    
    public boolean registrarCliente(Cliente cli){
        int res;
        
        try{
            res=st.executeUpdate("INSERT INTO clientes(nombres,apellidos,usuario,pass,email,indicador) VALUES('"+cli.getNombres()+"','"+cli.getApellidos()+"','"+cli.getUsuario()+"','"+cli.getPass()+"','"+cli.getCorreo()+"','S')");
            
            if (res!=0) {
                st.close();
                conexion.close();
                return true;
            }else {
                st.close();
                conexion.close();
                return false;
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede insertar el registro en la tabla clientes.."+ex); 
        }
        return false;
    }
    
    public boolean actualizarCliente(Cliente cli){
        int res;
        
        try{
            ps=conexion.prepareStatement("UPDATE clientes SET nombres=?,apellidos=?,usuario=?,pass=?,email=? WHERE idcli=?");
            ps.setString(1, cli.getNombres());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getUsuario());
            ps.setString(4, cli.getPass());
            ps.setString(5, cli.getCorreo());
            ps.setInt(6, cli.getIdcli());
            res=ps.executeUpdate();
            
            if (res!=0) {
                ps.close();
                conexion.close();
                return true;
            }else {
                ps.close();
                conexion.close();
                return false;
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede actualizar el registro en la tabla clientes.."+ex);
        }
        
        return false;
    }
    
    public boolean eliminarCliente(int idcli){
        int res;
        
        try{
            ps=conexion.prepareStatement("UPDATE clientes SET indicador='N' WHERE idcli=?");
            ps.setInt(1, idcli);
            res=ps.executeUpdate();
            
            if (res!=0) {
                ps.close();
                conexion.close();
                return true;
            }else {
                ps.close();
                conexion.close();
                return false;
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede eliminar el registro.."+ex); 
        }
        
        return false;
    }
}
