<%-- 
    Document   : formulariobuscarcedula
    Created on : 25-jul-2018, 10:45:46
    Author     : Internet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>CONSUMO BUSCADO POR CEDULA</h1>
        <form name="sn" action="listaconsumocedula.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">Formulario Busqueda por cedula</td>
                    </tr>
                    <tr>
                        <td>Cedula:</td>
                        <td>
                            <input type="text" name="txtCedula" value="" required="required" placeholder="Cedula sin guion"/>
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
