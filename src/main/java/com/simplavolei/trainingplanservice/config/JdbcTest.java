package com.simplavolei.trainingplanservice.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/trainingdb";
        String username = "daniel23";
        String password = "admin";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection successful!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
