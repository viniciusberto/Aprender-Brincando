package aprenderbrincando.controller;

import aprenderbrincando.model.ValoresDAO;
import aprenderbrincando.views.BotaoFormula;
import aprenderbrincando.views.Execucao;
import aprenderbrincando.views.Manipuladores;
import aprenderbrincando.views.ThreadExecucao;
import aprenderbrincando.views.View;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class ControllerExecucao extends ControllerView {

    private static Execucao telaExecucao = null;
    private Partida partida;
    private List<BotaoFormula> listaBtn;

    public ControllerExecucao() {
        ValoresDAO valores = new ValoresDAO();
        partida = new Partida();
        partida.gerarAtualizarListaAtual(valores.listagem());
        listaBtn = Manipuladores.gerarBotoes(partida);

        Thread threExecucao = new ThreadExecucao(listaBtn);
        threExecucao.start();

        if (this.view == null) {
            this.view = new Execucao(partida, listaBtn, this);
        }
    }

    @Override
    public void show() {
        this.view.setVisible(true);
    }

    @Override
    public void hide() {
        this.view.setVisible(false);
    }

    @Override
    public void reset() {
        ArrayList<BotaoFormula> btn = new ArrayList<>();
        btn.add(new BotaoFormula("Texto", "nome"));

        this.view = new Execucao(new Partida(), btn, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "":
                break;
            default:
                break;
        }
    }

    @Override
    public View setView(View view) {
        this.view = view;
        return this.view;
    }

    @Override
    public View getView() {
        return this.view;
    }

}
