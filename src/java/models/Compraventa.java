package models;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Compraventa extends Contrato {

    private Cliente comprador;
    private String medioPago;

    public Compraventa(int codigo,Date fecha,double valor,Inmueble inmueble,boolean disponible, String medioPago,Propietario propietario) {
        super(codigo,fecha,valor,inmueble,disponible,propietario);
        this.comprador = null;
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        return "Compraventa{" + "comprador=" + comprador + ", medioPago=" + medioPago + '}';
    }

    

    

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago.trim();
    }

    public static LinkedList compraventasDisponibles(HashMap<Integer, Compraventa> compraventas) {
        LinkedList<Compraventa> disponibles = new LinkedList<>();
        for (Compraventa c1 : compraventas.values()) {
            if (c1.getDisponible()) {
                disponibles.add(c1);
            }
        }
        if (disponibles.isEmpty()) {
            return null;
        }
        return disponibles;

    }

}
