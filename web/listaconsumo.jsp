<%-- 
    Document   : newjsplistaconsumo
    Created on : 25-jul-2018, 23:46:27
    Author     : Angel-Pc
--%>

<%@page import="java.util.List"%>
<%@page import="com.senagua.dao.contrato.IConsumo"%>
<%@page import="com.senagua.dao.contrato.IConsumo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.senagua.dao.imp.ConsumoImp"%>
<%@page import="com.senagua.rnegocio.entidades.Consumo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Lista Consumo</h1>
        <form name="sn" action="xxxxxxx" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Numero Medidor</td>
                    <td>Lectura Inicial</td>
                    <td>Fecha de Lectura Inicial</td>
                    <td>Lectura Anterior</td>
                    <td>Fecha de Lectura Anterior</td>
                    <td>Lectura Actual</td>
                    <td>Fecha de Lectura Actual</td>
                    <td>Lectura Final</td>
                    <td>Fecha de Lectura Final</td>
                    <td>Consumo</td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <%
                        List<Consumo> listaconsumo = new ArrayList<Consumo>();
                        IConsumo daoconsumo = new ConsumoImp();
                        try {
                            listaconsumo = daoconsumo.obtener();
                            for (Consumo consumo : listaconsumo) {
                    %>
                    <td><%=consumo.getIdconsumo()%></td>
                    <td><%=consumo.getMedidor().getNumeromedidor()%></td>
                    <td><%=consumo.getLecturainicial()%></td>
                    <td><%=consumo.getFechalecturainicial()%></td>
                    <td><%=consumo.getLecturanterior()%></td>
                    <td><%=consumo.getFechalecturaanterior()%></td>
                    <td><%=consumo.getLecturaactual()%></td>
                    <td><%=consumo.getFechalecturaactual()%></td>
                    <td><%=consumo.getLecturafinal()%></td>
                    <td><%=consumo.getFechalecturafinal()%></td>
                    <td><%=consumo.getConsumo()%></td>
                    <td colspan="2"><center>
                    <a href="formularioverconsumo.jsp?ci=<%=consumo.getIdconsumo()%>" title="Ver Consumo" style="cursor:pointer">
                        <img src="images/ver.png" alt="" width="40" height="40"/>
                    </a>
                </center></td>    
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                %>
            </table>
        </form>
        <a href="menuconsumo.jsp">MENU CONSUMO</a>
    </body>
</html>
