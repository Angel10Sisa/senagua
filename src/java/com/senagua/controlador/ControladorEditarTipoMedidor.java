/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.ITipomedidor;
import com.senagua.dao.imp.TipomedidorImp;
import com.senagua.rnegocio.entidades.Tipomedidor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ControladorEditarTipoMedidor extends HttpServlet {

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
            out.println("<title>Servlet ControladorEditarTipoMedidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEditarTipoMedidor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            String cod=request.getParameter("txtCodigo"); 
            int codigo=Integer.parseInt(cod);
            String caracteristica=request.getParameter("txtCaracteristica");
            String mult=request.getParameter("txtMulta");
            double multa=Double.parseDouble(mult);
            String observacion=request.getParameter("txtObservacion");
            int modificar=0;
            try {
                Tipomedidor tipomed=new Tipomedidor();
                ITipomedidor dao1=new TipomedidorImp();
                tipomed=dao1.obtener(codigo);
                tipomed.setCaracteristica(caracteristica);
                tipomed.setMulta(multa);
                tipomed.setObservacion(observacion);
                modificar=dao1.modificar(tipomed);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (modificar > 0) {
                    String error = "Tipo Medidor Modificado.";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("menutipomedidor.jsp").forward(request, response);
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
