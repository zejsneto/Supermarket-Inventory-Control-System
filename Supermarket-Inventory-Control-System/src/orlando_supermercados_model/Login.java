package orlando_supermercados_model;

/**
 *
 * @author ZENETO
 */
public class Login {

    private String usuario;
    private String senha;

    /**
     * Construtor Login sem parâmetros.
     */
    public Login() {

    }

    /**
     * Construtor Categoria parametrizado.
     *
     * @param usuario. User do usuário. Usado para logar.
     * @param senha. Senha do usuário. Usado para logar.
     */
    public Login(String usuario, String senha) {
        this.setUsuario(usuario);
        this.setSenha(senha);
    }

    /**
     * Getters e Setters dos atributos da classe Login.
     */
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

    /**
     * Método toString da classe Login.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s", this.getUsuario(), this.getSenha());
    }
}
