import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vinho {
    private String tipo;
    private String marca;
    private int volume;
    private LocalDate data;
    private double valor; // Corrigido: era public, deve ser private

    // Construtores
    public Vinho(String tipo, String marca, int volume, LocalDate data, double valor){
        this.tipo = tipo;
        this.marca = marca;
        setVolume(volume);
        this.data = data;
        setValor(valor);
    }

    // Outros tipos de Construtores
    /*public Vinho(){
        this("tinto", "", 750, LocalDate.now(), 0);
    }

    public Vinho(String tipo, String marca, int volume){
        this(tipo, marca, volume, LocalDate.now(), 0);
    }*/

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() { // Corrigido: removido o 'x' que estava antes do return
        return valor;
    }

    public void setValor(double valor) {
        if(valor >= 0)
            this.valor = valor;
    }

    public long getDataDias(){
        return(Math.abs(data.until(LocalDate.now(), ChronoUnit.DAYS)));
    }

    @Override
    public String toString() {
        return "Vinho [ " +
                "tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", volume=" + volume + "ml" +
                ", data=" + data +
                ", valor=R$" + valor +
                ']';
    }
}