/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainServlet.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cliente;
import models.Propietario;

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        
        Cliente c= (Cliente)session.getAttribute("logeado");
        Propietario p=(Propietario)session.getAttribute("propietario");
        request.setAttribute("logeado", c);
        request.setAttribute("propietario", p);
        
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();
        LinkedList<Propietario> propietarios = new LinkedList<Propietario>();
        if (null != session.getAttribute("Clientes")) {
            clientes = (LinkedList<Cliente>) session.getAttribute("Clientes");
        }
        if (null != session.getAttribute("Propietarios")) {
            propietarios = (LinkedList<Propietario>) session.getAttribute("Propietarios");
        }
        int cc = Integer.parseInt(request.getParameter("cedula"));
        String pass = request.getParameter("contrasena");
        Cliente logeado=null;
        Propietario propietario=null;
        for(Cliente c: clientes){
             if(c.getCedula()== cc && c.getContrasena().equals(pass)){
                 logeado= c;
                 break;
             }
        
         }
        if(logeado==null){
            for(Propietario c: propietarios){
             if(c.getCedula()== cc && c.getContrasena().equals(pass)){
                 propietario= c;
                 break;
             }
        
         }
        }
        
        session.setAttribute("logeado", logeado);
        request.setAttribute("logeado", logeado);
        session.setAttribute("propietario", propietario);
        request.setAttribute("propietario", propietario);
        
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
}
