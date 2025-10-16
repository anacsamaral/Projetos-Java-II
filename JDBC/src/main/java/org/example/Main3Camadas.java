package org.example;
import java.sql.ResultSet;
import java.util.List;


public class Main3Camadas {
    public static void main(String[] args) {
        if(!SingletonDB.conectar()){
            System.out.println(SingletonDB.getConexao().getMensagemErro());
        }
        CategoriaDal dal=new CategoriaDal();
        //Categoria categoria=new Categoria("fantasia");

        //if(!dal.gravar(categoria))
        //    System.out.println("Erro ao gravar");

        Categoria categoria=dal.get(6);
        dal.apagar(categoria);
        //categoria.setNome(categoria.getNome().toUpperCase());
        //dal.alterar(categoria);
        List<Categoria> categoriaList = dal.get("");
        for(Categoria c : categoriaList)
            System.out.println(c.getNome());
    }
}