package hr.obskc.niop.gui_test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tag {
    private final String name;
    private final Date date;

    public Tag(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("Oznaka: %s, datum: %s", name, sdf.format(date));
    }
    
    
    
}
