<%-- 
    Document   : formularioeliminarmulta
    Created on : 23-jul-2018, 22:29:53
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.IMulta"%>
<%@page import="com.senagua.dao.imp.MultaImp"%>
<%@page import="com.senagua.rnegocio.entidades.Multa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Eliminar Multa</h1>
        <%
            String cod = request.getParameter("ci");
            int codigo=Integer.parseInt(cod);
            String nombre="";
            double valor=0;
            Multa multa = new Multa();
            IMulta dao1 = new MultaImp();
            try {
                multa = dao1.obtener(codigo);
                nombre=multa.getNombre();
                valor=multa.getValor();
            } catch (Exception e) {
            }
        %>
        <form name="sn" action="EliminarMulta" method="POST">
            <table border="0">               
                <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" name="txtCodigo" value="<%=codigo%>" required="required" placeholder="999999999" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><%=nombre%></td>
                </tr>
                <tr>
                    <td>Valor</td>
                    <td><%=valor%></td>
                </tr>
                <tr>
                    <td colspan="2">Esta seguro que quiere eliminar este Registro?</td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Eliminar" name="btnEliminar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menumulta.jsp'"/>
                    </th>
                </tr>
            </table>
    </body>
</html>
