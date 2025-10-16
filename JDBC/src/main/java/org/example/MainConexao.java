package org.example;

import java.sql.*;

public class MainConexao {
    public static void main(String[] args) {
        Conexao conexao=new Conexao();
        if(!conexao.conectar("jdbc:postgresql://localhost:5432/","acervo_db","postgres","postgres123")) {
            System.out.println("Prolemas na conexao "+conexao.getMensagemErro());
        }
        else{
            String sql="INSERT INTO categoria (ca_nome) VALUES ('drama')";
            if(!conexao.manipular(sql))
                System.out.println("Erro...."+conexao.getMensagemErro());
            sql="SELECT * FROM categoria";
            ResultSet resultSet=conexao.consultar(sql);
            try {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("ca_nome"));
                }
            }catch (Exception e){
                System.out.println("Erro "+e);
            }
        }

    }
}