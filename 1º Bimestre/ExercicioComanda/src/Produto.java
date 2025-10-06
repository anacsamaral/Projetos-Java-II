class Produto {
    private int id;
    private String descricao;
    private Categoria categoria;
    private double valor;

    public Produto(int id, String descricao, Categoria categoria, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public Categoria getCategoria() { return categoria; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return descricao + " - " + categoria + " (R$" + valor + ")";
    }
}