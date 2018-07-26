<%-- 
    Document   : listaconsumomedidor
    Created on : 25-jul-2018, 23:32:44
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.imp.ConsumoImp"%>
<%@page import="com.senagua.dao.contrato.IConsumo"%>
<%@page import="com.senagua.rnegocio.entidades.Consumo"%>
<%@page import="com.senagua.dao.imp.MedidorImp"%>
<%@page import="com.senagua.dao.contrato.IMedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Medidor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
        <h1>Lista Consumo</h1>
        <form name="sn" action="xxxxxxx" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Numero Medidor</td>
                    <td>Lectura Inicial</td>
                    <td>Fecha de Lectura Inicial</td>
                    <td>Lectura Anterior</td>
                    <td>Fecha de Lectura Anterior</td>
                    <td>Lectura Actual</td>
                    <td>Fecha de Lectura Actual</td>
                    <td>Lectura Final</td>
                    <td>Fecha de Lectura Final</td>
                    <td>Consumo</td>
                    <%
                        String numeromedidor = request.getParameter("txtNumeromedidor");
                        Medidor medi=new Medidor();
                        IMedidor daomedi=new MedidorImp();
                        try {
                                medi=daomedi.obtenernumero(numeromedidor);
                            } catch (Exception e) {
                            }
                        String cedula = medi.getCliente().getCedula();
                    %>
                    <td colspan="2"><center>
                    <a href="formularioingresoconsumo.jsp?ci=<%=cedula%>" title="Nuevo Consumo" style="cursor:pointer">
                        <img src="images/nuevo.png" alt="" width="50" height="50"/>
                    </a>
                </center></td>
                </tr>
                <tr>
                    <%
                        Cliente cliente = new Cliente();
                        ICliente daocliente = new ClienteImp();
                        List<Medidor> lista = new ArrayList<Medidor>();
                        IMedidor dao = new MedidorImp();
                        try {
                            lista = dao.obtener();
                            for (Medidor medidor : lista) {
                                cliente = daocliente.obtenercedula(cedula);
                                if (medidor.getIdmedidor() == cliente.getIdcliente()) {
                                    List<Consumo> listaconsumo = new ArrayList<Consumo>();
                                    IConsumo daoconsumo = new ConsumoImp();
                                    listaconsumo = daoconsumo.obtener();
                                    for (Consumo consumo : listaconsumo) {
                                        if (consumo.getMedidor().getIdmedidor() == cliente.getIdcliente()) {

                    %>
                    <td><%=consumo.getIdconsumo()%></td>
                    <td><%=consumo.getMedidor().getNumeromedidor()%></td>
                    <td><%=consumo.getLecturainicial()%></td>
                    <td><%=consumo.getFechalecturainicial()%></td>
                    <td><%=consumo.getLecturanterior()%></td>
                    <td><%=consumo.getFechalecturaanterior()%></td>
                    <td><%=consumo.getLecturaactual()%></td>
                    <td><%=consumo.getFechalecturaactual()%></td>
                    <td><%=consumo.getLecturafinal()%></td>
                    <td><%=consumo.getFechalecturafinal()%></td>
                    <td><%=consumo.getConsumo()%></td>
                    <td colspan="2"><center>
                    <a href="formularioverconsumo.jsp?ci=<%=consumo.getIdconsumo()%>" title="Ver Consumo" style="cursor:pointer">
                        <img src="images/ver.png" alt="" width="40" height="40"/>
                    </a>
                </center></td>    
                </tr>
                <%
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                %>
            </table>
        </form>
        <a href="menuconsumo.jsp">MENU CONSUMO</a>
    </body>
</html>
