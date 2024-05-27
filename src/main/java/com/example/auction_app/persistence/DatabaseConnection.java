package com.example.auction_app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/auction_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection instance;

    private DatabaseConnection() {
        // Constructor privat pentru a face clasa Singleton
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null || instance.isClosed()) {
            synchronized (DatabaseConnection.class) {
                if (instance == null || instance.isClosed()) {
                    instance = DriverManager.getConnection(URL, USER, PASSWORD);
                }
            }
        }
        return instance;
    }
}
