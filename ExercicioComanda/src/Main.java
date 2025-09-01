import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Caixa
        Caixa caixa = new Caixa();

        // lista de categorias
        List<Categoria> categorias = new ArrayList<>();
        categorias.addAll(Arrays.asList(
                new Categoria(1, "picolé"),
                new Categoria(2, "massa"),
                new Categoria(3, "pote")));

        // lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.addAll(Arrays.asList(
            new Produto(1, "Uva", categorias.get(0), 3.5),
            new Produto(2, "Uva", categorias.get(1), 6),
            new Produto(3, "Uva", categorias.get(2), 22)));

        // *** Processo de Consumo ***
        // criando uma nova comanda
        // adicionando produto e quantidade na comanda
        // lembre-se da classe item (Inner Class).
        // verificar produtos repetidos, através do id
        Comanda comanda = new Comanda(10);
        caixa.addComanda(comanda); // enviando a comanda para o caixa
        comanda = caixa.getComanda(10) // pega a comanda do caixa para adicionar os seguintes produtos
        comanda.addProduto(produtos.get(0),1);
        comanda.addProduto(produtos.get(1),2);
        comanda.addProduto(produtos.get(2),1);

        // *** Processo de Recebimento
        comanda = caixa.getComanda(10);

        // exibições
        System.out.println("Valor da comanda: "+comanda.getValor());
        System.out.println("Comprovante: "+comanda.emitirComprovante());

        // fechando a comanda
        comanda.receber(30);
    }
}
