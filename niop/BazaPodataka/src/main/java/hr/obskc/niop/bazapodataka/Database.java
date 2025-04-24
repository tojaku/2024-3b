package hr.obskc.niop.bazapodataka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database _instance;

    private final String URL = "jdbc:sqlite:mydb.db";
    private Connection connection = null;

    private Database() {
        try {
            this.connection = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            System.err.println("Greška prilikom spajanja na bazu podataka!");
        }
    }

    public static Database getInstance() {
        if (_instance == null) {
            _instance = new Database();
        }
        return _instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    

}
