/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainServlet.setMessages;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import util.ValidadorDeFormularios;

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
        HttpSession session = request.getSession();
        Propietario p = (Propietario) session.getAttribute("propietario");
        
        request.setAttribute("propietario", p);
        RequestDispatcher view = request.getRequestDispatcher("nuevoInmueble.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        Propietario p = (Propietario) session.getAttribute("propietario");
        String boton = request.getParameter("boton");

        LinkedList inmuebles = (LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        if (boton.equals("Guardar contrato")) {
            int codigo = Contrato.codigo_nuevo + 1;
            Contrato.codigo_nuevo += 1;
            Date fecha = new Date();
        if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("valor"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("valor")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }

            int valor = Integer.parseInt(request.getParameter("valor"));
            Inmueble actual = (Inmueble) session.getAttribute("inmueble_actual");
            boolean disponible = Boolean.parseBoolean(request.getParameter("disponible"));
            if (actual.getTipo().equals("enVenta")) {
                String medio_pago = request.getParameter("medio_pago");
                Compraventa comven = new Compraventa(codigo, fecha, valor, actual, disponible, medio_pago, p);
                p.addContrato(comven);
                actual.setCompraventa(comven);

            } else {
                String agencia = request.getParameter("agencia");
                String medio_pago = request.getParameter("tipo_pago");
                Arriendo arri = new Arriendo(codigo, fecha, valor, actual, disponible, medio_pago, agencia, null, p);
                p.addContrato(arri);
                actual.addArriendo(arri);
            }
            request.setAttribute("propietario", p);
            RequestDispatcher view = request.getRequestDispatcher("nuevoInmueble.jsp");
            view.forward(request, response);
        }
        
         if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("predial"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("predial")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
         if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("estrato"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("estrato")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
         if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("area"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("area")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
         if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("banos"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("banos")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
         if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("antiguedad"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("antiguedad")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
         if (!ValidadorDeFormularios.esDatoNumerico(request.getParameter("cuartos"))) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El campo "+request.getParameter("cuartos")+", debe de ser un número entero");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
          
        Integer predial = Integer.parseInt(request.getParameter("predial"));
        int estrato = Integer.parseInt(request.getParameter("estrato"));
        boolean vigilancia = Boolean.parseBoolean(request.getParameter("vigilancia"));
        boolean ascensor = Boolean.parseBoolean(request.getParameter("ascensor"));
        int area = Integer.parseInt(request.getParameter("area"));
        int banos = Integer.parseInt(request.getParameter("banos"));
        int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
        int cuartos = Integer.parseInt(request.getParameter("cuartos"));
        String ciudad = request.getParameter("ciudad");
        String tipo;
        if (boton.equals("Poner en venta")) {
            tipo = "enVenta";
        } else {
            tipo = "enArriendo";
        }
        
        if (ValidadorDeFormularios.existeInmueble(inmuebles,predial)) {
            RequestDispatcher view = request.getRequestDispatcher("camposNoValidos.jsp");
            session.setAttribute("error", "El inmuble con el predia: "+predial.toString()+" ya existe");
            session.setAttribute("urlAnterior",request.getRequestURI());
             view.forward(request, response);
         }
        
        Inmueble inmu = new Inmueble(predial, estrato, vigilancia, ascensor, area, banos, cuartos, tipo, null, p, ciudad, antiguedad, true);
        p.addInmueble(inmu);
        inmuebles.add(inmu);

        session.setAttribute("Inmuebles", inmuebles);
        request.setAttribute("propietario", p);
        request.setAttribute("inmueble_actual", inmu);
        session.setAttribute("inmueble_actual", inmu);
        request.setAttribute("tipo_contrato", boton);

        RequestDispatcher view = request.getRequestDispatcher("nuevoContrato.jsp");
        view.forward(request, response);
    }
}
