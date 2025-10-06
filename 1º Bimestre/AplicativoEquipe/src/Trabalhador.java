abstract public class Trabalhador {
    // classes abstratas não são instanciáveis
    private String nome;
    private int horaTrab;

    public Trabalhador(String nome, int horaTrab) {
        this.nome = nome;
        this.horaTrab = horaTrab;
    }

    public Trabalhador() {
        this("",0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoraTrab() {
        return horaTrab;
    }

    public void setHoraTrab(int horaTrab) {
        this.horaTrab = horaTrab;
    }

    abstract public double getSalario();
}
