public class QGeo implements IQuestao
{   private String answer; private int value;
    public String getPergunta() {
        return "The Gobi Desert is located in... "; }
    public String getResposta() {
        return "Mongolia and China"; }
    public void setResposta(String resp) {
        this.answer=resp.toUpperCase();  }

    public boolean estaCorreta() {
        if(answer.equals("CHINA")||answer.equals("MONGOLIA")) {
            value=5;return SIM; }
       else
        if(answer.contains("CHINA")&& answer.contains("MONGOLIA"))
        { value=10; return SIM; }
         else return NAO;
    }
    public int getPontos() {
        return value;   }
}
