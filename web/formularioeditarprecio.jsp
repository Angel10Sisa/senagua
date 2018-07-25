<%-- 
    Document   : formularioeditarprecio
    Created on : 25-jul-2018, 8:22:54
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.PrecioImp"%>
<%@page import="com.senagua.dao.contrato.IPrecio"%>
<%@page import="com.senagua.rnegocio.entidades.Precio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>DATOS DEL PRECIO</h1>
        <form name="sn" action="EditarPrecio" method="POST">
            <%
                Precio precio = new Precio();
                IPrecio daoprecio = new PrecioImp();
                try {
                    precio = daoprecio.obtener(1);
            %>
            <table border="0">
                <tr>
                    <td>Codigo Precio:</td>
                    <td>
                        <input type="text" name="txtIdprecio" value="<%=precio.getIdprecio()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Precio Basico:</td>
                    <td>
                        <input type="text" name="txtPreciobasico" value="<%=precio.getPreciobasico()%>" required="required" placeholder="Precio basico"/>
                    </td>
                </tr>
                <tr>
                    <td>Precio Exceso:</td>
                    <td>
                        <input type="text" name="txtPrecioxceso" value="<%=precio.getPrecioexceso()%>" required="required" placeholder="Precio Exceso"/>
                    </td>                    
                </tr>
                <tr>
                    <td>Detalle:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30"><%=precio.getDetalle()%>
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td><center>
                        <input type="submit" value="Guardar" name="btnGuardar"/>
                </center></td>
                <td><center>
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuprecio.jsp'"/>
                </center></td>
                </tr>
            </table>
            <%
                } catch (Exception e) {
                }

            %>
        </form>
    </body>
</html>
