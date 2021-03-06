/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.ICliente;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.imp.ClienteImp;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.rnegocio.entidades.Cliente;
import com.senagua.rnegocio.entidades.Medidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel-Pc
 */
public class ControlMostrarUsuario extends HttpServlet {

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
            out.println("<title>Servlet ControlMostrarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlMostrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            List<Cliente> listacliente = new ArrayList<>();
            ICliente dao = new ClienteImp();
            List<Medidor> listamedidor = new ArrayList<>();
            IMedidor dao1 = new MedidorImp();
            try {
                listacliente = dao.obtener();
                listamedidor = dao1.obtener();
            } catch (Exception e) {
            }
            if (listacliente == null && listamedidor == null) {
                String error = "No se han encontrado articulos.";
                request.getSession().setAttribute("error", error);
            } else {
            }
            request.getSession().setAttribute("listacliente", listacliente);
            request.getSession().setAttribute("listamedidor", listamedidor);
            request.getRequestDispatcher("listausuario.jsp").forward(request, response);
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
