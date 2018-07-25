<%-- 
    Document   : formularioverconsumo
    Created on : 25-jul-2018, 11:21:35
    Author     : Internet
--%>

<%@page import="com.senagua.dao.contrato.IConsumo"%>
<%@page import="com.senagua.dao.imp.ConsumoImp"%>
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
        <h1>DATOS DEL CONSUMO</h1>
        <form name="sn" action="xxxxxx" method="POST">
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
                        <input type="text" name="txtNumeroMedidor" value="<%=consumo.getMedidor().getNumeromedidor()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
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
                    <td>Lectura Inicial:</td>
                    <td>
                        <input type="text" name="txtLecturaInicial" value="<%=consumo.getLecturainicial()%>" required="required" placeholder="Apellidos Completos" readonly=”readonly”/>
                    </td>
                    <td>Fecha Lectura Inicial:</td>
                    <td>
                        <input type="text" name="txtFechaLecturaInicial" value="<%=consumo.getFechalecturainicial()%>" required="required" placeholder="Apellidos Completos" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Lectura Anterior:</td>
                    <td>
                        <input type="text" name="txtLecturaAnterior" value="<%=consumo.getLecturanterior()%>" required="required" placeholder="Celular" readonly=”readonly”/>
                    </td>
                    <td>Fecha Lectura Anterior:</td>
                    <td>
                        <input type="text" name="txtFechalecturaanterior" value="<%=consumo.getFechalecturaanterior()%>" required="required" placeholder="Direccion" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Lectura Actual:</td>
                    <td>
                        <input type="text" name="txtLeturaactual" value="<%=consumo.getLecturaactual()%>" required="required" placeholder="ejemplo@yahoo.com" readonly=”readonly”/>
                    </td>
                    <td>Fecha Lectura Actual:</td>
                    <td>
                        <input type="text" name="txtFechalecturaactual" value="<%=consumo.getFechalecturaactual()%>" required="required" placeholder="Numero de medidor" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Lectura Final:</td>
                    <td>
                        <input type="text" name="txtLecturafinal" value="<%=consumo.getLecturafinal()%>" required="required" placeholder="Marca de medidor" readonly=”readonly”/>
                    </td>
                    <td>Fecha Lectura Final:</td>
                    <td>
                        <input type="text" name="txtFechalecturafinal" value="<%=consumo.getFechalecturafinal()%>" required="required" placeholder="Marca de medidor" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Consumo:</td>
                    <td>
                        <input type="text" name="txtConsumo" value="<%=consumo.getConsumo()%>" required="required" placeholder="Modelo medidor" readonly=”readonly”/>
                    </td>
                    <td>Cedula Usuario:</td>
                    <td>
                        <input type="text" name="txtNombreUsuario" value="<%=consumo.getMedidor().getCliente().getCedula()%>" required="required" placeholder="Cedula sin guion" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                <td colspan="2"><center>
                    <a href="menuconsumo.jsp" title="Salir" style="cursor:pointer">
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
