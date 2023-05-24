public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;

    /**
     * Constructor.
     * @param modelo
     * @param matricula
     * @param velocidad
     */
    public Coche(String modelo, String matricula, int velocidad) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = velocidad;
    }
}
