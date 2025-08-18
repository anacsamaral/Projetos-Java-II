import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Vinho vinho = new Vinho("branco","natal",1000, LocalDate.of(2024,12,25),15);
        System.out.println("Quantidade de dias: "+vinho.getDataDias());

        Adega adega = new Adega();
        adega.add(vinho,10,8);
        System.out.println(adega);

        System.out.println("Quantidade de Vinhos Brancos: "+adega.getQuantidadeTipo("branco"));
    }
}