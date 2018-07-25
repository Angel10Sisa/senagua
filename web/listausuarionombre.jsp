<%-- 
    Document   : listausuarionombre
    Created on : 25-jul-2018, 2:03:13
    Author     : Angel-Pc
--%>

<%@page import="com.senagua.dao.contrato.ICliente"%>
<%@page import="com.senagua.dao.imp.ClienteImp"%>
<%@page import="com.senagua.rnegocio.entidades.Cliente"%>
<%@page import="com.senagua.dao.imp.MedidorImp"%>
<%@page import="com.senagua.dao.contrato.IMedidor"%>
<%@page import="com.senagua.rnegocio.entidades.Medidor"%>
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
        <h1>Lista Usuario</h1>
        <form name="sn" action="MostrarUsuario" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td>Numero Medidor</td>
                    <td>Cedula</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Tipo</td>
                    <td>Celular</td>                    
                    <td>Direccion</td>
                    <td>Mail</td>
                    <td>Tipo Medidor</td>
                    <td colspan="2">
                        <a href="formularioingresousuario.jsp" title="Nuevo Usuario" style="cursor:pointer">
                            <img src="images/nuevo.png" alt="" width="50" height="50"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <%
                        String nombre = request.getParameter("txtNombre");
                        List<Cliente> listacliente = new ArrayList<Cliente>();
                        ICliente daocliente = new ClienteImp();
                        List<Medidor> lista = new ArrayList<Medidor>();
                        IMedidor dao = new MedidorImp();
                        try {
                            lista = dao.obtener();
                            for (Medidor medidor : lista) {
                                listacliente = daocliente.obtenernombre(nombre);
                                for (Cliente cli : listacliente) {
                                    if (medidor.getIdmedidor() == cli.getIdcliente()) {
                    %>
                    <td><%=medidor.getIdmedidor()%></td>
                    <td><%=medidor.getNumeromedidor()%></td>
                    <td><%=medidor.getCliente().getCedula()%></td>
                    <td><%=medidor.getCliente().getNombre()%></td>
                    <td><%=medidor.getCliente().getApellido()%></td>
                    <td><%=medidor.getCliente().getTipocliente().getNombre()%></td>
                    <td><%=medidor.getCliente().getCelular()%></td>
                    <td><%=medidor.getCliente().getDireccion()%></td>
                    <td><%=medidor.getCliente().getEmail()%></td>
                    <td><%=medidor.getTipo().getCaracteristica()%></td>
                    <td colspan="2"><center>
                    <a href="formulariodatousuario.jsp?ci=<%=medidor.getIdmedidor()%>" title="Ver Usuario" style="cursor:pointer">
                        <img src="images/ver.png" alt="" width="40" height="40"/>
                    </a>
                </center></td>    
                </tr>
                <%                    }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                %>
            </table>
        </form>
        <a href="menuusuario.jsp">MENU USUARIO</a>
    </body>
</html>
