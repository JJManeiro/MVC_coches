import javax.swing.*;
public class View  {

    public void IU (){
        /**
         * Se llama al método crear en la clase IU.
         */
        IU.crear();
    }
   public static String mostrarCoche(String modelo,String matricula,int Velocidad){
       /**
        * @param mensaje será mostrado por pantalla, este variará por 3 condicionales.
        * Dependiendo de la velocidad actual del coche.
        * Saca por pantalla los datos del nuevo coche creado y del coche que de la busqueda filtrada.
        * @return mensaje
        */
       String mensaje = "";
        if (Velocidad==0){
           mensaje = "El coche "+modelo+" con la matricula "+matricula+" está quieto.";
       }
       else if (Velocidad<0){
           mensaje = "El coche "+modelo+" "+matricula+ " está yendo "+(-Velocidad)+" km/h hacia atrás.";
       }
       else {
           mensaje = "El coche "+modelo+" "+matricula+" va a "+Velocidad+" km/h.";
       }
       JOptionPane.showMessageDialog(null,mensaje);
       return null;
   }
}