<%-- 
    Document   : formulariobuscarempleadocedula
    Created on : 22-jul-2018, 22:36:11
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
        <h1>EMPLEADO BUSCADO POR CEDULA</h1>
        <form name="sn" action="mostrarempleadocedula.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">Formulari Busqueda por cedula</td>
                    </tr>
                    <tr>
                        <td>Cedula:</td>
                        <td>
                            <input type="text" name="txtCedula" value="" required="required" placeholder="Nombres Completos"/>
                        </td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <input type="submit" value="Buscar" name="btnBuscar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuempleado.jsp'"/>
                    </th>
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
