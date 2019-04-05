/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainServlet.setMessages;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import util.ValidadorDeFormularios;

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "nuevoPropietario", urlPatterns = {"/nuevoPropietario"})
public class nuevoPropietario extends HttpServlet {

   private RequestDispatcher view =null;
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);   
        this.view = request.getRequestDispatcher("nuevoPropietario.jsp");
        this.view .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Propietario> propietarios = null;
        if(null != session.getAttribute("Propietarios")){
            propietarios=(LinkedList<Propietario>) session.getAttribute("Propietarios");
        }
          if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("cedula"))) {
            this.view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo Cédula, debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             this.view .forward(request, response);
        }
         if (!ValidadorDeFormularios.esCorreoValido(request.getParameter("correo"))) {
            this.view  = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo Correo, debe tener un formato válido");
             this.view .forward(request, response);
        }
        Integer cc = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre"); 
        String correo = request.getParameter("correo"); 
        String pass= request.getParameter("contrasena");
        String direccion= request.getParameter("direccion");
        
         if (ValidadorDeFormularios.existePropietario(propietarios,cc)) {
            this.view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El Propietario con cédula numer: "+cc.toString()+" ya existe");
            session.setAttribute("urlAnterior",request.getRequestURI());
             this.view.forward(request, response);
         }
        Propietario p= new Propietario(cc, nombre, correo,  pass, direccion);
        
        propietarios.add(p);
        
        session.setAttribute("Propietarios", propietarios);      
        this.view = request.getRequestDispatcher("nuevoPropietario.jsp");
        this.view.forward(request, response);
    }

}
