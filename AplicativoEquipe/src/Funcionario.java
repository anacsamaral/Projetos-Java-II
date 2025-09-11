public class Funcionario {
    private int ctps;
    private String nome;
    private int horasTrab;
    private double valorHora;
    // se trocar private para protected, libera o acesso para subclasse, porém pode ocorrer violação apesar de válida

//    public Funcionario(){ -> construtor vazio
//        this(0,"",0,0);
//    }
    public Funcionario(int ctps, String nome, int horasTrab, double valorHora) {
        this.ctps = ctps;
        this.nome = nome;
        this.horasTrab = horasTrab;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    // métodos
    public double getSalario(){
        return horasTrab * valorHora;
    }
}
