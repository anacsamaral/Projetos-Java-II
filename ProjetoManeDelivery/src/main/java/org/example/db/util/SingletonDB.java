package org.example.db.util;

public class SingletonDB {
    private static Conexao conexao=null;
    public static boolean conectar(){
        conexao=new Conexao();
        return conexao.conectar("jdbc:postgresql://localhost:5433/","delivery_db","postgres","postgres123");
    }
    public static Conexao getConexao() {
        return conexao;
    }
    // inibe a instância de SingletonDB
    private SingletonDB() {
    }
}