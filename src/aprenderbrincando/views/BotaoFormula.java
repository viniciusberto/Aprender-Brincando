package aprenderbrincando.views;

import javax.swing.JButton;
import static aprenderbrincando.views.Manipuladores.*;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Vinicius
 */
public class BotaoFormula extends JButton {

    public BotaoFormula(String texto, String nome) {
        super(texto);
        setName(nome);
        setIcon(tratarImagen(getClass().getResource("../imagens/Botao-Hover.png").getPath(), escalaBotao(), Image.SCALE_SMOOTH));//tratarImagen(getClass().getResource("../imagens/Botao.png").getPath(), escalaBotao(), Image.SCALE_SMOOTH));
        setRolloverEnabled(true);
        setRolloverIcon(tratarImagen(getClass().getResource("../imagens/Botao-Hover.png").getPath(), escalaBotao(), Image.SCALE_SMOOTH));
        setPressedIcon(tratarImagen(getClass().getResource("../imagens/Botao-Clicked.png").getPath(), escalaBotao(), Image.SCALE_SMOOTH));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(null);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        Point pos = gerarPosicao();
        setBounds(pos.x, pos.y, escalaBotao().width, escalaBotao().height);
        
    }

}
