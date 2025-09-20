public interface IQuestao {
    public static boolean SIM=true;
    public static boolean NAO=false;

    public String getPergunta();
    public String getResposta();
    public void setResposta(String resp);
    public boolean estaCorreta();
    public int getPontos();
}
