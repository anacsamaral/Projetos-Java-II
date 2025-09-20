public class QHistoria implements IQuestao {
    private String resp;
    private int pontos;
    public String getPergunta() { return "Quem descobriu o Brasil?"; }
    public String getResposta() { return "Pedro Alvares Cabral"; }
    public void setResposta(String resp) { this.resp=resp.toUpperCase(); }
    public boolean estaCorreta() {
        if(resp.equals("PEDRO ALVARES CABRAL")) {
            pontos=10;return SIM; }
        else if(resp.contains("CABRAL")) {
            pontos=5; return SIM; }
        else {pontos=0;return NAO;}
    }
    public int getPontos() { return pontos; }
}

