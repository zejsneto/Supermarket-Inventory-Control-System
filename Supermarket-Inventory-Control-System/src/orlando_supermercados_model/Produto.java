package orlando_supermercados_model;

/**
 *
 * @author ZENETO
 */
public class Produto {

    private String codigo;
    private String nome;
    private int categoria;
    private String descricao;
    private String fornecedor;

    /**
     * Construtor Produto sem parâmetros.
     */
    public Produto() {

    }

    /**
     * Construtor Produto parametrizado.
     *
     * @param codigo. Código alfanumérico (String) do produto.
     * @param nome. Nome do produto.
     * @param categoria. Código da categoria.
     * @param descricao. Descrição do produto.
     * @param fornecedor. Nome do fornecedor do produto.
     */
    public Produto(String codigo, String nome, int categoria, String descricao, String fornecedor) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCategoria(categoria);
        this.setDescricao(descricao);
        this.setFornecedor(fornecedor);
    }

    /**
     * Getters e Setters dos atributos da classe Produto.
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * Método toString da classe Produto.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%s\t%s", this.getCodigo(), this.getNome(), this.getCategoria(), this.getDescricao(), this.getFornecedor());
    }
}
