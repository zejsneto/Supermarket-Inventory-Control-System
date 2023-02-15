package orlando_supermercados_model;

import java.sql.Date;

/**
 *
 * @author ZENETO
 */
public class Movimentacao {

    /**
     * Atributos usados para registrar movimentação, visualizar inventário e
     * consultar estoque.
     */
    private String dataMovimentacao;
    private String tipo;
    private String codigoProduto;
    private String nome;
    private double preco;
    private int quantidade;
    private double precoTotal;

    /**
     * Atributos usados para consultar estoque.
     */
    private Date DataInicio;
    private Date DataFim;

    /**
     * Construtor Movimentacao sem parâmetros.
     */
    public Movimentacao() {

    }

    /**
     * Construtor Movimentacao parametrizado.
     *
     * @param dataMovimentacao. Data da movimentação.
     * @param tipo. Tipo de movimentação (entrada ou sáida)
     * @param codigoProduto. Código do produto movimentado.
     * @param nome. Nome do produto movimentado.
     * @param preco. Preço do produto movimentado.
     * @param quantidade. Quantidade do produto movimentado.
     * @param precoTotal. Preço total calculado do produto movimentado (Preço X
     * Quantidade).
     *
     * @param DataInicio. Data inicial da consulta.
     * @param DataFim. Data final da consulta.
     */
    public Movimentacao(String dataMovimentacao, String tipo, String codigoProduto, String nome, double preco, int quantidade, double precoTotal, Date DataInicio, Date DataFim) {
        this.setDataMovimentacao(dataMovimentacao);
        this.setTipo(tipo);
        this.setCodigoProduto(codigoProduto);
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setPrecoTotal(precoTotal);
        this.setDataInicio(DataInicio);
        this.setDataFim(DataFim);
    }

    /**
     * Getters e Setters dos atributos da classe Movimentacao.
     */
    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Date getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(Date DataInicio) {
        this.DataInicio = DataInicio;
    }

    public Date getDataFim() {
        return DataFim;
    }

    public void setDataFim(Date DataFim) {
        this.DataFim = DataFim;
    }

    /**
     * Método toString da classe Movimentacao.
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%d\t%d\t%d", this.getDataMovimentacao(), this.getTipo(), this.getCodigoProduto(), this.getNome(), this.getPreco(), this.getQuantidade(), this.getPrecoTotal());
    }

}
