package orlando_supermercados_model;

/**
 *
 * @author ZENETO
 */
public class Fornecedor {

    private int codigo;
    private String cnpj;
    private String nomeEmpresa;
    private String endereco;
    private String contatoResponsavel;
    private String contatoTelefone;

    /**
     * Construtor Fornecedor sem parâmetros.
     */
    public Fornecedor() {

    }

    /**
     * Construtor Fornecedor parametrizado.
     *
     * @param codigo. Código do fornecedor.
     * @param cnpj. CNPJ do fornecedor.
     * @param nomeEmpresa. Nome da empresa fornecedora.
     * @param endereco. Endereço completo da empresa fornecedora.
     * @param contatoResponsavel. Nome do responsável.
     * @param contatoTelefone. Telefone do responsável.
     */
    public Fornecedor(int codigo, String cnpj, String nomeEmpresa, String endereco, String contatoResponsavel, String contatoTelefone) {
        this.setCodigo(codigo);
        this.setCnpj(cnpj);
        this.setNomeEmpresa(nomeEmpresa);
        this.setEndereco(endereco);
        this.setContatoResponsavel(contatoResponsavel);
        this.setContatoTelefone(contatoTelefone);
    }

    /**
     * Getters e Setters dos atributos da classe Fornecedor.
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(String contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }

    public String getContatoTelefone() {
        return contatoTelefone;
    }

    public void setContatoTelefone(String contatoTelefone) {
        this.contatoTelefone = contatoTelefone;
    }

    /**
     * Método toString da classe Fornecedor.
     */
    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\t%s\t%s\t%s", this.getCodigo(), this.getCnpj(), this.getNomeEmpresa(), this.getEndereco(), this.getContatoResponsavel(), this.getContatoTelefone());
    }
}
