package interfaztextual;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VistaTextualEnviamelo {

    private static final Scanner in = new Scanner(System.in);

    public Integer menuElegirAlmacen(Map<String, Integer> listaAlmacenes) {          
        Map<Integer, String> menuEP = new TreeMap<>();
        int numeroOpcion = 0;
        for (String prop : listaAlmacenes.keySet()) {
            menuEP.put(numeroOpcion, prop);
            numeroOpcion = numeroOpcion + 1;
        }
        int salida = seleccionMenu(menuEP);
        return listaAlmacenes.get(menuEP.get(salida));
    }
    
    public int menuElegirRutaPlantilla(List<Integer> listaRutaPlantilla) {          
        mostrar("Escoge una plantilla para generar la ruta diaria");
        listaRutaPlantilla.forEach(this::mostrar);
        int idRutaPlantilla = Integer.parseInt(in.nextLine());
        return idRutaPlantilla;
    }
    
    public String menuElegirFurgoneta(List<String> furgonetasAlmacen) {          
        mostrar("Escoge una furgoneta por su matrícula");
        furgonetasAlmacen.forEach(this::mostrar);
        String idFurgoneta = in.nextLine();
        return idFurgoneta;
    }

    LocalDate menuElegirRutaDiaria(List<LocalDate> rutasDiarias) {
        mostrar("Escoge un día para la ruta diaria");
        Map<Integer, String> menuEP = new TreeMap<>();
        int numeroOpcion = 0;
        for (LocalDate prop : rutasDiarias) {
            menuEP.put(numeroOpcion, prop.toString());
            numeroOpcion = numeroOpcion + 1;
        }
        int salida = seleccionMenu(menuEP);
        return rutasDiarias.get(salida);
    }

    public LocalTime crearLocalTime() {
        mostrar("Hora inicio: ");
        int horaInicio = Integer.parseInt(in.nextLine());
        mostrar("Minutos: ");
        int minutosInicio = Integer.parseInt(in.nextLine());
        return LocalTime.of(horaInicio, minutosInicio);
    }

    public LocalDate crearLocalDate() {
        mostrar("Día: ");
        int day = Integer.parseInt(in.nextLine());
        mostrar("Mes: ");
        int month = Integer.parseInt(in.nextLine());
        mostrar("Año: ");
        int year = Integer.parseInt(in.nextLine());
        return LocalDate.of(year, month, day);
    }
    
    public boolean chooseYesOrNo() {
        Map<Integer, String> menuSO = new TreeMap<>();
        menuSO.put(0, "No");
        menuSO.put(1, "Sí");
        int salida = seleccionMenu(menuSO);
        return salida != 0;
    }
    
    //Funciones de utilidades
    
    private int seleccionMenu(Map<Integer, String> menu) {
        boolean valido;
        int numero;
        String lectura;
        do {
            for (Map.Entry<Integer, String> fila : menu.entrySet()) {
                numero = fila.getKey();
                String texto = fila.getValue();
                this.mostrar(numero + " : " + texto);
            }
            this.mostrar("\nElige una opción: ");
            lectura = in.nextLine();  //lectura de teclado
            valido = comprobarOpcion(lectura, 0, menu.size() - 1);
        } while (!valido);
        return Integer.parseInt(lectura);
    }

    private boolean comprobarOpcion(String lectura, int min, int max) {
        boolean valido = true;
        int opcion;
        try {
            opcion = Integer.parseInt(lectura);
            if (opcion < min || opcion > max) {
                mostrar("el numero debe estar entre min y max");
                valido = false;
            }

        } catch (NumberFormatException e) {
            mostrar("debes introducir un numero");
            valido = false;
        }
        if (!valido) {
            mostrar("\n\n Seleccion erronea. Intentalo de nuevo.\n\n");
        }
        return valido;
    }

    public void mostrar(Object texto) {
        System.out.println(texto);
    }

}
