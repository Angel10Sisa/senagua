<%-- 
    Document   : formularioeditarusuario
    Created on : 24-jul-2018, 22:30:51
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.TipomedidorImp"%>
<%@page import="com.senagua.dao.contrato.ITipomedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Tipomedidor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.senagua.dao.contrato.ITipocliente"%>
<%@page import="com.senagua.dao.imp.TipoclienteImp"%>
<%@page import="com.senagua.rnegocio.entidades.Tipocliente"%>
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
        <h1>EDITAR DATOS DEL USUARIO</h1>
        <form name="sn" action="EditarUsuario" method="POST">
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
                        <input type="text" name="txtCedula" value="<%=medidor.getCliente().getCedula()%>" required="required" placeholder="Cedula sin guion"/>
                    </td>
                    <td>Nombres:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=medidor.getCliente().getNombre()%>" required="required" placeholder="Nombres Completos"/>
                    </td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td>
                        <input type="text" name="txtApellido" value="<%=medidor.getCliente().getApellido()%>" required="required" placeholder="Apellidos Completos"/>
                    </td>
                    <td>Tipo de Cliente:</td>
                    <td>
                        <select name="txtTipocliente">
                            <option readonly=”readonly” value="<%=medidor.getCliente().getTipocliente().getNombre()%>"><%=medidor.getCliente().getTipocliente().getNombre()%></option>
                            <%
                                List<Tipocliente> listacli=new ArrayList<Tipocliente>();
                                ITipocliente daocli=new TipoclienteImp();
                                listacli=daocli.obtener();
                                for(Tipocliente tipocliente:listacli){
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
                        <input type="text" name="txtCelular" value="<%=medidor.getCliente().getCelular()%>" required="required" placeholder="Celular"/>
                    </td>
                    <td>Direccion:</td>
                    <td>
                        <input type="text" name="txtDireccion" value="<%=medidor.getCliente().getDireccion()%>" required="required" placeholder="Direccion"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" name="txtEmail" value="<%=medidor.getCliente().getApellido()%>" required="required" placeholder="ejemplo@yahoo.com"/>
                    </td>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=medidor.getNumeromedidor()%>" required="required" placeholder="Numero de medidor"/>
                    </td>
                </tr>
                <tr>
                    <td>Tipo de Medidor:</td>
                    <td>
                        <select name="txtTipomedidor">
                            <option readonly=”readonly” value="<%=medidor.getTipo().getCaracteristica()%>"><%=medidor.getTipo().getCaracteristica()%></option>
                            <%
                                List<Tipomedidor> listamed=new ArrayList<Tipomedidor>();
                                ITipomedidor daomed=new TipomedidorImp();
                                listamed=daomed.obtener();
                                for(Tipomedidor tipomedidor:listamed){
                            %>
                            <option readonly=”readonly” value="<%=tipomedidor.getCaracteristica()%>"><%=tipomedidor.getCaracteristica()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>Marca</td>
                    <td>
                        <input type="text" name="txtMarca" value="<%=medidor.getMarca()%>" required="required" placeholder="Marca de medidor"/>
                    </td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td>
                        <input type="text" name="txtModelo" value="<%=medidor.getModelo()%>" required="required" placeholder="Modelo medidor"/>
                    </td>
                    <td>Detalle del medidor:</td>
                    <td>
                        <textarea name="txtDetalle" rows="3" cols="30"><%=medidor.getDetalle()%>
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>Observacion de Cliente:</td>
                    <td>
                        <textarea name="txtObservacion" rows="3" cols="30"><%=medidor.getCliente().getObservacion()%>
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
            <%
                } catch (Exception e) {
                }

            %>
        </form>

    </center>
</body>
</html>
