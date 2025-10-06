import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Caixa caixa = new Caixa();
    private static List<Categoria> categorias = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        exibirMenuPrincipal();
    }

    private static void inicializarDados() {

        categorias.addAll(Arrays.asList(
                new Categoria(1, "Picolé"),
                new Categoria(2, "Massa"),
                new Categoria(3, "Pote")
        ));
        produtos.addAll(Arrays.asList(
                new Produto(1, "Uva", categorias.get(0), 3.5),
                new Produto(2, "Chocolate", categorias.get(1), 6),
                new Produto(3, "Napolitano", categorias.get(2), 22),
                new Produto(4, "Morango", categorias.get(0), 4.0),
                new Produto(5, "Creme", categorias.get(1), 5.5)
        ));
    }
    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE COMANDAS ===");
            System.out.println("1. Gerenciar Comandas");
            System.out.println("2. Gerenciar Produtos");
            System.out.println("3. Gerenciar Categorias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarComandas();
                    break;
                case 2:
                    gerenciarProdutos();
                    break;
                case 3:
                    gerenciarCategorias();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void gerenciarComandas() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR COMANDAS ===");
            System.out.println("1. Nova Comanda");
            System.out.println("2. Buscar Comanda");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarComanda();
                    break;
                case 2:
                    buscarComanda();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void criarComanda() {
        System.out.print("Digite o ID da nova comanda: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (caixa.getComanda(id) != null) {
            System.out.println("Já existe uma comanda com este ID!");
            return;
        }
        Comanda comanda = new Comanda(id);
        caixa.addComanda(comanda);
        System.out.println("Comanda " + id + " criada com sucesso!");

        gerenciarItensComanda(comanda);
    }
    private static void buscarComanda() {
        System.out.print("Digite o ID da comanda: ");
        int id = scanner.nextInt();

        Comanda comanda = caixa.getComanda(id);
        if (comanda == null) {
            System.out.println("Comanda não encontrada!");
            return;
        }

        System.out.println("\n" + comanda.emitirComprovante());
        gerenciarItensComanda(comanda);
    }
    private static void gerenciarItensComanda(Comanda comanda) {
        int opcao;
        do {
            System.out.println("\n=== COMANDA " + comanda.getId() + " ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Finalizar Comanda");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProdutoComanda(comanda);
                    break;
                case 2:
                    finalizarComanda(comanda);
                    opcao = 0;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void adicionarProdutoComanda(Comanda comanda) {
        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }

        System.out.print("Escolha o produto: ");
        int produtoIndex = scanner.nextInt() - 1;

        if (produtoIndex < 0 || produtoIndex >= produtos.size()) {
            System.out.println("Produto inválido!");
            return;
        }

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        comanda.addProduto(produtos.get(produtoIndex), quantidade);
        System.out.println("Produto adicionado com sucesso!");
    }
    private static void finalizarComanda(Comanda comanda) {
        System.out.println("\n" + comanda.emitirComprovante());

        System.out.print("Valor pago: R$");
        double valorPago = scanner.nextDouble();
        scanner.nextLine();

        comanda.receber(valorPago);
    }
    private static void gerenciarProdutos() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR PRODUTOS ===");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void listarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    private static void adicionarProduto() {
        System.out.print("ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("Categorias disponíveis:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }

        System.out.print("Escolha a categoria: ");
        int categoriaIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (categoriaIndex < 0 || categoriaIndex >= categorias.size()) {
            System.out.println("Categoria inválida!");
            return;
        }

        System.out.print("Valor: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Produto novoProduto = new Produto(id, descricao, categorias.get(categoriaIndex), valor);
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }
    private static void gerenciarCategorias() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR CATEGORIAS ===");
            System.out.println("1. Listar Categorias");
            System.out.println("2. Adicionar Categoria");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarCategorias();
                    break;
                case 2:
                    adicionarCategoria();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void listarCategorias() {
        System.out.println("\n=== LISTA DE CATEGORIAS ===");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }
    private static void adicionarCategoria() {
        System.out.print("ID da categoria: ");
        int id = scanner.nextInt();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Categoria novaCategoria = new Categoria(id, nome);
        categorias.add(novaCategoria);
        System.out.println("Categoria adicionada com sucesso!");
    }
}