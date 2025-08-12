public class Main {
    public static void main(String[] args) {
        Pais br = new Pais("BRA", "Brasil", 200000000, 8200000);
        Pais arg = new Pais();

        arg.setCodIso("FRA");
        arg.setNome("França");
        arg.setPopulacao(8500000);
        arg.setDimensao(7500000);

        System.out.println(br.getNome()+" tem densidade pop. de "+br.getDensidade()+" hab/km2");

        if(br.igual(arg))
            System.out.println("É o mesmo país.");
        else
            System.out.println("Países diferentes");
    }
}
