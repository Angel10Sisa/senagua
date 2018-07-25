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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel-Pc
 */
@WebServlet(name = "ConEditarUsuario", urlPatterns = {"/EditarUsuario"})
public class ControlEditarUsuario extends HttpServlet {

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
            out.println("<title>Servlet ControlEditarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlEditarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int ingresocliente = 0;
            int ingresomedidor = 0;
            int Idcliente = Integer.parseInt(request.getParameter("txtIdcliente"));
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
            int idmedidor = Integer.parseInt(request.getParameter("txtIdmedidor"));
            String numeromedidor = request.getParameter("txtNumeromedidor");
            String tipomedi = request.getParameter("txtTipomedidor");
            String marca = request.getParameter("txtMarca");
            String modelo = request.getParameter("txtModelo");
            String detalle = request.getParameter("txtDetalle");
            Medidor medidor = new Medidor();
            IMedidor daomedidor = new MedidorImp();
            Tipomedidor tipomedidor = new Tipomedidor();
            ITipomedidor daotipomedidor = new TipomedidorImp();
            try {
                tipocliente = daotipocliente.obtenernombre(tipocli);
                cliente = daocliente.obtener(Idcliente);
                cliente.setCedula(cedula);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setTipocliente(tipocliente);
                cliente.setCelular(celular);
                cliente.setDireccion(direccion);
                cliente.setEmail(email);
                cliente.setObservacion(observacion);
                ingresocliente = daocliente.modificar(cliente);
                cliente = daocliente.obtener(Idcliente);
                tipomedidor = daotipomedidor.obtenernombre(tipomedi);
                medidor = daomedidor.obtener(idmedidor);
                medidor.setNumeromedidor(numeromedidor);
                medidor.setCliente(cliente);
                medidor.setTipo(tipomedidor);
                medidor.setMarca(marca);
                medidor.setModelo(modelo);
                medidor.setDetalle(detalle);
                ingresomedidor = daomedidor.modificar(medidor);
            } catch (Exception e) {
            }
            if (ingresocliente > 0 && ingresomedidor > 0) {
                String error = "Usuario Modificado.";
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
