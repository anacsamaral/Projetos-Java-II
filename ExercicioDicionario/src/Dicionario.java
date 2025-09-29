import java.util.ArrayList;
import java.util.List;

public class Dicionario implements IDicionario {
    private List<Termo> termos;

    public Dicionario() {
        this.termos = new ArrayList<>();
    }

    @Override
    public boolean inserir(Termo novoTermo) {

        for (Termo termoExistente : termos)
            if (termoExistente.getPalavra().equalsIgnoreCase(novoTermo.getPalavra()))
                return false;

        termos.add(novoTermo);
        return true;
    }

    @Override
    public String traduzir(String palavra) {

        for (Termo termo : termos)
            if (termo.getPalavra().equalsIgnoreCase(palavra))
                return termo.getTraducao();

        return "Palavra '" + palavra + "' não encontrada no dicionário.";
    }

    @Override
    public boolean remover(String palavra) {
        return termos.removeIf(termo -> termo.getPalavra().equalsIgnoreCase(palavra));
    }

    public void exibirTodos() {
        if (termos.isEmpty()) {
            System.out.println("O dicionário está vazio.");
            return;
        }

        for (Termo t : termos)
            System.out.println(t.exibir());
    }
}