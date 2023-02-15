package orlando_supermercados_model;

/**
 *
 * @author ZENETO
 */
public class Categoria {

    private int codigo;
    private String nome;
    private String descricao;

    /**
     * Construtor Categoria sem parâmetros.
     */
    public Categoria() {

    }

    /**
     * Construtor Categoria parametrizado.
     *
     * @param codigo. Código da categoria.
     * @param nome. Nome da categoria.
     * @param descricao. Descrição da categoria.
     */
    public Categoria(int codigo, String nome, String descricao) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setDescricao(descricao);
    }

    /**
     * Getters e Setters dos atributos da classe Categoria.
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método toString da classe Categoria.
     */
    @Override
    public String toString() {
        return String.format("%d\t%s\t%s", this.getCodigo(), this.getNome(), this.getDescricao());
    }
}
