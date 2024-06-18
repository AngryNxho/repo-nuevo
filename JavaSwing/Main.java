import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Main {
    public static void main(String args[]) {
        JFrame ventana = new JFrame();

        ventana.setSize(400, 300);

        ventana.setTitle("Primera ventana con java");

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton boton = new JButton("Click aqui");

        JPanel panel = new JPanel();

        panel.add(boton);

        ventana.getContentPane().add(panel);

        ventana.setVisible(true);
    }
}