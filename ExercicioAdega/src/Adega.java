public class Adega {
    private Vinho[][] vinhos;

    public Adega(){
        vinhos = new Vinho[20][10];
    }
    public boolean add(Vinho vinho, int fila, int col){
        if(fila >= 0  && fila < vinhos.length && col >= 0 && col < vinhos[fila].length){
            // uma matriz de objeto fica instanciada com null
            if(vinhos[fila][col] == null){
                vinhos[fila][col] = vinho;
                return true;
            }
        }
        return false;
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
}
