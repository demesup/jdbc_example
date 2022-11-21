package org.example;

import org.example.utils.DBWorker;
import org.example.utils.Trip;

import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetExample {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from trip where name is not null and city is not null and per_diem is not null;";
        try {
            Statement statement = worker.getConnection().createStatement();
            var result = statement.executeQuery(query);

            while (result.next()){
                Trip trip = new Trip(
                        result.getInt("trip_id"),
                        result.getString("name"),
                        result.getString("city"),
                        Float.parseFloat(result.getString("per_diem")));

                System.out.println(trip);
                statement.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
