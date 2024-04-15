import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String prueba = "switch \" stringAux \" ( aux >= 10 ) { }";
        //Gramatica.Validacion(prueba);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JTextArea campoTexto =new JTextArea("switch \" stringAux \" ( aux >= 10 ) { }",100,100);
        campoTexto.setSize(400,400);
        //campoTexto.setBackground(Color.BLUE);
        frame.setSize(400,400);
        //boton.setSize(200,200);
        JButton button = new JButton("Ejecutar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UM puco em mim");
                System.out.println(campoTexto.getText());
                label.setText(campoTexto.getText());
                Gramatica.Validacion(prueba);
            }
        });
        //System.out.println(button);
        panel.add(campoTexto);
        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel);

        frame.setVisible(true);

    }
}
//ANTLER