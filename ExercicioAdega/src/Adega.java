import java.util.ArrayList;
import java.util.List;

public class Adega {

    // Record
    /*private record Posicao(int linha, int coluna){}
    private Vinho[][] vinho;
    public Adega(){
        vinho = new Vinho[20][10];
    }*/

    // Inner Class
    public class Posicao {
        private int linha, coluna;

        public Posicao(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        public int getLinha() {
            return linha;
        }

        public int getColuna() {
            return coluna;
        }
    }


    private Vinho[][] vinhos;
    private int quantidadeGarrafas;
    private double valorTotal;

    public Adega(){
        vinhos = new Vinho[20][10];
        quantidadeGarrafas = 0;
        valorTotal = 0.0;
    }

    // a) Incluir uma garrafa na adega, dada a posição;
    public boolean add(Vinho vinho, int fila, int col){
        if(fila >= 0  && fila < vinhos.length && col >= 0 && col < vinhos[fila].length){

            // uma matriz de objeto fica instanciada com null
            if(vinhos[fila][col] == null){
                vinhos[fila][col] = vinho;
                quantidadeGarrafas++;
                valorTotal += vinho.getValor();
                return true;
            }
        }
        return false;
    }

    // b) Incluir uma garrafa na adega, em uma posição aleatória;
    public void addAleatorio(Vinho vinho) {
        boolean isCheia = true;
        List <Posicao> posicoesLivres = new ArrayList<>();
        for (int i = 0; i < vinhos.length; i++) {
            for (int j = 0; j < vinhos[i].length; j++) {
                if(vinhos[i][j] == null) {
                    posicoesLivres.add(new Posicao(i,j));
                    isCheia = false;
                }
            }
        }
        // o mét. de acesso "get" retorna um valor inteiro, então precisa convertê-lo para int
        if(!isCheia){
            Posicao posicaoSorteada = posicoesLivres.get((int)(Math.random() * posicoesLivres.size()));
            vinhos[posicaoSorteada.getLinha()][posicaoSorteada.getColuna()] = vinho;
        }
    }

    // c) Obter a quantidade de vinhos (por tipo) que estão na adega;
    public int getQuantidadeTipo(String tipo){
        int cont = 0;
        for(int i = 0; i < vinhos.length; i++){
            for(int j = 0; j < vinhos[i].length; j++){
                if(vinhos[i][j] != null){
                    if(vinhos[i][j].getTipo().equals(tipo.toLowerCase())){ // se chamar um objeto nulo, da erro
                        cont++;
                    }
                }
            }
        }
        return  cont;
    }

    // f) Obter o vinho mais antigo da adega (menor data de fabricação);
    public 

    // para remover um vinho da posicao, jogar null no valor da posicao dele
    // guardar as posicoes livres e sortear uma delas

    // d) Obter a quantidade de garrafas cadastradas na adega;
    public int getQuantidadeTotal() {
        return quantidadeGarrafas;
    }

    // e) Obter o valor agregado da adega (somatório dos vinhos);
    public double getValorAgregado() {
        return valorTotal;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < vinhos.length; i++){
            for(int j = 0; j < vinhos[i].length; j++){
                str += (vinhos[i][j] == null)?".":"X";
            }
            str+="\n";
        }
        return str;
    }
}
