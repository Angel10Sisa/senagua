<%-- 
    Document   : listafacturamulta
    Created on : 26-jul-2018, 8:59:32
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.FacturamultaImp"%>
<%@page import="com.senagua.dao.contrato.IFacturamulta"%>
<%@page import="com.senagua.rnegocio.entidades.Facturamulta"%>
<%@page import="com.senagua.dao.imp.MultaxmedidorImp"%>
<%@page import="com.senagua.dao.contrato.IMultaxmedidor"%>
<%@page import="com.senagua.dao.contrato.IMultaxmedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Multaxmedidor"%>
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
        <h1>Lista Factura Multa</h1>
        <form name="sn" action="xxxxxxx" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Medidor</td>
                    <td>Empleado</td>
                    <td>Fecha</td>
                    <td>Direccion</td>
                    <td>Multa</td>
                    <td>Subtotal</td>
                    <td>Descuento</td>
                    <td>Total Pago</td>
                    <td>Detalle</td>
                    <td>Estado</td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <%
                        List<Facturamulta> listafactmul = new ArrayList<Facturamulta>();
                        IFacturamulta daofactmul = new FacturamultaImp();
                        try {
                            listafactmul = daofactmul.obtener();
                            for (Facturamulta factura : listafactmul) {
                    %>
                    <td><%=factura.getIdfactura()%></td>
                    <td><%=factura.getMedidor().getNumeromedidor()%></td>
                    <td><%=factura.getEmpleado().getNombre()+" "+factura.getEmpleado().getApellido()%></td>
                    <td><%=factura.getFecha()%></td>
                    <td><%=factura.getDireccion()%></td>
                    <td><%=factura.getMultamedidor().getMulta().getValor()%></td>
                    <td><%=factura.getSubtotalmulta()%></td>
                    <td><%=factura.getDescuento()%></td>
                    <td><%=factura.getTotalpagar()%></td>
                    <td><%=factura.getDetalle()%></td>
                    <td><%=factura.getEstado()%></td>
                    
                    <td colspan="2"><center>
                    <a href="formularioverfacturamulta.jsp?ci=<%=factura.getIdfactura()%>" title="Ver Factura" style="cursor:pointer">
                        <img src="images/ver.png" alt="" width="40" height="40"/>
                    </a>
                </center></td>    
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                %>
            </table>
        </form>
        <a href="menufacturamulta.jsp">MENU MULTA FACTURA</a>
    </body>
</html>
