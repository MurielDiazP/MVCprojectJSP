<%-- 
    Document   : listarAutores
    Created on : 4/04/2024, 7:13:06 p. m.
    Author     : murieldiazperez
--%>

<%@page contentType="text/html" pageEncoding="UIF-8"%>
<%@page session="true" %>
<%@page import="models.Autor" %>
<%
    Autor listado [] = (Autor []) session.getAttribute("autor.listarAutores");
    String mensaje = null;
    if (listado == null || listado.length <= 0) {
        mensaje = "Resultado: 0 Usuarios encontrados en el Sistema";
    }
%>
< !DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"' content="text/html; charget=UTF-8">
        <title>Listar Autores</title>
    </head>
    <body>
    <center>
        <h1>Todos los Autores Agregados al Sistema </h1>
        <%
            if (mensaje != null) {
                out.print (mensaje);
            } else {
        %>
        <table border="1">
               <thead>
                <tr>
                    <th>Item</th>
                    <th>ID</th>
                    <th>AREA INVESTIGACION</th>
                    <th›>CEDULA</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>INSTITUCION</th>
                    <th>EMAIL</th>
                    <th>CELULAR</th>
                </tr>
            </thead>
            <tbody>
                <%
                int contador = 0;
                for (Autor autor1: listado) {
                contador = contador + 1;
                %>
                <tr>
                    <td><&= contador%></td>
                    <td><%= autor1.getId()%></td>
                    <td><%= autor1.getArea_investigacion()%></td>
                    <td><%= autor1.getCedula()%></td>
                    <td><%= autor1.getNombre()%></td>
                    <td><%= autor1.getApellido()%></td>
                    <td><%= autor1.getInstitucion()%></td>
                    <td><%= autor1.getEmail()%></td>
                    <td><%= autor1.getCelular()%></td>
                </tr>
                <%
                    }
                %>
            <hr>
            <a  href ="../../index.jsp"><‹:: VOLVER AL MENU</a>
    </center> 
</body>
</html>

