<%-- 
    Document   : formularioverfacturamulta
    Created on : 26-jul-2018, 9:35:16
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.IFacturamulta"%>
<%@page import="com.senagua.dao.imp.FacturamultaImp"%>
<%@page import="com.senagua.rnegocio.entidades.Facturamulta"%>
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
                int idfactura = Integer.parseInt(cod);
                Facturamulta facturamulta = new Facturamulta();
                IFacturamulta daofacturamulta = new FacturamultaImp();
                try {
                    facturamulta = daofacturamulta.obtener(idfactura);
                } catch (Exception e) {
                }
            %>
            <table border="0">
                <tr>
                    <td>Codigo Factura:</td>
                    <td>
                        <input type="text" name="txtIdfacturamulta" value="<%=facturamulta.getIdfactura()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                    <td>Numero de Medidor:</td>
                    <td>
                        <input type="text" name="txtNumeromedidor" value="<%=facturamulta.getMedidor().getNumeromedidor()%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Empleado:</td>
                    <td>
                        <input type="text" name="txtEmpleado" value="<%=facturamulta.getEmpleado().getNombre() + " " + facturamulta.getEmpleado().getApellido()%>" required="required" placeholder="Cedula sin guion" readonly=”readonly”/>
                    </td>
                    <td>Fecha:</td>
                    <td>
                        <input type="text" name="txtFecha" value="<%=facturamulta.getFecha()%>" required="required" placeholder="Nombres Completos" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Direccion:</td>
                    <td>
                        <input type="text" name="txtApellido" value="<%=facturamulta.getDireccion()%>" required="required" placeholder="Apellidos Completos" readonly=”readonly”/>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table border="1">
                            <tr>
                                <td width="200">Codigo</td>
                                <td width="200">Concepto</td>
                                <td width="200">Valor</td>
                            </tr>
                            <tr>
                                <td><%=facturamulta.getMultamedidor().getMulta().getIdmulta()%></td>
                                <td><%=facturamulta.getMultamedidor().getMulta().getNombre()%></td>
                                <td><%=facturamulta.getMultamedidor().getMulta().getValor()%></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Subtotal:</td>
                                <td><%=facturamulta.getSubtotalmulta()%></td>
                            </tr> 
                            <tr>
                                <td></td>
                                <td>Descuento:</td>
                                <td><%=facturamulta.getDescuento()%></td>
                            </tr> 
                            <tr>
                                <td></td>
                                <td>Total a Pagar</td>
                                <td><%=facturamulta.getTotalpagar()%></td>
                            </tr> 
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>Detalle:</td>
                    <td><%=facturamulta.getDetalle()%></td>
                    <td>Estado:</td>
                    <td><%=facturamulta.getEstado()%></td>
                </tr>
                <tr>
                    <td colspan="2"><center>
                    <a href="menufacturamulta.jsp" title="Salir" style="cursor:pointer">
                        <img src="images/salir.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                <td colspan="2"><center>
                    <a href="xxxxxx.jsp" title="Salir" style="cursor:pointer">
                        <img src="images/emitir.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
