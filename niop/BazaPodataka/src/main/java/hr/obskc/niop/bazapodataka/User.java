package hr.obskc.niop.bazapodataka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.RegexValidator;
import org.mindrot.jbcrypt.BCrypt;

public class User {

    private long id;
    private String email;
    private String name;

    public User() { }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public boolean register(String email, String password, String name) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(email)) {
            System.err.println("E-mail adresa nije u valjanom formatu!");
            return false;
        }

        RegexValidator passwordValidator = new RegexValidator("^.{6,}$");
        if (!passwordValidator.isValid(password)) {
            System.err.println("Zaporka nije u valjanom formatu!");
            return false;
        }

        RegexValidator nameValidator = new RegexValidator("^[A-Za-z ]{3,30}$");
        if (!nameValidator.isValid(name)) {
            System.err.println("Ime nije u valjanom formatu!");
            return false;
        }
        
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            Connection conn = Database.getInstance().getConnection();
            String query = "INSERT INTO users (email, password, name) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            long lastInsertId = 0;
            if (rs.next()) {
                lastInsertId = rs.getLong(1);
            }
            id = lastInsertId;
            this.email = email;
            this.name = name;
            return true;
        } catch (SQLException ex) {
            System.err.println("Greška prilikom spremanja novog korisnika u bazu!");
            return false;
        }
    }

}
