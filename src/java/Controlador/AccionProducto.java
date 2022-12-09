/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.CRUDProductos;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "AccionProducto", urlPatterns = {"/AccionProducto"})
public class AccionProducto extends HttpServlet {

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
        
        String idprod=request.getParameter("idprod");
        String nomProd=request.getParameter("nomProd");
        String prodDes=request.getParameter("prodDes");
        String precio=request.getParameter("precio");
        String mensaje=null;
        
        try {
            Producto prod=new Producto();
            prod.setIdprod(Integer.parseInt(idprod));
            prod.setNomProd(nomProd);
            prod.setDescripcion(prodDes);
            prod.setPrecio(Double.parseDouble(precio));
            
            CRUDProductos crud=new CRUDProductos();
            
            if (request.getParameter("btnEditarUsuario")!=null) {
                if (crud.actualizarProducto(prod)) {
                    mensaje="PRODUCTO ACTUALIZADO EXITOSAMENTE";
                }
            }else if (request.getParameter("btnEliminarUsuario")!=null) {
                if (crud.eliminarProducto(prod.getIdprod())) {
                    mensaje="PRODUCTO ELIMINAR EXITOSAMENTE";
                }
            }
            
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/tablaProductos.jsp").forward(request, response); 
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
