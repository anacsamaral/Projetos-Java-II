public class Adega {
    private Vinho[][] vinhos;
    private int quantidadeGarrafas;
    private double valorTotal;

    public Adega(){
        vinhos = new Vinho[20][10];
        quantidadeGarrafas = 0;
        valorTotal = 0.0;
    }

    // colocar o vinho numa posição específica
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

    // colocar o vinho numa posição qualquer
    public boolean addAleatorio(Vinho vinho) {
        if (isCheia()) {
            return false;
        }

        List posicoesLivres = getPosicoesLivres();
        if (posicoesLivres.isEmpty()) {
            return false;
        }

        Random random = new Random();
        int indiceAleatorio = random.nextInt(posicoesLivres.size());
        int[] posicao = posicoesLivres.get(indiceAleatorio);

        return add(vinho, posicao[0], posicao[1]);
    }

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
    // para remover um vinho da posicao, jogar null no valor da posicao dele
    // guardar as posicoes livres e sortear uma delas

    // quantidade total
    public int getQuantidadeTotal() {
        return quantidadeGarrafas;
    }

    // valor agregado
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
