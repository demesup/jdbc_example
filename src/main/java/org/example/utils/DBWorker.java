package org.example.utils;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class DBWorker {
    private  final String url = "jdbc:mysql://localhost:3306/test_db";
    private  final String user = "root";
    private  final String password = "Js7vz92Jef7gv";

    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
