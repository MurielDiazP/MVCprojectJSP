/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CRUDAutor;
import models.Autor;

/**
 *
 * @author murieldiazperez
 */

@WebServlet(name = "ServletAutor", urlPatterns = {"/autor"})


public class ServletAutor extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            if (accion.equals("agregar")){
                
                CRUDAutor crudAutor1 = new CRUDAutor();
                crudAutor1.getAutor1().setId (request.getParameter ("id"));
                crudAutor1.getAutor1().setArea_investigacion(request.getParameter("area_investigacion"));
                crudAutor1.getAutor1().setCedula(request.getParameter("cedula"));
                crudAutor1.getAutor1().setNombre(request.getParameter("nombre"));
                crudAutor1.getAutor1().setApellido (request.getParameter ("apellido"));
                crudAutor1.getAutor1().setInstitucion (request.getParameter ("institucion"));
                crudAutor1 .getAutor1().setEmail (request.getParameter ("email"));
                crudAutor1.getAutor1().setCelular (request. getParameter ("celular"));
                crudAutor1.agregarAutor();
            
            
       
                response.sendRedirect("web/autor/agregar.jsp?mensaje=Autor"+request.getParameter("id")+"AgregadoalSistema");
            
            }else if (accion.equals ("consultar")) {
                Autor autor1 = CRUDAutor.consultarAutor (request.getParameter ("id"));
                request.getSession() .setAttribute ("autor.consultar", autor1);
                String redirecion = request.getParameter ("redir");
            
                if (redirecion.equals ("borrar")) {
                    response.sendRedirect("web/autor/eliminar.jsp");
                } else if (redirecion.equals ("modificar")) {
                    response.sendRedirect("web/autor/modificar.isp");
                }else{
                response.sendRedirect ( "web/autor/consultar.jsp" );
                }
            }else if (accion.equals ("modificar")) {
                CRUDAutor crudAutor1 = new CRUDAutor();
                crudAutor1.getAutor1().setId (request.getParameter ("id"));
                crudAutor1.getAutor1().setArea_investigacion(request.getParameter("area_investigacion"));
                crudAutor1.getAutor1().setCedula(request.getParameter("cedula"));
                crudAutor1.getAutor1().setNombre(request.getParameter("nombre"));
                crudAutor1.getAutor1().setApellido (request.getParameter ("apellido"));
                crudAutor1.getAutor1().setInstitucion (request.getParameter ("institucion"));
                crudAutor1 .getAutor1().setEmail (request.getParameter ("email"));
                crudAutor1.getAutor1().setCelular (request. getParameter ("celular"));
                crudAutor1.modificarAutor();
            
                response.sendRedirect("web/autor/modificar.jsp?mensaje=Usuario"+request.getParameter("id")+"Modificado en el Sistema");
            
            } else if (accion.equals ("borrar")) {
                CRUDAutor crudAutor1 = new CRUDAutor();
                crudAutor1.getAutor1().setId (request.getParameter ("id"));
                crudAutor1.eliminarAutor();
                response.sendRedirect("web/autor/eliminar.jsp?mensaje=Usuario"+request.getParameter("id")+"Eliminado del Sistema");
            
            }else if (accion.equals ("listartodo")) {
                Autor[] listado = CRUDAutor. listarAutores ();
                request.getSession ().setAttribute ("autor.listar", listado);
                response.sendRedirect("web/autor/listarAutores.jsp");

            }else{
                response.sendRedirect("web/mensaje.jsp?mensaje=laAccionSolicitadanoesCorrecta");
            }
        }catch (Exception error) {
            response.sendRedirect("web/mensaje.jsp?mensaje="+error.getMessage());
        }finally {
            out.close ();
            
        }
        }
      
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }