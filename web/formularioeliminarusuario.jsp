<%-- 
    Document   : formularioeliminarusuario
    Created on : 25-jul-2018, 1:14:10
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.MedidorImp"%>
<%@page import="com.senagua.dao.contrato.IMedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Medidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>ELIMINAR USUARIO</h1>
        <form name="sn" action="EliminarUsuario" method="POST">
            <%
                String cod = request.getParameter("ci");
                int codigo = Integer.parseInt(cod);
                Medidor medidor = new Medidor();
                IMedidor dao = new MedidorImp();
                try {
                    medidor = dao.obtener(codigo);
            %>
            <table border="0">
                <tr>
                    <td>Codigo Medidor:</td>
                    <td>
                        <input type="text" name="txtIdmedidor" value="<%=medidor.getIdmedidor()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                    <td>Codigo Usuario:</td>
                    <td>
                        <input type="text" name="txtIdcliente" value="<%=medidor.getCliente().getIdcliente()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" name="txtCedula" value="<%=medidor.getCliente().getCedula()%>" required="required" placeholder="Cedula sin guion" readonly=”readonly”/>
                    </td>
                    <td>Nombres:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=medidor.getCliente().getNombre()%>" required="required" placeholder="Nombres Completos" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=medidor.getCliente().getApellido()%>" required="required" placeholder="Apellidos Completos" readonly=”readonly”/>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=medidor.getNumeromedidor()%>" required="required" placeholder="Numero de medidor" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">Seguro que quiere eliminar?</td>
                </tr>
                <tr>
                    <td colspan="2"><center>
                    <input type="submit" value="Eliminar" name="btnEliminar"/>
                </center></td>
                <td colspan="2"><center>
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuusuario.jsp'"/>
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
