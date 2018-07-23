/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.controlador;

import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.ITipoempleado;
import com.senagua.dao.imp.EmpleadoImp;
import com.senagua.dao.imp.TipoempleadoImp;
import com.senagua.rnegocio.entidades.Empleado;
import com.senagua.rnegocio.entidades.Tipoempleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel-Pc
 */
public class ControlIngresoEmpleado extends HttpServlet {

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
            out.println("<title>Servlet ControlIngresoEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenidos a Servelet</h1>");
            out.println("</body>");
            out.println("</html>");*/
            int codigomayor=0, codigomenor=0;            
            List<Empleado> lista=new ArrayList<>();
            IEmpleado dao1=new EmpleadoImp();
            try {
                lista=dao1.obtener();
                for(Empleado emp2: lista){
                    codigomenor=emp2.getIdempleado();
                    if (codigomenor>codigomayor) {
                        codigomayor=codigomenor;
                    }
                }
            } catch (Exception e) {
            }            
            String cedula=request.getParameter("txtCedula");
            String nombre=request.getParameter("txtNombre");
            String apellido=request.getParameter("txtApellido");
            String tipo=request.getParameter("txtTipo");
            String usuario=request.getParameter("txtUsuario");
            String clave=request.getParameter("txtClave");
            String celular=request.getParameter("txtCelular");
            String mail=request.getParameter("txtMail");
            String observacion=request.getParameter("txtObservacion");
            codigomayor=codigomayor+1;
            out.println(codigomayor);
            out.println(cedula);
            out.println(nombre);
            out.println(apellido);
            out.println(tipo);
            out.println(usuario);
            out.println(clave);
            out.println(celular);
            out.println(mail);
            out.println(observacion);
            int insertar=0;
            Tipoempleado tipo1=new Tipoempleado();
            ITipoempleado dao2=new TipoempleadoImp();
            try {
                tipo1=dao2.obtener(tipo);
                Empleado empleado=new Empleado(codigomayor, cedula, nombre, apellido, tipo1, usuario, clave, celular, mail, observacion);
                insertar=dao1.insertar(empleado);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            out.println(tipo1.getNombre());
            if (insertar > 0) {
                    String error = "Empleado Insertado.";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("menuempleado.jsp").forward(request, response);
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
