package orlando_supermercados_model;

/**
 *
 * @author ZENETO
 */
public class Usuario {

    private String nome;
    private String usuario;
    private String senha;
    private String tipo;
    private boolean status;

    /**
     * Construtor Usuario sem parâmetros.
     */
    public Usuario() {

    }

    /**
     * Construtor Usuario parametrizado.
     *
     * @param nome. Nome do usuário.
     * @param usuario. String usado pelo usuário para logar.
     * @param senha. Senha do usuário, usado para logar.
     * @param tipo. Tipo do usuário (Administrador ou Funcionário).
     * @param status. Status 'booleano' do usuário. True para ativo e false para inativo.
     */
    public Usuario(String nome, String usuario, String senha, String tipo, boolean status) {
        this.setNome(nome);
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setTipo(tipo);
        this.setStatus(status);
    }

    /**
     * Getters e Setters dos atributos da classe Usuario.
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Método toString da classe Usuario.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", this.getNome(), this.getUsuario(), this.getSenha(), this.getTipo(), this.isStatus());
    }
}
