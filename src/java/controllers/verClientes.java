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

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "verClientes", urlPatterns = {"/verClientes"})
public class verClientes extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();        
        if(null != session.getAttribute("Clientes")){
            clientes=(LinkedList<Cliente>) session.getAttribute("Clientes");
        }
        Cliente c= (Cliente)session.getAttribute("logeado");
        Propietario p=(Propietario)session.getAttribute("propietario");
        request.setAttribute("logeado", c);
        request.setAttribute("propietario", p);
        request.setAttribute("Clientes", clientes);   
        RequestDispatcher view = request.getRequestDispatcher("verClientes.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        //setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();
        if(null != session.getAttribute("Clientes")){
            clientes=(LinkedList<Cliente>) session.getAttribute("Clientes");
        }        
        
        session.setAttribute("Clientes", clientes);
        request.setAttribute("Clientes", clientes);        
        RequestDispatcher view = request.getRequestDispatcher("verClientes.jsp");
        view.forward(request, response);
    }
}
