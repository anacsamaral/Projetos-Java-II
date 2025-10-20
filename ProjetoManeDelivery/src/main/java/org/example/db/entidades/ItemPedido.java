package org.example.db.entidades;

import java.math.BigDecimal;

/**
 * Representa um item específico dentro de um Pedido.
 * Cada item contém um Produto, a quantidade comprada e o preço unitário
 * no momento da venda, para garantir a integridade histórica dos dados.
 */
public class ItemPedido {

    private int id;
    private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario; // Preço do produto no momento da compra

    // Construtor padrão
    public ItemPedido() {
    }

    // Construtor para criar um novo item para um pedido (sem ID ainda)
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        // Congela o preço do produto no momento em que o item é criado
        this.precoUnitario = produto.getPreco();
    }

    // Construtor completo, útil para quando carregamos um item do banco de dados
    public ItemPedido(int id, Produto produto, int quantidade, BigDecimal precoUnitario) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // --- Getters e Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    // --- Métodos Úteis ---

    /**
     * Calcula o subtotal para este item do pedido.
     * @return O resultado de (quantidade * precoUnitario).
     */
    public BigDecimal getSubtotal() {
        if (precoUnitario == null) {
            return BigDecimal.ZERO;
        }
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", produto=" + (produto != null ? produto.getNome() : "null") +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}