<%-- 
    Document   : formularioingresoempleado
    Created on : 22-jul-2018, 11:47:36
    Author     : Angel-Pc
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.senagua.dao.imp.TipoempleadoImp"%>
<%@page import="com.senagua.dao.contrato.ITipoempleado"%>
<%@page import="com.senagua.rnegocio.entidades.Tipoempleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
    <center>
        <h1>INGRESO DE EMPLEADO</h1>
        <form name="sn" action="IngresoEmpleado" method="POST">
            <table border="1">               
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" name="txtCedula" value="" required="required" placeholder="999999999"/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" value="" required="required" placeholder="Nombres"/>
                    </td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td>
                        <input type="text" name="txtApellido" value="" required="required" placeholder="Apellidos"/>
                    </td>
                </tr>

                <tr>
                    <td>Tipo:</td>
                    <td>
                        <select name="txtTipo">
                            <%
                                List<Tipoempleado> lista = new ArrayList<Tipoempleado>();
                                ITipoempleado dao = new TipoempleadoImp();
                                try {
                                    lista = dao.obtener();
                                    for (Tipoempleado tipo : lista) {


                            %>
                            <option><%=tipo.getNombre()%></option>
                            <%                            }
                                } catch (Exception e) {
                                }
                            %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Usuario:</td>
                    <td>
                        <input type="text" name="txtUsuario" value="" required="required" placeholder="Usuario"/>
                    </td>
                </tr>
                <tr>
                    <td>Clave:</td>
                    <td>
                        <input type="password" name="txtClave" value="" required="required" placeholder="Contraseña"/>
                    </td>
                </tr>
                <tr>
                    <td>Celular:</td>
                    <td>
                        <input type="text" name="txtCelular" value="" required="required" placeholder="9999999999"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" name="txtMail" value="" required="required" placeholder="ejemplo@yahoo.com"/>
                    </td>
                </tr>
                <tr>
                    <td>Observación:</td>
                    <td>
                        <textarea name="txtObservacion" rows="3" cols="30">
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Guardar" name="btnGuardar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menuempleado.jsp'"/>
                    </th>
                </tr>
            </table>

        </form>
    </center>
</body>
</html>
