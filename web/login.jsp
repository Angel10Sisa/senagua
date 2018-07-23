<%-- 
    Document   : login
    Created on : 02-jul-2018, 15:12:35
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="shortcut icon" href="imgs/llave.png">
        <title>LOGIN</title>
    
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div id="cuadro">
            <center><img src="imgs/llave.png" alt="" width="90" height="90" /></center>
            <form name="sn" action="inicio.jsp">
            <p id="titulo">INICIAR SESIÓN</p>   
            <hr>
            <br><br>
            <label id="subtitulo1">NOMBRE DE USUARIO</label>
            <br><br>
            <input type="text" class="entrada" required="required">
            <br><br>
            <label id="subtitulo2" >CONTRASEÑA</label>
            <br><br>
            <input type="password" class="entrada" required="required">
            <br><br>
            <input type="submit" value="Iniciar Sesión" id="boton" style="cursor:">
            </form>
            <br>
                     
            
        </div>
              
    </body>
</html>
