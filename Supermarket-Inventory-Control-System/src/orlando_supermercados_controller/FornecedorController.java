package orlando_supermercados_controller;

import orlando_supermercados_view.FrmLogado;
import orlando_supermercados_model.Fornecedor;
import orlando_supermercados_dal.FornecedorDAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZENETO
 */
public class FornecedorController {

    private FrmLogado form;

    public FornecedorController(FrmLogado form) {
        this.form = form;
    }

    /**
     * Método preencheCodigoFornecedor. Responsável por automaticamente
     * preencher o código do fornecedor com o número zero (0).
     */
    public void preencheCodigoFornecedor() {
        form.getTxtCodigoFornecedores().setText(String.valueOf(0));
        form.getTxtCodigoExcluirFornecedor().setText(String.valueOf(0));
        form.getTxtCodigoAlterarFornecedor().setText(String.valueOf(0));
    }

    /**
     * Método cadastraFornecedor. Responsável por cadastrar um fornecedor no
     * banco de dados.
     */
    public void cadastraFornecedor() {
        try {
            FornecedorDAO fornecedorDao = new FornecedorDAO();

            /* Cria um objeto fornecedor */
            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setCodigo(Integer.valueOf(form.getTxtCodigoFornecedores().getText()));
            fornecedor1.setCnpj(form.getTxtCNPJFornecedores().getText());
            fornecedor1.setNomeEmpresa(form.getTxtNomeEmpresaFornecedores().getText());
            fornecedor1.setEndereco(form.getTxtEnderecoFornecedores().getText());
            fornecedor1.setContatoResponsavel(form.getTxtNomeResponsavelFornecedores().getText());
            fornecedor1.setContatoTelefone(form.getTxtTelefoneFornecedores().getText());

            /* Verifica se o código do fornecedor está como 0 */
            if (form.getTxtCodigoFornecedores().getText().equals("0")) {
                //JOptionPane.showMessageDialog(form, this, title, 0);
                JOptionPane.showMessageDialog(form, "Por favor, insira um código de fornecedor válido.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } 
            /* Verifica se os text fields do fornecedor estão vazios e o código está como 0 */ 
            else if (form.getTxtCodigoFornecedores().getText().equals("0") || form.getTxtCNPJFornecedores().getText().equals("") || form.getTxtNomeEmpresaFornecedores().getText().equals("") || form.getTxtEnderecoFornecedores().getText().equals("") || form.getTxtNomeResponsavelFornecedores().getText().equals("") || form.getTxtTelefoneFornecedores().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Insere um novo fornecedor */
                fornecedorDao.insere(fornecedor1);
                JOptionPane.showMessageDialog(form, "Categoria adicionada.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de inserir o fornecedor */
                limpaCamposAdicionar();
            }

            /* Chama o método de listar a table para que a mesma atualize */
            listaFornecedores();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método limpaCamposAdicionar. Responsável por limpar os campos da inserção
     * de fornecedor após a mesma ser bem sucedida.
     */
    public void limpaCamposAdicionar() {
        form.getTxtCodigoFornecedores().setText(String.valueOf(0));
        form.getTxtCNPJFornecedores().setText("");
        form.getTxtNomeEmpresaFornecedores().setText("");
        form.getTxtEnderecoFornecedores().setText("");
        form.getTxtNomeResponsavelFornecedores().setText("");
        form.getTxtTelefoneFornecedores().setText("");
    }

    /**
     * Método limpaCamposAlterar. Responsável por limpar os campos da alteração
     * do fornecedor após a mesma ser bem sucedida.
     */
    public void limpaCamposAlterar() {
        /* Código (Inalterável) */
        form.getTxtCodigoAlterarFornecedor().setText(String.valueOf(0));
        /* Atual */
        form.getTxtCNPJAntigoAlterarFornecedor().setText("");
        form.getTxtNomeAntigoAlterarFornecedores().setText("");
        form.getTxtEnderecoAntigoAlterarFornecedor().setText("");
        form.getTxtResponsavelAntigoAlterarFornecedor().setText("");
        form.getTxtTelefoneAntigoAlterarFornecedor().setText("");
        /* Novo */
        form.getTxtCNPJNovoAlterarFornecedor().setText("");
        form.getTxtNomeNovoAlterarFornecedor().setText("");
        form.getTxtEnderecoNovoAlterarFornecedor().setText("");
        form.getTxtResponsavelNovoAlterarFornecedor().setText("");
        form.getTxtTelefoneNovoAlterarFornecedor().setText("");
    }

    /**
     * Método limpaCamposExcluir. Responsável por limpar os campos da exclusão
     * do fornecedor após a mesma ser bem sucedida.
     */
    public void limpaCamposExcluir() {
        form.getTxtCodigoExcluirFornecedor().setText(String.valueOf(0));
        form.getTxtCNPJExcluirFornecedor().setText("");
        form.getTxtNomeExcluirFornecedor().setText("");
        form.getTxtEnderecoExcluirFornecedor().setText("");
        form.getTxtResponsavelExcluirFornecedor().setText("");
        form.getTxtTelefoneExcluirFornecedor().setText("");
    }

    /**
     * Método listaFornecedores. Responsável por listar todos os fornecedores do
     * banco de dados em uma table.
     */
    public void listaFornecedores() {
        try {
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            ArrayList<Fornecedor> fornecedores = fornecedorDao.consulta();

            String[] colunas = {"Código", "CNPJ", "Empresa", "Endereço", "Responsável", "Telefone"};
            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            for (Fornecedor f : fornecedores) {
                Object[] data = {f.getCodigo(), f.getCnpj(), f.getNomeEmpresa(), f.getEndereco(), f.getContatoResponsavel(), f.getContatoTelefone()};
                tableModel.addRow(data);
            }
            form.getTableVerFornecedores().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
        }
    }

    /**
     * Método listaFornecedorAtualExcluir. Responsável por listar os dados do
     * fornecedor digitado na aba exlcuir fornecedor.
     */
    public void listaFornecedorAtualExcluir() {
        try {
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            Fornecedor fornecedor1 = fornecedorDao.consulta(Integer.parseInt(form.getTxtCodigoExcluirFornecedor().getText()));

            if (fornecedor1 != null) {
                form.getTxtCNPJExcluirFornecedor().setText(fornecedor1.getCnpj());
                form.getTxtNomeExcluirFornecedor().setText(fornecedor1.getNomeEmpresa());
                form.getTxtEnderecoExcluirFornecedor().setText(fornecedor1.getEndereco());
                form.getTxtResponsavelExcluirFornecedor().setText(fornecedor1.getContatoResponsavel());
                form.getTxtTelefoneExcluirFornecedor().setText(fornecedor1.getContatoTelefone());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método apagaFornecedor. Responsável por apagar um fornecedor no banco de
     * dados.
     */
    public void apagaFornecedor() {
        try {
            FornecedorDAO fornecedorDao = new FornecedorDAO();

            /* Cria um objeto fornecedor */
            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setCodigo(Integer.valueOf(form.getTxtCodigoExcluirFornecedor().getText()));

            /* Verifica se o código do fornecedor permanece como 0 */
            if (form.getTxtCodigoExcluirFornecedor().getText().equals("0")) {
                JOptionPane.showMessageDialog(form, "Por favor, insira um código de fornecedor válido.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } 
            /* Verifica se o código do fornecedor está vazio */ 
            else if (form.getTxtCodigoExcluirFornecedor().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Apaga o fornecedor */
                fornecedorDao.apaga(fornecedor1);
                JOptionPane.showMessageDialog(form, "O fornecedor foi apagado.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de excluir o fornecedor */
                limpaCamposExcluir();
            }

            /* Chama o método de listar a table para que a mesma atualize */
            listaFornecedores();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método listaFornecedorAtualAlterar. Responsável por listar os dados do
     * fornecedor digitado na aba alterar fornecedor.
     */
    public void listaFornecedorAtualAlterar() {
        try {
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            Fornecedor fornecedor1 = fornecedorDao.consulta(Integer.parseInt(form.getTxtCodigoAlterarFornecedor().getText()));

            if (fornecedor1 != null) {
                form.getTxtCNPJAntigoAlterarFornecedor().setText(fornecedor1.getCnpj());
                form.getTxtNomeAntigoAlterarFornecedores().setText(fornecedor1.getNomeEmpresa());
                form.getTxtEnderecoAntigoAlterarFornecedor().setText(fornecedor1.getEndereco());
                form.getTxtResponsavelAntigoAlterarFornecedor().setText(fornecedor1.getContatoResponsavel());
                form.getTxtTelefoneAntigoAlterarFornecedor().setText(fornecedor1.getContatoTelefone());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método atualizaFornecedor. Responsável por atualizar um fornecedor no
     * banco de dados.
     */
    public void atualizaFornecedor() {
        try {
            FornecedorDAO fornecedorDao = new FornecedorDAO();

            /* Cria um objeto fornecedor */
            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setCodigo(Integer.valueOf(form.getTxtCodigoAlterarFornecedor().getText()));
            fornecedor1.setCnpj(form.getTxtCNPJNovoAlterarFornecedor().getText());
            fornecedor1.setNomeEmpresa(form.getTxtNomeNovoAlterarFornecedor().getText());
            fornecedor1.setEndereco(form.getTxtEnderecoNovoAlterarFornecedor().getText());
            fornecedor1.setContatoResponsavel(form.getTxtResponsavelNovoAlterarFornecedor().getText());
            fornecedor1.setContatoTelefone(form.getTxtTelefoneNovoAlterarFornecedor().getText());

            /* Verifica se o código do fornecedor permanece como 0 */
            if (form.getTxtCodigoAlterarFornecedor().getText().equals("0")) {
                JOptionPane.showMessageDialog(form, "Por favor, insira um código de fornecedor válido.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } 
            /* Verifica se o código do fornecedor está vazio */ 
            else if (form.getTxtCodigoAlterarFornecedor().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, insira um fornecedor válido.","Aviso",JOptionPane.INFORMATION_MESSAGE);
             /* Verifica se os campos estão vazios */
            } else if (form.getTxtCNPJNovoAlterarFornecedor().getText().equals("") || form.getTxtNomeNovoAlterarFornecedor().getText().equals("") || form.getTxtEnderecoNovoAlterarFornecedor().getText().equals("") || form.getTxtResponsavelNovoAlterarFornecedor().getText().equals("") || form.getTxtTelefoneNovoAlterarFornecedor().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Atualiza o fornecedor */
                fornecedorDao.atualiza(fornecedor1);
                JOptionPane.showMessageDialog(form, "O fornecedor foi alterado.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de alterar o fornecedor */
                limpaCamposAlterar();
            }

            /* Chama o método de listar a table para que a mesma atualize */
            listaFornecedores();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

}
