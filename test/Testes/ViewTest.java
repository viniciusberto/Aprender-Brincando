package Testes;

import aprenderbrincando.views.View;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewTest extends View {
    public static JButton btnTeste;

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(800,600);
        jframe.setVisible(true);
        jframe.setLayout(new BorderLayout());
        btnTeste = new JButton("Teste");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.add(btnTeste);
        btnTeste.setText("<html>x<sub>y</sub></html>");
    }
}