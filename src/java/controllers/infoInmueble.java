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
@WebServlet(name = "infoInmueble", urlPatterns = {"/infoInmueble"})
public class infoInmueble extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();    
        Propietario p= (Propietario)session.getAttribute("propietario");
        Cliente c=(Cliente)session.getAttribute("logeado");
        Contrato contrato_inm;
        if(p==null && null== c){
            RequestDispatcher view = request.getRequestDispatcher("/index");
            view.forward(request, response);
        }
        LinkedList<Inmueble> inmuebles = new LinkedList<Inmueble>(); 
        inmuebles=(LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        int predial=Integer.parseInt(request.getParameter("predial"));
        for (Inmueble i : inmuebles) {
            if(i.getPredial()==predial){
                if(i.getTipo().equals("enVenta")){
                    contrato_inm=i.getCompraventa();
                }else{
                    contrato_inm=(Arriendo)i.getArriendo().getLast();
                }
                LinkedList<Contrato> lista_contrato_actual = new LinkedList<Contrato>();
                LinkedList<Inmueble> lista_inmueble_actual = new LinkedList<Inmueble>();
                lista_contrato_actual.addLast(contrato_inm);
                lista_inmueble_actual.addLast(i);
                session.setAttribute("lista_contrato_actual", lista_contrato_actual);
                session.setAttribute("lista_inmueble_actual", lista_inmueble_actual);
                request.setAttribute("contrato_actual", contrato_inm);
                session.setAttribute("contrato_actual", contrato_inm);
                request.setAttribute("propietario", p); 
                request.setAttribute("logeado", c);
                session.setAttribute("inmueble_actual", i);
                request.setAttribute("inmueble_actual", i);
                RequestDispatcher view = request.getRequestDispatcher("infoInmueble.jsp");
                view.forward(request, response);
            }
        }
        
        request.setAttribute("propietario", p); 
        request.setAttribute("logeado", c);
        request.setAttribute("Inmuebles", inmuebles);
        RequestDispatcher view = request.getRequestDispatcher("verInmuebles.jsp");
        view.forward(request, response);
    }
}
