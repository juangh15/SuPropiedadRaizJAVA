package models;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
public class Contrato {

    private int codigo;
    private Date fecha;
    private double valor;
    private Inmueble inmueble;
    private boolean disponible;
    public static int codigo_nuevo=999;
    public Contrato(int codigo,Date fecha,double valor,Inmueble inmueble,boolean disponible,Propietario propietario){
        this.codigo=codigo;
        this.fecha=fecha;
        this.inmueble =inmueble;
        this.valor=valor;
        this.disponible=disponible;
    }
    @Override
    public String toString() {
        return "Contrato{" + "codigo=" + codigo + ", fecha=" + fecha + ", valor=" + valor + ", inmueble=" + inmueble + ", disponible=" + disponible + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //busquedas------------------------------------------------------------------------------------
    
    //por codigo
    public static Contrato buscarContrato(HashMap<Integer, Contrato> contratos, Integer codigo) {
        Contrato encontrado = contratos.get(codigo);
        return encontrado;
    }

    //por ciudad
    public static LinkedList buscarPorCiudad(HashMap<Integer, Contrato> contratos, String ciudad) {
        LinkedList<Contrato> todos_los_contratos = new LinkedList<>();
        for (Contrato contra : contratos.values()) {
            if (contra.getInmueble().getCiudad().equalsIgnoreCase(ciudad)) {
                todos_los_contratos.add(contra);
            }
        }
        if (todos_los_contratos.isEmpty()) {
            return null;
        }
        return todos_los_contratos;
    }

    //por estrato
    public static LinkedList buscarPorEstrato(HashMap<Integer, Contrato> contratos, int estrato) {
        LinkedList<Contrato> todos_los_contratos = new LinkedList<>();
        for (Contrato contra : contratos.values()) {
            if (contra.getInmueble().getEstrato() == estrato) {
                todos_los_contratos.add(contra);
            }
        }
        if (todos_los_contratos.isEmpty()) {
            return null;
        }
        return todos_los_contratos;
    }
    
    //por numero de banos
    public static LinkedList buscarPorNumeroDeBanos(HashMap<Integer, Contrato> contratos, int banosini, int banostop) {
        LinkedList<Contrato> todos_los_contratos = new LinkedList<>();
        int bano;
        for (Contrato contra : contratos.values()) {
            bano = contra.getInmueble().getBanos();
            if ((bano>=banosini)&&(bano<=banostop)) {
                todos_los_contratos.add(contra);
            }
        }
        if (todos_los_contratos.isEmpty()) {
            return null;
        }
        return todos_los_contratos;
    }
    
    //por numero de cuartos
    public static LinkedList buscarPorNumeroDeCuartos(HashMap<Integer, Contrato> contratos, int cuartosini, int cuartostop) {
        LinkedList<Contrato> todos_los_contratos = new LinkedList<>();
        int c;
        for (Contrato contra : contratos.values()) {
            c = contra.getInmueble().getCuartos();
            if ((c>=cuartosini)&&(c<=cuartostop)) {
                todos_los_contratos.add(contra);
            }
        }
        if (todos_los_contratos.isEmpty()) {
            return null;
        }
        return todos_los_contratos;
    }
    
    //por area
    public static LinkedList buscarPorArea(HashMap<Integer, Contrato> contratos, int areaini, int areatop) {
        LinkedList<Contrato> todos_los_contratos = new LinkedList<>();
        int area;
        for (Contrato contra : contratos.values()) {
            area = contra.getInmueble().getArea();
            if ((area>=areaini)&&(area<=areatop)) {
                todos_los_contratos.add(contra);
            }
        }
        if (todos_los_contratos.isEmpty()) {
            return null;
        }
        return todos_los_contratos;
    }
}
