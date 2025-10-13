package org.example;

import java.sql.ResultSet;

public class Main3Camadas {
    SingletonDB.conectar();
    public static void main(String[] args) {
        CategoriaDal dal = new CategoriaDal();
        Categoria categoria = new Categoria("Fantasia");
        if(!dal.gravar(categoria))
            System.out.println("Erro ao Gravar");
    }
}