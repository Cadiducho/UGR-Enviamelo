package modeloenviamelo;

import java.time.LocalTime;
import java.util.List;

public class Parada {
    
    private final LocalTime horaPrevistaLlegada;

    public Parada(LocalTime horaPrevistaLlegada) {
        this.horaPrevistaLlegada = horaPrevistaLlegada;
    }
    
    Parada crear(LocalTime horaPrevistaLlegada, Almacen almacen) {
        return null;
    }
    
    int obtenerDistrito() {
        return -1;
    }
    
    Almacen obtenerAlmacen() {
        return null;
    }
    
    List<String> obtenerDatos() {
        return null;
    }
}
