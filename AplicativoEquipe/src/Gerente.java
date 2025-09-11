public class Gerente extends Funcionario {
    private double adicional;

    public Gerente(int ctps, String nome, int horasTrab, double valorHora, double adicional){
        super(ctps,nome,horasTrab,valorHora);
        this.adicional = adicional;
    }

    public Gerente() {
        super();
        adicional = 0;
    }

    public double getAdicional(){
        return adicional;
    }

    public void setAdicional(double adicional){
        this.adicional = adicional;
    }

    @Override // sinaliza que quer fazer um Override, se não tiver ele não considera
    public double getSalario(){
        //return (getHorasTrab() * getValorHora()) * (1 + (adicional/100));
        return super.getSalario() * (1 + (adicional/100));
        // se tirar o 'super', ele vai acabar chamando o próprio getSalario de Gerente, ou seja, entrará em um metodo recursivo
    }
}
