public class Musica {
    // atributos
    private String nome;
    private int duracao;
    private String link;

    // construtor de música
    public Musica(String nome, int duracao, String link) {
        this.nome = nome;
        this.duracao = duracao;
        this.link = link;
    }

    // gets para pegar valores
    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getLink() {
        return link;
    }

    // exibir informações da música
    public String exibirInfo() {
        return "Música: " + nome + " | Duração: " + duracao + (link != null && !link.isEmpty() ? " | Youtube: " + link : "");
    }
}
