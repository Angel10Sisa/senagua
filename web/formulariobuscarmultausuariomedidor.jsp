<%-- 
    Document   : formulariobuscarmultausuariomedidor
    Created on : 26-jul-2018, 8:26:52
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
        <h1>MULTA USUARIO BUSCADO POR NUMERO DE MEDIDOR</h1>
        <form name="sn" action="listamultausuariomedidor.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">Formulari Busqueda por Medidor</td>
                    </tr>
                    <tr>
                        <td>Numero de medidor:</td>
                        <td>
                            <input type="text" name="txtNumeromedidor" value="" required="required" placeholder="Numero de Medidor"/>
                        </td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <input type="submit" value="Buscar" name="btnBuscar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menumultausuario.jsp'"/>
                    </th>
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
