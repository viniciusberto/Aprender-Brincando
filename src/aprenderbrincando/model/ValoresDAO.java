package aprenderbrincando.model;

import aprenderbrincando.Conexao;
import static aprenderbrincando.Config.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class ValoresDAO {

    

    public List<ValoresVO> listagem() {
        
        List<ValoresVO> lista = new ArrayList<>();
        Connection conn = new Conexao().getConnection();

        Statement stmt;
        try {
            stmt = conn.createStatement();

            String sql = "SELECT * FROM valores";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ValoresVO valores = new ValoresVO();
                valores.setId(rs.getInt("id"));
                valores.setFormula(rs.getString("formula"));
                valores.setNome(rs.getString("nome"));
                valores.setBtnTexto(textoBotao(rs.getString("formula")));
                lista.add(valores);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    private String textoBotao(String string) {
        String formula = string;
        for (int i = 10; i > 1; i--) {
            formula = formula.replace("" + i, "<sub>" + i + "</sub>");
        }
        formula = "<html>"
                + "<style>"
                + "font{"
                + "font-weight:bold;"
                + "font-size:" + TAM_FONTE_BTN_FORMULA + "pt;"
                + "font-family:'Roboto CN','Calibri','Sans Serif';"
                + "text-shadow: 2px 2px 1px BLACK;"
                + "color:rgb(255,228,23);"
                + "}"
                + "</style>"
                + "<font>" + formula + "</font></html>";

        return formula;
    }

}
