public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Biblioteca criada.\n");

        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 1178);
        Revista revista1 = new Revista("Superinteressante", "Editora Abril", 2023, 455);
        Livro livro2 = new Livro("Java: Como Programar", "Deitel & Deitel", 2016, 968);

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(revista1);
        biblioteca.adicionarItem(livro2);

        biblioteca.listarItens();

        biblioteca.calcularTotalMultas(1);
    }
}