package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/acervo_db","postgres","postgres123");
            connection.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}