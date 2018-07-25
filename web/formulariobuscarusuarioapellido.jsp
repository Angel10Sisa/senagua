<%-- 
    Document   : formulariobuscarusuarioapellido
    Created on : 25-jul-2018, 2:19:46
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
        <h1>FORMULARIO BUSQUEDA USUARIO POR APELLIDO</h1>
        <form name="sn" action="listausuarioapellido.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">Formulari Busqueda por nombre</td>
                    </tr>
                    <tr>
                        <td>Apellido:</td>
                        <td>
                            <input type="text" name="txtApellido" value="" required="required" placeholder="Apellidos Completos"/>
                        </td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <input type="submit" value="Buscar" name="btnBuscar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuusuario.jsp'"/>
                    </th>
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
