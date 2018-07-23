/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.ITipocliente;
import com.senagua.dao.imp.TipoclienteImp;
import com.senagua.rnegocio.entidades.Tipocliente;
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
public class ControlIngresoTipoCliente extends HttpServlet {

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
            out.println("<title>Servlet ControlIngresoTipoCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlIngresoTipoCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int codigomayor=0, codigomenor=0;            
            List<Tipocliente> lista=new ArrayList<>();
            ITipocliente dao1=new TipoclienteImp();
            try {
                lista=dao1.obtener();
                for(Tipocliente tipo: lista){
                    codigomenor=tipo.getIdtipocliente();
                    if (codigomenor>codigomayor) {
                        codigomayor=codigomenor;
                    }
                }
            } catch (Exception e) {
            }            
            String nombre=request.getParameter("txtNombre");
            String descuento=request.getParameter("txtDescuento");
            double des=Double.parseDouble(descuento);
            double valor=0;
            valor=des/100;
            String detalle=request.getParameter("txtDetalle");
            codigomayor=codigomayor+1;
            out.println(codigomayor);
            out.println(nombre);
            out.println(descuento);
            out.println(des);
            out.println(valor);
            out.println(detalle);
            int insertar=0;
            try {
                Tipocliente tipocli=new Tipocliente(codigomayor, nombre, descuento, valor, detalle);
                insertar=dao1.insertar(tipocli);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (insertar > 0) {
                    String error = "Empleado Insertado.";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("menutipocliente.jsp").forward(request, response);
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
