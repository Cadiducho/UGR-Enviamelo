package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RutaPlantilla {
    
    private final int numeroRuta;
    private final LocalTime horaPrevistaInicio;
    private boolean activa = true;

    public RutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        this.numeroRuta = numeroRuta;
        this.horaPrevistaInicio = horaPrevistaInicio;
    }
    
    RutaPlantilla crear(int numeroRuta, LocalTime horaPrevistaInicio) {
        return null;
    }
    
    void asiganrRutaFurgoneta(LocalDate idRutaDiaria, Furgoneta furgoneta) {
        
    }

    void añadirParada(LocalTime horaPrevistaLlegada, Almacen almacen) {
        
    }

    void vogenerarRutaDiaria(LocalDate fecha) {
        
    }

    String obtenerDistritoPrimeraParada() {
        return null;
    }
    
    int obtenerNumeroParadas() {
        return -1;
    }

    int obtenerNumeroRuta() {
        return -1;
    }
    

    void registrarConclusionRuta() {
        
    }

    void registrarInicioRuta() {
        
    }
    
    void registrarParadaCompleta() {
        
    }

    private Ruta buscarRuta(LocalTime idRutaDiaria) {
        return null;
    }
}
