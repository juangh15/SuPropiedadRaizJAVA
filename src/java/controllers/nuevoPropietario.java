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

   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);   
        RequestDispatcher view = request.getRequestDispatcher("nuevoPropietario.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Propietario> propietarios = new LinkedList<Propietario>();
        if(null != session.getAttribute("Propietarios")){
            propietarios=(LinkedList<Propietario>) session.getAttribute("Propietarios");
        }
          if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("cedula"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo Cédula, debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
        }
         if (!ValidadorDeFormularios.esCorreoValido(request.getParameter("correo"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo Correo, debe tener un formato válido");
             view.forward(request, response);
        }
        int cc = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre"); 
        String correo = request.getParameter("correo"); 
        String pass= request.getParameter("contrasena");
        String direccion= request.getParameter("direccion");
        Propietario p= new Propietario(cc, nombre, correo,  pass, direccion);
        
        propietarios.add(p);
        
        session.setAttribute("Propietarios", propietarios);      
        RequestDispatcher view = request.getRequestDispatcher("nuevoPropietario.jsp");
        view.forward(request, response);
    }

}
