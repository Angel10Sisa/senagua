<%-- 
    Document   : formularioeditartipomedidor
    Created on : 23-jul-2018, 15:57:38
    Author     : Usuario
--%>

<%@page import="com.senagua.dao.imp.TipomedidorImp"%>
<%@page import="com.senagua.dao.contrato.ITipomedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Tipomedidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>EDITAR TIPO MEDIDOR</h1>
        <%
            String multa="";
            String co = request.getParameter("ci");
            int cod = Integer.parseInt(co);
            String caracteristica = " ", observacion = " ";
            double mult;
            Tipomedidor tipo = new Tipomedidor();
            ITipomedidor dao1 = new TipomedidorImp();
            try {
                tipo = dao1.obtener(cod);
                caracteristica=tipo.getCaracteristica();
                mult=tipo.getMulta();
                multa=String.valueOf(mult);
                observacion=tipo.getObservacion();
            } catch (Exception e) {
            }
            
        %>
        <form name="sn" action="EditarTipoMedidor" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" name="txtCodigo" value="<%=co%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Caracteristica:</td>
                    <td>
                        <input type="text" name="txtCaracteristica" value="<%=caracteristica%>" required="required" placeholder="Caracteristica"/>
                    </td>
                </tr>                
                <tr>
                    <tr>
                    <td>Multa:</td>
                    <td>
                        <input type="text" name="txtMulta" value="<%=multa%>" required="required" placeholder="Valor Multa"/>
                    </td>
                </tr> 
                <tr>
                    <tr>
                    <td>Observacion:</td>
                    <td>
                        <input type="text" name="txtObservacion" value="<%=observacion%>" required="required" placeholder="Observacion"/>
                    </td>
                </tr>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Guardar" name="btnGuardar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menutipocliente.jsp'"/>
                    </th>
                </tr>
            </table>

        </form>
    </center>
    </body>
</html>
