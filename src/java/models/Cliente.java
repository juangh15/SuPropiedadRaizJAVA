package models;


import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int cedula;
    private String nombre;
    private String correo;
    private String contrasena;
    private String direccion;
    public static List<Cliente> clientes = new ArrayList<Cliente>();
    public Cliente(int ced, String nom, String correo, String contrasena, String direccion) {
        this.cedula=ced;
        this.nombre=nom;
        this.contrasena=contrasena;
        this.direccion=direccion;
        this.correo=correo;
        
    }
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return this.cedula;
    }

    public boolean setCedula(int cedula) {

        if (cedula > 0) {
            this.cedula = cedula;
            return true;
        } else {
            return false;
        }

    }
    public static void addCliente(Cliente p){
        clientes.add(p);
    }
    public static Cliente getCliente(int cc,List<Cliente> clientes) {
        return clientes.get(cc);
    }
    public static Cliente login(int cedula, String contrasena, ArrayList<Cliente> clientes) {
        
         for(Cliente c: clientes){
             if(c.getCedula()== cedula && c.getContrasena()==contrasena){
                 return c;
             }
         }
        return null;

    }
}
