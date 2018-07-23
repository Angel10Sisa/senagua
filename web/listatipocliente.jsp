<%-- 
    Document   : newjsplistadotipocliente
    Created on : 23-jul-2018, 10:13:45
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.ITipocliente"%>
<%@page import="com.senagua.dao.imp.TipoclienteImp"%>
<%@page import="com.senagua.rnegocio.entidades.Tipocliente"%>
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
        <h1>Lista Tipo Cliente</h1>
        <form name="sn" action="MostarEmpleado" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Descuento %</td>
                    <td>Valor</td>
                    <td>Detalle</td>
                    <td colspan="2">
                        <a href="formularioingresotipocliente.jsp" title="Nuevo Tipo Cliente" style="cursor:pointer">
                            <img src="images/nuevo.png" alt="" width="50" height="50"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <%
                        List<Tipocliente> lista = new ArrayList<Tipocliente>();
                        ITipocliente dao = new TipoclienteImp();
                        try {
                            lista = dao.obtener();
                            for (Tipocliente tipo : lista) {

                    %>
                    <td><%=tipo.getIdtipocliente()%></td>
                    <td><%=tipo.getNombre()%></td>
                    <td><%=tipo.getDescuento()%></td>
                    <td><%=tipo.getValor()%></td>
                    <td><%=tipo.getDetalle()%></td>
                    <td>
                        <a href="formularioeditartipocliente.jsp?ci=<%=tipo.getIdtipocliente()%>" title="Editar Tipo Cliente" style="cursor:pointer">
                            <img src="images/editar.png" alt="" width="30" height="30"/>
                        </a>
                    </td>                
                    <td>
                        <a href="formularioeliminartipocliente.jsp?ci=<%=tipo.getIdtipocliente()%>" title="Eliminar Tipo Cliente" style="cursor:pointer">
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
            <a href="menutipocliente.jsp">MENU TIPO CLIENTE</a>
    </body>
</html>
