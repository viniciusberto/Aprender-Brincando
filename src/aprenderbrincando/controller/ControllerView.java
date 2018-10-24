package aprenderbrincando.controller;

import aprenderbrincando.views.View;
import java.awt.event.ActionListener;

/**
 *
 * @author Vinicius Berto
 *
 */
public abstract class ControllerView implements ActionListener {

    protected View view;

    public abstract void show();

    public abstract void hide();

    public abstract void reset();

    public abstract View setView(View view);

    public abstract View getView();
}
