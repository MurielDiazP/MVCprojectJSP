<%-- 
    Document   : agregar
    Created on : 4/04/2024, 2:00:43 p. m.
    Author     : murieldiazperez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Autor</title>
    </head>
    <body>
        <center>
            <hl>Agregar Autor al sitema </h1>
        <hr/>
        <form action ="/eventosMVC/autor?accion=agregar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID:</th>
                    <th›input type="text" name="id"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Area de investigacion:</th>
                    <th›<input type="text" name="area_investigacion"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Cedula:</th>
                    <th›<input type="text" name="cedula"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Nombre:</th>
                    <th›<input type="text" name="area_investigacion"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Apellido:</th>
                    <th›<input type="text" name="apellido"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Institucion:</th>
                    <th›<input type="text" name="institcion"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Email:</th>
                    <th›<input type="text" name="email"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Celular:</th>
                    <th›<input type="text" name="celular"/></th>
                </tr>
            </table>
        </form>
        <hr/>
    </center>
</body>
</html>

        
        
    