<%-- 
    Document   : formulariobuscarconsumomedidor
    Created on : 25-jul-2018, 23:27:17
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
        <h1>CONSUMO BUSCADO POR NUMERO MEDIDOR</h1>
        <form name="sn" action="listaconsumomedidor.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">Formulario Busqueda por Numero Medidor</td>
                    </tr>
                    <tr>
                        <td>Numero Medidor:</td>
                        <td>
                            <input type="text" name="txtNumeromedidor" value="" required="required" placeholder="Numero de medidor"/>
                        </td>
                    </tr>
                    <tr>
                    <th colspan="2">
                        <input type="submit" value="Buscar" name="btnBuscar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuconsumo.jsp'"/>
                    </th>
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
