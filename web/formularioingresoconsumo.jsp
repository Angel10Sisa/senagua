<%-- 
    Document   : formularioingresoconsumo
    Created on : 25-jul-2018, 11:55:18
    Author     : Internet
--%>

<%@page import="com.senagua.dao.imp.ConsumoImp"%>
<%@page import="com.senagua.dao.contrato.IConsumo"%>
<%@page import="com.senagua.rnegocio.entidades.Consumo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>INGRESO DE CONSUMO MENSUAL</h1>
        <form name="sn" action="IngresoConsumo" method="POST">
            <%
                String cod = request.getParameter("ci");
                int codigo = Integer.parseInt(cod);
                Consumo consumo = new Consumo();
                IConsumo dao = new ConsumoImp();
                try {
                    consumo = dao.obtener(codigo);
            %>
            <table border="0">
                <tr>
                    <td>Codigo Consumo:</td>
                    <td>
                        <input type="text" name="txtIdconsumo" value="<%=consumo.getIdconsumo()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=consumo.getMedidor().getNumeromedidor()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre Usuario:</td>
                    <td>
                        <input type="text" name="txtNombreUsuario" value="<%=consumo.getMedidor().getCliente().getNombre()%>" required="required" placeholder="Cedula sin guion" readonly=”readonly”/>
                    </td>
                    <td>Apellido Usuario:</td>
                    <td>
                        <input type="text" name="txtApellidoUsuario" value="<%=consumo.getMedidor().getCliente().getApellido()%>" required="required" placeholder="Nombres Completos" readonly=”readonly”/>
                    </td>
                </tr>                
                <tr>
                    <td>Lectura Anterior</td>
                    <td>
                        <input type="text" name="txtLeturaanterior" value="<%=consumo.getLecturaactual()%>" required="required" placeholder="Lectura anterior de medidor" readonly=”readonly”/>
                    </td>
                    <td>Lectura Actual:</td>
                    <td>
                        <input type="text" name="txtLeturaactual" value="" required="required" placeholder="Lectura actual de medidor"/>
                    </td>
                </tr>                
                <tr>
                    <td colspan="2"><center>
                    <input type="submit" value="Guardar" name="btnGuardar"/>
                </center></td>
                <td colspan="2"><center>
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuconsumo.jsp'"/>
                </center></td>
                </tr>
            </table>
            <%
                } catch (Exception e) {
                }

            %>
        </form>

    </center>
</body>
</html>
