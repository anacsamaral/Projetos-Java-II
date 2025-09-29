import java.util.List;

public class TermoCompleto extends Termo {
    private List<String> sinonimos;

    public TermoCompleto(String palavra, String traducao, List<String> sinonimos) {
        super(palavra, traducao);
        this.sinonimos = sinonimos;
    }

    @Override
    public String exibir() {
        return "Termo Completo | Palavra: " + palavra + ", Tradução: " + traducao + ", Sinônimos: " + sinonimos;
    }
}