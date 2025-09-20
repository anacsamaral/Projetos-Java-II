import javax.swing.*;

public class Questionario
{
    private IQuestao[] questoes;
    private int tl;

    public Questionario(int qt) {
        questoes = new IQuestao[qt];
        tl = 0;
    }

    public void adicionarQuestao(IQuestao q) {
        questoes[tl++] = q;
    }

    public void responderQuestoes() {
        for (int i = 0; i < tl; i++) {
            questoes[i].setResposta(JOptionPane.showInputDialog
                    (null, questoes[i].getPergunta()));
        }
    }

    public void corrigirQuestoes() {
        int nota = 0;
        for (int i = 0; i < tl; i++) {
            if (questoes[i].estaCorreta())
                nota += questoes[i].getPontos();
        }
        JOptionPane.showMessageDialog(null, "Sua nota " + nota);
    }
}
