/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
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
        HttpSession session = request.getSession();        
        List<Cliente> clientes = new ArrayList<Cliente>();        
        if(null != session.getAttribute("Clientes")){
            clientes=(ArrayList<Cliente>) session.getAttribute("Clientes");
        }
        Cliente c= (Cliente)session.getAttribute("logeado");
        request.setAttribute("logeado", c);
        request.setAttribute("Clientes", clientes);   
        RequestDispatcher view = request.getRequestDispatcher("nuevoCliente.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        setMessages(request);
        HttpSession session = request.getSession();        
        List<Cliente> clientes = new ArrayList<Cliente>();
        if(null != session.getAttribute("Clientes")){
            clientes=(ArrayList<Cliente>) session.getAttribute("Clientes");
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
