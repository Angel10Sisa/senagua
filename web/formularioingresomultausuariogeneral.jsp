<%-- 
    Document   : formularioingresarmultausuariogeneral
    Created on : 26-jul-2018, 8:38:14
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.rnegocio.entidades.Multa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.senagua.dao.imp.MultaImp"%>
<%@page import="com.senagua.dao.contrato.IMulta"%>
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
    <center>
        <h1>INGRESO MULTA USUARIO</h1>
        <form name="sn" action="IngresoMultaUsuario" method="POST">
            <table border="0">
                <tr>
                    <td>Numero Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="" required="required" placeholder="Lectura actual de medidor"/>
                    </td>
                    <td>Multa</td>
                    <td>
                        <select name="txtMulta">
                            <%
                                List<Multa> lismulta = new ArrayList<Multa>();
                                IMulta daomulta = new MultaImp();
                                try {
                                    lismulta = daomulta.obtener();
                                    for (Multa multa : lismulta) {
                            %>
                            <option><%=multa.getNombre()%></option>
                            <%
                                    }
                                } catch (Exception e) {
                                }
                            %>
                        </select>
                    </td>
                </tr> 
                <tr>

                    <td>Detalle:</td>
                    <td>
                        <textarea name="txtDetalle" rows="4" cols="20">
                        </textarea>
                    </td>
                    <td></td>
                    <td></td>
                </tr> 
                <tr>
                    <td colspan="2"><center>
                    <input type="submit" value="Guardar" name="btnGuardar"/>
                </center></td>
                <td colspan="2"><center>
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menumultausuario.jsp'"/>
                </center></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
