package modeloenviamelo;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

class Parada {
    
    private final LocalTime horaPrevistaLlegada;
    private final Almacen almacen;

    Parada(LocalTime horaPrevistaLlegada, Almacen almacen) {
        this.horaPrevistaLlegada = horaPrevistaLlegada;
        this.almacen = almacen;
    }
    
    int obtenerDistrito() {
        return almacen.obtenerDistrito();
    }
    
    Almacen obtenerAlmacen() {
        return almacen;
    }
    
    List<String> obtenerDatos() {
        return Arrays.asList(horaPrevistaLlegada.toString(), Integer.toString(obtenerDistrito()), obtenerAlmacen().obtenerDireccion());
    }
    
    @Override
    public boolean equals(Object otra) {
        if (this == otra) return true;
        if (!(otra instanceof Parada)) return false;
        
        Parada p = (Parada) otra;
        return (p.horaPrevistaLlegada.equals(horaPrevistaLlegada) && p.almacen.equals(almacen));
    }
}
