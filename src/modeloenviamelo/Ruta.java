package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

class Ruta {
    
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private Parada actual;
    private final List<Furgoneta> furgonetasCubriendo;
    private final List<ParadaEnRuta> paradas;
    
    Ruta(LocalDate fecha) {
        this.fechaRealizacion = fecha;
        this.paradas = new ArrayList<>();
        this.furgonetasCubriendo = new ArrayList<>();
    }
    
    void asignarFurgoneta(Furgoneta furgoneta) {
        furgoneta.modificarDisponibilidad(true);
        furgonetasCubriendo.add(furgoneta);
    }
    
    void incluirParada(Parada parada) {
        ParadaEnRuta unaParadaEnRuta = new ParadaEnRuta(parada);
        paradas.add(unaParadaEnRuta);
    }
    
    void registrarConclusion() {
        Almacen almacen = actual.obtenerAlmacen();
        for (Furgoneta furgo : furgonetasCubriendo) {
            furgo.modificarLocalizacion(almacen);
            furgo.modificarDisponibilidad(true);
        }
        sinParadaActual();
    }
    
    void registrarInicio() {
        Parada primeraParada = siguienteParada();
        modificarParadaActual(primeraParada);
        modificarHoraInicio(LocalTime.now());
    }
    
    List<String> registrarParadaCompleta() throws EnviameloException {
        Optional<ParadaEnRuta> paradaEnRuta = obtenerParadaEnRuta(actual);
        if (!paradaEnRuta.isPresent()) {
            throw new EnviameloException("No se ha encontrado la ParadaEnRuta identificada por " + actual);
        }
        paradaEnRuta.get().modificarHoraLlegada(LocalTime.now());
        Parada parada = siguienteParada();
        modificarParadaActual(parada);
        List<String> datosSiguienteParada = actual.obtenerDatos();
        return datosSiguienteParada;
    }
    
    void sinParadaActual() {
        modificarParadaActual(null);
    }
    
    void modificarHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    void modificarParadaActual(Parada parada) {
        actual = parada;
    }
        
    List<ParadaEnRuta> obtenerParadas() {
        return paradas;
    }
    
    Optional<ParadaEnRuta> obtenerParadaEnRuta(Parada paradaActual) {
        return paradas.stream().filter(pr -> pr.getParada().equals(paradaActual)).findFirst();
    }
    
    Parada siguienteParada() {
        if (actual == null) {
            return paradas.get(0).getParada();
        }
        
        Iterator<ParadaEnRuta> iterator = paradas.iterator();
        while (iterator.hasNext()) {
            ParadaEnRuta it = iterator.next();
            if (it.getParada().equals(actual) && iterator.hasNext()) {
                return iterator.next().getParada();
            }
        }
        return null;
    }
    
    LocalDate obtenerFechaRealizacion() {
        return fechaRealizacion;
    }
    
}
