<%-- 
    Document   : formularioeliminartipomedidor
    Created on : 23-jul-2018, 16:32:46
    Author     : Usuario
--%>

<%@page import="com.senagua.dao.contrato.ITipomedidor"%>
<%@page import="com.senagua.dao.imp.TipomedidorImp"%>
<%@page import="com.senagua.rnegocio.entidades.Tipomedidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Eliminar Tipo Medidor</h1>
        <%
            String cod = request.getParameter("ci");
            int codigo=Integer.parseInt(cod);
            String caracteristica="";
            double multa=0;
            Tipomedidor tipo = new Tipomedidor();
            ITipomedidor dao1 = new TipomedidorImp();
            try {
                tipo = dao1.obtener(codigo);
                caracteristica=tipo.getCaracteristica();
                multa=tipo.getMulta();
            } catch (Exception e) {
            }
        %>
        <form name="sn" action="EliminarTipoMedidor" method="POST">
            <table border="0">               
                <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" name="txtCodigo" value="<%=codigo%>" required="required" placeholder="999999999" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Caracteristica:</td>
                    <td><%=caracteristica%></td>
                </tr>
                <tr>
                    <td>Multa:</td>
                    <td><%=multa%></td>
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
