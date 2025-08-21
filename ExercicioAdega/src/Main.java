import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Vinho vinho = new Vinho("branco","natal",1000, LocalDate.of(2024,12,25),15);
        System.out.println("Quantidade de dias: "+vinho.getDataDias());

        Adega adega = new Adega();
        adega.add(vinho,10,8);

        Vinho vinho2 = new Vinho("tinto", "Casa Silva", 750, LocalDate.of(2015, 3, 15), 89.90);
        Vinho vinho3 = new Vinho("branco", "Concha y Toro", 750, LocalDate.of(2018, 7, 20), 45.50);

        adega.add(vinho2, 5, 3);

        System.out.println("Quantidade de Vinhos Brancos: " + adega.getQuantidadeTipo("branco"));
        System.out.println("Quantidade de Vinhos Tintos: " + adega.getQuantidadeTipo("tinto"));
        System.out.println("Quantidade Total: " + adega.getQuantidadeTotal());
        System.out.println("Valor Agregado: R$" + adega.getValorAgregado());
    }
}