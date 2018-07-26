<%-- 
    Document   : listamultausuariomedidor
    Created on : 26-jul-2018, 8:30:32
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.MultaxmedidorImp"%>
<%@page import="com.senagua.rnegocio.entidades.Multaxmedidor"%>
<%@page import="com.senagua.dao.contrato.IMultaxmedidor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.senagua.dao.contrato.IMedidor"%>
<%@page import="com.senagua.dao.imp.MedidorImp"%>
<%@page import="com.senagua.rnegocio.entidades.Medidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>Lista Multa de los Usuarios</h1>
        <form name="sn" action="xxxxxxx" method="POST">
            <table border="1">
                <tr>
                    <%
                        String cedula = "";
                        String numeromedidor = request.getParameter("txtNumeromedidor");
                        Medidor medi = new Medidor();
                        IMedidor daomedi = new MedidorImp();
                        try {
                            medi = daomedi.obtenernumero(numeromedidor);
                            cedula=medi.getCliente().getCedula();
                        } catch (Exception e) {
                        }

                    %>
                    <td>Codigo</td>
                    <td>Numero Medidor</td>
                    <td>Cedula</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Multa</td>
                    <td>Nombre</td>
                    <td>Fecha</td>
                    <td>Detalle</td>
                    <td colspan="2"><center>
                    <a href="formularioingresomultausuario.jsp?ci=<%=cedula%>" title="Nueva Multa" style="cursor:pointer">
                        <img src="images/nuevo.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                </tr>
                <tr>
                    <%
                        List<Multaxmedidor> listamulta = new ArrayList<Multaxmedidor>();
                        IMultaxmedidor daomulta = new MultaxmedidorImp();
                        try {
                            listamulta = daomulta.obtener();
                            for (Multaxmedidor multa : listamulta) {
                                if (multa.getMedidor().getCliente().getCedula().equals(cedula)) {
                    %>
                    <td><%=multa.getIdmultamedidor()%></td>
                    <td><%=multa.getMedidor().getNumeromedidor()%></td>
                    <td><%=multa.getMedidor().getCliente().getCedula()%></td>
                    <td><%=multa.getMedidor().getCliente().getNombre()%></td>
                    <td><%=multa.getMedidor().getCliente().getApellido()%></td>
                    <td><%=multa.getMulta().getValor()%></td>
                    <td><%=multa.getMulta().getNombre()%></td>
                    <td><%=multa.getFecha()%></td>                    
                    <td><%=multa.getDetalle()%></td>
                    <td colspan="2"><center>
                    <a href="formulariovermultausuario.jsp?ci=<%=multa.getIdmultamedidor()%>" title="Ver Consumo" style="cursor:pointer">
                        <img src="images/ver.png" alt="" width="40" height="40"/>
                    </a>
                </center></td>    
                </tr>
                <%
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                %>
            </table>
        </form>
        <a href="menumultausuario.jsp">MENU CONSUMO</a>
    </body>
</html>
