import java.util.ArrayList;
import java.util.List;

class Comanda {
    private int id;
    private List<Item> itens;

    public Comanda(int id) {
        this.id = id;
        this.itens = new ArrayList<>();
    }

    public int getId() { return id; }

    public void addProduto(Produto produto, int quantidade) {
        for (Item item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new Item(produto, quantidade));
    }

    public double getValor() {
        return itens.stream().mapToDouble(Item::getSubtotal).sum();
    }

    public String emitirComprovante() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Comanda " + id + " ===\n");
        for (Item item : itens) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total: R$").append(getValor());
        return sb.toString();
    }

    public void receber(double valorPago) {
        double troco = valorPago - getValor();
        System.out.println("Pagamento recebido: R$" + valorPago);
        System.out.println("Troco: R$" + troco);
    }
}