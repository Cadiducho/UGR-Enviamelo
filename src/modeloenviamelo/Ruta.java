package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ruta {
    
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    
    void crear(LocalDate fecha) {
        
    }
    
    void asignarFurgoneta(Furgoneta furgoneta) {
        
    }
    
    void incluirParada(Parada parada) {
        
    }
    
    void registrarConclusion() {
        
    }
    
    void registrarInicio() {
        
    }
    
    void registrarParadaCompleta() {
        
    }
    
    void sinParadaActual() {
        
    }
    
    void modificarHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    void modificarParadaActual(Parada parada) {
        
    }
    
    ParadaEnRuta obtenerParadaEnRuta(Parada paradaActual) {
        return null;
    }
    
    Parada siguienteParada() {
        return null;
    }
    
}
