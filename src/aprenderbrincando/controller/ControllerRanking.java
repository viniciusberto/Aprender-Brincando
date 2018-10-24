package aprenderbrincando.controller;

import aprenderbrincando.views.Ranking;
import aprenderbrincando.views.View;
import java.awt.event.ActionEvent;

public class ControllerRanking extends ControllerView {

    public ControllerRanking() {
        if (view == null) {
            view = new Ranking(this);
        }
    }

    @Override
    public void show() {
        view.setVisible(true);
    }

    @Override
    public void hide() {
        view.setVisible(false);
    }

    @Override
    public void reset() {
        view = new Ranking(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "fechar":
                this.hide();
                break;
            default:
                break;

        }
    }
}
