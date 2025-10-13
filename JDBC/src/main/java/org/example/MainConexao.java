package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        if(!conexao.conectar("jdbc:postgresql://localhost:5433/","acervo_db","postgres", "postgres123")){
            System.out.println("Problemas de Conexão: " + conexao.getMensagemErro());
        }
        else {
            String sql = "INSERT INTO categoria (ca_nome) VALUES ('drama')";
            if(conexao.manipular(sql))
                System.out.println("Erro: " + conexao.getMensagemErro());

            sql = "SELECT * FROM categoria";
            ResultSet resultSet = conexao.consultar(sql);
            try {
                while(resultSet.next()){
                    System.out.println("ca_nome");
                }
            } catch (Exception e){
                System.out.println("Erro: " + e);
            }

        }
    }
}