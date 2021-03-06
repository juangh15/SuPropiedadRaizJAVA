package controllers;

import static controllers.MainServlet.setMessages;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import org.apache.commons.io.IOUtils;
import util.Ficticios;

/**
 *
 * @author Tamayo
 */
@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setMessages(request);
        HttpSession session = request.getSession();
        Cliente c= (Cliente)session.getAttribute("logeado");
        Propietario p=(Propietario)session.getAttribute("propietario");
        request.setAttribute("logeado", c);
        request.setAttribute("propietario", p);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();
        LinkedList<Propietario> propietarios = new LinkedList<Propietario>();
        LinkedList<Inmueble> inmuebles = new LinkedList<Inmueble>();
        LinkedList<Contrato> contratos = new LinkedList<Contrato>();
        if (null != session.getAttribute("Propietarios")) {
            propietarios = (LinkedList<Propietario>) session.getAttribute("Propietarios");
            inmuebles = (LinkedList<Inmueble>) session.getAttribute("Inmuebles");
            contratos = (LinkedList<Contrato>) session.getAttribute("Contratos");
        }
        if (null != session.getAttribute("Clientes")) {
            
            clientes = (LinkedList<Cliente>) session.getAttribute("Clientes");
        }
        Cliente c = (Cliente) session.getAttribute("logeado");
        String accion=request.getParameter("ficticios");
        if(accion.equals("agragar ficticios")){
            
            Ficticios.agregarClientes(clientes);
            try {
                Ficticios.agregarPropietarios(propietarios, inmuebles, contratos);
            } catch (ParseException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(accion.equals("agregar clientes desde txt")){
            InputStream input=getServletContext().getResourceAsStream("/ficticios.txt");
            String result = IOUtils.toString(input,"UTF-8");
            Ficticios.datos_desde_txt(clientes, result);
                
        }
        
        session.setAttribute("Propietarios", propietarios);
        session.setAttribute("Inmuebles", inmuebles);
        session.setAttribute("Contratos", contratos);
        request.setAttribute("logeado", c);
        session.setAttribute("Clientes", clientes);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
