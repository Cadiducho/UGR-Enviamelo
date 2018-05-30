package modeloenviamelo;

/**
 *
 * @author aanaya
 */
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
    
    String[] obtenerDatos() {
        String[] datos = new String[2];
        datos[0] = matricula;
        datos[1] = Double.toString(pesoMaximo);
        return datos;
    }
}
