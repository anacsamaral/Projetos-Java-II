package org.example;

public class SingletonDB {
    private static Conexao conexao = null;
    public static boolean conectar(){
        return conexao.conectar("jdbc:postgresql://localhost:5433/","acervo_db","postgres", "postgres123");
    }

    public static Conexao getConexao(){
        return conexao;
    }

    // inibe a instância
    private SingletonDB(){

    }

}
