<%-- 
    Document   : listaempleado
    Created on : 22-jul-2018, 7:39:50
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.IEmpleado"%>
<%@page import="com.senagua.dao.imp.EmpleadoImp"%>
<%@page import="com.senagua.rnegocio.entidades.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Lista Empleado</h1>
        <form name="sn" action="MostarEmpleado" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Cedula</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Tipo</td>
                    <td>Celular</td>
                    <td>Mail</td>
                    <td>Detalle</td>
                    <td colspan="2">
                        <a href="formularioingresoempleado.jsp" title="Nuevo Empleado" style="cursor:pointer">
                            <img src="images/nuevo.png" alt="" width="50" height="50"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <%
                        List<Empleado> lista = new ArrayList<Empleado>();
                        IEmpleado dao = new EmpleadoImp();
                        try {
                            lista = dao.obtener();
                            for (Empleado empleado : lista) {

                    %>
                    <td><%=empleado.getIdempleado()%></td>
                    <td><%=empleado.getCedula()%></td>
                    <td><%=empleado.getNombre()%></td>
                    <td><%=empleado.getApellido()%></td>
                    <td><%=empleado.getTipo().getNombre()%></td>
                    <td><%=empleado.getCelular()%></td>
                    <td><%=empleado.getMail()%></td>
                    <td><%=empleado.getObservacion()%></td>
                    <td>
                        <a href="formularioeditarempleado.jsp?ci=<%=empleado.getCedula()%>" title="Nuevo Empleado" style="cursor:pointer">
                            <img src="images/editar.png" alt="" width="30" height="30"/>
                        </a>
                    </td>                
                    <td>
                        <a href="formularioeliminarempleado.jsp?ci=<%=empleado.getCedula()%>" title="Nuevo Empleado" style="cursor:pointer">
                            <img src="images/eliminar.png" alt="" width="30" height="30"/>
                        </a>
                    </td>
                </tr>
                <%                    }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                %>
            </table>
        </form>
            <a href="menuempleado.jsp">MENU EMPLEADO</a>
    </body>
</html>
