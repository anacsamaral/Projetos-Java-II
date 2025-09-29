import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Item> itens;

    public Biblioteca() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
        System.out.println("'" + item.getTitulo() + "' adicionado à biblioteca.");
    }

    public void listarItens() {
        System.out.println("\n--- Itens na Biblioteca ---");
        if (itens.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
            return;
        }
        for (Item item : itens) {
            System.out.println(item.getInfo());
        }
        System.out.println("-------------------------");
    }

    public void calcularTotalMultas(int diasAtraso) {
        double totalMultas = 0.0;
        for (Item item : itens) {
            totalMultas += item.calcularMulta(diasAtraso);
        }
        System.out.println(String.format("\nO total de multas para um atraso de %d dias é: R$ %.2f",
                diasAtraso, totalMultas));
    }
}