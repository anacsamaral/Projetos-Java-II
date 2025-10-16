package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/acervo_db",
                    "postgres", "postgres123");
            Statement statement=connection.createStatement();
            //String sql="INSERT INTO categoria (ca_nome) VALUES ('drama')";
            //String sql="DELETE FROM categoria WHERE ca_id=5";
            //String sql="UPDATE categoria SET ca_nome='adventure' WHERE ca_id=1";

            //if(statement.executeUpdate(sql) < 1)
            //    System.out.println("Ação não executada");
            /* --------------------------------------------
            * não serve para SELECT; retorna se deu certo ou não (boolean)
            * se deu DELETE e retornar true, mas nem sempre deletou alguma coisa
            * alterar, deletar algo que não existe, gera erro
              --------------------------------------------- */

            String sql="SELECT * FROM categoria";
            ResultSet resultSet=statement.executeQuery(sql);
            // usa a forma navegacional para acessar as linhas
            // navega por ação, não é por índice

            while(resultSet.next()){
                System.out.println(resultSet.getString("ca_nome"));
            }
            statement.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("ERRROOOO:"+e.getMessage());
        }
    }
}