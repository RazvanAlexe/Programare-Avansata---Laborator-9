package app;

import java.sql.*;
import java.sql.DriverManager;

public class Database {

    private static Database database;
    private Connection connection;

    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "student");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
