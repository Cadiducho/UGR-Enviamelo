package modeloenviamelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aanaya
 */
public class Enviamelo {
    private static Enviamelo instancia = new Enviamelo();
    public static Enviamelo getInstancia(){
        return instancia;
    }
    private Enviamelo(){    
        this.inicalizar();
    }
    
    private List<Almacen> almacenes =new ArrayList();
    private List<Furgoneta> furgonetas = new ArrayList();
    
    private void inicalizar() {
        Almacen a1 = new Almacen("18000","el florio, Granada","958345678","Antonio");
        Almacen a2 = new Almacen("29000","el potril, Málaga","952785678", "Maria");
        Almacen a3 =new Almacen("04000","el poniente, Almería","954087654", "Mario");
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
    // proporciona todos los numeros de ruta plantilla que estén activas 
    public int[] obtenerRutasActivas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int registrarInicioRuta(int numeroRuta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List registrarParadaCompletada(int numeroRuta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void registrarConclusionRuta(int numeroRuta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void crearRutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      
}
