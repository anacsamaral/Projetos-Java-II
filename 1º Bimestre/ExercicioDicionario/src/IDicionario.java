public interface IDicionario {
    boolean inserir(Termo termo);
    String traduzir(String palavra);
    boolean remover(String palavra);
}