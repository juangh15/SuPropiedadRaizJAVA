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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cliente;
import models.Inmueble;
import models.Propietario;

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "verInmueblesPropietario", urlPatterns = {"/verInmueblesPropietario"})
public class verInmueblesPropietario extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();    
        Propietario p= (Propietario)session.getAttribute("propietario");
        if(p==null){
            RequestDispatcher view = request.getRequestDispatcher("/index");
            view.forward(request, response);
        }
        LinkedList<Inmueble> inmuebles = new LinkedList<Inmueble>();      
        inmuebles=p.getInmuebles();
        request.setAttribute("propietario", p);
        request.setAttribute("Inmuebles", inmuebles);  
        RequestDispatcher view = request.getRequestDispatcher("verInmuebles.jsp");
        view.forward(request, response);
    }
}
