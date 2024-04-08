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
public class CRUDAutor {
    
    private Autor autor1;
    private ConexionBD baseDatos;
    


    public void agregarAutor () throws Exception {
        if (autor1.getId () == null ||autor1.getId ().isEmpty ()) {
            throw new Exception ("El ID del Autor es Necesario");
        }

        String sqlInsert = "INSERT INTO Autors"
        + "(id, area_investigacion, cedula, nombre, apellido, institucion, email, celular) "
        + "VALUES (?,?,?,?,?, ?)";
        try {
            // Crear una sentencia JDBC mediante la sentencia SQL anterior
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlInsert);
            // Pasarle los datos del autor a la sentencia SQL
            sentenciaSQL.setString (1, autor1.getId());
            sentenciaSQL.setString (2, autor1.getArea_investigacion ());
            sentenciaSQL.setString (3, autor1.getCedula ());
            sentenciaSQL.setString (4, autor1.getNombre());
            sentenciaSQL.setString (5, autor1.getApellido());
            sentenciaSQL.setString (6, autor1.getInstitucion());
            sentenciaSQL.setString (7, autor1.getEmail ());
            sentenciaSQL.setString (8, autor1.getCelular ());
            // actualizar la BD usando la sentenciaSOL con los datos del autor
            
            baseDatos.actualizar (sentenciaSQL);
        } catch (Exception error) {
            throw new Exception ("Error al Agregar el Autor " + autor1.getId ()
                + "<br/›Explicacion: " + error.getMessage ());
            
        } finally {
            baseDatos.desconectar ();
        }

    
    }
    
    public void modificarAutor () throws Exception {
        if (autor1.getId () == null || autor1.getId ().isEmpty ()) {
            throw new Exception ("El ID del Autor es Necesario");
            
        }  
        String sqlUpdate = "UPDATE Autors"
            + "SET id=?, area_investigacion=?, cedula=?, nombre=?, apellido=?, institucion=?, email=?,  celular=? "
            + "WHERE id =?";
        try {
            // Crear una sentencia JDBC mediante la sentencia SQL anterior
            
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlUpdate);
            
            //Pasarle los datos del usuario a la sentencia SQL
            //sentenciaSQL.setString(1, alquien.getId());
            sentenciaSQL. setString(1, autor1. getArea_investigacion ());
            sentenciaSQL.setString (2, autor1. getCedula ());
            sentenciaSQL.setString (3, autor1.getNombre ());
            sentenciaSQL.setString (4, autor1.getApellido());
            sentenciaSQL.setString (5, autor1.getInstitucion());
            sentenciaSQL.setString (6, autor1.getEmail ());
            sentenciaSQL.setString(7,autor1.getCelular());
            
            // actualizar la BD usando la gentenciaSOL con los datos del autor
            baseDatos.actualizar (sentenciaSQL);
        } catch (Exception error) {
            throw new Exception ("Error al Actualizar el Autor: " + autor1.getId ()
            + "<br/›Explicacion: " + error.getMessage ());
        } finally {
            baseDatos.desconectar();
        }
    }
        
    public void eliminarAutor () throws Exception {
        if (autor1.getId () == null || autor1.getId ().isEmpty ()) {
        throw new Exception ("El ID del Autor es Necesario");
        }
        // armar el SOL DELETE de forma dinamica
        String sqlDelete = "DELETE FROM Autors "
        + "WHERE id =?";
        
        try {
            
            // Crear una sentencia JDBC mediante la sentencia SQL anterior
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlDelete);
            
            //Pasarle los datos del autor a la sentencia SOL
            sentenciaSQL.setString(1, autor1.getId());
            
            // actualizar la BD usando la sentenciaSQL con los datos del autor
            baseDatos.actualizar (sentenciaSQL);
        } catch (Exception error) {
            throw new Exception ("Error al Eliminar el Autor: " + autor1.getId ()
            + "<br/›Explicacion: " + error.getMessage ());
        } finally {
             baseDatos.desconectar ();
        }
    }
    public static Autor consultarAutor ( String id) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new Exception ("El ID del Autor es Necesario");
        }
        Autor autor1; ConexionBD baseDatos = null;
            
        // armar el SQL SELECT de forma dinamica
        String sqlSelect = "SELECT * FROM Autors WHERE id =?";
        
        try {
            //Crear una sentencia JDBC mediante la sentencia SQL anterior
            baseDatos = new ConexionBD();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlSelect);
            
            // Pasarle los datos del autor a la sentencia SQL
            sentenciaSQL.setString(1, id);
            
            // Verificar el Resultado de la consulta
            ResultSet resultado = baseDatos.consultar(sentenciaSQL);
            if (resultado.next() == true) {
                autor1 = new Autor ();
                autor1.setId (resultado.getString ("id"));
                autor1.setId (resultado.getString ("area_investigacion"));
                autor1.setId (resultado.getString ("cedula"));
                autor1.setId (resultado.getString ("nombre"));
                autor1.setId (resultado.getString ("apellido"));
                autor1.setId (resultado.getString ("institucion"));
                autor1.setId (resultado.getString ("email"));
                autor1.setId (resultado.getString ("celular"));
                return autor1;
                
            }
                
            else {
                throw new Exception ("Error al Consultar el Autor " + id+"<br/DExplicacion: ");
            }

        }catch (Exception error) {
            throw new Exception(error.getMessage ()+"El Autor no existe en la BD");
            
        } finally {
            if (baseDatos != null) {
                baseDatos.desconectar ();
            }
        }
    } 
      
        
        
    public static Autor[] listarAutores() throws Exception {

       Autor autor1; ConexionBD baseDatos = null;

        //armar el SQL SELECT de forma dinamica

        String sqlSelect = "SELECT * FROM Autors";

        try {
            // Crear una sentencia JDBC mediante la sentencia SOL anterior
            baseDatos = new ConexionBD();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia (sqlSelect);

            //Verificar el Resultado de la consulta
            ResultSet resultado = baseDatos.consultar (sentenciaSQL);
            resultado.last();
            Autor [] listado = new Autor [resultado.getRow()] ;
            resultado.beforeFirst();// nos colocamos antes del primer registro

            while (resultado.next () == true) { // nos colocamos en el proximo registro
            autor1 = new Autor ();
            autor1.setId (resultado.getString ("id"));
            autor1.setArea_investigacion (resultado. getString ("area_investigacion"));
            autor1.setCedula (resultado.getString ("cedula"));
            autor1.setNombre(resultado.getString ("nombre"));
            autor1.setApellido (resultado.getString ("apellido"));
            autor1.setInstitucion (resultado.getString ("Institucion"));
            autor1.setEmail (resultado.getString ("email"));
            autor1.setCelular (resultado.getString("celular"));

            listado [resultado.getRow ()] = autor1;

            }if (listado.length <= 0) {
                throw new Exception("Error al listar los Autores "
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
    
    
    
    
    
        

