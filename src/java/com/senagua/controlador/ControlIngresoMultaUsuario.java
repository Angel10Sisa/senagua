/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.IMulta;
import com.senagua.dao.contrato.IMultaxmedidor;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.dao.imp.MultaImp;
import com.senagua.dao.imp.MultaxmedidorImp;
import com.senagua.rnegocio.entidades.Medidor;
import com.senagua.rnegocio.entidades.Multa;
import com.senagua.rnegocio.entidades.Multaxmedidor;
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
 * @author Angel-Pc
 */
public class ControlIngresoMultaUsuario extends HttpServlet {

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
            out.println("<title>Servlet ControlIngresoMultaUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Angel Servlet ControlIngresoMultaUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); */
            int codigomayor = 0, codigomenor = 0;
            List<Multaxmedidor> listamultamedidor = new ArrayList<Multaxmedidor>();
            IMultaxmedidor daomultamedidor = new MultaxmedidorImp();
            try {
                listamultamedidor = daomultamedidor.obtener();
                for (Multaxmedidor multamedidor : listamultamedidor) {
                    codigomenor = multamedidor.getIdmultamedidor();
                    if (codigomenor > codigomayor) {
                        codigomayor = codigomenor;
                    }
                }
            } catch (Exception e) {
            }
            codigomayor = codigomayor + 1;            
            String numeromedidor=request.getParameter("txtNumeromedidor");
            Medidor medidor=new Medidor();
            IMedidor daomedidor=new MedidorImp();
            try {
                medidor=daomedidor.obtenernumero(numeromedidor);
            } catch (Exception e) {
            }
            String nombremulta=request.getParameter("txtMulta");
            Multa multa=new Multa();
            IMulta daomulta=new MultaImp();
            try {
                multa=daomulta.obtenernombre(nombremulta);
            } catch (Exception e) {
            }
            int insertar=0;
            String detalle=request.getParameter("txtDetalle");
            IMultaxmedidor daomedidormulta=new MultaxmedidorImp();
            try {
                Multaxmedidor multme=new Multaxmedidor(codigomayor, medidor, multa, new Date(), detalle);
                insertar=daomedidormulta.insertar(multme);
            } catch (Exception e) {
            }
            if (insertar > 0) {
                    String error = "Multa Medidor Insertado.";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("menumultausuario.jsp").forward(request, response);
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
