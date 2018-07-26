/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.IFacturamulta;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.IMulta;
import com.senagua.dao.contrato.IMultaxmedidor;
import com.senagua.dao.imp.EmpleadoImp;
import com.senagua.dao.imp.FacturamultaImp;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.dao.imp.MultaImp;
import com.senagua.dao.imp.MultaxmedidorImp;
import com.senagua.rnegocio.entidades.Empleado;
import com.senagua.rnegocio.entidades.Facturamulta;
import com.senagua.rnegocio.entidades.Medidor;
import com.senagua.rnegocio.entidades.Multa;
import com.senagua.rnegocio.entidades.Multaxmedidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractList;
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
public class ControlActualizarFacturaMulta extends HttpServlet {

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
            out.println("<title>Servlet ControlActualizarFacturaMulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlActualizarFacturaMulta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            
            List<Multaxmedidor> listamultamedidor = new ArrayList<Multaxmedidor>();
            int ingreso = 0;
            IMultaxmedidor daomultamedidor = new MultaxmedidorImp();
            try {
                listamultamedidor = daomultamedidor.obtener();
                for (Multaxmedidor multamedidor : listamultamedidor) {
                    int codigomayor = 0, codigomenor = 0;
                    List<Facturamulta> listafacuturamulta = new ArrayList<Facturamulta>();
                    IFacturamulta daofacturamulta = new FacturamultaImp();
                    try {
                        listafacuturamulta = daofacturamulta.obtener();
                        for (Facturamulta facturamulta : listafacuturamulta) {
                            codigomenor = facturamulta.getIdfactura();
                            if (codigomenor > codigomayor) {
                                codigomayor = codigomenor;
                            }
                        }
                    } catch (Exception e) {
                    }
                    if (multamedidor.getMulta().getNombre().equals("ninguno")) {
                      
                    }else{
                        codigomayor = codigomayor + 1;
                        Medidor medidor = multamedidor.getMedidor();
                        //Combiar empleado
                        Empleado empleado = new Empleado();
                        IEmpleado daoempleado = new EmpleadoImp();
                        empleado = daoempleado.obtener(1);
                        Date fecha = new Date();
                        String direccion = "Bayushic";
                        Multa multa = multamedidor.getMulta();
                        double subtotal = multamedidor.getMulta().getValor();
                        double descuento = multamedidor.getMedidor().getCliente().getTipocliente().getValor() * subtotal;
                        double totalpagar = subtotal - descuento;
                        String detalle = "ninguno";
                        String estado = "pendiente";
                        Facturamulta facturamulta1 = new Facturamulta(codigomayor, medidor, empleado, fecha, direccion, multamedidor, subtotal, descuento, totalpagar, detalle, estado);
                        IFacturamulta daofacturamulta1 = new FacturamultaImp();
                        ingreso = daofacturamulta1.insertar(facturamulta1);
                    }
                }
            } catch (Exception e) {
            }
            
            List<Multaxmedidor> listeditarfac = new ArrayList<Multaxmedidor>();
            IMultaxmedidor daomultafac = new MultaxmedidorImp();
            try {
                listeditarfac = daomultafac.obtener();
                for (Multaxmedidor edi : listeditarfac) {
                    Multaxmedidor editar = edi;
                    Multa multa = new Multa();
                    IMulta daomulta = new MultaImp();
                    multa = daomulta.obtenernombre("ninguno");
                    editar.setMulta(multa);
                    daomultafac.modificar(editar);
                }
            } catch (Exception e) {
            }
            
            if (ingreso > 0) {
                String error = "Insertar Facturas.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("menufacturamulta.jsp").forward(request, response);
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
