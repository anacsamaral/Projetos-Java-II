package org.example.db.util;

public class SingletonDB {
    private static Conexao conexao=null;
    private SingletonDB(){
        //impede a instancia da classe
    }
    public static boolean conectar(){
        conexao=new Conexao();
        return conexao.conectar("jdbc:postgresql://localhost:5433/","delivery_db","postgres","postgres123");
    }

    public static Conexao getConexao() {
        return conexao;
    }
}
