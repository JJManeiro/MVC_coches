import javax.swing.*;

public class Dialog extends JDialog {
    /**
     * @param ContentPane es el cuadro donde se pondrán los avisos que llamen a la clase Dialog.
     * @param Tag es el texto que aparecerá en el Dialog.
     */
    private JPanel contentPane;
    private JLabel Tag;


    public Dialog() {
        /**
         * Hacen comandos para preparar el cuadro para salir en pantalla de forma funcional.
         */
        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    public static void main(String m) {
        /**
         * @param m es el constructo que usaremos para poner el texto en pantalla usando Tag.setText.
         * fuera de eso, acá hay más comandos que hagan que el texto salga por pantalla de forma funcional.
         */
        Dialog dialog = new Dialog();
        dialog.pack();
        dialog.Tag.setText(m);
        dialog.setBounds(200,100,500,100);
        dialog.setVisible(true);
    }
}
