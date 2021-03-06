<%-- 
    Document   : formularioeliminartipocliente
    Created on : 23-jul-2018, 11:59:32
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.TipoclienteImp"%>
<%@page import="com.senagua.dao.contrato.ITipocliente"%>
<%@page import="com.senagua.rnegocio.entidades.Tipocliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SEGUANA</title>
    </head>
    <body>
        <h1>ELIMINAR TIPO CLIENTE</h1>
        <%
            String co = request.getParameter("ci");
            int cod = Integer.parseInt(co);
            String nombre = " ", descuento = " ", detalle = " ";
            Tipocliente tipo = new Tipocliente();
            ITipocliente dao1 = new TipoclienteImp();
            try {
                tipo = dao1.obtener(cod);
                nombre = tipo.getNombre();
                descuento = tipo.getDescuento();
                detalle = tipo.getDetalle();
            } catch (Exception e) {
            }
        %>
        <form name="sn" action="EliminarTipoCliente" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" name="txtCodigo" value="<%=co%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=nombre%>" required="required" placeholder="Nombres" readonly=”readonly”/>
                    </td>
                </tr>

                <tr>
                    <td>Descuento %:</td>
                    <td>
                        <select name="txtDescuento">
                            <option value="<%=descuento%>" readonly=”readonly”><%=descuento%></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Detalle:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30" readonly=”readonly”><%=detalle%></textarea>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Eliminar" name="btnEliminar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menutipocliente.jsp'"/>
                    </th>
                </tr>
            </table>

        </form>
    </center>
</body>
</html>
