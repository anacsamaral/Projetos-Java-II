public class PessoaFisica extends Contribuinte {
    private String sexo;

    public PessoaFisica(String nome, String documento, double rendaBruta, String sexo) {
        super(nome, documento, rendaBruta);
        this.sexo = sexo;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public double calcImposto(){
        double renda = this.getRendaBruta();
        if(renda <= 1400.00)
            return 0.00;
        else if (renda <= 2100.00)
            return (renda * 0.10) - 100.00;
        else if (renda <= 2800.00)
            return (renda * 0.15) - 270.00;
        else if (renda <= 3600.00)
            return (renda * 0.25) - 500.00;
        else
            return (renda * 0.30) - 700.00;
    }
}
