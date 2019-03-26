/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author DanielGara
 */
public class Messages {
    public static HashMap<String,String> list_texts = new HashMap<String,String>(){
        {
            put("header_text","Bienvenido a suPropiedadRaiz");
            put("lista_clientes","Lista de clientes");
            put("cedula","Cedula");
            put("nombre","Nombre");
            put("correo","Correo");
            put("contrasena","Contrasena");
            put("direccion","Direccion");            
            put("lista_inmuebles","Lista de inmuebles disponibles ");
            put("predial","Predial");
            put("estrato","Estrato");
            put("area","Area total");
            put("banos","Numero banos");
            put("cuartos","Numero cuartos");
            put("ciudad","ciudad");  
        }
    };
}
