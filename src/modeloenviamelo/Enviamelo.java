package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aanaya
 */
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
    
    public void añadirParadaRutaPlantilla(int idRutaPlantilla, LocalTime horaPrevistaLlegada, int idAlmacen) {
        
    }
    
    public void asignarRutaFurgoneta(int idRutaPlantilla, LocalDate idRutaDiaria, String idFurgoneta) {
        
    }
    
    public int crearRutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        return -1;
    }
    
    public void generarRutaDiaria(LocalTime fecha, int idRutaPlantilla) {
        
    }
    
    public String[] obtenerFurgonetasRuta(int idRutaPlantilla) {
        return null;
    }
    
    public void registarConclusionRuta(int idRutaPlantilla) {
        
    }
    
    public int registrarInicioRuta(int idRutaPlantilla) {
        return -1;
    }
    
    public void registrarParadaCompleta(int idRutaPlantilla) {
        
    }
    
    private Almacen buscarAlmacen(int idAlmacen) {
        return null;
    }

    private Furgoneta buscarFurgoneta(int idFurgoneta) {
        return null;
    }

    private RutaPlantilla buscarRutaPlantilla(int idRutaPlantilla) {
        return null;
    }
    
    private boolean existeRutaPlantilla(int numeroRP) {
        return false;
    }

    private Furgoneta[] seleccionarFurgonetasDisponibles(String distrito) {
        return null;
    }


    // proporciona todos los numeros de ruta plantilla que estén activas 
    public int[] obtenerRutasActivas() {
        return null;
    }

    public List registrarParadaCompletada(int numeroRuta) {
        return null;
    }

    public void registrarConclusionRuta(int numeroRuta) {
    }
}
