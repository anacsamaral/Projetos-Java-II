import java.util.ArrayList;
import java.util.List;

public class BibliotecaCD {
    private List<CD> cds;
    private List<Artista> artistas;

    public BibliotecaCD() {
        this.cds = new ArrayList<>();
    }

    public void addCD(CD cd) {
        cds.add(cd);
    }

    public void listarCDs() {
        System.out.println("\n>>> Lista de CDs cadastrados: ");
        for(CD cd : cds)
            System.out.println(" - " + cd);
    }

    public CD buscarCD(String titulo) {
        for(CD cd : cds)
            if(cd.getTitulo().equalsIgnoreCase(titulo))
                return cd;
        return null;
    }

    public Artista buscarArtista(String nome) {
        for(Artista artista : artistas)
            if(artista.getNome().equalsIgnoreCase(nome))
                return artista;
        return null;
    }
}