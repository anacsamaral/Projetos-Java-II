//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        QMatematica qm=new QMatematica("Quanto é 2+2", 4);

        Questionario questionario=new Questionario(3);
        questionario.adicionarQuestao(qm);
        questionario.adicionarQuestao(new QGeo());
        questionario.adicionarQuestao(new QHistoria());

        questionario.responderQuestoes();
        questionario.corrigirQuestoes();
    }
}