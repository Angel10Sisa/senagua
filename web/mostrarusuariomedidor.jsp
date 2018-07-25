<%-- 
    Document   : mostrarusuariomedidor
    Created on : 25-jul-2018, 2:28:45
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.MedidorImp"%>
<%@page import="com.senagua.dao.contrato.IMedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Medidor"%>
<%@page import="com.senagua.dao.imp.ClienteImp"%>
<%@page import="com.senagua.dao.contrato.ICliente"%>
<%@page import="com.senagua.rnegocio.entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <center>
        <h1>DATOS DEL USUARIO</h1>
        <form name="sn" action="xxxxxx" method="POST">
            <%
                String numeromed = request.getParameter("txtNumeromedidor");
                Medidor medidor = new Medidor();
                IMedidor dao = new MedidorImp();
                try {
                    medidor = dao.obtenernumero(numeromed);
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
                    <td>Tipo de Cliente:</td>
                    <td>
                        <select name="txtTipocliente" readonly=”readonly”>
                            <option readonly=”readonly” value="<%=medidor.getCliente().getTipocliente().getNombre()%>"><%=medidor.getCliente().getTipocliente().getNombre()%></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Celular:</td>
                    <td>
                        <input type="text" name="txtCelular" value="<%=medidor.getCliente().getCelular()%>" required="required" placeholder="Celular" readonly=”readonly”/>
                    </td>
                    <td>Direccion:</td>
                    <td>
                        <input type="text" name="txtDireccion" value="<%=medidor.getCliente().getDireccion()%>" required="required" placeholder="Direccion" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" name="txtEmail" value="<%=medidor.getCliente().getApellido()%>" required="required" placeholder="ejemplo@yahoo.com" readonly=”readonly”/>
                    </td>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=medidor.getNumeromedidor()%>" required="required" placeholder="Numero de medidor" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Tipo de Medidor:</td>
                    <td>
                        <select name="txtTipomedidor" readonly=”readonly”>
                            <option readonly=”readonly” value="<%=medidor.getTipo().getCaracteristica()%>"><%=medidor.getTipo().getCaracteristica()%></option>
                        </select>
                    </td>
                    <td>Marca</td>
                    <td>
                        <input type="text" name="txtMarca" value="<%=medidor.getMarca()%>" required="required" placeholder="Marca de medidor" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td>
                        <input type="text" name="txtModelo" value="<%=medidor.getModelo()%>" required="required" placeholder="Modelo medidor" readonly=”readonly”/>
                    </td>
                    <td>Detalle del medidor:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30" readonly=”readonly”><%=medidor.getDetalle()%>
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>Observacion de Cliente:</td>
                    <td>
                        <textarea name="txtObservacion" rows="3" cols="30" readonly=”readonly”><%=medidor.getCliente().getObservacion()%>
                        </textarea>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2"><center>
                    <a href="formularioeditarusuario.jsp?ci=<%=medidor.getIdmedidor()%>" title="Editar Usuario" style="cursor:pointer">
                        <img src="images/editar.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                <td colspan="2"><center>
                    <a href="formularioeliminarusuario.jsp?ci=<%=medidor.getIdmedidor()%>" title="Eliminar Uusario" style="cursor:pointer">
                        <img src="images/eliminar.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                </tr>
            </table>
            <%
                } catch (Exception e) {
                }

            %>
            <input type="button" value="Salir" name="btnSalir" onclick="location.href = 'menuusuario.jsp'"/>
        </form>

    </center>
    </body>
</html>
