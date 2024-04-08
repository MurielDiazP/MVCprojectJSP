<%-- 
    Document   : listar
    Created on : 4/04/2024, 2:01:53 p. m.
    Author     : murieldiazperez
--%>
<%@page import="models.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-Type" content="text/html";charset="UTF-8"%>
        <title> Consultar Autor</title>
    </head>
    <body>
        <center>
        <h1>Consultar Autor </h1>
        <hr/>
        <form action="/eventosMVC/autor?accion=consultar&redir=buscar" method="post">
        <table>
            <tr>
                <th style="text-align: right">ID:</th>
                <td><input type="text" names="id"</th>
            </tr>
            <tr>
                <th><input type="submit" value="Consultar"></th>
            </tr>
            <tr>
                <th style="text-align: right">Area de investigacion:</th>
                <td style="text-align: left"><%= ( autor 1 != null) ? autor1.getArea_investigacion() :"" %></td>
            </tr>
            <tr>    
                 <th style="text-align: right">Cedula:</th>
                <td style="text-align: left"><%= (autor1 != null) ? autor1.getCedula() :"" %></td>
            </tr>
            <tr>
                <th style="text-align: right"> Nombre:</th>
                <td style="text-align: left"><%= (autor1 != null)?autor1.getNombre():"" %></td>
            <tr> 
            <tr>
                 <th style="text-align: right"> Apellido:</th>
                <td style="text-align: left"><%= (autor1 != null) ? autor1.getApellido() :"" %></td>
            </tr>
            <tr>
                 <th style="text-align: right"> Institucion:</th>
                <td style="text-align: left"><%= (autor1 != null) ? autor1.getInstitucion() :"" %></td>
            </tr>
            <tr>
                 <th style="text-align: right"> Email:</th>
                <td style="text-align: left"><%= (autor1 != null) ? autor1.getEmail() :"" %></td>
            </tr>
            <tr>
                 <th style="text-align: right"> Celular:</th>
                <td style="text-align: left"><%= (autor1 != null) ? autor1.getCelular() :"" %></td>
            </tr>
        </table>
        </form>
        <hr/>
        <p style = "color: #FF0000;">
            <%= (mensaje != null && !mensaje.isEmpty()) ? mensaje : "" %>
        </p>
            <% request.setAttribute("autor.consultar", null);%>
        </center>
    </body>
</html>

