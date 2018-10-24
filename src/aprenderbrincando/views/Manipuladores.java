package aprenderbrincando.views;

import static aprenderbrincando.Config.*;
import aprenderbrincando.controller.Partida;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Vinicius Berto
 */
public class Manipuladores {

    public static ImageIcon tratarImagen(String url, Dimension tamanho, int escala) {
        ImageIcon img = new ImageIcon(url);
        return new ImageIcon(img.getImage().getScaledInstance(tamanho.width, tamanho.height, escala));
    }

    public static void centralizar(JComponent perso, JComponent item) {
        if (item.getClass().toString().equals("class aprenderbrincando.view.BotaoTransparente")) {
            perso.setLayout(new FlowLayout(FlowLayout.CENTER));
            item.setPreferredSize(convertSize(21, 10));
        } else {
            JComponent personalizar;
            personalizar = perso;
            GridBagLayout layout = new GridBagLayout();
            GridBagConstraints constraints = new GridBagConstraints();
            personalizar.setLayout(layout);
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(item, constraints);
        }
    }

    public static Dimension escalaBotao() {
        Double c1 = 132.0;
        c1 = (double) c1 * TAM_TELA.width;
        c1 = (double) c1 / 1366;
        return new Dimension(round(c1.floatValue()), round(c1.floatValue()));
    }

    public static Point gerarPosicao() {
        Random ran = new Random();
        Point ponto;

        int linhas = TAM_CENTRO_EXE.width - (escalaBotao().width);
        int colunas = TAM_CENTRO_EXE.height - (escalaBotao().height);
        do {

            ponto = new Point(ran.nextInt(linhas), ran.nextInt(colunas));
        } while (!verificarNaMatriz(ponto));
        return ponto;
    }

    private static boolean verificarNaMatriz(Point ponto) {
        boolean resposta = true;
        for (int i = 0; i < escalaBotao().height; i++) {
            for (int j = 0; j < escalaBotao().width; j++) {
                if (MATRIZ[ponto.x + i][ponto.y + j]) {
                    resposta = false;
                }
            }
        }
        return resposta;
    }

    public static void reposicionarBotoes(List<BotaoFormula> lista, int tempo) {
        for (int i = 0; i < lista.size() - 1; i++) {
            aguardar(tempo);
            limparPosicaoMatriz(lista.get(i).getLocation());
            Point pos = gerarPosicao();
            lista.get(i).setLocation(pos);
            marcarPosicaoMatriz(pos);

        }

    }

    private static void limparPosicaoMatriz(Point ponto) {
        for (int i = 0; i < escalaBotao().height; i++) {
            for (int j = 0; j < escalaBotao().width; j++) {
                MATRIZ[ponto.x + i][ponto.y + j] = false;

            }
        }
    }

    private static void marcarPosicaoMatriz(Point ponto) {
        for (int i = 0; i < escalaBotao().height; i++) {
            for (int j = 0; j < escalaBotao().width; j++) {
                MATRIZ[ponto.x + i][ponto.y + j] = true;

            }
        }
    }

    public static List<BotaoFormula> gerarBotoes(Partida partida) {
        List<BotaoFormula> lBtn = new ArrayList<>();
        for (int i = 0; i < partida.getListaAtual().size(); i++) {
            BotaoFormula btn = new BotaoFormula(partida.getListaAtual().get(i).getBtnTexto(), partida.getListaAtual().get(i).getFormula());
            Point pos = gerarPosicao();
            btn.setBounds(pos.x, pos.y, escalaBotao().width, escalaBotao().height);
            marcarPosicaoMatriz(pos);
            lBtn.add(btn);

        }
        return lBtn;
    }

    private static void aguardar(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Manipuladores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
