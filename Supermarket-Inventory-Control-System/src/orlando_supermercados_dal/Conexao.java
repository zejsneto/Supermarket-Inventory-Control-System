package orlando_supermercados_dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ZENETO
 */
public class Conexao {

    private static Conexao conn;
    private Connection driver;

    /** 
     * Construtor Conexao. Chama o método criaConexao.
     */
    public Conexao() throws SQLException {
        this.criaConexao();
    }

    public static Conexao getConexao() throws SQLException {
        if (conn == null) {
            conn = new Conexao();
        }
        return conn;
    }

    /**
     * Método criaConexao. Responsável por realizar a conexão com o banco de dados postgresql.
     */
    private void criaConexao() throws SQLException {
        /* 123 = campo de senha */
        this.driver = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
    }

    public Connection getDriver() {
        return driver;
    }
}
