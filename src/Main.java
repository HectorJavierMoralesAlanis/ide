import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String prueba = "switch \" stringAux \" ( aux >= 10 ) { }";
        //Gramatica.Validacion(prueba);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JTextArea campoTexto = new JTextArea("switch \" stringAux \" ( aux >= 10 ) { }",50,20);
        JTextArea terminal = new JTextArea(50,50);
        //campoTexto.setSize(400,400);
        terminal.setBackground(Color.BLACK);
        terminal.setForeground(Color.WHITE);
        frame.setSize(400,400);
        //boton.setSize(200,200);
        JButton button = new JButton("Ejecutar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UM puco em mim");
                System.out.println(campoTexto.getText());
                //terminal.setText(campoTexto.getText());
                String[][] compilado = Gramatica.Validacion(campoTexto.getText());
                String[] codigo = new String[compilado.length];
                String[] tipo = new String[compilado.length];
                //String tipovar = " ";
                for(int i = 0; i<compilado.length;i++){
                    codigo[i] = compilado[i][0];
                    tipo[i] = compilado[i][1];
                    //System.out.println(compilado[i][1]);
                    //tipovar = tipovar + " " +compilado[i][1];
                }
                System.out.println(Arrays.toString(tipo));
                terminal.setText(Arrays.toString(codigo) +"\n" + Arrays.toString(tipo));
            }
        });
        //System.out.println(button);
        panel.add(campoTexto);
        panel.add(button);
        panel.add(label);
        panel.add(terminal);
        frame.getContentPane().add(panel);

        frame.setVisible(true);

    }
}
//ANTLER