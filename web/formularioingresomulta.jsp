<%-- 
    Document   : formularioingresomulta
    Created on : 23-jul-2018, 17:30:47
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>INGRESO MULTA</h1>
        <form name="sn" action="IngresoMulta" method="POST">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" value="" required="required" placeholder="Nombre"/>
                    </td>
                </tr>
                <tr>
                    <td>Valor:</td>
                    <td>
                        <input type="text" name="txtValor" value="" required="required" placeholder="Valor de Multa"/>
                    </td>
                </tr>
                <tr>
                    <td>Descripcion:</td>
                    <td>
                        <input type="text" name="txtDescripcion" value="" required="required" placeholder="Descripcion"/>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Guardar" name="btnGuardar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menumulta.jsp'"/>
                    </th>
                </tr>
            </table>

        </form>
    </center>
    </body>
</html>
