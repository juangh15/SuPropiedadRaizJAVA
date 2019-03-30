/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainServlet.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "nuevoInmueble", urlPatterns = {"/nuevoInmueble"})
public class nuevoInmueble extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);   
        RequestDispatcher view = request.getRequestDispatcher("nuevoInmueble.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        Propietario p= (Propietario)session.getAttribute("propietario");
        
        if(p==null){
            RequestDispatcher view = request.getRequestDispatcher("/index");
        view.forward(request, response);
        }
        LinkedList inmuebles=(LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        int predial = Integer.parseInt(request.getParameter("predial"));
        int estrato = Integer.parseInt(request.getParameter("estrato"));
        boolean vigilancia = Boolean.parseBoolean(request.getParameter("vigilancia")); 
        boolean ascensor = Boolean.parseBoolean(request.getParameter("ascensor")); 
        int area = Integer.parseInt(request.getParameter("area"));
        int banos = Integer.parseInt(request.getParameter("banos"));
        String tipo= request.getParameter("tipo");
        int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
        int cuartos = Integer.parseInt(request.getParameter("cuartos"));
        String ciudad =request.getParameter("ciudad");
        Inmueble inmu=new Inmueble(predial, estrato, vigilancia, ascensor, area, banos, cuartos, tipo, null, p, ciudad, antiguedad, true);
        p.addInmueble(inmu);
        inmuebles.add(inmu);
        request.setAttribute("Inmuebles", inmuebles);
        request.setAttribute("propietario", p);
        RequestDispatcher view = request.getRequestDispatcher("nuevoInmueble.jsp");
        view.forward(request, response);
    }
}
