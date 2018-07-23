<%-- 
    Document   : listamulta
    Created on : 23-jul-2018, 17:18:42
    Author     : Usuario
--%>

<%@page import="com.senagua.dao.contrato.IMulta"%>
<%@page import="com.senagua.dao.imp.MultaImp"%>
<%@page import="com.senagua.rnegocio.entidades.Multa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Lista Multas</h1>
        <form name="sn" action="MostarMulta" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Valor</td>
                    <td>Fecha</td>
                    <td>Descripción</td>
                    <td colspan="2">
                        <a href="formularioingresomulta.jsp" title="Nueva Multa" style="cursor:pointer">
                            <img src="images/nuevo.png" alt="" width="50" height="50"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <%
                        List<Multa> lista = new ArrayList<Multa>();
                        IMulta dao = new MultaImp();
                        try {
                            lista = dao.obtener();
                            for (Multa multa : lista) {

                    %>
                    <td><%=multa.getIdmulta()%></td>
                    <td><%=multa.getNombre()%></td>
                    <td><%=multa.getValor()%></td>
                    <td><%=multa.getFecha()%></td>
                    <td><%=multa.getDescripcion()%></td>
                    <td>
                        <a href="formularioeditarmulta.jsp?ci=<%=multa.getIdmulta()%>" title="Editar Multa" style="cursor:pointer">
                            <img src="images/editar.png" alt="" width="30" height="30"/>
                        </a>
                    </td>                
                    <td>
                        <a href="xxxx.jsp?ci=<%=multa.getIdmulta()%>" title="Eliminar Multa" style="cursor:pointer">
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
        <a href="menumulta.jsp">MENU MULTA</a>
    </body>
</html>
