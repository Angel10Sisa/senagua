/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IMulta;
import com.senagua.dao.imp.MultaImp;
import com.senagua.rnegocio.entidades.Multa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControlEditarMulta extends HttpServlet {

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
            out.println("<!DOCTYPE html>");*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlEditarMulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Angel Servlet ControlEditarMulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
//            Date fecha=new Date();
//            String cod = request.getParameter("txtCodigo");
//            int codigo = Integer.parseInt(cod);
//            String nombre = request.getParameter("txtNombre");
//            String val = request.getParameter("txtValor");
//            double valor = Double.parseDouble(val);
//            String fech = request.getParameter("txtFecha");
//            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                fecha = formato.parse(fech);
//            } catch (Exception e) {
//            }
//            String descripcion = request.getParameter("txtDescripcion");
//            System.out.println(codigo);
//            System.out.println(nombre);
//            System.out.println(valor);
//            System.out.println(fecha);
//            System.out.println(descripcion);
//            int modificar = 0;
//            try {
//                Multa multa = new Multa();
//                IMulta dao1 = new MultaImp();
//                multa = dao1.obtener(codigo);
//                multa.setNombre(nombre);
//                multa.setValor(valor);
//                multa.setFecha(fecha);
//                multa.setDescripcion(descripcion);
//                modificar = dao1.modificar(multa);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            if (modificar > 0) {
//                String error = "Multa Modificado.";
//                request.getSession().setAttribute("error", error);
//                request.getRequestDispatcher("menumedidor.jsp").forward(request, response);
//            } else {
//                String error = "No se puedo guardar Datos.";
//                request.getSession().setAttribute("error", error);
//                System.out.println(error);
//                //request.getRequestDispatcher("inicio.jsp").forward(request, response);
//            }
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
