public class TermoSimples extends Termo {
    private String pronuncia;

    public TermoSimples(String palavra, String traducao, String pronuncia) {
        super(palavra, traducao);
        this.pronuncia = pronuncia;
    }

    @Override
    public String exibir() {
        return "Termo Simples | Palavra: " + palavra + ", Tradução: " + traducao + ", Pronúncia: " + pronuncia;
    }
}