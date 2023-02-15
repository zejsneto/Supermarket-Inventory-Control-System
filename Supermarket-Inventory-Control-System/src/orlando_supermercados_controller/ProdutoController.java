package orlando_supermercados_controller;

import orlando_supermercados_view.FrmLogado;
import orlando_supermercados_model.Produto;
import orlando_supermercados_dal.ProdutoDAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZENETO
 */
public class ProdutoController {

    private FrmLogado form;

    public ProdutoController(FrmLogado form) {
        this.form = form;
    }

    /**
     * Método preencheCodigoCategoria. Responsável por automaticamente preencher
     * o código da categoria no registrar produto com o número zero (0) .
     */
    public void preencheCodigoCategoria() {
        form.getTxtCategoriaRegistrarProduto().setText(String.valueOf(0));
    }

    /**
     * Método cadastraProduto. Responsável por cadastrar um produto no banco de
     * dados.
     */
    public void cadastraProduto() {
        try {
            ProdutoDAO produtoDao = new ProdutoDAO();

            /* Cria um objeto produto */
            Produto produto1 = new Produto();
            produto1.setCodigo(form.getTxtCodigoRegistrarProduto().getText());
            produto1.setNome(form.getTxtNomeRegistrarProduto().getText());
            produto1.setCategoria(Integer.valueOf(form.getTxtCategoriaRegistrarProduto().getText()));
            produto1.setDescricao(form.getTxtDescricaoRegistrarProduto().getText());
            produto1.setFornecedor(form.getTxtFornecedorRegistrarProduto().getText());

            /* Verifica se os campos de 'cadastra produto' estão vazios. */
            if (form.getTxtCodigoRegistrarProduto().getText().equals("") || form.getTxtNomeRegistrarProduto().getText().equals("") || form.getTxtDescricaoRegistrarProduto().getText().equals("") || form.getTxtFornecedorRegistrarProduto().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Insere um novo produto */
                produtoDao.insere(produto1);
                JOptionPane.showMessageDialog(form, "Produto registrado.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de inserir o produto */
                limpaCampos();
            }

            /* Chama o método de listar a table para que a mesma atualize */
            listaProdutos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método listaProdutos. Responsável por listar todos os produtos do banco
     * de dados em uma table.
     */
    public void listaProdutos() {
        try {
            ProdutoDAO produtoDao = new ProdutoDAO();
            ArrayList<Produto> produtos = produtoDao.consulta();

            String[] colunas = {"Código", "Nome", "Categoria", "Descrição", "Fornecedor"};
            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            for (Produto p : produtos) {
                Object[] data = {p.getCodigo(), p.getNome(), p.getCategoria(), p.getDescricao(), p.getFornecedor()};
                tableModel.addRow(data);
            }
            form.getTableVerProdutos().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
        }
    }

    /**
     * Método limpaCampos. Responsável por limpar os campos da inserção de
     * produto após a mesma ser bem sucedida.
     */
    public void limpaCampos() {
        form.getTxtCodigoRegistrarProduto().setText("");
        form.getTxtNomeRegistrarProduto().setText("");
        form.getTxtCategoriaRegistrarProduto().setText(String.valueOf(0));
        form.getTxtDescricaoRegistrarProduto().setText("");
        form.getTxtFornecedorRegistrarProduto().setText("");
    }

}
