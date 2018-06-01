package modeloenviamelo;

import java.time.LocalTime;
import java.util.Objects;

public class ParadaEnRuta {

    private Parada parada;
    private LocalTime horaLlegada;
    private float pesoParada;
    
    ParadaEnRuta(Parada parada) {
        this.parada = parada;
    }
    
    void modificarHoraLlegada(LocalTime hora) {
        this.horaLlegada = hora;
    }
    
    Parada getParada() {
        return parada;
    }
    
    @Override
    public boolean equals(Object otra) {
        if (this == otra) return true;
        if (!(otra instanceof ParadaEnRuta)) return false;
        
        ParadaEnRuta p = (ParadaEnRuta) otra;
        return (p.horaLlegada.equals(horaLlegada) && p.pesoParada == pesoParada && p.parada.equals(parada));
    }
}
