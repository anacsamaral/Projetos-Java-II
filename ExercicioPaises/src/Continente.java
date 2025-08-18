import java.util.ArrayList;
import java.util.List;

public class Continente {
    // atributos
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean addPais(Pais pais){
        if(!paises.contains(pais)) {
            paises.add(pais);
            return true;
        }
        return false;
    }

    public double getDimensao(Pais pais){
        double dimensao = 0;
        dimensao += pais.getDimensao();

        return dimensao;
    }

    public int getPopulacao(Pais pais){
        int populacao = 0;
        for(int i = 0; i < paises.size(); i++){
            populacao += paises.get(i).getPopulacao();
        }

        return populacao;
    }

    public double getDensidade(){
        double densidade = 0;
        densidade = this.getPopulacao()/this.getDimensao();
        return densidade;
    }
}
