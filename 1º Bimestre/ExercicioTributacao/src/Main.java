public class Main {

    public static void main(String[] args) {
        PagadoresImposto pagadores = new PagadoresImposto();

        PessoaFisica pf1 = new PessoaFisica("João Silva", "111.111.111-11", 1300.00, "Masculino"); // Isento
        PessoaFisica pf2 = new PessoaFisica("Maria Souza", "222.222.222-22", 2500.00, "Feminino");  // Faixa de 15%
        PessoaFisica pf3 = new PessoaFisica("Ana Costa", "333.333.333-33", 4000.00, "Feminino");   // Faixa de 30%
        PessoaFisica pf4 = new PessoaFisica("Carlos Lima", "444.444.444-44", 2000.00, "Masculino"); // Faixa de 10%

        PessoaJuridica pj1 = new PessoaJuridica("Empresa X Ltda", "12.345.678/0001-99", 50000.00, 2010);
        PessoaJuridica pj2 = new PessoaJuridica("Mercado Y SA", "98.765.432/0001-11", 150000.00, 1995);

        pagadores.addContribuinte(pf1);
        pagadores.addContribuinte(pf2);
        pagadores.addContribuinte(pf3);
        pagadores.addContribuinte(pf4);
        pagadores.addContribuinte(pj1);
        pagadores.addContribuinte(pj2);

        System.out.println("------ Relatório de Impostos ------");
        System.out.println(); // Linha em branco para organizar

        System.out.println(String.format("Imposto devido por %s: R$ %.2f", pf1.getNome(), pf1.calcImposto()));
        System.out.println(String.format("Imposto devido por %s: R$ %.2f", pf2.getNome(), pf2.calcImposto()));
        System.out.println(String.format("Imposto devido por %s: R$ %.2f", pj1.getNome(), pj1.calcImposto()));
        System.out.println();

        double totalImpostos = pagadores.calcularImpostoTotal();
        double porcentagemFeminina = pagadores.calcularPorcentagemFeminino();

        System.out.println(String.format("Valor TOTAL de impostos a serem pagos: R$ %.2f", totalImpostos));
        System.out.println(String.format("Porcentagem de contribuintes do sexo feminino: %.2f%%", porcentagemFeminina));

        System.out.println();
        System.out.println("---------------------------------");
    }
}