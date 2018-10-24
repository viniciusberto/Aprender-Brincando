package aprenderbrincando.views;

/**
 *
 * @author Vinicius Berto
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static aprenderbrincando.Config.*;
import java.awt.event.ActionListener;

public abstract class View extends JFrame {

    protected ActionListener al;

    private final JLabel background = new JLabel();

    protected void draw() {
        setUndecorated(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setSize(TAM_TELA);
        setLocationRelativeTo(null);
        setContentPane(background);
    }

    public void changeBackground(ImageIcon img) {
        background.setIcon(img);
    }

}
