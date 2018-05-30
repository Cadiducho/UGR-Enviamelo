package modeloenviamelo;

/**
 *
 * @author aanaya
 */
class Almacen {

    private final String distrito;
    private final String direccion;
    private final String telefono;
    private final String responsable;

    Almacen(String distrito, String direccion, String telefono, String responsable) {
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.responsable = responsable;
    }
    
    String obtenerDistrito() {
        return distrito;
    }
    
    String obtenerDireccion() {
        return direccion;
    }
}
