package aprenderbrincando.views;

import static aprenderbrincando.views.Manipuladores.reposicionarBotoes;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class ThreadExecucao extends Thread{
    List<BotaoFormula> lista;

    public ThreadExecucao(List<BotaoFormula> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        while(true){
            reposicionarBotoes(lista, 500);
        }
        
    }
    
    
}