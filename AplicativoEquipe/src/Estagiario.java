public class Estagiario extends Trabalhador{
    private int contrato;

    public Estagiario(String nome, int horaTrab, int contrato) {
        super(nome, horaTrab);
        this.contrato = contrato;
    }

    public Estagiario(int contrato) {
        super();
        this.contrato = contrato;
    }

    @Override
    public double getSalario() {
        return 500;
    }
}
