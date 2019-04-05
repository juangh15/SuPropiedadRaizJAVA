/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import util.ValidadorDeFormularios;
/**
 *
 * @author Tamayo
 */
@WebServlet(name = "nuevoCliente", urlPatterns = {"/nuevoCliente"})
public class nuevoCliente extends MainServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);   
        RequestDispatcher view = request.getRequestDispatcher("nuevoCliente.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();
        if(null != session.getAttribute("Clientes")){
            clientes=(LinkedList<Cliente>) session.getAttribute("Clientes");
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
        Cliente c= new Cliente(cc, nombre, correo,  pass, direccion);
        
        clientes.add(c);
        
        session.setAttribute("Clientes", clientes);
        request.setAttribute("Clientes", clientes);        
        RequestDispatcher view = request.getRequestDispatcher("nuevoCliente.jsp");
        view.forward(request, response);
    }
    
    
}
