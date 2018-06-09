package interfaztextual;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import modeloenviamelo.Enviamelo;
import modeloenviamelo.EnviameloException;

public class IUEnviamelo {

    private static VistaTextualEnviamelo vista;
    private static Enviamelo muyRapido;
    
    public static void main(String[] args) {
        muyRapido = Enviamelo.getInstancia();
        vista = new VistaTextualEnviamelo();

        final Scanner in = new Scanner(System.in);
        int opcion = 0;
        int idRutaPlantilla;

        boolean ejecutando = true;
        
        while (ejecutando) {
            vista.mostrar("\n\n********************** OPCIONES ********************\n");
            vista.mostrar("\t1. Conductor \n"
                    + "\t2. Oficinista \n"
                    + "\t0. SALIR");
            
            opcion = Integer.parseInt(in.nextLine());
            
            switch (opcion) {
                // CONDUCTOR
                case 1:
                    if (muyRapido.obtenerRutasActivas().isEmpty()) {
                        vista.mostrar("No hay rutas activas");
                        continue; //volver a preguntar si oficinista o conductor. Dar opción a crear rutas activas
                    } 
                    
                    idRutaPlantilla = vista.menuElegirRutaPlantilla(muyRapido.obtenerRutasActivas());
                    try {
                        int numeroParadas = muyRapido.registrarInicioRuta(idRutaPlantilla);
                        for (int i = 1; i < numeroParadas; i++) {
                            vista.mostrar("Pulsa cualquier tecla para indicar parada completada");
                            in.nextLine();
                            List<String> datosSiguiente = muyRapido.registrarParadaCompletada(idRutaPlantilla);
                            if (!datosSiguiente.isEmpty()) {
                                vista.mostrar(datosSiguiente);
                                vista.mostrar("Vamos a la siguiente parada");
                            }
                        }
                        vista.mostrar("La ruta: " + idRutaPlantilla + " ha finalizado , pulsa cualquier tecla para indicar fin de ruta");
                        in.nextLine();
                        muyRapido.registrarConclusionRuta(idRutaPlantilla);
                    } catch (EnviameloException ex) {
                        vista.mostrar(ex.getMessage());
                    }
                    break;
                    
                // OFICINISTA
                case 2:
                    do {
                        try {
                            vista.mostrar("===== CESTIÓN DE RUTAS===== \n"
                                    + "\t1. Nueva ruta plantilla \n"
                                    + "\t2. Generar ruta diaria \n"
                                    + "\t3. Asignar furgoneta a ruta\n");
                            
                            vista.mostrar("*******************************************************");
                            vista.mostrar("\t0. Volver a menú principal");
                            vista.mostrar("*******************************************************");
                            
                            // Lectura de un int, para darle valor a opcion.
                            opcion = Integer.parseInt(in.nextLine());
                            
                            switch (opcion) {
                                case 1:
                                    vista.mostrar("Numero de ruta: ");
                                    idRutaPlantilla = Integer.parseInt(in.nextLine());
                                    LocalTime horaPrevistaInicio = vista.crearLocalTime();
                                    idRutaPlantilla = muyRapido.crearRutaPlantilla(idRutaPlantilla, horaPrevistaInicio);
                                    
                                    boolean añadirMas = true;
                                    while (añadirMas) {
                                        int idAlmacen = vista.menuElegirAlmacen(muyRapido.obtenerAlmacenes());
                                        vista.mostrar("¿A qué hora está prevista la llegada?");
                                        LocalTime horaPrevistaLlegada = vista.crearLocalTime();
                                        
                                        muyRapido.añadirParadaRutaPlantilla(idRutaPlantilla, horaPrevistaLlegada, idAlmacen);
                                        
                                        vista.mostrar("¿Quieres añadir más paradas?");
                                        añadirMas = vista.chooseYesOrNo();
                                    }
                                    break;
                                case 2:
                                    idRutaPlantilla = vista.menuElegirRutaPlantilla(muyRapido.obtenerRutasActivas());
                                    LocalDate fechaRutaDiaria = vista.crearLocalDate();
                                    
                                    muyRapido.generarRutaDiaria(fechaRutaDiaria, idRutaPlantilla);
                                    break;
                                case 3:
                                    idRutaPlantilla = vista.menuElegirRutaPlantilla(muyRapido.obtenerRutasActivas());
                                    String matricula = vista.menuElegirFurgoneta(muyRapido.obtenerFurgonetasRuta(idRutaPlantilla));
                                    fechaRutaDiaria = vista.menuElegirRutaDiaria(muyRapido.obtenerRutasDiarias(idRutaPlantilla));
                                    
                                    muyRapido.asignarRutaFurgoneta(idRutaPlantilla, fechaRutaDiaria, matricula);
                                    break;
                                case 0:
                                    continue;
                                default:
                                    vista.mostrar("OPCION NO VÁLIDA");
                                    break;
                            }
                        } catch (NumberFormatException | EnviameloException ex) {
                            System.err.println("Se ha producido la siguiente excepcion: " + ex.getMessage());
                        }
                    } while (opcion != 0);
                    break;
                case 0:
                    ejecutando = false;
                    break;
            }
        }
        System.exit(0);
    }

}
