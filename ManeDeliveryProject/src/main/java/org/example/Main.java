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
            PedidoDAL dal=new PedidoDAL();
            Pedido pedido=dal.get(1);
            pedido.setNomeCliente("Clotilda Nunes");
            dal.alterar(pedido);
        }
        else
            System.out.println("Erro ao conectar o banco "+SingletonDB.getConexao().getMensagemErro());
    }
}