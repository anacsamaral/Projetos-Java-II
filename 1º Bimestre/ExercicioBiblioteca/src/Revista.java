public class Revista extends Item {
    private int numeroEdicao;

    public Revista(String titulo, String autor, int anoPublicacao, int numeroEdicao) {
        super(titulo, autor, anoPublicacao);
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public String getInfo() {
        return String.format("Revista: %s | Editora: %s (%d) - Edição Nº %d",
                titulo, autor, anoPublicacao, numeroEdicao);
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 0.30;
    }
}