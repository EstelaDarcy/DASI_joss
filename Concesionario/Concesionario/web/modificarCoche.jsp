<%-- 
    Document   : modificarCoche
    Created on : 06-may-2017, 0:22:28
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
        <h2>Modifique los datos del vehiculo con la matricula '${coche.matricula}'</h2>
        <form action="modificarCoche.do" method="POST">                                              
            <b>Modelo:</b>
            <input type="text" name="modelo" value="${coche.modelo}"/> ${errores['modelo']}<br/>
            <b>Marca:</b>
            <input type="text" name="marca" value="${coche.marca}"/> ${errores['marca']}<br/>
            <b>Color:</b>
            <input type="text" name="color" value="${coche.color}"/> ${errores['color']}<br/>
            <b>Anno:</b>
            <input type="text" name="anno" value="${coche.anno}"/> ${errores['anno']}<br/>
            <b>Cilindrada:</b>
            <input type="text" name="cilindrada" value="${coche.cilindrada}"/> ${errores['cilindrada']}<br/>
            <b>Caballos:</b>
            <input type="text" name="caballos" value="${coche.caballos}"/> ${errores['caballos']}<br/>
            
            <input type="submit" value="Modificar"/>
        </form>
    </body>
</html>
