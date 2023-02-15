package orlando_supermercados_controller;

import orlando_supermercados_view.FrmLogado;
import orlando_supermercados_model.Movimentacao;
import orlando_supermercados_dal.MovimentacaoDAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author ZENETO
 */
public class RelatorioController {

    private FrmLogado form;

    public RelatorioController(FrmLogado form) {
        this.form = form;
    }

    /**
     * Método irParaPasta. Responsável pela lógica do botão que leva à pasta
     * onde os relatórios serão gerados.
     */
    public static void irParaPasta() {
        /* Talvez seja necessário alterar o diretório para o botão funcionar em máquinas diferentes */
        File pastaRelatorios = new File("..\\222210130_Jose_Neto_Projeto\\relatorios");

        try {
            Desktop.getDesktop().open(pastaRelatorios);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Método verificaButtonTXT. Responsável por verificar se o radioButton
     * selecionado é o do tipo de arquivo TXT.
     */
    public boolean verificaButtonTXT() {
        return form.getjRadioButtonTXT().isSelected() == true;
    }

    /**
     * Método verificaButtonCSV. Responsável por verificar se o radioButton
     * selecionado é o do tipo de arquivo CSV.
     */
    public boolean verificaButtonCSV() {
        return form.getjRadioButtonCSV().isSelected() == true;
    }

    /**
     * Método gerarRelatorio. Responsável por gerar o relatório (table
     * movimentação, mesma da aba inventário).
     */
    public void gerarRelatorio() {
        /* timeStamp - pega a data de hoje. */
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

        if (verificaButtonTXT() == true) {
            try {
                //FileWriter relatorioTxt = new FileWriter(".//relatorios//relatorio-" + timeStamp + ".txt", true);
                FileWriter relatorioTxt = new FileWriter("relatorio-" + timeStamp + ".txt", true);
                PrintWriter escritaArquivo = new PrintWriter(relatorioTxt);

                MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO();
                ArrayList<Movimentacao> movimentacoes = movimentacaoDao.consulta();

                String[] colunas = {"Data", "Tipo", "Código", "Nome", "Preço", "Quantidade", "Preço Total"};
                DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
                for (Movimentacao m : movimentacoes) {
                    Object[] data = {"Data: " + m.getDataMovimentacao()
                        + " | Tipo: " + m.getTipo()
                        + " | Código: " + m.getCodigoProduto()
                        + " | Nome: " + m.getNome()
                        + " | Preço: " + m.getPreco()
                        + " | Quantidade: " + m.getQuantidade()
                        + " | Preço Total: " + m.getPrecoTotal()};
                    escritaArquivo.println(Arrays.toString(data));
                    tableModel.addRow(data);
                }
                relatorioTxt.close();
                JOptionPane.showMessageDialog(form, "Relatório TXT gerado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, ex.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(ex.getMessage());
            }
        } else if (verificaButtonCSV() == true) {
            try {
                //FileWriter relatorioCsv = new FileWriter("relatorios//relatorio" + timeStamp + ".csv", true);
                FileWriter relatorioCsv = new FileWriter("relatorio" + timeStamp + ".csv", true);
                PrintWriter escritaArquivo = new PrintWriter(relatorioCsv);

                MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO();
                ArrayList<Movimentacao> movimentacoes = movimentacaoDao.consulta();

                String[] colunas = {"Data", "Tipo", "Código", "Nome", "Preço", "Quantidade", "Preço Total"};
                DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
                for (Movimentacao m : movimentacoes) {
                    Object[] data = {"Data: " + m.getDataMovimentacao()
                        + " | Tipo: " + m.getTipo()
                        + " | Código: " + m.getCodigoProduto()
                        + " | Nome: " + m.getNome()
                        + " | Preço: " + m.getPreco()
                        + " | Quantidade: " + m.getQuantidade()
                        + " | Preço Total: " + m.getPrecoTotal()};
                    escritaArquivo.println(Arrays.toString(data));
                    tableModel.addRow(data);
                }
                relatorioCsv.close();
                JOptionPane.showMessageDialog(form, "Relatório CSV gerado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, ex.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(form, "Não foi possível gerar o relatório.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
