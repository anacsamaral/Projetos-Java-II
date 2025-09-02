import java.util.ArrayList;
import java.util.List;

public class Artista {
    // atributos
    private String nome;
    private String tipo;
    private List<CD> cds; // lista de álbuns do artista

    // construtor
    public Artista(String nome, String tipo) {
        this.nome = nome;
        this.cds = new ArrayList<>(); // inicializando a lista de CD's
    }

    public void addCD(CD cd) {
        cds.add(cd);
    }

    public void listarCDs() {
        System.out.println("CDs do artista " + nome + ":");
        for(CD cd : cds)
            System.out.println(" - " + cd.getTitulo());
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Artista: " + nome + " | Tipo : " + tipo;
    }
}