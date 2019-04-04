package models;
import java.util.*;

public class Propietario {
    
    private int cedula;
    private String nombre;
    private String correo;
    private String contrasena;
    private String direccion;
    private LinkedList<Inmueble> inmuebles;
    private LinkedList<Contrato> contratos;

    public Propietario(int cedula, String nombre, String correo, String contrasena, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.inmuebles = new LinkedList<>();
        this.contratos = new LinkedList<>();
    }

    
    
    
    @Override
    public String toString() {
        return "Propietario{" + "cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", direccion=" + direccion + ", inmuebles=" + inmuebles + '}';
    }

   
    public long getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public LinkedList getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(LinkedList<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
    
    public void addInmueble(Inmueble i1){
        this.getInmuebles().add(i1);
    }

    public LinkedList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(LinkedList<Contrato> contratos) {
        this.contratos = contratos;
    }
    public void addContrato(Contrato c){
        this.contratos.add(c);
    }
    public static Propietario login(int cedula, String contrasena, HashMap<Integer, Propietario> propietarios) {
        if (propietarios.containsKey(cedula)) {
            Propietario temporal = propietarios.get(cedula);
            if(temporal.getContrasena().equals(contrasena)){
                return temporal;
            }
        }
        return null;

    }
}
