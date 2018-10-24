package aprenderbrincando.views;

import static aprenderbrincando.Config.*;
import aprenderbrincando.controller.Partida;
import static aprenderbrincando.views.Manipuladores.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Vinicius Berto
 */
public class Execucao extends View {

    private ActionListener al;
    private Partida partida;

    private PnlTopoExecucao topo;
    private PnlMeioExecucao meio;
    private PnlRodapeExecucao rodape;

    public Execucao(Partida partida, List<BotaoFormula> listaBotoes, ActionListener al) {
        this.al = al;
        draw();
        changeBackground(tratarImagen(getClass().getResource("../imagens/Fundo-Meio-Execucao.png").getPath(), getSize(), Image.SCALE_SMOOTH));;
        this.partida = partida;

        topo = new PnlTopoExecucao();
        meio = new PnlMeioExecucao();
        rodape = new PnlRodapeExecucao();

        for (int i = 0; i < listaBotoes.size(); i++) {
            meio.add(listaBotoes.get(i));
        }
        setLayout(new BorderLayout());

        add(topo, BorderLayout.NORTH);
        add(meio, BorderLayout.CENTER);
    }

    @Override
    protected void draw() {
        super.draw();

    }

}

class PnlTopoExecucao extends JPanel {

    private JPanel pnlEsquerdaTopo;
    private JPanel pnlCentroTopo;
    private JPanel pnlDireitaTopo;

    private JLabel lblFormula;
    private JLabel lblPontos;
    private JLabel lblNivel;
    private JLabel lblHora;

    public PnlTopoExecucao() {
        JLabel fundo = new JLabel(tratarImagen(getClass().getResource("../imagens/Fundo-Topo-Execucao.png").getPath(), TAM_SUL_EXE, Image.SCALE_SMOOTH));
        setBorder(BorderFactory.createMatteBorder(3, 3, 0, 3, Color.BLACK));
        setBackground(Color.WHITE);
        setPreferredSize(convertSize(100, 3));
        setLayout(new BorderLayout());

        pnlEsquerdaTopo = new JPanel();
        pnlEsquerdaTopo.setPreferredSize(convertSize(20, 3));
        pnlEsquerdaTopo.setOpaque(false);
        lblNivel = new JLabel("Nível");

        lblNivel.setFont(FONTE_ROBOTO);

        pnlEsquerdaTopo.add(lblNivel);

        pnlCentroTopo = new JPanel();
        lblFormula = new JLabel("Fórmula Atual");
        pnlCentroTopo.add(lblFormula);
        pnlCentroTopo.setOpaque(false);

        pnlDireitaTopo = new JPanel();
        pnlDireitaTopo.setPreferredSize(convertSize(20, 3));
        pnlDireitaTopo.setOpaque(false);
        lblPontos = new JLabel("Pontos");
        pnlDireitaTopo.add(lblPontos);

        add(fundo, BorderLayout.CENTER);

        fundo.setLayout(new BorderLayout());
        fundo.add(pnlEsquerdaTopo, BorderLayout.WEST);
        fundo.add(pnlDireitaTopo, BorderLayout.EAST);
        fundo.add(pnlCentroTopo, BorderLayout.CENTER);
    }

}

class PnlMeioExecucao extends JPanel {

    public PnlMeioExecucao() {
        setBackground(Color.RED);
        setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.BLACK));
        setLayout(null);
        setOpaque(false);
    }
}

class PnlRodapeExecucao extends JPanel {

    public PnlRodapeExecucao() {
        setBackground(Color.yellow);
        setPreferredSize(convertSize(100, 3));
        setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3, Color.BLACK));
    }

}
