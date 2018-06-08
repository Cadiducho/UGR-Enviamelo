package modeloenviamelo;

public class Almacen {

    private final Integer distrito;
    private final String direccion;
    private final String telefono;
    private final String responsable;

    Almacen(String distrito, String direccion, String telefono, String responsable) {
        this.distrito = Integer.parseInt(distrito);
        this.direccion = direccion;
        this.telefono = telefono;
        this.responsable = responsable;
    }
    
    Integer obtenerDistrito() {
        return distrito;
    }
    
    String obtenerDireccion() {
        return direccion;
    }
    
    @Override
    public boolean equals(Object otra) {
        if (this == otra) return true;
        if (!(otra instanceof Almacen)) return false;
        
        Almacen a = (Almacen) otra;
        return (a.distrito.equals(distrito) && a.direccion.equals(direccion) && a.telefono.equals(telefono) && a.responsable.equals(responsable));
    }
}
