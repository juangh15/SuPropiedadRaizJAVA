package util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import models.*;
import java.net.URL;

public class Ficticios {
    
    static private int prediales = 200001;

    static private String[] nombres = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
        "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
        "Caritina", "Carlota", "Baltazar"};
    static private String[] apellidos = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
        "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
        "Grigalva"};
    

    public static void agregarClientes(ArrayList<Cliente> clientes) {
        Cliente c;
        String nombre = "prueba";
        String correo = "@Prueba";
        String contrasena = "1234";
        int cc = 104000;
        String direccion = "carr#Prueba";
        c = new Cliente(cc, nombre, correo, contrasena, direccion);
        clientes.add(c);
        for (int i = 1; i <= 10; i++) {
            nombre = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
            cc += i;
            correo = nombre.replace(" ", "") + "@gmail.com";
            contrasena = nombre.replace(" ", "");
            direccion = "carrera#" + ((int) (Math.random() * 100) + 1) + "a" + ((int) (Math.random() * 50) + 1);
            c = new Cliente(cc, nombre, correo, contrasena, direccion);
            clientes.add(c);
        }
    }
    
    public static void agregarPropietarios(ArrayList<Propietario> propietarios,ArrayList<Inmueble> inmuebles,ArrayList<Contrato> contratos) throws ParseException{
        Propietario p;
        Inmueble inmu;
        Arriendo arri;
        int codigo_contrato=10001;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String nombre = "propietario";
        String correo = "@propietario";
        String contrasena = "1234";
        int cc = 1111,i;
        String direccion = "carr#propietario";
        p = new Propietario(cc, nombre, correo, contrasena, direccion);
        propietarios.add(p);
        prediales += 1;
        inmu=new Inmueble(prediales, 3, true, true, 20, 3, 4, "enVenta", null, p, "Medellin", 12, true);
        p.addInmueble(inmu);
        Date fecha = formatter.parse("01/11/2018");
        Date fecha_fin;
        Compraventa compra= new Compraventa(codigo_contrato, fecha, 200000, inmu, true, "efectivo",p);  
        inmu.setCompraventa(compra);
        propietarios.add(p);
        inmuebles.add(inmu);
        contratos.add(compra);        
        //Inmuebles en venta
        for(i=0;i<5;i++){
            nombre = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
            correo = nombre.replace(" ", "") + "@gmail.com";
            contrasena = nombre.replace(" ", "");
            cc+=1;
            direccion = "carrera#" + ((int) (Math.random() * 100) + 1) + "a" + ((int) (Math.random() * 50) + 1);
            p = new Propietario(cc, nombre, correo, contrasena, direccion);
            propietarios.add(p);
            prediales += 1;
            inmu=new Inmueble(prediales,i+1, true, true, 40+i, 3, 4, "enVenta", null, p, "Medellin", 12, true);
            p.addInmueble(inmu);
            fecha = formatter.parse("01/11/2018");
            compra= new Compraventa(codigo_contrato, fecha, 200000, inmu, true, "efectivo",p);
            inmu.setCompraventa(compra);
            propietarios.add(p);
            inmuebles.add(inmu);
            contratos.add(compra);
            codigo_contrato+=1;
        }
        //Inmuebles en arriendo
        for(i=0;i<5;i++){
            nombre = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
            correo = nombre.replace(" ", "") + "@gmail.com";
            contrasena = nombre.replace(" ", "");
            cc+=1;
            direccion = "carrera#" + ((int) (Math.random() * 100) + 1) + "a" + ((int) (Math.random() * 50) + 1);
            p = new Propietario(cc, nombre, correo, contrasena, direccion);
            propietarios.add(p);
            prediales += 1;
            inmu=new Inmueble(prediales,i+1, true, true, 40+i, 3, 4, "enArriendo", null, p, "Medellin", 12, true);
            p.addInmueble(inmu);
            fecha = formatter.parse("01/11/2018");
            fecha_fin= formatter.parse("01/11/2020");
            arri= new Arriendo(codigo_contrato, fecha, 100000, inmu, true, "efectivo", "No", fecha_fin, p);
            inmu.getArriendo().addLast(arri);
            propietarios.add(p);
            inmuebles.add(inmu);
            contratos.add(arri);                    
            codigo_contrato+=1;
        }
    }
    
    //Clientes desde txt
    public static void datos_desde_txt(ArrayList<Cliente> clientes, String todos){
        
        java.util.Scanner input = new Scanner(todos);
        String siguiente, nombre="", correo="", contrasena="", direccion="";
        int cedula=0;
        while(input.hasNext()){
            
            siguiente = input.next();
            if(siguiente.equals("cedula:")){
                cedula = Integer.parseInt(input.next());
            }
            else if(siguiente.equals("nombre:")){
                nombre = input.next();
            }
            else if(siguiente.equals("correo:")){
                correo = input.next();
            }
            else if(siguiente.equals("contrasena:")){
                contrasena = input.next();
            }
            else if(siguiente.equals("direccion:")){
                direccion = input.next();
            }
            else if(siguiente.equals(".")){
                Cliente c1 = new Cliente(cedula,nombre,correo,contrasena,direccion);
                clientes.add(c1);
            }
        }
    }
    
}

