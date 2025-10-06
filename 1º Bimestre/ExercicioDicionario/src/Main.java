import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dicionario meuDicionario = new Dicionario();

        Termo t1 = new TermoSimples("gato", "cat", "két");
        Termo t2 = new TermoCompleto("cachorro", "dog", Arrays.asList("cão", "canino", "perro"));
        Termo t3 = new TermoSimples("casa", "house", "ráuse");
        Termo t4 = new TermoSimples("gato", "feline", "filaine");

        System.out.println("--- Inserindo Termos ---");
        System.out.println("Inserindo 'gato': " + (meuDicionario.inserir(t1) ? "Sucesso" : "Falha - Já existe"));
        System.out.println("Inserindo 'cachorro': " + (meuDicionario.inserir(t2) ? "Sucesso" : "Falha - Já existe"));
        System.out.println("Inserindo 'casa': " + (meuDicionario.inserir(t3) ? "Sucesso" : "Falha - Já existe"));
        System.out.println("Inserindo 'gato' de novo: " + (meuDicionario.inserir(t4) ? "Sucesso" : "Falha - Já existe"));

        System.out.println("\n--- Dicionário Atual ---");
        meuDicionario.exibirTodos();

        System.out.println("\n--- Traduzindo Palavras ---");
        System.out.println("A tradução de 'cachorro' é: " + meuDicionario.traduzir("cachorro"));
        System.out.println("A tradução de 'CASA' é: " + meuDicionario.traduzir("CASA"));
        System.out.println("A tradução de 'peixe' é: " + meuDicionario.traduzir("peixe"));

        System.out.println("\n--- Removendo Termos ---");
        System.out.println("Removendo 'casa': " + (meuDicionario.remover("casa") ? "Sucesso" : "Falha - Não encontrado"));
        System.out.println("Removendo 'peixe': " + (meuDicionario.remover("peixe") ? "Sucesso" : "Falha - Não encontrado"));

        System.out.println("\n--- Dicionário Final ---");
        meuDicionario.exibirTodos();
    }
}