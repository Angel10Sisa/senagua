/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IConsumo;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.imp.ConsumoImp;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.rnegocio.entidades.Consumo;
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
 * @author Internet
 */
public class ControlIngresoConsumo extends HttpServlet {

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
            out.println("<title>Servlet ControlIngresoConsumo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>AAngel Servlet ControlIngresoConsumo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int codigo = 0;
            int codigomayor = 0, codigomenor = 0;
            List<Consumo> lista1 = new ArrayList<Consumo>();
            IConsumo dao1 = new ConsumoImp();
            String numeromedidor=request.getParameter("txtNumeromedidor");
            Medidor medidor=new Medidor();
            IMedidor daomedidor=new MedidorImp();
            try {
                lista1 = dao1.obtener();
                for (Consumo con : lista1) {
                    codigo = con.getIdconsumo();
                    codigomenor = codigo;
                    if (codigomenor > codigomayor) {
                        codigomayor = codigomenor;
                    }
                }
                medidor=daomedidor.obtenernumero(numeromedidor);
            } catch (Exception e) {
            }
            Consumo consu=new Consumo();
            IConsumo daoconsu=new ConsumoImp();
            try {
                
            } catch (Exception e) {
            }
            codigomayor=codigomayor+1;            
            out.println(codigomayor);out.println("<br>");
            out.println(medidor.getIdmedidor());out.println("<br>");
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
