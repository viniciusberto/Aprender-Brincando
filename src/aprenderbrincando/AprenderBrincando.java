package aprenderbrincando;

import aprenderbrincando.controller.ControllerInicio;

/**
 *
 * @author Vinicius Berto
 */
public class AprenderBrincando {

    private final Config config = new Config();
    private final ControllerInicio telaInicial;

    public static void main(String[] args) {
        new AprenderBrincando();
    }

    public AprenderBrincando() {
        telaInicial = new ControllerInicio();
        telaInicial.show();
    }

}
