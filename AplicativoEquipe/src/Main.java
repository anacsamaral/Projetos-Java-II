import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void imprimirDados(Funcionario f){
        System.out.println("Funcionario: "+f.getNome());
        System.out.println("    Salário: R$ "+f.getSalario());
        if(f instanceof Gerente)
            System.out.println("    Adicional: "+((Gerente)f).getAdicional()+"%");
    }

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario(262413760,"João Bastos",25,30.00);
        Funcionario f2 = new Funcionario(262413756,"Roberta Marques",25,30.00);

        Gerente g1 = new Gerente(122343125,"Eri Tanoue",20,50,500.00);
        Gerente g2 = new Gerente(566789856,"Fulano de Tal",44,23,100);

        List<Funcionario> equipe = new ArrayList<>();
        equipe.add(f1);
        equipe.add(f2);
        equipe.add(g1);
        equipe.add(g2);

        imprimirDados(f1);
        imprimirDados(f2);
        imprimirDados(g1);
        imprimirDados(g2);
    }
}
