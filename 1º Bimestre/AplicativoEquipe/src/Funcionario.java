public class Funcionario extends Trabalhador{
    // se colocar 'final', a classe não pode ser herdada por outras classes, o mesmo funciona para metodos
    // é o mesmo que Funcionario extends Object
    private int ctps;
    private double valorHora;
    // se trocar private para protected, libera o acesso para subclasse, porém pode ocorrer violação apesar de válida
    // recomenda-se usar os gets e sets

    public Funcionario(){ // construtor vazio
        super("",0);
        ctps = 0;
        valorHora = 0;
    }
    public Funcionario(int ctps, String nome, int horasTrab, double valorHora) {
        super(nome,horasTrab);
        this.ctps = ctps;
        this.valorHora = valorHora;
    }

    public Funcionario(int ctps, String nome) {
        this(ctps,nome,0,0);
    }

    // getters e setters
    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    // métodos
    public double getSalario(){
        return getHoraTrab() * this.valorHora;
    }
}
