<%-- 
    Document   : formulariobuscarusuariomedidor
    Created on : 25-jul-2018, 2:26:21
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
        <h1>USUARIO BUSCADO POR CEDULA</h1>
        <form name="sn" action="mostrarusuariomedidor.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">Formulario Busqueda por Numero de Medidor</td>
                    </tr>
                    <tr>
                        <td>Numero de Medidor:</td>
                        <td>
                            <input type="text" name="txtNumeromedidor" value="" required="required" placeholder="Numero de Medidor"/>
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
