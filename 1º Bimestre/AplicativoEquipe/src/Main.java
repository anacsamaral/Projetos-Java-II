import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void imprimirDados(Trabalhador f){
        System.out.println("Funcionario: "+f.getNome());
        System.out.println("    Salário: R$ "+f.getSalario());
        if(f instanceof Gerente)
            System.out.println("    Adicional: "+((Gerente)f).getAdicional()+"%");
        // o cast revela a instância, nesse caso, o f é um gerente
    }

    public static void main(String[] args) {

        Funcionario f1 = new Funcionario(262413760,"João Bastos",25,30.00);
        Funcionario f2 = new Funcionario(262413756,"Roberta Marques",25,30.00);

        Gerente g1 = new Gerente(122343125,"Eri Tanoue",20,50,500.00);
        Gerente g2 = new Gerente(566789856,"Fulano de Tal",44,23,100);

        List<Trabalhador> equipe = new ArrayList<>();
        equipe.add(f1);
        equipe.add(f2);
        equipe.add(g1);
        equipe.add(g2);
        equipe.add(new Estagiario("Henzzo Freitas",20,123456));

        for(Trabalhador t : equipe)
            imprimirDados(t);
    }
}
