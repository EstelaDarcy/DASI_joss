<%-- 
    Document   : listarCoches
    Created on : 06-may-2017, 19:28:53
    Author     : USUARIO
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de coches</title>
    </head>
    <body>
        <h1> ${requestScope.titulo}  <fmt:message key="title.listado.alumnos"/> </h1>
        <table>            
        <c:choose>        
            <c:when test="${ empty requestScope.lista_alumnos }">
                Ahora mismo no hay coches
            </c:when>            
            <c:otherwise>                
                <table>
                    <thead>
                        <tr>
                            <th> <fmt:message key="label.expediente" />  </th>
                            <th> <fmt:message key="label.nombre"     />  </th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach var="alumno" items="${requestScope.lista_alumnos}">
                            
                            <c:url var="urlAlumno" value="/api/alumnos/${alumno.expediente}">
                            </c:url>
                            
                            <tr>
                                <td>${alumno.expediente}</td>
                                <td> <a href="${urlAlumno}"> ${alumno.apellido1} &nbsp; ${alumno.apellido2}, ${alumno.nombre} </a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>            
        </c:choose>    
        </table>
    </body>
</html>