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
@WebServlet(name = "buscarInmuebles", urlPatterns = {"/buscarInmuebles"})
public class buscarInmuebles extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        LinkedList<Inmueble> inmuebles = new LinkedList<Inmueble>();
        LinkedList<Inmueble> filtrados = new LinkedList<Inmueble>();
        if (null != session.getAttribute("Inmuebles")) {
            inmuebles = (LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        }
        Cliente c = (Cliente) session.getAttribute("logeado");
        Propietario p = (Propietario) session.getAttribute("propietario");
        String busqueda = request.getParameter("busqueda");
        System.out.println(busqueda);
        if (busqueda.equalsIgnoreCase("buscarPorPredial")) {
            String predial = request.getParameter("predial");
            int numero = Integer.parseInt(predial);
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            filtrados.add(Inmueble.buscarPorPredial(inmuebles, numero));
            request.setAttribute("filtrados", filtrados);
        } else if (busqueda.equalsIgnoreCase("buscarPorEstrato")) {
            String estrato = request.getParameter("estrato");
            int numero = Integer.parseInt(estrato);
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            filtrados = Inmueble.buscarPorEstrato(inmuebles, numero);
            request.setAttribute("filtrados", filtrados);
        } else if (busqueda.equalsIgnoreCase("buscarPorArea")) {
            String min = request.getParameter("area_minima");
            String max = request.getParameter("area_maxima");
            int area_minima = Integer.parseInt(min);
            int area_maxima = Integer.parseInt(max);
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            filtrados = Inmueble.buscarPorArea(inmuebles, area_minima, area_maxima);
            request.setAttribute("filtrados", filtrados);
        } else if (busqueda.equalsIgnoreCase("buscarPorNumeroDeCuartos")) {
            String min = request.getParameter("cuartos_minima");
            String max = request.getParameter("cuartos_maxima");
            int cuartos_minima = Integer.parseInt(min);
            int cuartos_maxima = Integer.parseInt(max);
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            filtrados = Inmueble.buscarPorNumeroDeCuartos(inmuebles, cuartos_minima, cuartos_maxima);
            request.setAttribute("filtrados", filtrados);
        } else if (busqueda.equalsIgnoreCase("buscarPorNumeroDeBanos")) {
            String min = request.getParameter("banos_minima");
            String max = request.getParameter("banos_maxima");
            int banos_minima = Integer.parseInt(min);
            int banos_maxima = Integer.parseInt(max);
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            filtrados = Inmueble.buscarPorNumeroDeBanos(inmuebles, banos_minima, banos_maxima);
            request.setAttribute("filtrados", filtrados);
        } else if (busqueda.equalsIgnoreCase("buscarPorCiudad")) {
            String ciudad = request.getParameter("ciudad");
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            filtrados = Inmueble.buscarPorCiudad(inmuebles, ciudad);
            request.setAttribute("filtrados", filtrados);
        }

        request.setAttribute("Inmuebles", inmuebles);

        RequestDispatcher view = request.getRequestDispatcher("inmueblesFiltrados.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        LinkedList<Inmueble> inmuebles = new LinkedList<Inmueble>();
        if (null != session.getAttribute("Inmuebles")) {
            inmuebles = (LinkedList<Inmueble>) session.getAttribute("Inmuebles");
        }
        Cliente c = (Cliente) session.getAttribute("logeado");
        Propietario p = (Propietario) session.getAttribute("propietario");
        String busqueda = request.getParameter("busqueda");
        request.setAttribute("busqueda", busqueda);
        if (busqueda.equalsIgnoreCase("buscarPorPredial") || busqueda.equalsIgnoreCase("buscarPorCiudad") || busqueda.equalsIgnoreCase("buscarPorEstrato") || busqueda.equalsIgnoreCase("buscarPorNumeroDeBanos") || busqueda.equalsIgnoreCase("buscarPorNumeroDeCuartos") || busqueda.equalsIgnoreCase("buscarPorArea")) {

            request.setAttribute("logeado", c);
            request.setAttribute("propietario", p);
            RequestDispatcher view = request.getRequestDispatcher("buscarInmuebles.jsp");
            view.forward(request, response);
        } else {
            if (busqueda.equalsIgnoreCase("buscarInmueblesEnCompraventa")) {
                LinkedList<Inmueble> filtrados = Inmueble.buscarInmueblesEnCompraventa(inmuebles);
                request.setAttribute("filtrados", filtrados);
                request.setAttribute("logeado", c);
                request.setAttribute("propietario", p);
            } else if (busqueda.equalsIgnoreCase("buscarInmueblesEnArriendo")) {
                LinkedList<Inmueble> filtrados = Inmueble.buscarInmueblesEnArriendo(inmuebles);
                request.setAttribute("filtrados", filtrados);
                request.setAttribute("logeado", c);
                request.setAttribute("propietario", p);
            }

            request.setAttribute("Inmuebles", inmuebles);

            RequestDispatcher view = request.getRequestDispatcher("inmueblesFiltrados.jsp");
            view.forward(request, response);
        }

    }
}
