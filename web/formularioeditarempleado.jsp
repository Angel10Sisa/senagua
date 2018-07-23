<%-- 
    Document   : formularioeditarempleado
    Created on : 22-jul-2018, 14:07:23
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.IEmpleado"%>
<%@page import="com.senagua.dao.imp.EmpleadoImp"%>
<%@page import="com.senagua.rnegocio.entidades.Empleado"%>
<%@page import="com.senagua.dao.imp.TipoempleadoImp"%>
<%@page import="com.senagua.dao.contrato.ITipoempleado"%>
<%@page import="com.senagua.rnegocio.entidades.Tipoempleado"%>
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
        <h1>EDITAR EMPLEADO</h1>
        <%
            String ced = request.getParameter("ci");
            String cedula=" ",nombre=" ",apellido=" ",tipo=" ",celular=" ",mail=" ",observacion=" ";
            Empleado empleado=new Empleado();
            IEmpleado dao1=new EmpleadoImp();
            try {
                    empleado=dao1.obtener(ced);
                    cedula=empleado.getCedula();
                    nombre=empleado.getNombre();
                    apellido=empleado.getApellido();
                    tipo=empleado.getTipo().getNombre();
                    celular=empleado.getCelular();
                    mail=empleado.getMail();
                    observacion=empleado.getObservacion();
                } catch (Exception e) {
                }
        %>
        <form name="sn" action="EditarEmpleado" method="POST">
            <table border="1">               
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" name="txtCedula" value="<%=cedula%>" required="required" placeholder="999999999" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=nombre%>" required="required" placeholder="Nombres"/>
                    </td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td>
                        <input type="text" name="txtApellido" value="<%=apellido%>" required="required" placeholder="Apellidos"/>
                    </td>
                </tr>

                <tr>
                    <td>Tipo:</td>
                    <td>
                        <select name="txtTipo">
                            <option value="<%=tipo%>"><%=tipo%></option>
                            <%
                                List<Tipoempleado> lista = new ArrayList<Tipoempleado>();
                                ITipoempleado dao = new TipoempleadoImp();
                                try {
                                    lista = dao.obtener();
                                    for (Tipoempleado tipo1 : lista) {
                            %>                            
                            <option><%=tipo1.getNombre()%></option>
                            <%                            }
                                } catch (Exception e) {
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Celular:</td>
                    <td>
                        <input type="text" name="txtCelular" value="<%=celular%>" required="required" placeholder="9999999999"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" name="txtMail" value="<%=mail%>" required="required" placeholder="ejemplo@yahoo.com"/>
                    </td>
                </tr>
                <tr>
                    <td>Observación:</td>
                    <td>
                        <textarea name="txtObservacion" rows="3" cols="30" ><%=observacion%>
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
    </body>
</html>
