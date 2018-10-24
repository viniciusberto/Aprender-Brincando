package aprenderbrincando.controller;

/**
 *
 * @author Vinicius Berto
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Vinicius
 */
public class TratadorAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        JButton btn = (JButton) ae.getSource();
//        switch (btn.getName()) {
//            case "Iniciar":
//                new ControllerExecucao().mostar();
//                new ControllerInicio().ocultar();
//                break;
//            case "Ranking":
//                System.out.println("Teste de funcionamento Ranking");
//                break;
//            case "Creditos":
//                System.out.println("Teste de funcionamento Creditos");
//                break;
//            default:
//                JButton botao = (JButton) ae.getSource();
//
//                //validarResposta(botao.getName(), Partida.getFormulaAtual().getFormula());
//                break;
//
//        }
//    }

}
