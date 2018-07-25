<%-- 
    Document   : newjsp
    Created on : 25-jul-2018, 8:07:07
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.IPrecio"%>
<%@page import="com.senagua.rnegocio.entidades.Precio"%>
<%@page import="com.senagua.dao.imp.PrecioImp"%>
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
        <form name="sn" action="xxxxxx" method="POST">
            <%
                Precio precio = new Precio();
                IPrecio daoprecio = new PrecioImp();
                try {
                    precio=daoprecio.obtener(1);
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
                        <input type="text" name="txtPreciobasico" value="<%=precio.getPreciobasico()%>" required="required" placeholder="Precio basico" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Precio Exceso:</td>
                    <td>
                        <input type="text" name="txtPrecioxceso" value="<%=precio.getPrecioexceso()%>" required="required" placeholder="Precio Exceso" readonly=”readonly”/>
                    </td>                    
                </tr>
                <tr>
                    <td>Detalle:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30" readonly=”readonly”><%=precio.getDetalle()%>
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td><center>
                    <a href="formularioeditarprecio.jsp?ci=<%=precio.getIdprecio()%>" title="Editar Precio" style="cursor:pointer">
                        <img src="images/editar.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                <td><center>
                    <a href="xxxxxx.jsp?ci=<%=precio.getIdprecio()%>" title="Eliminar Precio" style="cursor:pointer">
                        <img src="images/eliminar.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                </tr>
            </table>
            <%
                } catch (Exception e) {
                }

            %>
            <input type="button" value="Salir" name="btnSalir" onclick="location.href = 'menuprecio.jsp'"/>
        </form>
        
    </center>
    </body>
</html>
