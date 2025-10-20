package org.example;

import org.example.db.dals.ProdutoDAL;
import org.example.db.entidades.Produto;
import org.example.db.util.SingletonDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SingletonDB.conectar();
        ProdutoDAL dal = new ProdutoDAL();
        List<Produto> produtoList;
    }
}
 // só faz DAL para classes que não possuem FKs
