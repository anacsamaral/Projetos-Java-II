import java.time.LocalDate;
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
    public static class Posicao {
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
        if(!isCheia && !posicoesLivres.isEmpty()){
            Posicao posicaoSorteada = posicoesLivres.get((int)(Math.random() * posicoesLivres.size()));
            vinhos[posicaoSorteada.getLinha()][posicaoSorteada.getColuna()] = vinho;
            quantidadeGarrafas++;
            valorTotal += vinho.getValor();
        }
    }

    // c) Obter a quantidade de vinhos (por tipo) que estão na adega;
    public int getQuantidadeTipo(String tipo){
        int cont = 0;
        for(int i = 0; i < vinhos.length; i++){
            for(int j = 0; j < vinhos[i].length; j++){
                if(vinhos[i][j] != null){
                    if(vinhos[i][j].getTipo().equalsIgnoreCase(tipo)){ // se chamar um objeto nulo, da erro
                        cont++;
                    }
                }
            }
        }
        return  cont;
    }

    // f) Obter o vinho mais antigo da adega (menor data de fabricação);
    public Vinho getVinhoMaisAntigo(){
        if(quantidadeGarrafas == 0){
            return null;
        }

        Vinho maisAntigo = null;
        LocalDate dataMaisAntiga = LocalDate.MAX;

        for (int i = 0; i < vinhos.length; i++) {
            for (int j = 0; j < vinhos[i].length; j++) {
                if(vinhos[i][j] != null){
                    LocalDate dataAtual = vinhos[i][j].getData();
                    if(dataAtual.isBefore(dataMaisAntiga)){
                        dataMaisAntiga = dataAtual;
                        maisAntigo = vinhos[i][j];
                    }
                }
            }
        }
        return maisAntigo;
    }

    // g) Retirar um determinado vinho, de acordo com sua localização.
    public Vinho retirarVinho(int fila, int col){
        if(fila >= 0 && fila < vinhos.length && col >= 0 && col < vinhos[fila].length){
            if(vinhos[fila][col] != null) {
                Vinho vinhoRemovido = vinhos[fila][col];
                vinhos[fila][col] = null;
                quantidadeGarrafas--;
                valorTotal -= vinhoRemovido.getValor();
                return vinhoRemovido;
            }
        }
        return null;
    }

    // d) Obter a quantidade de garrafas cadastradas na adega;
    public int getQuantidadeGarrafas() {
        return quantidadeGarrafas;
    }

    // e) Obter o valor agregado da adega (somatório dos vinhos);
    public double getValorAgregado() {
        return valorTotal;
    }

    @Override
    public String toString(){
        String str = "Adega - " + quantidadeGarrafas + "/200 garrafas\n";
        str += "Valor total: R$" + String.format("%.2f", valorTotal) + "\n";

        for(int i = 0; i < vinhos.length; i++){
            for(int j = 0; j < vinhos[i].length; j++){
                str += (vinhos[i][j] == null) ? "." : "X";
            }
            str += "\n";
        }
        return str;
    }
}
