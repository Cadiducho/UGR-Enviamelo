package modeloenviamelo;

import java.util.ArrayList;
import java.util.List;

class Furgoneta {

    private final String matricula;
    private final double pesoMaximo;
    private boolean disponibilidad = true;
    private Almacen almacen;

    Furgoneta(String matricula, double pesoMaximo, Almacen almacen) {
        this.matricula = matricula;
        this.pesoMaximo = pesoMaximo;
        this.almacen = almacen;
    }
    
    void modificarDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    void modificarLocalizacion(Almacen almacen) {
        this.almacen = almacen;
    }
    
    Almacen obtenerLocalizacion() {
        return almacen;
    }
    
    String obtenerMatricula() {
        return matricula;
    }
    
    List<String> obtenerDatos() {
        List<String> datos = new ArrayList<>();
        datos.add(matricula);
        datos.add(Double.toString(pesoMaximo));
        return datos;
    }
    
    boolean isDisponible() {
        return disponibilidad;
    }
}
