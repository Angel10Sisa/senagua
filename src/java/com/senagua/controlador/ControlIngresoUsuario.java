/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.ICliente;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.ITipocliente;
import com.senagua.dao.contrato.ITipomedidor;
import com.senagua.dao.imp.ClienteImp;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.dao.imp.TipoclienteImp;
import com.senagua.dao.imp.TipomedidorImp;
import com.senagua.rnegocio.entidades.Cliente;
import com.senagua.rnegocio.entidades.Medidor;
import com.senagua.rnegocio.entidades.Tipocliente;
import com.senagua.rnegocio.entidades.Tipomedidor;
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
public class ControlIngresoUsuario extends HttpServlet {

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
            out.println("<title>Servlet ControlIngresoUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Angel Servlet ControlIngresoUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int ingresocliente = 0;
            int ingresomedidor = 0;
            int codigomayor = 0, codigomenor = 0;
            List<Cliente> listacliente = new ArrayList<>();
            ICliente daolistacliente = new ClienteImp();
            try {
                listacliente = daolistacliente.obtener();
                for (Cliente cli : listacliente) {
                    codigomenor = cli.getIdcliente();
                    if (codigomenor > codigomayor) {
                        codigomayor = codigomenor;
                    }
                }
            } catch (Exception e) {
            }
            codigomayor = codigomayor + 1;
            String cedula = request.getParameter("txtCedula");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String tipocli = request.getParameter("txtTipocliente");
            String celular = request.getParameter("txtCelular");
            String direccion = request.getParameter("txtDireccion");
            String email = request.getParameter("txtEmail");
            String observacion = request.getParameter("txtObservacion");
            Cliente cliente = new Cliente();
            ICliente daocliente = new ClienteImp();
            Tipocliente tipocliente = new Tipocliente();
            ITipocliente daotipocliente = new TipoclienteImp();
            int codigomayor1 = 0, codigomenor1 = 0;
            List<Medidor> listamedidor = new ArrayList<>();
            IMedidor daolistamedidor = new MedidorImp();
            String numeromedidor = request.getParameter("txtNumeromedidor");
            int igual = 0;
            try {
                listamedidor = daolistamedidor.obtener();
                for (Medidor me : listamedidor) {
                    if (me.getNumeromedidor().equals(numeromedidor)) {
                        igual = igual + 1;
                    }
                    codigomenor1 = me.getIdmedidor();
                    if (codigomenor1 > codigomayor1) {
                        codigomayor1 = codigomenor1;
                    }
                }
            } catch (Exception e) {
            }
            codigomayor1 = codigomayor1 + 1;
            String tipomedi = request.getParameter("txtTipomedidor");
            String marca = request.getParameter("txtMarca");
            String modelo = request.getParameter("txtModelo");
            String detalle = request.getParameter("txtDetalle");
            Medidor medidor = new Medidor();
            IMedidor daomedidor = new MedidorImp();
            Tipomedidor tipomedidor = new Tipomedidor();
            ITipomedidor daotipomedidor = new TipomedidorImp();
            if (igual != 1) {
                try {
                    tipocliente = daotipocliente.obtenernombre(tipocli);
                    Cliente clientein = new Cliente(codigomayor, cedula, nombre, apellido, tipocliente, celular, direccion, email, observacion);
                    ingresocliente = daocliente.insertar(clientein);
                    cliente = daocliente.obtener(codigomayor);
                    tipomedidor = daotipomedidor.obtenernombre(tipomedi);
                    Medidor medidorin = new Medidor(codigomayor1, numeromedidor, cliente, tipomedidor, marca, modelo, detalle);
                    ingresomedidor = daomedidor.insertar(medidorin);
                } catch (Exception e) {
                }
            }
            if (ingresocliente > 0 && ingresomedidor > 0) {
                String error = "Usuario Ingresado.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("menuusuario.jsp").forward(request, response);
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
