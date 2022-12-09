/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Formato.Mensajes;
import Modelo.Producto;

/**
 *
 * @author jorge
 */
public class CRUDProductos extends ConectarDB{
    
    public boolean registrarProducto(Producto prod){
        int res;
        try{
            res=st.executeUpdate("INSERT INTO productos(idcat,nomProd,descripcion,precio,indicador) VALUES("+prod.getIdcat()+",'"+prod.getNomProd()+"','"+prod.getDescripcion()+"',"+prod.getPrecio()+",'S')");
            
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
            Mensajes.M1("ERROR: no se puede insertar el registro en la tabla productos.."+ex);
        }
        
        return false;
    }
    
    public boolean actualizarProducto(Producto prod){
        int res;
        
        try{
            ps=conexion.prepareStatement("UPDATE productos SET nomProd=?,descripcion=?,precio=? WHERE idprod=?");
            ps.setString(1, prod.getNomProd());
            ps.setString(2, prod.getDescripcion());
            ps.setDouble(3, prod.getPrecio());
            ps.setInt(4, prod.getIdprod());
            res=ps.executeUpdate();
            
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
        Mensajes.M1("ERROR: no se puede actualizar el registro.."+ex);
        }
        return false;
    }
    
    public boolean eliminarProducto(int idprod){
        int res;
        
        try{
            ps=conexion.prepareStatement("UPDATE productos SET indicador='N' WHERE idprod=?");
            ps.setInt(1, idprod);
            res=ps.executeUpdate();
            
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
            Mensajes.M1("ERROR: no se puede eliminar el registro.."+ex);
        }
        return false;
    }
}
