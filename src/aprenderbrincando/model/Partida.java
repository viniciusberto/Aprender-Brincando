package aprenderbrincando.model;

import java.util.ArrayList;

public class Partida {

    private int nivel;
    private int pontos;
    private int pontosNivel;
    private int tempoNivel;
    private int tempoLimite;
    private int jagadas;
    ArrayList<Estatisticas> estatisticas = null;

    public Partida() {
        this.nivel = 1;
        this.pontos = 0;
        this.pontosNivel = 0;
        this.tempoNivel = 0;
        this.tempoLimite = 120;
    }

    public int incrementNivel() {
        this.nivel++;
        return this.nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getTempoNivel() {
        return tempoNivel;
    }

    public void setTempoNivel(int tempoNivel) {
        this.tempoNivel = tempoNivel;
    }

    public int getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(int tempoLimite) {
        this.tempoLimite = tempoLimite;
    }

    public ArrayList<Estatisticas> getEstatisticas() {
        return estatisticas;
    }

    public void setEstatisticas() {
        this.estatisticas.add(new Estatisticas(nivel, pontosNivel, tempoNivel));
    }

}

class Estatisticas {

    private int pontos;
    private int nivel;
    private int tempo;

    public Estatisticas(int nivel, int pontos, int tempo) {
        this.pontos = pontos;
        this.nivel = nivel;
        this.tempo = tempo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

}
