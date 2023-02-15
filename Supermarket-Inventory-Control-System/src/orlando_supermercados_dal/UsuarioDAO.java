package orlando_supermercados_dal;

import orlando_supermercados_model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ZENETO
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private Conexao conn;

    /**
     * Construtor UsuarioDAO. Realiza a conexão.
     */
    public UsuarioDAO() throws Exception {
        this.conn = Conexao.getConexao();
    }

    /**
     * Método Consulta. Usado para listar a tabela Funcionários no elemento
     * gráfico table.
     */
    @Override
    public ArrayList<Usuario> consulta() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT nome, usuario, tipo, status FROM usuarios;";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Usuario objUsuario = new Usuario();
            objUsuario.setNome(rs.getString("nome"));
            objUsuario.setUsuario(rs.getString("usuario"));
            objUsuario.setTipo(rs.getString("tipo"));
            objUsuario.setStatus(rs.getBoolean("status"));
            usuarios.add(objUsuario);
        }

        return usuarios;
    }

    @Override
    public Usuario consulta(int id) throws SQLException {
        return null;
    }

    /**
     * Método Insere. Usado para inserir um funcionário.
     */
    @Override
    public boolean insere(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, usuario, senha, tipo, status) VALUES (?, ?, ?, 'Funcionário', true)";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getUsuario());
        ps.setString(3, u.getSenha());
        return ps.execute();

    }

    @Override
    public boolean apaga(Usuario u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean atualiza(Usuario u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método reativar. Usado para reativar um funcionário.
     */
    @Override
    public boolean reativar(Usuario u) throws SQLException {
        String sql = "UPDATE usuarios SET status = true WHERE usuario = ?";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, u.getUsuario());

        return ps.execute();
    }

    /**
     * Método desativar. Usado para desativar um funcionário.
     */
    @Override
    public boolean desativar(Usuario u) throws SQLException {
        String sql = "UPDATE usuarios SET status = false WHERE usuario = ?";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, u.getUsuario());

        return ps.execute();
    }

    @Override
    public boolean verificaAdm(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaFunc(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> consultaSemData(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> consultaComData(Usuario o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
