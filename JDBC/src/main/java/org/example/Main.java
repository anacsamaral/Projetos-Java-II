package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/acervo_db","postgres","postgres123");

            Statement statement = connection.createStatement(); // faz transação com o banco

            //String sql = "INSERT INTO categoria (ca_nome) VALUES ('drama')";
            //String sql = "DELETE FROM categoria WHERE ca_id = 5";
            //String sql = "UPDATE categoria SET ca_nome = 'adventure' WHERE ca_id = 1";


            //statement.execute(sql); // não serve para SELECT; retorna se deu certo ou não (boolean)
                                     // se deu DELETE e retornar true, mas nem sempre deletou alguma coisa
                                    // alterar, deletar algo que não existe, gera erro

            // if(statement.executeUpdate(sql) < 1) => retorna um inteiro, ou seja, se não achou algo para deletar, retorna zero
            // System.out.println("Ação não executada");

            String sql = "SELECT * FROM categoria";

            ResultSet resultset = statement.executeQuery(sql); // retorna um ResultSet
            // usa a forma navegacional para acessar as linhas
            // navega por ação, não é por índice

            while(resultset.next()){
                System.out.println(resultset.getString("ca_nome"));
            }
            statement.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}