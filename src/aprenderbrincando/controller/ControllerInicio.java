package aprenderbrincando.controller;

import aprenderbrincando.Config;
import aprenderbrincando.views.Inicio;
import aprenderbrincando.views.View;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ControllerInicio extends ControllerView {

    public ControllerInicio() {
        if (view == null) {
            view = new Inicio(this);
        }
    }

    @Override
    public void show() {
        this.view.setVisible(true);
        Config.CURRENT_VIEW = this.view;
    }

    @Override
    public void hide() {
        this.view.setVisible(false);

    }

    @Override
    public void reset() {
        this.view = new Inicio(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "open_ranking":
                ControllerRanking cr = new ControllerRanking();
                cr.show();
                break;
            case "start_game":
                ControllerExecucao ce = new ControllerExecucao();
                ce.show();
                break;
            default:
                JOptionPane.showMessageDialog(view, e.getActionCommand());
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
