/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import util.Messages;

/**
 *
 * @author DanielGara
 */
public class MainServlet extends HttpServlet  {
    
    public static void setMessages(HttpServletRequest request){
        request.setAttribute("messages", Messages.list_texts);
    }
    public static void hola(HttpServletRequest request){
        
    }
    
}
