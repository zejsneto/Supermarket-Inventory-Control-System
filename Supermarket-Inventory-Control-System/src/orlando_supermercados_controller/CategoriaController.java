package orlando_supermercados_controller;

import orlando_supermercados_dal.CategoriaDAO;
import orlando_supermercados_model.Categoria;
import orlando_supermercados_view.FrmLogado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZENETO
 */
public class CategoriaController {

    private FrmLogado form;

    public CategoriaController(FrmLogado form) {
        this.form = form;
    }

    /**
     * Método preencheCodigoCategoria. Responsável por automaticamente preencher
     * o código da categoria com o número zero (0).
     */
    public void preencheCodigoCategoria() {
        form.getTxtCodigoRegistrarCategoria().setText(String.valueOf(0));
    }

    /**
     * Método cadastraCategoria. Responsável por cadastrar uma categoria no
     * banco de dados.
     */
    public void cadastraCategoria() {
        try {
            CategoriaDAO categoriaDao = new CategoriaDAO();

            /* Cria um objeto categoria */
            Categoria categoria1 = new Categoria();
            categoria1.setCodigo(Integer.valueOf(form.getTxtCodigoRegistrarCategoria().getText()));
            categoria1.setNome(form.getTxtNomeRegistrarCategoria().getText());
            categoria1.setDescricao(form.getTxtDescricaoRegistrarCategoria().getText());

            /* Verifica se os campos de 'cadastra categoria' estão vazios. */
            if (form.getTxtCodigoRegistrarCategoria().getText().equals(0) || form.getTxtNomeRegistrarCategoria().getText().equals("") || form.getTxtDescricaoRegistrarCategoria().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Insere uma nova categoria */
                categoriaDao.insere(categoria1);
                JOptionPane.showMessageDialog(form, "Categoria registrada.","Aviso",JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de inserir a categoria */
                limpaCampos();
            }

            /* Chama o método de listar a table para que a mesma atualize */
            listaCategorias();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método listaCategorias. Responsável por listar todos as categorias do
     * banco de dados em uma table.
     */
    public void listaCategorias() {
        try {
            CategoriaDAO categoriaDao = new CategoriaDAO();
            ArrayList<Categoria> categorias = categoriaDao.consulta();

            String[] colunas = {"Código", "Nome", "Descrição"};
            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            for (Categoria c : categorias) {
                Object[] data = {c.getCodigo(), c.getNome(), c.getDescricao()};
                tableModel.addRow(data);
            }
            form.getTableVerCategorias().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
        }
    }

    /**
     * Método limpaCampos. Responsável por limpar os campos da inserção de
     * categoria após a mesma ser bem sucedida.
     */
    public void limpaCampos() {
        form.getTxtCodigoRegistrarCategoria().setText(String.valueOf(0));
        form.getTxtNomeRegistrarCategoria().setText("");
        form.getTxtDescricaoRegistrarCategoria().setText("");
    }

}
