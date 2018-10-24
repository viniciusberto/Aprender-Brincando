package aprenderbrincando;

/**
 *
 * @author Vinicius Berto
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.round;
import javax.swing.JFrame;

public class Config {

    /*Camada View*/
    private static final Toolkit TOO = Toolkit.getDefaultToolkit();

    public static JFrame CURRENT_VIEW = null;
    /**
     * Variável Dimension Armazena o atual tamanho da tela.
     */
    public static Dimension TAM_TELA = TOO.getScreenSize();

    //Tela de Execucao
    /**
     * Variável Dimension Armazena o tamanho do panel norte e sul da tela de
     * execução.
     */
    public static Dimension TAM_NORTE_EXE, TAM_SUL_EXE;

    /**
     * Variável Dimension Armazena o tamanho do panel centro da tela de
     * execução.
     */
    public static Dimension TAM_CENTRO_EXE;

    /**
     * Variável boolean[][] Armazena o status de cada pixel do panel centro da
     * tela de execução.
     */
    public static boolean[][] MATRIZ;
    public static int TAM_FONTE_BTN_FORMULA;
    public static float TAM_FONTE_LBL_EXECUCAO;
    public static Font FONTE_ROBOTO;
    /*Camada Model*/
    /**
     * Variável String Armazena a localização do banco de dados.
     */
    public static String BANCO_DE_DADOS;

    /*Camada Controller*/
    public static int PONTOS_ACERTO;
    public static int PONTOS_ERRO;

    public Config() {

        /*Camada View*/
        carregarFontes();
        TAM_NORTE_EXE = TAM_SUL_EXE = new Dimension(convertSize(100f, 7f));
        TAM_CENTRO_EXE = new Dimension(convertSize(100f, 93f));
        inicializarMATRIZ();
        setTAM_FONTE_BTN_FORMULA();
        setTAM_FONTE_LBL_EXECUCAO();

        /*Camada Controller*/
        PONTOS_ACERTO = 10;
        PONTOS_ERRO = 5;

        /*Camada Model*/
        BANCO_DE_DADOS = "jdbc:sqlite:" + getClass().getResource("database/Banco.db").getPath();

    }

    /**
     *
     * convertSize converte porcentagem em valores inteiros referentes ao
     * tamanho da tela.
     *
     * @param valor1 porcentagem da largura da tela;
     * @param valor2 porcentagem da altura da tela;
     * @return
     */
    public static Dimension convertSize(float valor1, float valor2) {
        Double c1, c2;

        c1 = (double) valor1 / 100;
        c1 = (double) c1 * TAM_TELA.width;

        c2 = (double) valor2 / 100;
        c2 = (double) c2 * TAM_TELA.height;

        return new Dimension(round(c1.floatValue()), round(c2.floatValue()));
    }

    public static void setTAM_FONTE_BTN_FORMULA() {
        Double c1;
        c1 = (double) 26 * TAM_TELA.width;
        c1 = (double) c1 / 1366;
        TAM_FONTE_BTN_FORMULA = round(c1.floatValue());
    }

    public static void setTAM_FONTE_LBL_EXECUCAO() {
        Double c1;
        c1 = (double) 18 * TAM_TELA.width;
        c1 = (double) c1 / 1366;
        TAM_FONTE_LBL_EXECUCAO = c1.floatValue();
    }

    /**
     * inicializarMATRIZ popula a matriz com valores false.
     */
    private void inicializarMATRIZ() {
        MATRIZ = new boolean[TAM_CENTRO_EXE.width][TAM_CENTRO_EXE.height];
        for (int i = 0; i < TAM_CENTRO_EXE.width; i++) {
            for (int j = 0; j < TAM_CENTRO_EXE.height; j++) {
                MATRIZ[i][j] = false;
            }
        }

    }

    private void carregarFontes() {
        try {
            Font myFont = new Font("Arial", Font.ITALIC | Font.BOLD, 12);
            FONTE_ROBOTO = myFont.deriveFont(Font.BOLD, 50.0f);
//            FONTE_ROBOTO = Font.createFont(Font.BOLD, this.getClass().getResourceAsStream("./fonts/RobotoC.ttf"));
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.BOLD, new File(getClass().getResource("./fonts/RobotoC.ttf").getPath())));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
