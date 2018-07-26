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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
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
            String numeromedidor = request.getParameter("txtNumeromedidor");
            Medidor medidor = new Medidor();
            IMedidor daomedidor = new MedidorImp();
            try {
                lista1 = dao1.obtener();
                for (Consumo con : lista1) {
                    codigo = con.getIdconsumo();
                    codigomenor = codigo;
                    if (codigomenor > codigomayor) {
                        codigomayor = codigomenor;
                    }
                }
                medidor = daomedidor.obtenernumero(numeromedidor);
            } catch (Exception e) {
            }
            Consumo consu = new Consumo();
            IConsumo daoconsu = new ConsumoImp();
            try {
                int Idconsumo = Integer.parseInt(request.getParameter("txtIdconsumo"));
                consu = daoconsu.obtener(Idconsumo);
            } catch (Exception e) {
            }
            codigomayor = codigomayor + 1;
            int lecturainicial = consu.getLecturainicial();
            Date fechalecturainicial = consu.getFechalecturainicial();

            String fecha1;
            DateFormat dateFormatter;
            dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
            fecha1 = dateFormatter.format(fechalecturainicial);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date date1=null;
            try {
                date1 = formatter.parse(fecha1);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            int lecturaanterior = consu.getLecturaactual();
            Date fechalecturaanterior = consu.getFechalecturaactual();

            String fecha2;
            DateFormat dateFormatter1;
            dateFormatter1 = DateFormat.getDateInstance(DateFormat.DEFAULT);
            fecha2 = dateFormatter.format(fechalecturaanterior);
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
            Date date2=null;
            try {
                date2 = formatter1.parse(fecha2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            out.println(date2);

            int lecturaactural = Integer.parseInt(request.getParameter("txtLecturaactual"));
            Date fechalecturaactual = new Date();
            int lecturafinal = lecturaactural;
            Date fechalecturafinal = new Date();
            int consumo = lecturaactural - lecturaanterior;
            int insertar = 0;
            try {
                Consumo consumoingreso = new Consumo(codigomayor, medidor, lecturainicial, date1, lecturaanterior, date2, lecturaactural, fechalecturaactual, lecturafinal, fechalecturafinal, consumo);
                insertar = daoconsu.insertar(consumoingreso);
            } catch (Exception e) {
            }
            if (insertar > 0) {
                String error = "Consumo Insertado.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("menuconsumo.jsp").forward(request, response);
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
