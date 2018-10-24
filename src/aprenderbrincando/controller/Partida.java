package aprenderbrincando.controller;

import aprenderbrincando.model.ValoresVO;
import aprenderbrincando.views.BotaoFormula;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Vinicius Berto
 */
public class Partida {

    private int nivel;
    private int pontuacao;
    private int qtdAcertos;
    private int tempo;
    private int maiorPontuacao;
    private ValoresVO formulaAtual;
    private List<ValoresVO> listaAtual;

    public Partida() {
        this.nivel = 1;
        this.pontuacao = 10;
        this.qtdAcertos = 0;
        this.tempo = 500;
        this.maiorPontuacao = 0;
    }

    public void alterarFormulaAtual(ValoresVO formulaAtual) {
        Random ran = new Random();
        this.formulaAtual = listaAtual.get(ran.nextInt(listaAtual.size() - 1));
    }
    
    public List<BotaoFormula> criarBotoes() {
        List<BotaoFormula> btnLista = new ArrayList<>();
        for (int i = 0; i < listaAtual.size(); i++) {
            BotaoFormula botao = new BotaoFormula(listaAtual.get(i).getBtnTexto(), listaAtual.get(i).getFormula());
            btnLista.add(botao);
        }

        return btnLista;
    }
    
    public void gerarAtualizarListaAtual(List<ValoresVO> listaCompleta) {
        List<ValoresVO> lista = new ArrayList<>();
        listaAtual = new ArrayList<>();
        int qtd = 10;

        switch (nivel) {
            case 1:
                qtd = 10;
                break;
            case 2:
                qtd = 12;
                break;
            case 3:
                qtd = 14;
                break;
            case 4:
                qtd = 16;
                break;
        }

        Random ram = new Random();
        int valor;
        lista.clear();

        for (int i = 0; i < qtd; i++) {
            boolean teste = true;
            valor = ram.nextInt(listaCompleta.size());
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getNome().equals(listaCompleta.get(valor).getNome())) {
                    teste = false;
                }
            }
            if (teste) {
                lista.add(listaCompleta.get(valor));
            } else {
                i--;
            }
        }
        listaAtual = lista;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQtdAcertos() {
        return qtdAcertos;
    }

    public void setQtdAcertos(int qtdAcertos) {
        this.qtdAcertos = qtdAcertos;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getMaiorPontuacao() {
        return maiorPontuacao;
    }

    public void setMaiorPontuacao(int maiorPontuacao) {
        this.maiorPontuacao = maiorPontuacao;
    }

    public List<ValoresVO> getListaAtual() {
        return listaAtual;
    }

    public ValoresVO getFormulaAtual() {
        return formulaAtual;
    }
}