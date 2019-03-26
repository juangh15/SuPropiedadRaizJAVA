package controllers;

import static controllers.MainServlet.setMessages;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
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
        List<Cliente> clientes = new ArrayList<Cliente>();
        if (null != session.getAttribute("Clientes")) {
            clientes = (ArrayList<Cliente>) session.getAttribute("Clientes");
        }
        Cliente c = (Cliente) session.getAttribute("logeado");
        request.setAttribute("logeado", c);
        request.setAttribute("Clientes", clientes);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        if (null != session.getAttribute("propietarios")) {
            propietarios = (ArrayList<Propietario>) session.getAttribute("Propietarios");
            inmuebles = (ArrayList<Inmueble>) session.getAttribute("Inmuebles");
            contratos = (ArrayList<Contrato>) session.getAttribute("Contratos");
        }
        if (null != session.getAttribute("Clientes")) {
            
            clientes = (ArrayList<Cliente>) session.getAttribute("Clientes");
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
            try {
                String rutaRelativaApp= getServletContext().getRealPath("/");
                System.out.println("rutaaaa"+rutaRelativaApp);
                Ficticios.datos_desde_txt(clientes);
                
            } catch (Exception ex) {
                System.out.println(ex.toString());
                RequestDispatcher view = request.getRequestDispatcher("nuevoCliente.jsp");
                view.forward(request, response);
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
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
