package orlando_supermercados_dal;

import orlando_supermercados_model.Produto;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ZENETO
 */
public class ProdutoDAO implements IDAO<Produto> {

    private Conexao conn;

    /**
     * Construtor ProdutoDAO. Realiza a conexão.
     */
    public ProdutoDAO() throws Exception {
        this.conn = Conexao.getConexao();
    }

    /**
     * Método Consulta. Usado para listar a tabela Produtos no elemento gráfico
     * table.
     */
    @Override
    public ArrayList<Produto> consulta() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "SELECT codigo, nome, categoria, descricao, fornecedor FROM produtos;";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Produto objProduto = new Produto();
            objProduto.setCodigo(rs.getString("codigo"));
            objProduto.setNome(rs.getString("nome"));
            objProduto.setCategoria(rs.getInt("categoria"));
            objProduto.setDescricao(rs.getString("descricao"));
            objProduto.setFornecedor(rs.getString("fornecedor"));
            produtos.add(objProduto);
        }

        return produtos;
    }

    @Override
    public Produto consulta(int id) throws SQLException {
        return null;
    }

    /**
     * Método Insere. Usado para inserir um produto.
     */
    @Override
    public boolean insere(Produto p) throws SQLException {
        String sql = "INSERT INTO produtos (codigo, nome, categoria, descricao, fornecedor) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, p.getCodigo());
        ps.setString(2, p.getNome());
        ps.setInt(3, p.getCategoria());
        ps.setString(4, p.getDescricao());
        ps.setString(5, p.getFornecedor());
        return ps.execute();
    }

    @Override
    public boolean atualiza(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean apaga(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean reativar(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desativar(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaAdm(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaFunc(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Produto> consultaSemData(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Produto> consultaComData(Produto o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
