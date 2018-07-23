<%-- 
    Document   : formularioeditarmulta
    Created on : 23-jul-2018, 17:57:02
    Author     : Usuario
--%>

<%@page import="java.util.Date"%>
<%@page import="com.senagua.dao.contrato.IMulta"%>
<%@page import="com.senagua.dao.imp.MultaImp"%>
<%@page import="com.senagua.rnegocio.entidades.Multa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SENAGUA</title>
    </head>
    <body>
        <h1>EDITAR MULTA</h1>
        <%
            String co = request.getParameter("ci");
            int cod = Integer.parseInt(co);
            String nombre = " ", descripcion = " ";
            double valor=0;
            Date fecha=new Date();
            Multa multa = new Multa();
            IMulta dao1 = new MultaImp();
            try {
                multa = dao1.obtener(cod);
                nombre=multa.getNombre();
                valor=multa.getValor();
                fecha=multa.getFecha();
                descripcion=multa.getDescripcion();
            } catch (Exception e) {
            }
            
        %>
        <form name="sn" action="EditarMulta" method="POST">
            <table border="1">
                <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" name="txtCodigo" value="<%=cod%>" required="required" placeholder="Codigo" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td>
                        <input type="text" name="txtNombre" value="<%=nombre%>" required="required" placeholder="Nombre"/>
                    </td>
                </tr>                
                <tr>
                    <tr>
                    <td>Valor:</td>
                    <td>
                        <input type="text" name="txtValor" value="<%=valor%>" required="required" placeholder="Valor Multa"/>
                    </td>
                </tr> 
                <tr>
                    <tr>
                    <td>Fecha:</td>
                    <td>
                        <input type="text" name="txtFecha" value="<%=fecha%>" required="required" placeholder="yyyy-mm-dd" readonly=”readonly”/>
                    </td>
                </tr>
                <tr>
                    <tr>
                    <td>Descripción:</td>
                    <td>
                        <input type="text" name="txtDescripcion" value="<%=descripcion%>" required="required" placeholder="Descripción"/>
                    </td>
                </tr> 
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Guardar" name="btnGuardar"/>
                        <input type="button" value="Cancelar" name="btnCancelar" onclick="location.href = 'menumulta.jsp'"/>
                    </th>
                </tr>
            </table>

        </form>
    </body>
</html>
