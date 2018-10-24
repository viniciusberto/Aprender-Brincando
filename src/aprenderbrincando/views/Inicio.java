package aprenderbrincando.views;

import static aprenderbrincando.views.Manipuladores.*;
import static aprenderbrincando.Config.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vinicius Berto
 */
public final class Inicio extends View {

    public Inicio(ActionListener al) {
        this.al = al;
        draw();
    }

    @Override
    public void draw() {
        super.draw();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gdLayout = new GridLayout(4, 3);
        gdLayout.setVgap(30);
        gdLayout.setHgap(30);
        setLayout(new BorderLayout());

        setTitle("Quimicamente");
        changeBackground(tratarImagen(getClass().getResource("../imagens/Fundo-Inicio.jpg").getPath(), TAM_TELA, Image.SCALE_SMOOTH));

        JPanel pnlTop = new JPanel();
        pnlTop.setOpaque(false);

        JPanel pnlContainer = new JPanel(gdLayout);
        pnlContainer.setOpaque(false);

        JPanel pnlButtons = new JPanel(null);
        pnlButtons.setOpaque(false);

        JPanel pnlClear = new JPanel();
        pnlClear.setOpaque(false);

        JPanel pnlClear2 = new JPanel();
        pnlClear2.setOpaque(false);

        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 7));

        BotaoTransparente btnStart = new BotaoTransparente("start");
        btnStart.addActionListener(this.al);
        btnStart.setActionCommand("start_game");
        btnStart.setIcon(tratarImagen(getClass().getResource("../imagens/start_button.png").getPath(), btnStart.getSize(), Image.SCALE_SMOOTH));

        BotaoTransparente btnRanking = new BotaoTransparente("ranking");
        btnRanking.setActionCommand("open_ranking");
        btnRanking.addActionListener(this.al);
        btnRanking.setIcon(tratarImagen(getClass().getResource("../imagens/ranking_button.png").getPath(), btnRanking.getSize(), Image.SCALE_SMOOTH));

        pnlButtons.add(btnStart);
        pnlButtons.add(btnRanking);

        add(pnlTop, BorderLayout.NORTH);
        add(pnlContainer, BorderLayout.CENTER);
        pnlContainer.add(pnlClear);
        pnlContainer.add(pnlClear2);
        pnlContainer.add(pnlButtons);
    }
}
