/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author murieldiazperez
 */
public class CRUDTrabajo_enviado {
    
    private Trabajo_enviado trabajo;
    private ConexionBD baseDatos;
    


    public void agregarTrabajo () throws Exception {
        if (trabajo.getId () == null ||trabajo.getId ().isEmpty ()) {
            throw new Exception ("El ID del trabajo es Necesario");
        }

        String sqlInsert = "INSERT INTO Trabajo_enviados"
        + "(id, titulo, abstract_trab, autor_id) "
        + "VALUES (?,?,?,?)";
        try {
            // Crear una sentencia JDBC mediante la sentencia SQL anterior
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlInsert);
            // Pasarle los datos del trabajo a la sentencia SQL
            sentenciaSQL.setString (1, trabajo.getId());
            sentenciaSQL.setString (2, trabajo.getTitulo ());
            sentenciaSQL.setString (3, trabajo.getAbstract_trab ());
            sentenciaSQL.setString (4, trabajo.getAutor_id());
            
            // actualizar la BD usando la sentenciaSOL con los datos del autor
            
            baseDatos.actualizar (sentenciaSQL);
        } catch (Exception error) {
            throw new Exception ("Error al Agregar el trabajo " + trabajo.getId ()
                + "<br/›Explicacion: " + error.getMessage ());
            
        } finally {
            baseDatos.desconectar ();
        }

    
    }
    
    public void modificarTrabajo() throws Exception {
        if (trabajo.getId () == null || trabajo.getId ().isEmpty ()) {
            throw new Exception ("El ID del trabajo es Necesario");
            
        }  
        String sqlUpdate = "UPDATE Trabajo_enviados"
            + "SET id=?, titulo=?, abstract_trab=?, autor_id=? "
            + "WHERE id =?";
        try {
            // Crear una sentencia JDBC mediante la sentencia SQL anterior
            
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlUpdate);
            
            //Pasarle los datos del usuario a la sentencia SQL
            //sentenciaSQL.setString(1, alquien.getId());
            sentenciaSQL. setString(1, trabajo. getTitulo ());
            sentenciaSQL.setString (2,trabajo. getAbstract_trab());
            sentenciaSQL.setString (3, trabajo.getAutor_id());
           
            
            // actualizar la BD usando la gentenciaSOL con los datos del trabajo
            baseDatos.actualizar (sentenciaSQL);
        } catch (Exception error) {
            throw new Exception ("Error al Actualizar el trabajo: " + trabajo.getId ()
            + "<br/›Explicacion: " + error.getMessage ());
        } finally {
            baseDatos.desconectar();
        }
    }
        
    public void eliminarTrabajo () throws Exception {
        if (trabajo.getId () == null || trabajo.getId ().isEmpty ()) {
        throw new Exception ("El ID del trabajo es Necesario");
        }
        // armar el SOL DELETE de forma dinamica
        String sqlDelete = "DELETE FROM Trabajo_enviados "
        + "WHERE id =?";
        
        try {
            
            // Crear una sentencia JDBC mediante la sentencia SQL anterior
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlDelete);
            
            //Pasarle los datos del autor a la sentencia SOL
            sentenciaSQL.setString(1, trabajo.getId());
            
            // actualizar la BD usando la sentenciaSQL con los datos del trabajo
            baseDatos.actualizar (sentenciaSQL);
        } catch (Exception error) {
            throw new Exception ("Error al Eliminar el Trabajo: " + trabajo.getId ()
            + "<br/›Explicacion: " + error.getMessage ());
        } finally {
             baseDatos.desconectar ();
        }
    }
    public static Trabajo_enviado consultarTrabajo ( String id) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new Exception ("El ID del trabajo es Necesario");
        }
        Trabajo_enviado trabajo; ConexionBD baseDatos = null;
            
        // armar el SQL SELECT de forma dinamica
        String sqlSelect = "SELECT * FROM Trabajo_enviados WHERE id =?";
        
        try {
            //Crear una sentencia JDBC mediante la sentencia SQL anterior
            baseDatos = new ConexionBD();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlSelect);
            
            // Pasarle los datos del trabajo a la sentencia SQL
            sentenciaSQL.setString(1, id);
            
            // Verificar el Resultado de la consulta
            ResultSet resultado = baseDatos.consultar(sentenciaSQL);
            if (resultado.next() == true) {
                trabajo = new Trabajo_enviado ();
                trabajo.setId (resultado.getString ("id"));
                trabajo.setId (resultado.getString ("titulo"));
                trabajo.setId (resultado.getString ("abstract_trab"));
                trabajo.setId (resultado.getString ("autor_id"));
                return trabajo;
                
            }
                
            else {
                throw new Exception ("Error al Consultar el trabajo " + id+"<br/DExplicacion: ");
            }

        }catch (Exception error) {
            throw new Exception(error.getMessage ()+"El trabajo no existe en la BD");
            
        } finally {
            if (baseDatos != null) {
                baseDatos.desconectar ();
            }
        }
    } 
      
        
        
    public static Trabajo_enviado[] listarTrabajos() throws Exception {

       Trabajo_enviado trabajo; ConexionBD baseDatos = null;

        //armar el SQL SELECT de forma dinamica

        String sqlSelect = "SELECT * FROM Trabajo_enviados";

        try {
            // Crear una sentencia JDBC mediante la sentencia SOL anterior
            baseDatos = new ConexionBD();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlSelect);

            //Verificar el Resultado de la consulta
            ResultSet resultado = baseDatos.consultar (sentenciaSQL);
            resultado.last();
            Trabajo_enviado [] listado = new Trabajo_enviado [resultado.getRow()] ;
            resultado.beforeFirst();// nos colocamos antes del primer registro

            while (resultado.next () == true) { // nos colocamos en el proximo registro
            trabajo = new Trabajo_enviado ();
            trabajo.setId (resultado.getString ("id"));
            trabajo.setTitulo (resultado. getString ("titulo"));
            trabajo.setAbstract_trab (resultado.getString ("abstract_trab"));
            trabajo.setAutor_id(resultado.getString ("autor_id"));
            
            listado [resultado.getRow ()] = trabajo;

            }if (listado.length <= 0) {
                throw new Exception("Error al listar los trabajos "
                    + "<br/›Explicacion: ");
            }
            return listado;

        }catch (Exception error) {
            throw new Exception(error.getMessage ()+"La BD esta vacia");
        } finally {
        if (baseDatos != null) {
            baseDatos.desconectar ();
        }
        }
    }







}
    
    
    
    
    
        

