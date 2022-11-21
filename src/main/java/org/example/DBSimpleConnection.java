package org.example;

import java.sql.*;

public class DBSimpleConnection {
//connection to db without db window
    private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String user = "root";
    private static final String password = "Js7vz92Jef7gv";

    public static void main(String args[]) {
        String query = "select distinct city from trip";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            executeOneQuery(statement);

            ResultSet resultSet = statement.executeQuery("select * from trip;");

            executeSeveralQueries(statement);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeOneQuery(Statement statement) throws SQLException {
        int result = statement.executeUpdate("update trip set city = 'Hello' where trip_id = 2");
        System.out.println(result);
    }

    private static void executeSeveralQueries(Statement statement) throws SQLException {
        statement.addBatch("insert into trip(name, city) values ('name1','city1')");
        statement.addBatch("insert into trip(name, city) values ('name2','city2')");
        statement.addBatch("insert into trip(name, city) values ('name3','city3')");
        statement.executeBatch();
        statement.clearBatch();
    }
}