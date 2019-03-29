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
import models.*;

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "verInmuebles", urlPatterns = {"/verInmuebles"})
public class verInmuebles extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Inmueble> inmuebles = new LinkedList<Inmueble>();      
        if(null != session.getAttribute("Inmuebles")){
            inmuebles=(LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        }
        Cliente c= (Cliente)session.getAttribute("logeado");
        Propietario p=(Propietario)session.getAttribute("propietario");
        request.setAttribute("logeado", c);
        request.setAttribute("propietario", p);
        request.setAttribute("Inmuebles", inmuebles);  
        RequestDispatcher view = request.getRequestDispatcher("verInmuebles.jsp");
        view.forward(request, response);
    }

}
