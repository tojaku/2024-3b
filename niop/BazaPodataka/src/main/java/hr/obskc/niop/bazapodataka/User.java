package hr.obskc.niop.bazapodataka;

import java.sql.Connection;

public class User {

    private int id;
    private String email;
    private String name;

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    
    public static User register(String email, String password, String name) {
        Connection conn = Database.getInstance().getConnection();
        
        return null;
    }

}
