package orlando_supermercados_controller;

import orlando_supermercados_view.FrmLogado;
import orlando_supermercados_model.Movimentacao;
import orlando_supermercados_dal.MovimentacaoDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZENETO
 */
public class MovimentacaoController {

    private FrmLogado form;

    public MovimentacaoController(FrmLogado form) {
        this.form = form;
    }

    /**
     * Método exibeData. Responsável por exibir a data atual na aba 'Registrar
     * movimentação'.
     */
    public void exibeData() {
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        form.getTxtDataMovimentacao().setText(timeStamp);
    }

    /**
     * Método consultaEstoque. Responsável por consultar o estoque (tabela
     * movimentacao).
     */
    public void consultaEstoque() {
        try {
            MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO();

            Movimentacao movimentacao1 = new Movimentacao();

            /* Variável para contar quantos itens foram encontrados */
            int count = 0;

            /* Verifica se campos de data estão preenchidos ou não, caos não estejam, realiza a consulta sem data */
            if (form.getTxtDataInicio().getText().equals("") || (form.getTxtDataFim().getText().equals(""))) {
                movimentacao1.setNome(form.getTxtConsultar().getText().toLowerCase());
                movimentacaoDao.consultaSemData(movimentacao1);
                ArrayList<Movimentacao> movimentacoes = movimentacaoDao.consultaSemData(movimentacao1);

                String[] colunas = {"Data", "Tipo", "Código", "Nome", "Preço", "Quantidade", "Preço Total"};
                DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);

                for (Movimentacao m : movimentacoes) {
                    Object[] data = {m.getDataMovimentacao(), m.getTipo(), m.getCodigoProduto(), m.getNome(), m.getPreco(), m.getQuantidade(), m.getPrecoTotal()};
                    tableModel.addRow(data);
                    count++;
                }
                form.getTableConsultar().setModel(tableModel);
                JOptionPane.showMessageDialog(form, count + " item(ns) encontrado(s).", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                movimentacao1.setDataInicio(Date.valueOf(form.getTxtDataInicio().getText().replace("/", "-")));
                movimentacao1.setDataFim(Date.valueOf(form.getTxtDataFim().getText().replace("/", "-")));
                movimentacao1.setNome(form.getTxtConsultar().getText().toLowerCase());

                movimentacaoDao.consultaComData(movimentacao1);
                ArrayList<Movimentacao> movimentacoes = movimentacaoDao.consultaComData(movimentacao1);

                String[] colunas = {"Data", "Tipo", "Código", "Nome", "Preço", "Quantidade", "Preço Total"};
                DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
                for (Movimentacao m : movimentacoes) {
                    Object[] data = {m.getDataMovimentacao(), m.getTipo(), m.getCodigoProduto(), m.getNome(), m.getPreco(), m.getQuantidade(), m.getPrecoTotal()};
                    count++;
                    tableModel.addRow(data);
                }
                form.getTableConsultar().setModel(tableModel);
                JOptionPane.showMessageDialog(form, count + " item(ns) encontrado(s).", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método cadastraMovimentacao. Responsável por cadastrar uma movimentação
     * no banco de dados.
     */
    public void cadastraMovimentacao() {
        try {
            MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO();

            Movimentacao movimentacao1 = new Movimentacao();

            movimentacao1.setTipo(String.valueOf(form.getjComboBoxTipoMovimentacao().getSelectedItem()));
            movimentacao1.setCodigoProduto(form.getTxtCodigoMovimentacao().getText().toUpperCase());
            movimentacao1.setNome(form.getTxtNomeProdutoMovimentacao().getText().toLowerCase());
            movimentacao1.setPreco(Double.valueOf(form.getTxtPrecoMovimentacao().getText().replace(",", ".")));
            movimentacao1.setQuantidade(Integer.valueOf(form.getTxtQuantMovimentacao().getText()));
            movimentacao1.setPrecoTotal(movimentacao1.getPreco() * movimentacao1.getQuantidade());

            /* Verifica se os text fields do fornecedor estão vazios */
            if (form.getTxtCodigoMovimentacao().getText().equals("") || form.getTxtNomeProdutoMovimentacao().getText().equals("") || form.getTxtPrecoMovimentacao().getText().equals("") || form.getTxtQuantMovimentacao().getText().equals("") || form.getTxtPrecoTotalMovimentacao().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* Insere uma nova movimentação */
                movimentacaoDao.insere(movimentacao1);
                JOptionPane.showMessageDialog(form, "Movimentação registrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                /* Chama o método de limpar os campos de cadastrar uma movimentação */
                limpaCampos();
            }

            /* Chama o método de listar a table para inventário e consulta */
            listaInventario();
            listaConsultar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método limpaCampos. Responsável por limpar os campos da inserção de
     * movimentação após a mesma ser bem sucedida.
     */
    public void limpaCampos() {
        form.getTxtCodigoMovimentacao().setText("");
        form.getTxtNomeProdutoMovimentacao().setText("");
        form.getTxtPrecoMovimentacao().setText("");
        form.getTxtQuantMovimentacao().setText("");
        form.getTxtPrecoTotalMovimentacao().setText("");
    }

    /**
     * Método calculaPrecoTotal. Responsável por calcular o preço total e
     * inserir o mesmo no elemento 'text field'.
     */
    public void calculaPrecoTotal() {
        try {
            Movimentacao movimentacao1 = new Movimentacao();

            if (form.getTxtPrecoMovimentacao().getText().equals("") || form.getTxtQuantMovimentacao().getText().equals("")) {
                JOptionPane.showMessageDialog(form, "Por favor, preencha todos os campos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                movimentacao1.setPreco(Double.valueOf(form.getTxtPrecoMovimentacao().getText().replace(",", ".")));
                movimentacao1.setQuantidade(Integer.valueOf(form.getTxtQuantMovimentacao().getText()));

                /* Preço total = Quantidade X Preço */
                double precoTotal = movimentacao1.getPreco() * movimentacao1.getQuantidade();

                if (movimentacao1 != null) {
                    form.getTxtPrecoTotalMovimentacao().setText(String.valueOf(precoTotal));
                }

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método listaInventario. Responsável por listar todas as movimentações na
     * table inventário.
     */
    public void listaInventario() {
        try {
            MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO();
            ArrayList<Movimentacao> movimentacoes = movimentacaoDao.consulta();

            String[] colunas = {"Data", "Tipo", "Código", "Nome", "Preço", "Quantidade", "Preço Total"};
            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            for (Movimentacao m : movimentacoes) {
                Object[] data = {m.getDataMovimentacao(), m.getTipo(), m.getCodigoProduto(), m.getNome(), m.getPreco(), m.getQuantidade(), m.getPrecoTotal()};
                tableModel.addRow(data);
            }
            form.getTableVisualizarInventario().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
        }
    }

    /**
     * Método listaConsultar. Responsável por listar (ao logar e ao adicionar
     * uma movimentação) todas as movimentações na table consultar .
     */
    public void listaConsultar() {
        try {
            MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO();
            ArrayList<Movimentacao> movimentacoes = movimentacaoDao.consulta();

            String[] colunas = {"Data", "Tipo", "Código", "Nome", "Preço", "Quantidade", "Preço Total"};
            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            for (Movimentacao m : movimentacoes) {
                Object[] data = {m.getDataMovimentacao(), m.getTipo(), m.getCodigoProduto(), m.getNome(), m.getPreco(), m.getQuantidade(), m.getPrecoTotal()};
                tableModel.addRow(data);
            }
            form.getTableConsultar().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
        }
    }

}
