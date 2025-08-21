import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Vinho vinho1 = new Vinho("branco","Natal",1000, LocalDate.of(2024,12,25),90);
        Vinho vinho2 = new Vinho("tinto", "Casa Silva", 750, LocalDate.of(2015, 3, 15), 90.00);
        Vinho vinho3 = new Vinho("branco", "Concha y Toro", 750, LocalDate.of(2018, 7, 20), 90.00);

        Adega adega = new Adega();
        adega.add(vinho1,10,8);
        adega.add(vinho2, 5, 3);
        adega.addAleatorio(vinho3);


        System.out.println("Quantidade de dias (Vinho 1): "+vinho1.getDataDias());
        // System.out.println("Quantidade de dias: "+vinho2.getDataDias());
        // System.out.println("Quantidade de dias: "+vinho3.getDataDias());
        System.out.println("Quantidade de Vinhos Brancos: " + adega.getQuantidadeTipo("branco"));
        System.out.println("Quantidade de Vinhos Tintos: " + adega.getQuantidadeTipo("tinto"));
        System.out.println("Quantidade Total: " + adega.getQuantidadeTotal());
        System.out.println("Valor Agregado: R$" + adega.getValorAgregado());

        //Adega.Posicao pos = new Adega.Posicao(0,0); isso apenas se a classe Posicao() for static
    }
}