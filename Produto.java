/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho_LPC;

/**
 *
 * @author daniel
 */
public class Produto {
    private long codigo_produto;
    private String nome_produto;
    private double valor_pago;
    private double valor_venda;
    private int qtde_estoque;
    private String unidade_medida;
    private String categoria;
    
    Produto(){
        
    }
    
    Produto(long codigo_produto, String nome_produto, double valor_pago, double valor_venda,
            int qtde_estoque, String unidade_medida, String categoria){
        this.codigo_produto = codigo_produto;
        this.nome_produto = nome_produto;
        this.valor_pago = valor_pago;
        this.valor_venda = valor_venda;
        this.qtde_estoque = qtde_estoque;
        this.unidade_medida = unidade_medida;
        this.categoria = categoria;
    }

    public long getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(long codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public int getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(int qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
