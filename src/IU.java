import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IU extends JFrame {
    /**
     * @param Panel Panel de interfaz.
     * @param modelo input para poner la marca del coche.
     * @param matricula input para poner la matricula.
     * @param velocidad input para decir a que velocidad se encuentra el coche ahora.
     * @param crearCoche Botón que llama a crearCoche en controller.
     * @param Acelerar Botón que llama a acelerar en controller.
     * @param Frenar Botón que llama a frenar en controller.
     * @param Filtro Botón que llama a filtar en controller.
     * @param Coches Botón que llama a todos en controller.
     * @param control llama a la clase controller.
     */
    private JPanel Panel;
    private JButton crearCoche;
    private JTextField matricula;
    private JTextField modelo;
    private JTextField velocidad;
    private JButton Acelerar;
    private JButton Frenar;
    private JButton Filtro;
    private JButton Coches;
    static Controller control;

    public IU() {
        /**
         * @param control instancia la clase controller.
         */
        control = new Controller();
        crearCoche.addActionListener(new ActionListener() {
            /**
             * @param e es el evento del botón.
             * Se llama al metodo construir en controller.
             * Si cualquiera de estos 3 parámetros(modelo,matricula o velocidad)es dejado en blanco,lanzará un aviso.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                control.construir(modelo.getText(),matricula.getText(),Integer.parseInt(velocidad.getText()));
                if (modelo.getText().equals("")||matricula.getText().equals("")||velocidad.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"No los dejes en blanco");
                }
            }
        });
        Acelerar.addActionListener(new ActionListener() {
            /**
             * @param e es el evento del botón.
             * Se llama al evento acelerar en controller.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            control.acelerar();
            }
        });
        Frenar.addActionListener(new ActionListener() {
            /**
             * @param e es el evento del botón.
             * Se llama al evento frenar en controller.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            control.frenar();
            }
        });
        Filtro.addActionListener(new ActionListener() {
            /**
             * @param e es el evento del botón.
             * Se llama al evento filtrar en controller.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            control.filtro();
            }
        });
        Coches.addActionListener(new ActionListener() {
            /**
             * @param e es el evento del botón.
             * Se llama al evento todos en controller.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            control.todos();
            }
        });
    }
    public static void crear(){
        /**
         * @param G instancia el frame, este llama a los parámetros que hacen que la interfaz se vea en pantalla.
         */
        JFrame G = new JFrame();
        G.setContentPane(new IU().Panel);
        G.setTitle("Panel facherito");
        G.setSize(800,600);
        G.setVisible(true);
        G.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
