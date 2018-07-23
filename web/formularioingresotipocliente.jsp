<%-- 
    Document   : formularioingresotipocliente
    Created on : 23-jul-2018, 10:32:50
    Author     : Angel-Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>INGRESO DE EMPLEADO</h1>
        <form name="sn" action="lIngresoTipoCliente" method="POST">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" value="" required="required" placeholder="Nombres"/>
                    </td>
                </tr>

                <tr>
                    <td>Descuento %:</td>
                    <td>
                        <select name="txtDescuento">
                            <%
                                int i;
                                for(i=0; i<=100; i++){
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Detalle:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30">
                        </textarea>
                    </td>
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
