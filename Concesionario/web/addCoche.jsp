<%-- 
    Document   : addCoche
    Created on : 05-may-2017, 19:03:59
    Author     : Estela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Introduzca los datos del nuevo vehiculo</h2>
        <form action="addCoche.do" method="POST">                                  
            <b>Matricula:</b>
            <input type="text" name="matricula" value="${old.matricula}"/> ${errores['matricula']}<br/>
            <b>Modelo:</b>
            <input type="text" name="modelo" value="${old.modelo}"/> ${errores['modelo']}<br/>
            <b>Marca:</b>
            <input type="text" name="marca" value="${old.marca}"/> ${errores['marca']}<br/>
            <b>Color:</b>
            <input type="text" name="color" value="${old.color}"/> ${errores['color']}<br/>
            <b>Anno:</b>
            <input type="text" name="anno" value="${old.anno}"/> ${errores['anno']}<br/>
            <b>Cilindrada:</b>
            <input type="text" name="cilindrada" value="${old.cilindrada}"/> ${errores['cilindrada']}<br/>
            <b>Caballos:</b>
            <input type="text" name="caballos" value="${old.caballos}"/> ${errores['caballos']}<br/>
            
            <input type="submit" value="Insertar"/>
        </form>
    </body>
</html>
