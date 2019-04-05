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
 * @author pedrcabu
 */
@WebServlet(name = "aplicarContrato", urlPatterns = {"/aplicarContrato"})
public class AplicarContrato extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AplicarContrato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> A aplicado correctamente al inmueble: "
                    + "" + getInmuebleTomado((LinkedList<Inmueble>)request.getAttribute("Inmuebles"),
                    Integer.parseInt(request.getParameter("predial"))) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          setMessages(request);
        HttpSession session = request.getSession();        
        LinkedList<Inmueble> inmuebles = null;      
        if(null != session.getAttribute("Inmuebles")){
            inmuebles=(LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        }
        Propietario p= (Propietario)session.getAttribute("propietario");
        Cliente c=(Cliente)session.getAttribute("logeado");
        
       
        Integer predial=Integer.parseInt(request.getParameter("predial"));
        for (Inmueble i : inmuebles) {
            if(i.getPredial()==predial){
                i.setDisponible(false);
        }
        }
           
        request.setAttribute("propietario", p); 
        request.setAttribute("logeado", c);
        request.setAttribute("Inmuebles", inmuebles);
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }
    
    private String getInmuebleTomado (LinkedList<Inmueble> inmuebles, Integer predial){
        String pred ="";
           for (Inmueble i : inmuebles) {
            if(i.getPredial()==predial){
                pred= predial.toString();
        }
    }
           return pred;
    }
      

   }
