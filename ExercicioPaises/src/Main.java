import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pais br = new Pais("BRA", "Brasil", 200000000, 8200000);
        Pais arg = new Pais();

        arg.setCodIso("FRA");
        arg.setNome("França");
        arg.setPopulacao(8500000);
        arg.setDimensao(7500000);

        // Lista Dinâmica
        /* da pra definir qual tipo ela suporta*/
        List <Pais> paisesList = new ArrayList();
        paisesList.add(br);
        paisesList.add(arg);
        paisesList.add(new Pais("PY","Paraguay",150000000,22000000));
        paisesList.add(new Pais("CHI","Chile",250000000,28000000));
        paisesList.add(0, new Pais("COL","Colombia",38000000,18000000));
        // add = o brasil foi remanejado para frente, apos a colombia ser adicionada na posicao dele
        // set = colombia sobrepoe o brasil
        // addAll = adiciona a lista inteira
        // a lista aceita tudo, string, inteiro, isso não é bom, pois na hora de recuperar o objeto, retorna um objeto generico
        System.out.println("Temos "+paisesList.size()+" paises na lista");
        System.out.println("São eles:");

        //paisesList.clear(); // zera a lista
        //System.out.println(paisesList.contains(br)); // se contem o objeto na lista
        //System.out.println(paisesList.indexOf(br)); // posição do objeto na lista
        //paisesList.remove(br); // remove o objeto e remaneja a lista
        paisesList.sort(new Comparator<Pais>() {

            @Override
            public int compare(Pais o1, Pais o2) {
                return o1.getPopulacao()-o2.getPopulacao(); //populacao
                //return o1.getNome().compareTo(o2.getNome()); //nome
            }
        }); // ordena a lista

        // for tradicional
        /*for (int i = 0; i < paisesList.size(); i++) {
            System.out.println(paisesList.get(i).getNome()+" "+paisesList.get(i).getPopulacao());
        }*/

        // foreach
        for(Pais pais : paisesList){
            System.out.println(pais.getNome()+" "+pais.getPopulacao());
        }
        System.out.println();
        paisesList.forEach(pais -> {
            System.out.println(pais.getNome());
        });

        //System.out.println(br.getNome()+" tem densidade pop. de "+br.getDensidade()+" hab/km2");

        /*if(br.igual(arg))
            System.out.println("É o mesmo país.");
        else
            System.out.println("Países diferentes");*/

        // TESTANDO OS VIZINHOS
        br.addVizinho(arg);
        br.addVizinho(paisesList.get(0));
        br.addVizinho(paisesList.get(2));

        System.out.println(br.getVizinhos());
    }
}
