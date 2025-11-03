package org.example;


import org.example.db.dals.PedidoDAL;
import org.example.db.dals.ProdutoDAL;

import org.example.db.entidades.Pedido;
import org.example.db.entidades.Produto;
import org.example.db.util.SingletonDB;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (SingletonDB.conectar()) {
//            CategoriaDAL dal=new CategoriaDAL();
//            List<Categoria> categoriaList=dal.get("");
//            for(Categoria categoria : categoriaList)
//                System.out.println(categoria.getNome());
//            ProdutoDAL dal=new ProdutoDAL();
//            List<Produto>produtoList=dal.get("");
//            for(Produto produto : produtoList)
//                System.out.println(produto.getNome()+" "+produto.getCategoria().getNome());
            PedidoDAL dal=new PedidoDAL();
            //List <Pedido> pedidos=dal.get("");
            //System.out.println(pedidos);

            //pedido.setNomeCliente("Antonyn Sebastiani");
            //dal.gravar(pedido);
            Pedido pedido=dal.get(1);
            pedido.setNomeCliente("Clotilda Nunes");
            dal.alterar(pedido);
        }
        else
            System.out.println("Erro ao conectar o banco "+SingletonDB.getConexao().getMensagemErro());
    }
}