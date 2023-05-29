import javax.swing.*;
public class View  {

    public void IU (){
        /**
         * Se llama al método crear en la clase IU.
         */
        IU.crear();
    }
    public void creado(){
        /**
         * Lanzará un mensaje que dirá que el coche se hizo.
         */
        JOptionPane.showMessageDialog(null,"Coche creado!");
    }
    public static void noHay(){
        /**
         * Lanza un mensaje que dice si hay o no hay ese coche.
         */
        JOptionPane.showMessageDialog(null,"No hay ese coche.");
    }
    public static String pedir(String mensaje){
        /**
         * @param P será el cajón de sastre donde pondremos las variables a pedir en pantalla.
         * @return el input puesto en la string P.
         */
        String P = JOptionPane.showInputDialog(null,mensaje);
        return P;
    }
   public static String mostrarCoche(String modelo,String matricula,int Velocidad){
       /**
        * @param mensaje será mostrado por pantalla, este variará por 4 condicionales.
        * Dependiendo de la velocidad actual del coche.
        * Saca por pantalla los datos del nuevo coche creado y del coche que de la busqueda filtrada.
        * Este proceso se hace a través de la clase dialog. Instanciado en el
        * @param D que llamará al proceso main, mostrando el mensaje por pantalla.
        * @return mensaje, que es llamado por la pantalla usando D.main
        */
       String mensaje = "";
        if (Velocidad==0){
           mensaje = "El coche "+modelo+" con la matricula "+matricula+" está quieto.";
       }
       else if (Velocidad<0){
           mensaje = "El coche "+modelo+" "+matricula+ " está yendo "+(-Velocidad)+" km/h hacia atrás.";
       }
       else if (Velocidad>120){
           mensaje = "El coche"+modelo+" "+matricula+" esta yendo demasiado rápido!"+"("+Velocidad+" km/h.)";
        }
       else {
           mensaje = "El coche "+modelo+" "+matricula+" va a "+Velocidad+" km/h.";
       }
       Dialog D = new Dialog();
       D.main(mensaje);
       return null;
   }

   public static String aviso(String m){
       /**
        * @param m es el constructo donde se pondrán los mensajes que vengan de View.
        * Dependiendo de la velocidad del coche el mensaje varía.
        * Saca por la pantalla el mensaje mandado por el Oteador.
        * Este proceso se hace a través de la clase dialog. Instanciado en el
        * @param D que llamará al proceso main, mostrando el mensaje por pantalla.
        * @return m , que es llamado por la pantalla usando D.main
        */
       Dialog D = new Dialog();
        D.main(m);
        return null;
   }
}