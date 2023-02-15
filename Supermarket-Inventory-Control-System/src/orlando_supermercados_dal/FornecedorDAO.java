package orlando_supermercados_dal;

import orlando_supermercados_model.Fornecedor;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ZENETO
 */
public class FornecedorDAO implements IDAO<Fornecedor> {

    private Conexao conn;

    /**
     * Construtor FornecedorDAO. Realiza a conexão.
     */
    public FornecedorDAO() throws Exception {
        this.conn = Conexao.getConexao();
    }

    /**
     * Método Consulta (ArrayList). Usado para listar a tabela fornecedores no
     * elemento gráfico table.
     */
    @Override
    public ArrayList<Fornecedor> consulta() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        String sql = "SELECT codigofornecedor, cnpj, nomeempresa, endereço, nomecontato, telefonecontato FROM fornecedores;";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            Fornecedor objFornecedor = new Fornecedor();
            objFornecedor.setCodigo(rs.getInt("codigofornecedor"));
            objFornecedor.setCnpj(rs.getString("cnpj"));
            objFornecedor.setNomeEmpresa(rs.getString("nomeempresa"));
            objFornecedor.setEndereco(rs.getString("endereço"));
            objFornecedor.setContatoResponsavel(rs.getString("nomecontato"));
            objFornecedor.setContatoTelefone(rs.getString("telefonecontato"));
            fornecedores.add(objFornecedor);
        }

        return fornecedores;
    }

    /**
     * Método Consulta (int id). Usado para preencher os text fields de preview
     * de dados atuais baseado no código inserido para as abas 'alterar
     * fornecedor' e 'excluir fornecedor'.
     */
    @Override
    public Fornecedor consulta(int id) throws SQLException {
        Fornecedor objFornecedor = null;

        String sql = "SELECT cnpj, nomeempresa, endereço, nomecontato, telefonecontato FROM fornecedores WHERE codigofornecedor = ?;";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        if (rs.next()) {
            objFornecedor = new Fornecedor();
            objFornecedor.setCnpj(rs.getString("cnpj"));
            objFornecedor.setNomeEmpresa(rs.getString("nomeempresa"));
            objFornecedor.setEndereco(rs.getString("endereço"));
            objFornecedor.setContatoResponsavel(rs.getString("nomecontato"));
            objFornecedor.setContatoTelefone(rs.getString("telefonecontato"));
        }

        return objFornecedor;
    }

    /**
     * Método Insere. Usado para inserir um fornecedor.
     */
    @Override
    public boolean insere(Fornecedor f) throws SQLException {
        String sql = "INSERT INTO fornecedores (codigofornecedor, cnpj, nomeempresa, endereço, nomecontato, telefonecontato) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setInt(1, f.getCodigo());
        ps.setString(2, f.getCnpj());
        ps.setString(3, f.getNomeEmpresa());
        ps.setString(4, f.getEndereco());
        ps.setString(5, f.getContatoResponsavel());
        ps.setString(6, f.getContatoTelefone());
        return ps.execute();
    }

    /**
     * Método atualiza. Usado para atualizar um fornecedor.
     */
    @Override
    public boolean atualiza(Fornecedor f) throws SQLException {
        String sql = "UPDATE fornecedores SET cnpj = ?, nomeempresa = ?, endereço = ?, nomecontato = ?, telefonecontato = ?  WHERE codigofornecedor = ?";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setString(1, f.getCnpj());
        ps.setString(2, f.getNomeEmpresa());
        ps.setString(3, f.getEndereco());
        ps.setString(4, f.getContatoResponsavel());
        ps.setString(5, f.getContatoTelefone());
        ps.setInt(6, f.getCodigo());
        return ps.execute();
    }

    /**
     * Método apaga. Usado para apagar um fornecedor do banco de dados.
     */
    @Override
    public boolean apaga(Fornecedor f) throws SQLException {
        String sql = "DELETE FROM fornecedores WHERE codigofornecedor = ? ";
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        ps.setInt(1, f.getCodigo());
        return ps.execute();
    }

    @Override
    public boolean reativar(Fornecedor o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desativar(Fornecedor o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaAdm(Fornecedor o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificaFunc(Fornecedor o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Fornecedor> consultaSemData(Fornecedor o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Fornecedor> consultaComData(Fornecedor o) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
