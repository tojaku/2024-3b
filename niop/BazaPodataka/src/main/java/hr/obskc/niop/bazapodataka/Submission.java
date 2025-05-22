package hr.obskc.niop.bazapodataka;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Submission {
    private long id;
    private String title;
    private String subject;
    private String teacher;
    private String time;
    private int grade;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    private long userId;
    
    public Submission(long id, String title, String subject, String teacher, String time, int grade, long userId) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.teacher = teacher;
        this.time = time;
        this.grade = grade;
        this.userId = userId;
    }
    
    public Submission(ResultSet result) {
        this.fillFromResultSet(result);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTime() {
        return time;
    }

    public int getGrade() {
        return grade;
    }

    public long getUserId() {
        return userId;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public void fillFromResultSet(ResultSet result) {
        try {
            this.id = result.getInt("id");
            this.title = result.getString("title");
            this.subject = result.getString("subject");
            this.teacher = result.getString("teacher");
            this.time = result.getString("time");
            this.grade = result.getInt("grade");
            this.userId = result.getInt("userId");
        } catch (SQLException ex) {
            System.err.println("Problem u dohvaćanju podataka prijave završnog rada.");
        }
    }

    @Override
    public String toString() {
        return String.format("Naslov: %s, Mentor: %s", this.title, this.teacher);
    }
    
    
   
}
