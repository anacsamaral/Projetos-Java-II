import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Teste básico do Vinho
        Vinho vinho1 = new Vinho("branco", "natal", 1000, LocalDate.of(2024, 12, 25), 50.00);
        System.out.println("Quantidade de dias do vinho " + vinho1.getMarca() + ": " + vinho1.getDataDias());

        // Teste da Adega
        Adega adega = new Adega();

        // Adicionar vinhos
        adega.add(vinho1, 10, 8);

        Vinho vinho2 = new Vinho("tinto", "Casa Silva", 750, LocalDate.of(2015, 3, 15), 50.00);
        Vinho vinho3 = new Vinho("branco", "Concha y Toro", 750, LocalDate.of(2018, 7, 20), 50.00);

        adega.add(vinho2, 5, 3); // Adiciona em posição específica
        adega.addAleatorio(vinho3); // Adiciona em posição aleatória

        System.out.println(adega);

        // Testar todas as funcionalidades
        System.out.println("Quantidade de Vinhos Brancos: " + adega.getQuantidadeTipo("branco"));
        System.out.println("Quantidade de Vinhos Tintos: " + adega.getQuantidadeTipo("tinto"));
        System.out.println("Quantidade Total de Vinhos: " + adega.getQuantidadeGarrafas());
        System.out.println("Valor Agregado: R$" + adega.getValorAgregado());

        Vinho maisAntigo = adega.getVinhoMaisAntigo();
        if (maisAntigo != null) {
            System.out.println("Vinho mais antigo: " + maisAntigo);
        }

        // Testar remoção
        Vinho removido = adega.retirarVinho(10, 8);
        if (removido != null) {
            System.out.println("Vinho removido: " + removido);
        }

        System.out.println("\nEstado final da adega:");
        System.out.println(adega);

        //Adega.Posicao pos = new Adega.Posicao(0,0); isso apenas se a classe Posicao() for static
    }
}