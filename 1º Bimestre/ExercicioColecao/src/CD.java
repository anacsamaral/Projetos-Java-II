import java.util.ArrayList;
import java.util.List;

public class CD {
    private String titulo;
    private int ano;
    private Artista artista;
    private List<Musica> musicas;

    public CD(String titulo, int ano, Artista artista) {
        if(!(titulo.isEmpty()))
            this.titulo = titulo;
        if(ano > 0)
            this.ano = ano;
        this.artista = artista;
        this.musicas = new ArrayList<>();

        artista.addCD(this); // mantém a lista do artista atualizada
    }

    // métodos
    public void addMusica(Musica musica) {
        musicas.add(musica); // na lista de músicas, adicione uma música
    }

    public void listarMusica() {
        System.out.println("\n>>> Músicas do CD \"" + titulo + "\" do artista " + artista.getNome() + ":");
        for(Musica m : musicas)
            System.out.println("  - " + m.exibirInfo());
    }

    public Musica buscarMusica(String nome) {
        for(Musica m : musicas) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

    public String getTitulo() {
        if(!(titulo.isEmpty()))
            return titulo;
        return null;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "CD: " + titulo + " | Ano: " + ano + " | Artistas: " + artista.getNome();
    }
}