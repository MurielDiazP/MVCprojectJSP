<%-- 
    Document   : modificar
    Created on : 4/04/2024, 2:01:37 p. m.
    Author     : murieldiazperez
--%>

<%@page import="models.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html
    <head>
        <meta http-equiv="Content-Type" content="text/html; charget=UTF-8")
        <title>Modificar Autor</title>
    </head> 
    <body>
    <center>
        <h1> Modificar Autor</h1>
        <hr/> 
        <form action ="/eventosMVC/autor?accion=buscar&redir=modificar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID:</th>
                    <td><input type="text" name=id"/></th>
                </tr>
                <tr>
                    <th><input type="submit" value="Consultar"></th>
                    <td><input type="reset" name="Limpiar"/></td>
                </tr>
                <tr>
            </table>      
        </form>
        <hr/>
        <%
            if (autor1 != null){
        %>
        <form action ="/eventosMVC/autor?accion=modificar" method="post">
            <table>
                <tr>
                    <th style= text-align: : right">ID:</th>
                    <td><input type="text" name="id" value="<%= (autor1 != null) ? autor1.getId() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr>       
                    <th style= text-align: : right">AREA INVESTIGACION:</th>
                    <td><input type="text" name="area_investigacion" value="<%= (autor1 != null) ? autor1.getArea_investigacion() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr>                     
                    <th style= text-align: : right">CEDULA:</th>
                    <td><input type="text" name="cedula" value="<%= (autor1 != null) ? autor1.getCedula() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr>                     </tr>
                    <th style= text-align: : right">NOMBRE:</th>
                    <td><input type="text" name="nombre" value="<%= (autor1 != null) ? autor1.getNombre() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr>                   
                    <th style= text-align: : right">APELLIDO:</th>
                    <td><input type="text" name="apellido" value="<%= (autor1 != null) ? autor1.getApellido() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr>                     
                       <th style= text-align: : right">INSTITUCION:</th>
                    <td><input type="text" name="institucion" value="<%= (autor1 != null) ? autor1.getInstitucion() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr>                    
                    <th style= text-align: : right">EMAIL:</th>
                    <td><input type="text" name="email" value="<%= (autor1 != null) ? autor1.getEmail() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr> 
                    <th style= text-align: : right">CELULAR:</th>
                    <td><input type="text" name="celular" value="<%= (autor1 != null) ? autor1.getCelular() : ""%>" readonly="readonly"/></th>
                </tr>
                <tr> 
                    <th><input type="submit" value="Modificar'></th>
                    <td><input type="reset" name="Limpiar"/></td>
                </tr>
            </table>
        </form>
        <hr/>
        <%                            
             }
        %>
        <p style = "color: #FF0000;">
            <%= (mensaje != null && !mensaje.isEmpty()) ? mensaje : ""%>
        </p>
        <% request.setAttribute("autor.buscar", null);%>
        </center>
    </body>
</html>
