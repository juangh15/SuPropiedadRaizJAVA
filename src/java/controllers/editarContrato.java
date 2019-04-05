/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.MainServlet.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "editarContrato", urlPatterns = {"/editarContrato"})
public class editarContrato extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        Propietario p = (Propietario) session.getAttribute("propietario");

        LinkedList<Inmueble> lista_inmueble_actual = (LinkedList<Inmueble>) session.getAttribute("lista_inmueble_actual");
        
        if (p == null) {
            RequestDispatcher view = request.getRequestDispatcher("/index");
            view.forward(request, response);
        }

        request.setAttribute("propietario", p);
        RequestDispatcher view = request.getRequestDispatcher("editarContrato.jsp");
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

        LinkedList<Inmueble> lista_inmueble_actual = (LinkedList<Inmueble>) session.getAttribute("lista_inmueble_actual");
        Inmueble inmueble_actual = (Inmueble) lista_inmueble_actual.getLast();

        
        if (boton.equals("Guardar contrato")) {
            int codigo = Contrato.codigo_nuevo + 1;
            Contrato.codigo_nuevo += 1;
            Date fecha = new Date();
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
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }

        if (boton.equals("Guardar")) {
            String check_predial = request.getParameter("check_predial");
            String check_estrato = request.getParameter("check_estrato");
            String check_vigilancia = request.getParameter("check_vigilancia");
            String check_ascensor = request.getParameter("check_ascensor");
            String check_area = request.getParameter("check_area");
            String check_banos = request.getParameter("check_banos");
            String check_cuartos = request.getParameter("check_cuartos");
            String check_ciudad = request.getParameter("check_ciudad");
            String check_antiguedad = request.getParameter("check_antiguedad");
            String check_disponible = request.getParameter("check_disponible");

            String actual = request.getParameter("predial");
            if (!actual.equalsIgnoreCase("") && check_predial != null) {
                int predial = Integer.parseInt(actual);
                inmueble_actual.setPredial(predial);
            }
            actual = request.getParameter("estrato");
            if (!actual.equalsIgnoreCase("") && check_estrato != null) {
                int estrato = Integer.parseInt(actual);
                inmueble_actual.setEstrato(estrato);
            }
            actual = request.getParameter("vigilancia");
            if (!actual.equalsIgnoreCase("") && check_vigilancia != null) {
                boolean vig = Boolean.parseBoolean(actual);
                inmueble_actual.setVigilancia(vig);
            }
            actual = request.getParameter("ascensor");
            if (!actual.equalsIgnoreCase("") && check_ascensor != null) {
                boolean asc = Boolean.parseBoolean(actual);
                inmueble_actual.setAscensor(asc);
            }
            actual = request.getParameter("area");
            if (!actual.equalsIgnoreCase("") && check_area != null) {
                int area = Integer.parseInt(actual);
                inmueble_actual.setArea(area);
            }
            actual = request.getParameter("banos");
            if (!actual.equalsIgnoreCase("") && check_banos != null) {
                int banos = Integer.parseInt(actual);
                inmueble_actual.setBanos(banos);
            }
            actual = request.getParameter("cuartos");
            if (!actual.equalsIgnoreCase("") && check_cuartos != null) {
                int cuartos = Integer.parseInt(actual);
                inmueble_actual.setCuartos(cuartos);
            }
            actual = request.getParameter("ciudad");
            if (!actual.equalsIgnoreCase("") && check_ciudad != null) {
                inmueble_actual.setCiudad(actual);
            }
            actual = request.getParameter("antiguedad");
            if (!actual.equalsIgnoreCase("") && check_antiguedad != null) {
                int antiguedad = Integer.parseInt(actual);
                inmueble_actual.setAntiguedad(antiguedad);
            }

            
            request.setAttribute("propietario", p);
            request.setAttribute("inmueble_actual", inmueble_actual);
            session.setAttribute("inmueble_actual", inmueble_actual);
            request.setAttribute("tipo_contrato", boton);
            request.setAttribute("Inmuebles", inmuebles);
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        
        
        if (boton.equals("Nuevo contrato de venta")) {
            String tipo="";
            tipo = "enVenta";
            inmueble_actual.setTipo(tipo);
        } 
        
        if(boton.equals("Nuevo contrato de arriendo")){
            String tipo="";
            tipo = "enArriendo";
            inmueble_actual.setTipo(tipo);
        }
        
        
        session.setAttribute("Inmuebles", inmuebles);
        request.setAttribute("propietario", p);
        request.setAttribute("inmueble_actual", inmueble_actual);
        session.setAttribute("inmueble_actual", inmueble_actual);
        request.setAttribute("tipo_contrato", boton);
        RequestDispatcher view = request.getRequestDispatcher("editarContratoActual.jsp");
        view.forward(request, response);
    }

}
