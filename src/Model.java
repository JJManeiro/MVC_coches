import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observer;
import java.util.Observable;
public class Model extends Observable {
    public static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el ArrayList parking.
     * @param modelo del coche.
     * @param matricula identificador único.
     * @return el coche creado.
     */
    public Coche crearCoche(String modelo, String matricula, int velocidad){
        Coche aux = new Coche(modelo, matricula, velocidad);
        parking.add(aux);
        return aux;
    }


    /**
     * Busca coche segun matricula.
     * @param matricula a buscar
     * @return coche o un aviso si no existe.
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        if (aux == null){
            JOptionPane.showMessageDialog(null,"No hay ese coche.");
        }
        else {
            return aux;
        }
        return null;
    }
    public Integer acelerar(String matricula,Integer a){
        /**
         * @param matricula pide la matrícula del coche que comprobará si existe o no.
         * @param a será cuánta velocidad quieres acelerar al coche.
         * @param res es el resultado final de sumar la velocidad.
         * Tras coger el resultado, se avisará del cambio a la clase observer sobre el coche cambiado.
         * @return el coche con la velocidad nueva.
         */
        Integer res= getCoche(matricula).velocidad+a;
        getCoche(matricula).velocidad=res;
        setChanged();
        notifyObservers(getCoche(matricula));
        return null;
    }
    public Integer frenar(String matricula,Integer f){
        /**
         * @param matricula pide la matrícula del coche que comprobará si existe o no.
         * @param f será cuánta velocidad quieres acelerar al coche.
         * @param res es el resultado final de restar la velocidad.
         * Tras coger el resultado, se avisará del cambio a la clase observer sobre el coche cambiado.
         * @return el coche con la velocidad nueva.
         */
        Integer res = getCoche(matricula).velocidad-f;
        getCoche(matricula).velocidad = res;
        setChanged();
        notifyObservers(getCoche(matricula));
        return null;
    }
    public void todos(){
        /**
         * @param message saca por consola todos los coches del arraylist parking.
         * @return message modificado si la velocidad que hay en el coche es mayor o menor a 0.
         */
        String message = "";
        System.out.println("Estos son los coches que tenemos:");
        for (Coche c: parking){
            if (c.velocidad==0){
                message = "El coche "+c.modelo+" "+c.matricula+" esta quieto.";
            }
            else if (c.velocidad<0){
                message = "El coche "+c.modelo+" "+c.matricula+" esta yendo "+(-c.velocidad)+" km/h hacia atrás.";
            }
            else {
                message = "El coche "+c.modelo+" "+c.matricula+" va a "+c.velocidad+" km/h.";
            }
            System.out.println(message);
        }
    }
}
