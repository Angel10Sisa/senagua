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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ControlIngresoMulta extends HttpServlet {

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
            out.println("<title>Servlet ControlIngresoMulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlIngresoMulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int codigomayor=0, codigomenor=0;            
            List<Multa> lista=new ArrayList<>();
            IMulta dao1=new MultaImp();
            try {
                lista=dao1.obtener();
                for(Multa multa: lista){
                    codigomenor=multa.getIdmulta();
                    if (codigomenor>codigomayor) {
                        codigomayor=codigomenor;
                    }
                }
            } catch (Exception e) {
            }            
            String nombre=request.getParameter("txtNombre");
            String val=request.getParameter("txtValor");
            String descripcion=request.getParameter("txtDescripcion");
            double valor=Double.parseDouble(val);
            codigomayor=codigomayor+1;
            int insertar=0;
            try {
                Multa multa=new Multa(codigomayor, nombre, valor, new Date(), descripcion);
                insertar=dao1.insertar(multa);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (insertar > 0) {
                    String error = "Tipo Medidor Insertado.";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("menumulta.jsp").forward(request, response);
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
