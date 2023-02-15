package orlando_supermercados_controller;

import orlando_supermercados_dal.LoginDAO;
import orlando_supermercados_model.Login;
import orlando_supermercados_view.FrmLogado;
import orlando_supermercados_view.FrmPrincipal;

import javax.swing.JOptionPane;

/**
 *
 * @author ZENETO
 */
public class LoginController {

    private FrmPrincipal form;
    private FrmLogado logado;

    public LoginController(FrmPrincipal form) {
        this.form = form;
    }

    public LoginController(FrmPrincipal form, FrmLogado logado) {
        this.form = form;
        this.logado = logado;
    }

    /**
     * Método verificaLogin. Responsável por verificar os dados para
     * procedimento de login.
     */
    public void verificaLogin() {
        try {
            LoginDAO loginDao = new LoginDAO();

            Login login1 = new Login();

            login1.setUsuario(form.getTxtUserLogin().getText());
            login1.setSenha(form.getTxtSenha().getText());

            loginDao.verificaAdm(login1);

            FrmLogado logado = new FrmLogado();

            if (loginDao.verificaAdm(login1) == true) {
                form.setVisible(false);
                logado.setVisible(true);

            } else if (loginDao.verificaFunc(login1) == true) {

                /* Bloqueia botões de usuários do tipo Funcionário */
                logado.getBtnDesativarFuncionario().setEnabled(false);
                logado.getBtnReativarFuncionario().setEnabled(false);
                logado.getBtnCadastrarFuncionario().setEnabled(false);

                logado.getBtnGerarRelatorio().setEnabled(false);
                logado.getBtnIrParaPasta().setEnabled(false);

                form.setVisible(false);
                logado.setVisible(true);

            } else if (form.getTxtUserLogin().getText().equals("") || form.getTxtSenha().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(form, "Usuário ou senha incorretos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());

        }
    }

}
