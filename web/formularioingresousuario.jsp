<%-- 
    Document   : formularioingresousuario
    Created on : 25-jul-2018, 0:05:54
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.TipomedidorImp"%>
<%@page import="com.senagua.dao.contrato.ITipomedidor"%>
<%@page import="com.senagua.dao.contrato.ITipomedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Tipomedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Tipomedidor"%>
<%@page import="com.senagua.dao.imp.TipoclienteImp"%>
<%@page import="com.senagua.dao.contrato.ITipocliente"%>
<%@page import="com.senagua.rnegocio.entidades.Tipocliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>EDITAR DATOS DEL USUARIO</h1>
        <form name="sn" action="IngresoUsuario" method="POST">
            <table border="0">
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" name="txtCedula" value="" required="required" placeholder="Cedula sin guion"/>
                    </td>
                    <td>Nombres:</td>
                    <td>
                        <input type="text" name="txtNombre" value="" required="required" placeholder="Nombres Completos"/>
                    </td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td>
                        <input type="text" name="txtApellido" value="" required="required" placeholder="Apellidos Completos"/>
                    </td>
                    <td>Tipo de Cliente:</td>
                    <td>
                        <select name="txtTipocliente">
                            <%
                                List<Tipocliente> listacli = new ArrayList<Tipocliente>();
                                ITipocliente daocli = new TipoclienteImp();
                                listacli = daocli.obtener();
                                for (Tipocliente tipocliente : listacli) {
                            %>
                            <option readonly=”readonly” value="<%=tipocliente.getNombre()%>"><%=tipocliente.getNombre()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Celular:</td>
                    <td>
                        <input type="text" name="txtCelular" value="" required="required" placeholder="Celular"/>
                    </td>
                    <td>Direccion:</td>
                    <td>
                        <input type="text" name="txtDireccion" value="" required="required" placeholder="Direccion"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" name="txtEmail" value="" required="required" placeholder="ejemplo@yahoo.com"/>
                    </td>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="" required="required" placeholder="Numero de medidor"/>
                    </td>
                </tr>
                <tr>
                    <td>Tipo de Medidor:</td>
                    <td>
                        <select name="txtTipomedidor">                            
                            <%
                                List<Tipomedidor> listamed = new ArrayList<Tipomedidor>();
                                ITipomedidor daomed = new TipomedidorImp();
                                listamed = daomed.obtener();
                                for (Tipomedidor tipomedidor : listamed) {
                            %>
                            <option readonly=”readonly” value="<%=tipomedidor.getCaracteristica()%>"><%=tipomedidor.getCaracteristica()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>Marca</td>
                    <td>
                        <input type="text" name="txtMarca" value="" required="required" placeholder="Marca de medidor"/>
                    </td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td>
                        <input type="text" name="txtModelo" value="" required="required" placeholder="Modelo medidor"/>
                    </td>
                    <td>Detalle del medidor:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30">
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>Observacion de Cliente:</td>
                    <td>
                        <textarea name="txtObservacion" rows="3" cols="30">
                        </textarea>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2"><center>
                    <input type="submit" value="Guardar" name="btnGuardar"/>
                </center></td>
                <td colspan="2"><center>
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuusuario.jsp'"/>
                </center></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
