package modeloenviamelo;

/**
 *
 * @author aanaya
 */
class Furgoneta {
    private String matricula;
    private double pesoMaximo;
    private boolean disponibilidad = true;
    private Almacen almacen;
   
    Furgoneta(String matricula, double pesoMaximo, Almacen almacen) {
        this.matricula = matricula;
        this.pesoMaximo =pesoMaximo;
        this.almacen = almacen;
    }
    
    
  
    
}
