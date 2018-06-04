package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Enviamelo {

    private static final Enviamelo instancia = new Enviamelo();
    public static Enviamelo getInstancia() {
        return instancia;
    }

    private Enviamelo() {
        this.inicalizar();
    }

    private final List<Almacen> almacenes = new ArrayList<>();
    private final List<Furgoneta> furgonetas = new ArrayList<>();
    private final List<RutaPlantilla> rutasPlantilla = new ArrayList<>();

    private void inicalizar() {
        Almacen a1 = new Almacen("18000", "el florio, Granada", "958345678", "Antonio");
        Almacen a2 = new Almacen("29000", "el potril, Málaga", "952785678", "Maria");
        Almacen a3 = new Almacen("04000", "el poniente, Almería", "954087654", "Mario");
        Almacen a4 = new Almacen("23000", "los olivares, Jaén", "953765432", "Antonia");
        
        almacenes.add(a1);
        almacenes.add(a2);
        almacenes.add(a3);
        almacenes.add(a4);

        furgonetas.add(new Furgoneta("3654 FFF", 2000, a1));
        furgonetas.add(new Furgoneta("3756 CDD", 3000, a1));
        furgonetas.add(new Furgoneta("9086 KDG", 1000, a2));
        furgonetas.add(new Furgoneta("9876 JJJ", 1000, a2));
        furgonetas.add(new Furgoneta("2111 HHH", 2000, a3));
        furgonetas.add(new Furgoneta("4545 HFG", 1000, a3));
        furgonetas.add(new Furgoneta("2885 JHG", 5000, a4));
        furgonetas.add(new Furgoneta("3335 DCD", 5000, a4));
    }
    
    public void añadirParadaRutaPlantilla(int idRutaPlantilla, LocalTime horaPrevistaLlegada, int idAlmacen) throws EnviameloException {
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        Optional<Almacen> almacen = buscarAlmacen(idAlmacen);
        if (!almacen.isPresent()) {
            throw new EnviameloException("No se ha encontrado el Almacen identificado por " + idAlmacen);
        }
        
        rutaPlantilla.get().añadirParada(horaPrevistaLlegada, almacen.get());
    }
    
    public void asignarRutaFurgoneta(int idRutaPlantilla, LocalDate idRutaDiaria, String idFurgoneta) throws EnviameloException {
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        Optional<Furgoneta> furgoneta = buscarFurgoneta(idFurgoneta);
        if (!furgoneta.isPresent()) {
            throw new EnviameloException("No se ha encontrado la Furgoneta identificada por " + idFurgoneta);
        }
        
        if (!furgoneta.get().isDisponible()) {
            throw new EnviameloException("Esa furgoneta no está disponible");
        }
        
        rutaPlantilla.get().asiganarRutaFurgoneta(idRutaDiaria, furgoneta.get());
    }
    
    public int crearRutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) throws EnviameloException {
        if (existeRutaPlantilla(numeroRuta)) {
            throw new EnviameloException("Ya existe una ruta plantilla con ese número de ruta");
        }
        
        RutaPlantilla unaRutaPlantilla = new RutaPlantilla(numeroRuta, horaPrevistaInicio);
        rutasPlantilla.add(unaRutaPlantilla);
        return unaRutaPlantilla.obtenerNumeroRuta();
    }
    
    public void generarRutaDiaria(LocalDate fecha, int idRutaPlantilla) throws EnviameloException {
        if (fecha.isAfter(LocalDate.now())) {
            throw new EnviameloException("La fecha debe ser igual o posterior a la fecha actual");
        }
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        rutaPlantilla.get().generarRutaDiaria(fecha);
    }
    
    public List<String> obtenerFurgonetasRuta(int idRutaPlantilla) throws EnviameloException {
        List<String> datos = new ArrayList<>();
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        int distrito = rutaPlantilla.get().obtenerDistritoPrimeraParada();
        List<Furgoneta> furgonetasDisponibles = seleccionarFurgonetasDisponibles(distrito);
        furgonetasDisponibles.forEach(furgo -> 
                datos.add(furgo.obtenerDatos().stream().map(Object::toString).collect(Collectors.joining(","))));
        return datos;
    }
    
    public void registrarConclusionRuta(int idRutaPlantilla) throws EnviameloException {
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        rutaPlantilla.get().registrarConclusionRuta();
    }
    
    public int registrarInicioRuta(int idRutaPlantilla) throws EnviameloException {
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        rutaPlantilla.get().registrarInicioRuta();
        return rutaPlantilla.get().obtenerNumeroParadas();
    }

    public List<String> registrarParadaCompletada(int idRutaPlantilla) throws EnviameloException {
        Optional<RutaPlantilla> rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        if (!rutaPlantilla.isPresent()) {
            throw new EnviameloException("No se ha encontrado la RutaPlantilla identificada por " + idRutaPlantilla);
        }
        
        List<String> datosSiguienteParada = rutaPlantilla.get().registrarParadaCompleta();
        return datosSiguienteParada;
    }
    
    private Optional<Almacen> buscarAlmacen(int idAlmacen) {
        return almacenes.stream().filter(a -> a.obtenerDistrito().equals(idAlmacen)).findFirst();
    }

    private Optional<Furgoneta> buscarFurgoneta(String idFurgoneta) {
        return furgonetas.stream().filter(f -> f.obtenerMatricula().equalsIgnoreCase(idFurgoneta)).findFirst();
    }
    
    private boolean existeRutaPlantilla(int numeroRP) {
        return false;
    }

    private Optional<RutaPlantilla> buscarRutaPlantilla(int idRutaPlantilla) {
        return rutasPlantilla.stream().filter(rp -> rp.obtenerNumeroRuta() == idRutaPlantilla).findFirst();
    }
    
    private boolean existeRutaPlantilla(int numeroRP) {
        return rutasPlantilla.stream().anyMatch(rp -> rp.obtenerNumeroRuta() == numeroRP);
    }

    private List<Furgoneta> seleccionarFurgonetasDisponibles(int distrito) {
        return furgonetas.stream().filter(f -> f.obtenerLocalizacion().obtenerDistrito() == distrito).collect(Collectors.toList());
    }

    /**
     * Proporciona todos los numeros de ruta plantilla que estén activas 
     * @return lista de ids
     */
    public List<Integer> obtenerRutasActivas() {
        return rutasPlantilla.stream().filter(RutaPlantilla::isActiva).map(RutaPlantilla::obtenerNumeroRuta).collect(Collectors.toList());
    }
}
