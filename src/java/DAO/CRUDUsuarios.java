/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Formato.Mensajes;
import Modelo.Usuarios;

/**
 *
 * @author jorge
 */
public class CRUDUsuarios extends ConectarDB{
    
    public boolean registrarUsuario(Usuarios user){
        int res;
        try{
            res=st.executeUpdate("INSERT INTO usuarios(nombres,apellidos,alias,usuario,pass,tipoacceso,indicador) VALUES ('"+user.getNombres()+"', '"+user.getApellidos()+"', '"+user.getAlias()+"', '"+user.getUsuario()+"','"+user.getPass()+"','"+user.getTipoacceso()+"','S')");
            
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
            Mensajes.M1("ERROR: no se puede insertar el registro en la tabla usuarios.."+ex);
        }
        return true;
    }
    
    public boolean actualizarUsuario(Usuarios user){
        int res;
        try{
            ps=conexion.prepareStatement("UPDATE usuarios SET nombres=?,apellidos=?,alias=?,usuario=?,pass=?,tipoacceso=? WHERE idusuario=?");
            ps.setString(1, user.getNombres());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getAlias());
            ps.setString(4, user.getUsuario());
            ps.setString(5, user.getPass());
            ps.setString(6, user.getTipoacceso());
            ps.setInt(7, user.getIdusuario());
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
            Mensajes.M1("ERROR: no se puede actualizar el registro"+ex);
        }
        return false;
    }
    
    public boolean eliminarUsuario(int iduser){
        int res;
        
        try{
            ps=conexion.prepareStatement("UPDATE usuarios SET indicador='N' WHERE idusuario=?");
            ps.setInt(1, iduser);
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
