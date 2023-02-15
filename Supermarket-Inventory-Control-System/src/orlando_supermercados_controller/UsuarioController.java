package orlando_supermercados_controller;

import orlando_supermercados_dal.UsuarioDAO;
import orlando_supermercados_model.Usuario;
import orlando_supermercados_view.FrmLogado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZENETO
 */
public class UsuarioController {

    private FrmLogado form;

    public UsuarioController(FrmLogado form) {
        this.form = form;
    }

    /**
     * Método cadastraUsuario. Responsável por cadastrar um usuário no banco de
     * dados.
     */
    public void cadastraUsuario() {
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();

            /* Cria um objeto usuário */
            Usuario usuario1 = new Usuario();
            usuario1.setNome(form.getTxtNomeCadastrarFuncionario().getText());
            usuario1.setUsuario(form.getTxtUsuarioCadastrarFuncionario().getText());
            usuario1.setSenha(form.getTxtSenhaCadastrarFuncionario().getText());

            /* Verifica se os campos de Cadastra Funcionário estão vazios. */
            if (form.getTxtNomeCadastrarFuncionario().getText().equals("") || form.getTxtUsuarioCadastrarFuncionario().getText().equals("") || form.getTxtSenhaCadastrarFuncionario().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Insere um novo usuário */
                usuarioDao.insere(usuario1);
                JOptionPane.showMessageDialog(form, "Usuários cadastrado.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de cadastrar um funcionário */
                limpaCamposCadastrar();
            }

            /* Chama o método de listar a table após inserir o usuário para que a mesma atualize e mostre o usuário adicionado */
            listaUsuarios();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método limpaCamposCadastrar. Responsável por limpar os campos da inserção
     * de funcionário após a mesma ser bem sucedida.
     */
    public void limpaCamposCadastrar() {
        form.getTxtNomeCadastrarFuncionario().setText("");
        form.getTxtUsuarioCadastrarFuncionario().setText("");
        form.getTxtSenhaCadastrarFuncionario().setText("");
    }

    /**
     * Método limpaCamposDesativar. Responsável por limpar os campos da
     * desativação de funcionário após a mesma ser bem sucedida.
     */
    public void limpaCamposDesativar() {
        form.getTxtUsuarioDesativarFuncionario().setText("");
    }

    /**
     * Método limpaCamposReativar. Responsável por limpar os campos da
     * reativação de funcionário após a mesma ser bem sucedida.
     */
    public void limpaCamposReativar() {
        form.getTxtUsuarioReativarFuncionario().setText("");
    }

    /**
     * Método listaUsuarios. Responsável por listar todos os usuários do banco
     * de dados em uma table.
     */
    public void listaUsuarios() {
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            ArrayList<Usuario> usuarios = usuarioDao.consulta();

            String[] colunas = {"Nome", "Usuário", "Tipo", "Status"};
            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            for (Usuario u : usuarios) {
                Object[] data = {u.getNome(), u.getUsuario(), u.getTipo(), u.isStatus()};
                tableModel.addRow(data);
            }
            form.getTableFuncionarios().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método desativaUsuario. Responsável por desativar um usuário sem
     * removê-lo do banco de dados.
     */
    public void desativaUsuario() {
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();

            /* Cria um objeto usuário */
            Usuario usuario1 = new Usuario();
            usuario1.setUsuario(form.getTxtUsuarioDesativarFuncionario().getText());

            /* Verifica se o campo de Desativa Funcionário está vazio. */
            if (form.getTxtUsuarioDesativarFuncionario().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } /* Verifica se o user digitado é do tipo Administrador, caso seja, não deixa desativá-lo. */ else if (form.getTxtUsuarioDesativarFuncionario().getText().equals("admin")) {
                JOptionPane.showMessageDialog(form, "Não é possível desativar o Administrador.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Desativa um usuário */
                usuarioDao.desativar(usuario1);
                JOptionPane.showMessageDialog(form, "Usuário desativado.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de desativar um funcionário */
                limpaCamposDesativar();
            }
            /* Chama o método de listar a table após inserir o usuário para que a mesma atualize e mostre o usuário adicionado */
            listaUsuarios();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método reativaUsuario. Responsável por reativar um usuário.
     */
    public void reativaUsuario() {
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();

            /* Cria um objeto usuário */
            Usuario usuario1 = new Usuario();
            usuario1.setUsuario(form.getTxtUsuarioReativarFuncionario().getText());

            /* Verifica se o campo de Reativa Funcionário está vazio. */
            if (form.getTxtUsuarioReativarFuncionario().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } /* Verifica se o user digitado é do tipo Administrador, caso seja, informa que Administrador sempre fica ativo. */ else if (form.getTxtUsuarioReativarFuncionario().getText().equals("admin")) {
                JOptionPane.showMessageDialog(form, "O Administrador sempre fica ativo.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Reativa um usuário */
                usuarioDao.reativar(usuario1);
                JOptionPane.showMessageDialog(form, "Usuário reativado.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de reativar um funcionário */
                limpaCamposReativar();
            }
            /* Chama o método de listar a table após inserir o usuário para que a mesma atualize e mostre o usuário adicionado */
            listaUsuarios();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

}
