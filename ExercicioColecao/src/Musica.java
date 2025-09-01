public class Musica {
    private String nome;
    private int duracao;
    private String link;

    public Musica(String nome, int duracao, String link) {
        this.nome = nome;
        this.duracao = duracao;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getLink() {
        return link;
    }
}
