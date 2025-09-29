import java.util.ArrayList;
import java.util.List;

public class PagadoresImposto {
    private List<Contribuinte> contribuintes;
    public PagadoresImposto() {
        this.contribuintes = new ArrayList<>();
    }

    public void addContribuinte(Contribuinte contribuinte){
        contribuintes.add(contribuinte);
    }

    public double calcularImpostoTotal(){
        double total = 0;

        for(Contribuinte contribuinte : contribuintes)
            total += contribuinte.calcImposto();

        return total;
    }

    public double calcularPorcentagemFeminino(){
        int totalFisicas = 0;
        int totalFem = 0;

        for(Contribuinte contribuinte : contribuintes){
            if(contribuinte instanceof PessoaFisica){
                totalFisicas++;
                if(((PessoaFisica) contribuinte).getSexo().equalsIgnoreCase("feminino"))
                    totalFem++;
            }
        }

        if(totalFisicas == 0)
            return 0.0;
        else
            return ((double) totalFem / totalFisicas) * 100.0;
    }
}
