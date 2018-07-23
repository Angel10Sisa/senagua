<%-- 
    Document   : listatipomedidor
    Created on : 23-jul-2018, 12:52:34
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.rnegocio.entidades.Tipomedidor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.senagua.dao.imp.TipomedidorImp"%>
<%@page import="com.senagua.dao.contrato.ITipomedidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Lista Tipo Medidor</h1>
        <form name="sn" action="MostarMedidor" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Caracteristica</td>
                    <td>Multa</td>
                    <td>Observacion</td>
                    <td colspan="2">
                        <a href="formularioingresotipomedidor.jsp" title="Nuevo Tipo Medidor" style="cursor:pointer">
                            <img src="images/nuevo.png" alt="" width="50" height="50"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <%
                        List<Tipomedidor> lista = new ArrayList<Tipomedidor>();
                        ITipomedidor dao = new TipomedidorImp();
                        try {
                            lista = dao.obtener();
                            for (Tipomedidor tipo : lista) {

                    %>
                    <td><%=tipo.getIdtipomedidor()%></td>
                    <td><%=tipo.getCaracteristica()%></td>
                    <td><%=tipo.getMulta()%></td>
                    <td><%=tipo.getObservacion()%></td>
                    <td>
                        <a href="xxxxx.jsp?ci=<%=tipo.getIdtipomedidor()%>" title="Editar Tipo Cliente" style="cursor:pointer">
                            <img src="images/editar.png" alt="" width="30" height="30"/>
                        </a>
                    </td>                
                    <td>
                        <a href="xxxxx.jsp?ci=<%=tipo.getIdtipomedidor()%>" title="Eliminar Tipo Cliente" style="cursor:pointer">
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
