package hr.obskc.niop.bazapodataka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance;

    private final String url = "jdbc:sqlite:mydb.db";
    private Connection connection = null;

    private Database() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.err.println("Greška prilikom spajanja na bazu podataka!");
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    

}
