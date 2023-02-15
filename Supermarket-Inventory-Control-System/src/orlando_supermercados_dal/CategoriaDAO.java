package orlando_supermercados_dal;

import orlando_supermercados_model.Categoria;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ZENETO
 */
public class CategoriaDAO implements IDAO<Categoria> {

    private Conexao conn;

    /**
     * Construtor CategoriaDAO. Realiza a conexão.
     */
    public CategoriaDAO() throws Exception {
        this.conn = Conexao.getConexao();
    }

    /**
     * Método Consulta. Usado para listar a tabela Categoria no elemento gráfico
     * table.
     */
    @Override
    public ArrayList<Categoria> consulta() throws SQLException {
        ArrayList<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT codigo, nome, descricao FROM categorias;";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Categoria objCategoria = new Categoria();
            objCategoria.setCodigo(rs.getInt("codigo"));
            objCategoria.setNome(rs.getString("nome"));
            objCategoria.setDescricao(rs.getString("descricao"));
            categorias.add(objCategoria);
        }

        return categorias;
    }

    @Override
    public Categoria consulta(int id) throws SQLException {
        return null;
    }

    /**
     * Método Insere. Usado para inserir uma categoria.
     */
    @Override
    public boolean insere(Categoria c) throws SQLException {
        String sql = "INSERT INTO categorias (codigo, nome, descricao) VALUES (?, ?, ?)";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setInt(1, c.getCodigo());
        ps.setString(2, c.getNome());
        ps.setString(3, c.getDescricao());
        return ps.execute();
    }

    @Override
    public boolean atualiza(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean apaga(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean reativar(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desativar(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaAdm(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaFunc(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Categoria> consultaSemData(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Categoria> consultaComData(Categoria o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
