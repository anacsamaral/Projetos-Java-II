public abstract class Contribuinte implements ITributacao {
    private String nome;
    private String documento;
    private double rendaBruta;

    public Contribuinte(String nome, String documento, double rendaBruta) {
        this.nome = nome;
        this.documento = documento;
        this.rendaBruta = rendaBruta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getRendaBruta() {
        return rendaBruta;
    }

    public void setRendaBruta(double rendaBruta) {
        this.rendaBruta = rendaBruta;
    }
}
