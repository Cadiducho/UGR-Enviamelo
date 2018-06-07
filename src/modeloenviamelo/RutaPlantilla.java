package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class RutaPlantilla {
    
    private final int numeroRuta;
    private final LocalTime horaPrevistaInicio;
    private boolean activa = true;
    List<Parada> paradas;
    List<Ruta> rutas;

    RutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        this.numeroRuta = numeroRuta;
        this.horaPrevistaInicio = horaPrevistaInicio;
        this.paradas = new ArrayList<>();
        this.rutas = new ArrayList<>();
    }
    
    void asiganarRutaFurgoneta(LocalDate idRutaDiaria, Furgoneta furgoneta) throws EnviameloException {
        Optional<Ruta> ruta = buscarRuta(LocalDate.now());
        if (!ruta.isPresent()) {
            throw new EnviameloException("No se ha encontrado la ParadaEnRuta identificada por " + LocalDate.now());
        }
        ruta.get().asignarFurgoneta(furgoneta);
    }

    void añadirParada(LocalTime horaPrevistaLlegada, Almacen almacen) {
        Parada unaParada = new Parada(horaPrevistaLlegada, almacen);
        paradas.add(unaParada);
    }

    void generarRutaDiaria(LocalDate fecha) {
        Ruta unaRuta = new Ruta(fecha);
        paradas.forEach(parada -> unaRuta.incluirParada(parada));
        rutas.add(unaRuta);
    }
    
    Parada obtenerPrimeraParada() {
        return paradas.get(0);
    }

    int obtenerDistritoPrimeraParada() {
        return obtenerPrimeraParada().obtenerDistrito();
    }
    
    int obtenerNumeroParadas() {
        return paradas.size();
    }

    int obtenerNumeroRuta() {
        return numeroRuta;
    }
    
    void registrarConclusionRuta() throws EnviameloException {
        Optional<Ruta> ruta = buscarRuta(LocalDate.now());
        if (!ruta.isPresent()) {
            throw new EnviameloException("No se ha encontrado la ParadaEnRuta identificada por " + LocalDate.now());
        }
        ruta.get().registrarConclusion();
    }

    void registrarInicioRuta() throws EnviameloException {
        Optional<Ruta> ruta = buscarRuta(LocalDate.now());
        if (!ruta.isPresent()) {
            throw new EnviameloException("No se ha encontrado la ParadaEnRuta identificada por " + LocalDate.now());
        }
        ruta.get().registrarInicio();
    }
    
    List<String> registrarParadaCompleta() throws EnviameloException {
        Optional<Ruta> ruta = buscarRuta(LocalDate.now());
        if (!ruta.isPresent()) {
            throw new EnviameloException("No se ha encontrado la ParadaEnRuta identificada por " + LocalDate.now());
        }
        List<String> datosSiguienteParada = ruta.get().registrarParadaCompleta();
        return datosSiguienteParada;
    }

    private Optional<Ruta> buscarRuta(LocalDate idRutaDiaria) {
        return rutas.stream().filter(r -> r.obtenerFechaRealizacion().equals(idRutaDiaria)).findFirst();
    }
    
    boolean isActiva() {
        return activa;
    }
    
    void setActiva(boolean bool) {
        this.activa = bool;
    }
}
