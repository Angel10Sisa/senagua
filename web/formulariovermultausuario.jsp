<%-- 
    Document   : formulariovermultausuario
    Created on : 26-jul-2018, 0:25:52
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.IMultaxmedidor"%>
<%@page import="com.senagua.dao.imp.MultaxmedidorImp"%>
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
        <h1>DATOS DEL MULTA</h1>
        <form name="sn" action="xxxxxx" method="POST">
            <%
                String cod = request.getParameter("ci");
                int codigo = Integer.parseInt(cod);
                Multaxmedidor multa=new Multaxmedidor();
                IMultaxmedidor daomulta=new MultaxmedidorImp();
                try {
                    multa = daomulta.obtener(codigo);
            %>
            <table border="0">
                <tr>
                    <td>Codigo Multa:</td>
                    <td>
                        <input type="text" name="txtIdmulta" value="<%=multa.getIdmultamedidor()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=multa.getMedidor().getNumeromedidor()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Cedula:</td>
                    <td>
                        <input type="text" name="txtCedula" value="<%=multa.getMedidor().getCliente().getCedula()%>" required="required" placeholder="Cedula sin guion" readonly=”readonly”/>
                    </td>
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=multa.getMedidor().getCliente().getNombre()%>" required="required" placeholder="Nombres Completos" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td>
                        <input type="text" name="txtApellido" value="<%=multa.getMedidor().getCliente().getApellido()%>" required="required" placeholder="Apellidos Completos" readonly=”readonly”/>
                    </td>
                    <td>Multa:</td>
                    <td>
                        <input type="text" name="txtValor" value="<%=multa.getMulta().getValor()%>" required="required" placeholder="Apellidos Completos" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td>
                        <input type="text" name="txtFecha" value="<%=multa.getFecha()%>" required="required" placeholder="Celular" readonly=”readonly”/>
                    </td>
                    <td>Detalle:</td>
                    <td>
                        <input type="text" name="txtDetalle" value="<%=multa.getDetalle()%>" required="required" placeholder="Direccion" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><center>
                    <a href="menumultausuario.jsp" title="Salir" style="cursor:pointer">
                        <img src="images/salir.png" alt="" width="50" height="50"/>
                    </a>
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
