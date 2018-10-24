package aprenderbrincando;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static aprenderbrincando.Config.*;

/**
 *
 * @author Vinicius
 */
public class Conexao {

    private final Connection connection = null;
   
    public Connection getConnection() {
        Connection conn = null;
        try {
            String url = BANCO_DE_DADOS;
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println("Falha na conexão com banco de dados!\nErro: " + e.getMessage());
        }
        return conn;
    }

}
