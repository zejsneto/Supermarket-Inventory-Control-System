package orlando_supermercados_dal;

import orlando_supermercados_model.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ZENETO
 */
public class LoginDAO implements IDAO<Login> {

    private Conexao conn;

    /**
     * Construtor LoginDAO. Realiza a conexão.
     */
    public LoginDAO() throws Exception {
        this.conn = Conexao.getConexao();
    }

    /**
     * Método verificaAdm. Usado para verificar se o usuário logado é do tipo
     * 'Administrador'.
     */
    @Override
    public boolean verificaAdm(Login l) throws SQLException {
        String sql = "SELECT count(0) FROM usuarios WHERE usuario = ? and senha = ? and tipo = 'Administrador' and status = true ";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);

        ps.setString(1, l.getUsuario());
        ps.setString(2, l.getSenha());

        ps.execute();
        ResultSet rs = ps.getResultSet();

        return rs.next() && rs.getInt(1) > 0;

    }

    /**
     * Método verificaFunc. Usado para verificar se o usuário logado é do tipo
     * 'Funcionário'.
     */
    @Override
    public boolean verificaFunc(Login l) throws SQLException {
        String sql = "SELECT count(0) FROM usuarios WHERE usuario = ? and senha = ? and tipo = 'Funcionário' and status = true";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);

        ps.setString(1, l.getUsuario());
        ps.setString(2, l.getSenha());

        ps.execute();
        ResultSet rs = ps.getResultSet();

        return rs.next() && rs.getInt(1) > 0;
    }

    @Override
    public ArrayList<Login> consulta() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Login consulta(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insere(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean atualiza(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean reativar(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desativar(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean apaga(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Login> consultaSemData(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Login> consultaComData(Login o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
