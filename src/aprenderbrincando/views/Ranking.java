package aprenderbrincando.views;

import aprenderbrincando.Config;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class Ranking extends View {
    
    private final ActionListener al;
    JPanel panelTop = new JPanel();
    
    public Ranking(ActionListener al) {
        this.al = al;
        draw();
    }
    
    @Override
    public final void draw() {
        super.draw();
        
        this.setLayout(new BorderLayout(70, 60));
        
        panelTop.setLayout(new BorderLayout());
        
        panelTop.setBackground(Color.red);
        
        JButton btnFechar = new JButton();
        btnFechar.setText("X");
        btnFechar.setActionCommand("fechar");
        btnFechar.addActionListener(al);
        
        JPanel panelCentral = new JPanel();
        JLabel lblTitulo = new JLabel("Ranking");
        
        Font ft = Config.FONTE_ROBOTO;
        ft = ft.deriveFont(Font.PLAIN, 24);
        
        lblTitulo.setFont(ft);
        
        panelCentral.add(lblTitulo);
        
        panelCentral.setBackground(Color.red);
        GridBagLayout gb = new GridBagLayout();
        
        panelTop.add(btnFechar, BorderLayout.EAST);
        
        add(panelTop, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }
}
