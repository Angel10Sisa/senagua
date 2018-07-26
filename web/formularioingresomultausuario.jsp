<%-- 
    Document   : formularioingresomultausuario
    Created on : 26-jul-2018, 1:08:34
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.ConsumoImp"%>
<%@page import="com.senagua.dao.contrato.IConsumo"%>
<%@page import="com.senagua.rnegocio.entidades.Consumo"%>
<%@page import="com.senagua.dao.contrato.IMulta"%>
<%@page import="com.senagua.dao.imp.MultaImp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.senagua.rnegocio.entidades.Multa"%>
<%@page import="java.util.List"%>
<%@page import="com.senagua.dao.contrato.IMedidor"%>
<%@page import="com.senagua.dao.imp.MedidorImp"%>
<%@page import="com.senagua.rnegocio.entidades.Medidor"%>
<%@page import="com.senagua.dao.contrato.ICliente"%>
<%@page import="com.senagua.rnegocio.entidades.Cliente"%>
<%@page import="com.senagua.dao.imp.ClienteImp"%>
<%@page import="com.senagua.dao.imp.MultaxmedidorImp"%>
<%@page import="com.senagua.dao.contrato.IMultaxmedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Multaxmedidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>INGRESO MULTA USUARIO</h1>
        <form name="sn" action="IngresoMultaUsuario" method="POST">
            <%
                String cedula = request.getParameter("ci");
                Cliente cliente = new Cliente();
                ICliente daocliente = new ClienteImp();
                Medidor medidor = new Medidor();
                IMedidor daomedidor = new MedidorImp();
                try {
                    cliente = daocliente.obtenercedula(cedula);
                    int Idmedidor = cliente.getIdcliente();
                    medidor = daomedidor.obtener(Idmedidor);
                } catch (Exception e) {
                }
            %>
            <table border="0">
                <tr>
                    <td>Nombre Usuario:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=cliente.getNombre()%>" required="required" placeholder="Cedula sin guion" readonly=”readonly”/>
                    </td>
                    <td>Apellido Usuario:</td>
                    <td>
                        <input type="text" name="txtApellido" value="<%=cliente.getApellido()%>" required="required" placeholder="Nombres Completos" readonly=”readonly”/>
                    </td>
                </tr>                
                <tr>
                    <td>Cedula</td>
                    <td>
                        <input type="text" name="txtCedula" value="<%=cliente.getCedula()%>" required="required" placeholder="Lectura anterior de medidor" readonly=”readonly”/>
                    </td>
                    <td>Numero Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=medidor.getNumeromedidor()%>" required="required" placeholder="Lectura actual de medidor" readonly=”readonly”/>
                    </td>
                </tr> 
                <tr>
                    <td>Multa</td>
                    <td>
                        <select name="txtMulta">
                            <%
                                List<Multa> lismulta = new ArrayList<Multa>();
                                IMulta daomulta = new MultaImp();
                                try {
                                    lismulta = daomulta.obtener();
                                    for (Multa multa : lismulta) {
                            %>
                            <option><%=multa.getNombre()%></option>
                            <%
                                    }
                                } catch (Exception e) {
                                }
                            %>
                        </select>
                    </td>
                    <td>Detalle:</td>
                    <td>
                        <textarea name="txtDetalle" rows="4" cols="20">
                        </textarea>
                    </td>
                </tr> 
                <tr>
                    <td colspan="2"><center>
                    <input type="submit" value="Guardar" name="btnGuardar"/>
                </center></td>
                <td colspan="2"><center>
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menumultausuario.jsp'"/>
                </center></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
