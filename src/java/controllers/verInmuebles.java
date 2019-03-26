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
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();      
        if(null != session.getAttribute("Inmuebles")){
            inmuebles=(ArrayList<Inmueble>) session.getAttribute("Inmuebles");
        }
        Cliente c=null;
        if(null!= session.getAttribute("logeado")){
            c= (Cliente)session.getAttribute("logeado");
        } 
        
        
        request.setAttribute("logeado", c);
        request.setAttribute("Inmuebles", inmuebles);  
        RequestDispatcher view = request.getRequestDispatcher("verInmuebles.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        setMessages(request);
        
        RequestDispatcher view = request.getRequestDispatcher("verInmuebles.jsp");
        view.forward(request, response);
    }
}
