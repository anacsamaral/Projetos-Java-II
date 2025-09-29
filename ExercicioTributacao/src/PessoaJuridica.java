public class PessoaJuridica extends Contribuinte{
    int anoFundacao;

    public PessoaJuridica(String nome, String documento, double rendaBruta, int anoFundacao) {
        super(nome, documento, rendaBruta);
        this.anoFundacao = anoFundacao;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    @Override
    public double calcImposto(){
        double renda = this.getRendaBruta();
        return (renda * 0.10);
    }
}
