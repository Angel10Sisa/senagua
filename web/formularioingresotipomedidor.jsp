<%-- 
    Document   : formularioingresotipomedidor
    Created on : 23-jul-2018, 13:01:53
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
        <h1>INGRESO TIPO MEDIDOR</h1>
        <form name="sn" action="IngresoTipoMedidor" method="POST">
            <table border="1">
                <tr>
                    <td>Caracteristica:</td>
                    <td>
                        <input type="text" name="txtCaracteristica" value="" required="required" placeholder="Caracteristica"/>
                    </td>
                </tr>
                <tr>
                    <td>Multa:</td>
                    <td>
                        <input type="text" name="txtMulta" value="" required="required" placeholder="Valor de Multa"/>
                    </td>
                </tr>
                <tr>
                    <td>Observacion:</td>
                    <td>
                        <input type="text" name="txtObservacion" value="" required="required" placeholder="Observación"/>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Guardar" name="btnGuardar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menutipomedidor.jsp'"/>
                    </th>
                </tr>
            </table>

        </form>
    </center>
</body>
</html>
