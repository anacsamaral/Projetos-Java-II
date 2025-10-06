public class Livro extends Item {
    private int numeroDePaginas;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroDePaginas) {
        super(titulo, autor, anoPublicacao);
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String getInfo() {
        return String.format("Livro: %s | Autor: %s (%d) - %d páginas",
                titulo, autor, anoPublicacao, numeroDePaginas);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 0.50;
    }
}