public class Pais {
    //atributos
    private String codIso;
    private String nome;
    private int populacao;
    private double dimensao;

    //A) construtor com parametro
    public Pais(String codIso, String nome, int populacao, double dimensao) {
        this.codIso = codIso;
        this.nome = nome;
        setPopulacao(populacao);
        setDimensao(dimensao);
    }

    // A) construtor sem parametro (forma 1)
    public Pais(){
        this("","",0,0); // executa o outro construtor
    }

    // A) construtor sem parametro (forma 2)
    /*public Pais(){
        codIso = "";
        nome = "";
        populacao = 0;
        dimensao = 0;
    }*/

    //B) method: get -> pega valor
    public String getCodIso(){
        return codIso;
    }
    public String getNome() {
        return nome;
    }
    public double getDimensao(){
        return dimensao;
    }
    public int getPopulacao(){
        return populacao;
    }

    //B) method: set -> troca de valor
    public void setCodIso(String codIso){
        this.codIso = codIso;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPopulacao(int populacao) {
        if(populacao >= 0)
            this.populacao = populacao;
    }
    public void setDimensao(double dimensao) {
        if(dimensao >= 0)
            this.dimensao = dimensao;
    }

    // C) verificar se paises sao iguais
    public boolean igual(Pais outro){
        return codIso.equals(outro.codIso); //outro.getCodIso() //está dentro do proprio objeto, por isso funciona
    }

    // D) densidade populacional
    public double getDensidade(){
        if(dimensao > 0)
            return populacao/dimensao;
        return 0;
    }
}
