package orlando_supermercados_dal;

import orlando_supermercados_model.Movimentacao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ZENETO
 */
public class MovimentacaoDAO implements IDAO<Movimentacao> {

    private Conexao conn;

    /**
     * Construtor MovimentacaoDAO. Realiza a conexão.
     */
    public MovimentacaoDAO() throws Exception {
        this.conn = Conexao.getConexao();
    }

    /**
     * Método Consulta. Usado para listar a tabela visualizar inventário e
     * consultar estoque (caso ao abrir e ao adicionar movimentação) no elemento
     * gráfico table.
     */
    @Override
    public ArrayList<Movimentacao> consulta() throws SQLException {
        ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

        String sql = "SELECT datamovimentacao, tipo, codigoproduto, nome, preco, quantidade, precototal FROM movimentacao;";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Movimentacao objMovimentacao = new Movimentacao();
            objMovimentacao.setDataMovimentacao(rs.getString("datamovimentacao"));
            objMovimentacao.setTipo(rs.getString("tipo"));
            objMovimentacao.setCodigoProduto(rs.getString("codigoproduto"));
            objMovimentacao.setNome(rs.getString("nome"));
            objMovimentacao.setPreco(rs.getDouble("preco"));
            objMovimentacao.setQuantidade(rs.getInt("quantidade"));
            objMovimentacao.setPrecoTotal(rs.getDouble("precototal"));
            movimentacoes.add(objMovimentacao);
        }

        return movimentacoes;
    }

    @Override
    public Movimentacao consulta(int id) throws SQLException {
        return null;
    }

    /**
     * Método Insere. Usado para inserir uma movimentação.
     */
    @Override
    public boolean insere(Movimentacao m) throws SQLException {
        String sql = "INSERT INTO movimentacao ( tipo, codigoproduto, nome, preco, quantidade, precototal) VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, m.getTipo());
        ps.setString(2, m.getCodigoProduto());
        ps.setString(3, m.getNome());
        ps.setDouble(4, m.getPreco());
        ps.setInt(5, m.getQuantidade());
        ps.setDouble(6, m.getPrecoTotal());
        return ps.execute();
    }

    @Override
    public boolean atualiza(Movimentacao m) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean apaga(Movimentacao m) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean reativar(Movimentacao m) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desativar(Movimentacao m) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Método consultaSemData. Usado para consultar a table 'movimentacao'
     * usando como parâmetros o nome do item apenas.
     */
    @Override
    public ArrayList<Movimentacao> consultaSemData(Movimentacao m) throws SQLException {
        ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

        String sql = "SELECT * FROM movimentacao WHERE nome LIKE CONCAT( '%',?,'%')";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, m.getNome());
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Movimentacao objMovimentacao = new Movimentacao();
            objMovimentacao.setDataMovimentacao(rs.getString("datamovimentacao"));
            objMovimentacao.setTipo(rs.getString("tipo"));
            objMovimentacao.setCodigoProduto(rs.getString("codigoproduto"));
            objMovimentacao.setNome(rs.getString("nome"));
            objMovimentacao.setPreco(rs.getDouble("preco"));
            objMovimentacao.setQuantidade(rs.getInt("quantidade"));
            objMovimentacao.setPrecoTotal(rs.getDouble("precototal"));
            movimentacoes.add(objMovimentacao);
        }
        return movimentacoes;
    }

    /**
     * Método consultaComData. Usado para consultar a table 'movimentacao'
     * usando como parâmetros o nome do item, data incial e data final.
     */
    @Override
    public ArrayList<Movimentacao> consultaComData(Movimentacao m) throws SQLException {
        ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

        //'%' || ? || '%'
        String sql = "SELECT * FROM movimentacao WHERE nome LIKE CONCAT( '%',?,'%') and datamovimentacao BETWEEN ? and ?";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, m.getNome());
        ps.setDate(2, m.getDataInicio());
        ps.setDate(3, m.getDataFim());
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Movimentacao objMovimentacao = new Movimentacao();
            objMovimentacao.setDataMovimentacao(rs.getString("datamovimentacao"));
            objMovimentacao.setTipo(rs.getString("tipo"));
            objMovimentacao.setCodigoProduto(rs.getString("codigoproduto"));
            objMovimentacao.setNome(rs.getString("nome"));
            objMovimentacao.setPreco(rs.getDouble("preco"));
            objMovimentacao.setQuantidade(rs.getInt("quantidade"));
            objMovimentacao.setPrecoTotal(rs.getDouble("precototal"));
            movimentacoes.add(objMovimentacao);
        }
        return movimentacoes;
    }

    @Override
    public boolean verificaAdm(Movimentacao o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaFunc(Movimentacao o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
