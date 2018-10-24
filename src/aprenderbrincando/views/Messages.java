package aprenderbrincando.views;

/**
 *
 * @author Vinicius Berto
 */
import static aprenderbrincando.Config.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Messages extends JOptionPane {

    public static View frmAlerta;

    public static JLabel lblCoordenadas = new JLabel("Coordenadas");

    public static void acerto(View cpmt) {
        JOptionPane.showMessageDialog(cpmt,
                "Você acertou!.",
                "Parabéns",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erro(View cpmt) {
        JOptionPane.showMessageDialog(cpmt,
                "Você errou!.",
                "Que pena",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void excessao(View cpmt, String titulo, String msg) {
        JOptionPane.showMessageDialog(cpmt,
                msg,
                titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void finalizar() {//Telas cpmt, String titulo, String msg){
//        frmAlerta = new View();
//        JPanel pnlAlert = new PnlAlerta();
//        frmAlerta.setSize(TAM_TELA);
//        frmAlerta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        frmAlerta.setLayout(new BorderLayout());
//        frmAlerta.setAlwaysOnTop(true);
//        frmAlerta.setUndecorated(true);
//        frmAlerta.setBackground(Color.RED);
//        frmAlerta.setOpacity(0.8f);
//        frmAlerta.add(lblCoordenadas);
//        frmAlerta.setVisible(true);        
//        frmAlerta.add(pnlAlert,BorderLayout.CENTER);
//        frmAlerta.addWindowFocusListener(new WindowAdapter() {
//            @Override
//            public void windowLostFocus(WindowEvent we) {
//                super.windowLostFocus(we);
//                if (Messages.frmAlerta != null) {
//                    we.getWindow().setFocusableWindowState(true);
//                    frmAlerta.setAlwaysOnTop(Boolean.TRUE);
//                    frmAlerta.requestFocus();
//                }
//            }
//
//            @Override
//            public void windowClosed(WindowEvent we) {
//                System.out.println("Fechou");
//                frmAlerta = null;
//            }
//
//        });
//        frmAlerta.repaint();

    }

    static class PnlAlerta extends JPanel {

        public PnlAlerta() {
            JPanel pnCentro = new JPanel();
            Manipuladores.centralizar(this, pnCentro);
            pnCentro.setSize(convertSize(50,65));
            add(pnCentro);
        }
        

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);
            grphcs.setColor(Color.black);
            grphcs.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        }

    }

}
