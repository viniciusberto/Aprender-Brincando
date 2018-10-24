package aprenderbrincando.views;

import javax.swing.JButton;
import static aprenderbrincando.Config.*;
import java.awt.Cursor;
import java.awt.Dimension;

/**
 *
 * @author Vinicius Berto
 */
public class BotaoTransparente extends JButton {
    
    public BotaoTransparente(String string) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setActionCommand(string);
        setContentAreaFilled(false);
        setFocusPainted(false);
        Dimension tam = convertSize(21, 10);
        //setBounds(0, 0, tam.width, tam.height);
        setSize(tam.width, tam.height);
    }
    
}
