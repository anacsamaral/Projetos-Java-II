import java.util.ArrayList;
import java.util.List;

public class Cd {
    private String titulo;
    private int ano;
    private Artista artista;
    private List <Musica> musicas;
    private String link;

    public Cd(String titulo, int ano, Artista artista, List<Musica> musicas, String link) {
        this.titulo = titulo;
        this.ano = ano;
        this.artista = artista;
        this.musicas = musicas;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }
}
