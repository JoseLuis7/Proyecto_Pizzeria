/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Colecciones.*;
import Formato.Mensajes;
import Modelo.*;


public class ActualizarListas extends ConectarDB{
    
    public void actualizarUsuarios(){
        try{
            rs=st.executeQuery("SELECT * FROM usuarios WHERE indicador='S'");
            
            while(rs.next()){
                Usuarios user=new Usuarios();
                user.setIdusuario(rs.getInt(1));
                user.setNombres(rs.getString(2));
                user.setApellidos(rs.getString(3));
                user.setAlias(rs.getString(4));
                user.setUsuario(rs.getString(5));
                user.setPass(rs.getString(6)); 
                user.setTipoacceso(rs.getString(7));
                ListaUsuarios.agregarUsuario(user);
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede actualizar la lista usuarios..."+ex); 
        }
    }
    
    public void actualizarClientes(){
        try{
            rs=st.executeQuery("SELECT * FROM clientes WHERE indicador='S'");
            
            while(rs.next()){
                Cliente cli=new Cliente();
                cli.setIdcli(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setUsuario(rs.getString(4));
                cli.setPass(rs.getString(5));
                cli.setCorreo(rs.getString(6));
                ListaClientes.agregarCliente(cli);
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede actualizar la lista clientes.."+ex);
        }
    }
    
    public void actualizarCategoria(){
        try{
            rs=st.executeQuery("SELECT * FROM categoria WHERE indicador='S'");
            
            while(rs.next()){
                Categoria cat=new Categoria();
                cat.setIdcat(rs.getInt(1));
                cat.setDescripcion(rs.getString(2));
                ListaCategoria.agregarCategoria(cat);
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede actualizar la lista categorías.."+ex);
        }
    }
    
    public void actualizarProductos(){
        try{
            rs=st.executeQuery("SELECT idprod,c.descripcion,nomProd,p.descripcion,precio FROM productos p INNER JOIN categoria c ON p.idcat=c.idcat WHERE p.indicador='S'");
            
            while(rs.next()){
                Producto prod=new Producto();
                prod.setIdprod(rs.getInt(1));
                prod.setCatDes(rs.getString(2));
                prod.setNomProd(rs.getString(3));
                prod.setDescripcion(rs.getString(4));
                prod.setPrecio(rs.getDouble(5));
                ListaProductos.agregarProducto(prod);
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR: no se puede actualizar la lista productos.."+ex);
        }
    }
}
