/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.CRUDClientes;
import Formato.EncriptadorAES;
import Modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "AccionCliente", urlPatterns = {"/AccionCliente"})
public class AccionCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String idcli=request.getParameter("idcli");
        String nombres=request.getParameter("nombres");
        String apellidos=request.getParameter("apellidos");
        String usuario=request.getParameter("usuario");
        String pass=request.getParameter("pass");
        String clave="pizzeridonjose";
        String correo=request.getParameter("correo");
        String mensaje=null;
        
        
        try {
            EncriptadorAES aes=new EncriptadorAES();
            pass=aes.encriptar(pass, clave);
            
            Cliente cli=new Cliente();
            cli.setIdcli(Integer.parseInt(idcli));
            cli.setNombres(nombres);
            cli.setApellidos(apellidos);
            cli.setUsuario(usuario);
            cli.setPass(pass);
            cli.setCorreo(correo);
            
            CRUDClientes crud=new CRUDClientes();
            
            if (request.getParameter("btnEditarCliente")!=null) {
                if (crud.actualizarCliente(cli)) {
                    mensaje="REGISTRO ACTUALIZADO CORRECTAMENTE";
                }
            }else if (request.getParameter("btnEliminarCliente")!=null) {
                if (crud.eliminarCliente(cli.getIdcli())) {
                    mensaje="REGISTRO ELIMINADO EXITOSAMENTE";
                }
            }
            
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/tablaClientes.jsp").forward(request, response); 
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(AccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(AccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
