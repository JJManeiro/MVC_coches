import javax.swing.*;
import java.awt.*;
import java.util.Collections;

/**
 * @author damiancastelao,JJManeiro
 * @version 1.2
 * Se ha añadido una opción de búsqueda filtrada, junto con una interfaz con botones para acelerar y frenar.
 */
public class Controller {
    //Llamamos a las clases que controlamos como objetos estáticos.
    static Model miModelo;
    static Oteador miObserver;
    static  View miVista;
    public static void main(String[] args) {
        //Instanciamos las clases-objeto y añadimos el observer al modelo en caso de acelerar o frenar la velocidad.
        miModelo = new Model();
        miObserver = new Oteador();
        miModelo.addObserver(miObserver);
        miVista = new View();
        miVista.IU();
    }
    public void construir(String modelo,String matricula,int velocidad) {
        /**
         * Llamamos al metodo crearCoche en modelo y lo incorporamos como un objeto tipo coche.
         * @param aux es el objeto coche, si este no es nulo. Se mostrará el nuevo coche creado.
         * @return modelo matricula y velocidad de aux.
         */
        Coche aux = miModelo.crearCoche(modelo, matricula, velocidad);
        if (aux != null) {
        miVista.creado();
        miVista.mostrarCoche(aux.modelo, aux.matricula, aux.velocidad);
        }
    }
    public void acelerar(){
        /**
         * @param m es el input donde se pondrá la matrícula.
         * @param v es el input que dirá cuanta velocidad ganó.
         * Estos serán usados para llamar al método acelerar en modelo.
         */
        String m = miVista.pedir("dime la matricula");
        int v = Integer.parseInt(miVista.pedir("Cuanto aceleró?"));
        miModelo.acelerar(m,v);
    }
    public void frenar(){
        /**
         * @param m es el input donde se pondrá la matrícula.
         * @param v es el input que dirá cuanta velocidad ganó.
         * Estos serán usados para llamar al método frenar en modelo.
         */
        String m = miVista.pedir("dime la matricula");
        int v = Integer.parseInt(miVista.pedir("Cuanto frenó?"));
        miModelo.frenar(m,v);
    }
    public void filtro(){
        /**
         * @param m es el input donde se pondrá la matrícula.
         * @param aux es el objeto coche que instanciará al método getCoche en modelo. Tras eso,
         * Llamaremos al modelo,matricula y velocidad del coche con el metodo en vista que los saca por pantalla.
         * @return modelo matricula y velocidad de aux.
         */
        String m = miVista.pedir("dime la matricula");
        Coche aux = miModelo.getCoche(m);
        miVista.mostrarCoche(aux.modelo, aux.matricula, aux.velocidad);
    }
    public void todos(){
        /**
         * llama al metodo todos en modelo, este saca por pantalla todos los coches del concesionario.
         * @return todos los coches del arraylist parking.
         */
    miModelo.todos();
    }
}