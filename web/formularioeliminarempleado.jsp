<%-- 
    Document   : formulaEliminarEmpleado
    Created on : 22-jul-2018, 15:43:52
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.TipoempleadoImp"%>
<%@page import="com.senagua.dao.contrato.ITipoempleado"%>
<%@page import="com.senagua.rnegocio.entidades.Tipoempleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.senagua.dao.imp.EmpleadoImp"%>
<%@page import="com.senagua.dao.contrato.IEmpleado"%>
<%@page import="com.senagua.rnegocio.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>Eliminar Empleado</h1>
        <%
            String ced = request.getParameter("ci");
            String cedula = " ", nombre = " ", apellido = " ", tipo = " ", celular = " ", mail = " ", observacion = " ";
            Empleado empleado = new Empleado();
            IEmpleado dao1 = new EmpleadoImp();
            try {
                empleado = dao1.obtener(ced);
                cedula = empleado.getCedula();
                nombre = empleado.getNombre();
                apellido = empleado.getApellido();
            } catch (Exception e) {
            }
        %>
        <form name="sn" action="EliminarEmpleado" method="POST">
            <table border="0">               
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" name="txtCedula" value="<%=cedula%>" required="required" placeholder="999999999" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><%=nombre%></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><%=apellido%></td>
                </tr>
                <tr>
                    <td colspan="2">Esta seguro que quiere eliminar este Registro?</td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Eliminar" name="btnEliminar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuempleado.jsp'"/>
                    </th>
                </tr>
            </table>
    </center>
</body>

</html>
