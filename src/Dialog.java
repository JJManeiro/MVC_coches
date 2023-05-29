import javax.swing.*;

public class Dialog extends JDialog {
    private JPanel contentPane;
    private JLabel Tag;


    public Dialog() {
        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    public static void main(String m) {
        Dialog dialog = new Dialog();
        dialog.pack();
        dialog.Tag.setText(m);
        dialog.setBounds(200,100,500,100);
        dialog.setVisible(true);
    }
}
