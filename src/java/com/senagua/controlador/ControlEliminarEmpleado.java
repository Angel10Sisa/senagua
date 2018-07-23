/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.ITipoempleado;
import com.senagua.dao.imp.EmpleadoImp;
import com.senagua.dao.imp.TipoempleadoImp;
import com.senagua.rnegocio.entidades.Empleado;
import com.senagua.rnegocio.entidades.Tipoempleado;
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
public class ControlEliminarEmpleado extends HttpServlet {

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
            out.println("<title>Servlet ControlEliminarEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Angel Servlet ControlEliminarEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int eliminar=0;
            String cedula = request.getParameter("txtCedula");
            Empleado empleado = new Empleado();
            IEmpleado dao1 = new EmpleadoImp();
            try {
                empleado = dao1.obtener(cedula);
                eliminar=dao1.eliminar(empleado);
            } catch (Exception e) {
            }
            if (eliminar > 0) {
                String error = "Empleado Elminado.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("menuempleado.jsp").forward(request, response);
            } else {
                String error = "No se puede eliminar Datos.";
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
