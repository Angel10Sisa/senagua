/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IPrecio;
import com.senagua.dao.imp.PrecioImp;
import com.senagua.rnegocio.entidades.Precio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel-Pc
 */
public class ControlEditarPrecio extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlEditarPrecio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlEditarPrecio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); */
            int ingreso = 0;
            String idpreci = request.getParameter("txtIdprecio");
            int idprecio = Integer.parseInt(idpreci);
            double preciobasico = Double.parseDouble(request.getParameter("txtPreciobasico"));
            double precioexceso = Double.parseDouble(request.getParameter("txtPrecioexceso"));
            String detalle = request.getParameter("txtDetalle");
            Precio precio = new Precio();
            IPrecio daoprecio = new PrecioImp();
            try {
                precio = daoprecio.obtener(idprecio);
                precio.setPreciobasico(preciobasico);
                precio.setPrecioexceso(precioexceso);
                precio.setDetalle(detalle);
                ingreso = daoprecio.modificar(precio);
            } catch (Exception e) {
            }
            if (ingreso > 0) {
                String error = "Precio Modificado.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("menuprecio.jsp").forward(request, response);
            } else {
                String error = "No se puedo guardar Datos.";
                request.getSession().setAttribute("error", error);
                System.out.println(error);
                //request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
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
