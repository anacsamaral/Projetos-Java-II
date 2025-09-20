public class QMatematica implements IQuestao{
    private String pergunta;
    private int valor, resposta, correta;

    public QMatematica(String pergunta, int correta)
    { this.pergunta=pergunta; this.correta=correta; }

    @Override
    public String getPergunta() {
        return pergunta;
    }

    @Override
    public String getResposta() {
        return ""+resposta;
    }

    @Override
    public void setResposta(String resp) {
        this.resposta=Integer.parseInt(resp);
    }

    @Override
    public boolean estaCorreta() {
        if(resposta==correta) {
            valor=10;  return SIM; }
        else { valor=0; return NAO; }
    }

    @Override
    public int getPontos() {
        return valor;
    }
}
