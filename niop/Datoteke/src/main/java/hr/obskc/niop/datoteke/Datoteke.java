package hr.obskc.niop.datoteke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Datoteke {

    private static String imeTxtDatoteke = "primjer.txt";
    private static String imeBinDatoteke = "primjer.dat";
    private static String imeDatotekeZaKnjige = "knjige.txt";
    private static String delimiter = "#";
    private static String imeDatotekeSerijalizacija = "serij.dat";

    public static void main(String[] args) {
        //pisiTekst();
        //citajTekst();
        //pisiBinarno();
        //citajBinarno();

        List<Book> books = Arrays.asList(
                new Book("Smrt Smail-age Čengića", "Ivan Mažuranić", "12345ABC"),
                new Book("Zločin i kazna", "Fjodor Mihajlovič Dostojevski", "45632DFE"),
                new Book("Zelena milja", "Stephen King", "62786HSJ"),
                new Book("Pinokio", "Carlo Collodi", "92383KJH")
        );
        //spremiKnjige(books);
        //ucitajKnjige();
        serijalizirajKnjige(books);
        List<Book> rebooks = deserijalizirajKnjige();
        System.out.println("Pročitane knjige:");
        for (Book rebook : rebooks) {
            System.out.println("- " + rebook.toString());
        }
    }

    public static void serijalizirajKnjige(List<Book> db) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Datoteke.imeDatotekeSerijalizacija))) {
            oos.writeObject(db);
            System.out.println("Knjige spremljene!");
        } catch (IOException e) {
            System.err.println("Dogodila se greška!");
        }
    }
    
    public static List<Book> deserijalizirajKnjige() {
        List<Book> db = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Datoteke.imeDatotekeSerijalizacija))) {
            db = (List<Book>) ois.readObject();
            System.out.println("Knjige učitane!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Dogodila se greška!");
        }
        return db;
    }

    public static void spremiKnjige(List<Book> db) {
        try {
            FileWriter fw = new FileWriter(Datoteke.imeDatotekeZaKnjige);
            BufferedWriter writer = new BufferedWriter(fw);
            for (Book book : db) {
                String line = book.getTitle() + Datoteke.delimiter + book.getAuthor()
                        + Datoteke.delimiter + book.getIsbn();
                System.out.println("Pišem liniju: " + line);
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            System.err.println("Dogodila se greška!");
        }
    }

    public static List<Book> ucitajKnjige() {
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(Datoteke.imeDatotekeZaKnjige))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(Datoteke.delimiter);
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    String isbn = parts[2];
                    Book newBook = new Book(title, author, isbn);
                    System.out.println("Pronađena knjiga: " + newBook.toString());
                    books.add(newBook);
                }
            }
        } catch (IOException e) {
            System.err.println("Dogodila se greška!");
        }
        return books;
    }

    public static void pisiTekst() {
        try {
            FileWriter fw = new FileWriter(Datoteke.imeTxtDatoteke);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("Dobar dan, svijete!");
            writer.newLine();
            writer.write("Moje ime je Tomislav!");
            writer.close();
        } catch (Exception e) {
            System.err.println("Dogodila se greška!");
        }
    }

    public static void citajTekst() {
        try {
            FileReader fr = new FileReader(Datoteke.imeTxtDatoteke);
            BufferedReader reader = new BufferedReader(fr);
            String linija;
            while ((linija = reader.readLine()) != null) {
                System.out.println(linija);
            }
        } catch (Exception e) {
            System.err.println("Dogodila se greška!");
        }
    }

    public static void pisiBinarno() {
        byte[] podaci = {65, 66, 67, 68, -128, -127, -100};
        try {
            FileOutputStream fos = new FileOutputStream(imeBinDatoteke);
            fos.write(podaci);
        } catch (FileNotFoundException ex) {
            System.err.println("Datoteka ne postoji!");
        } catch (IOException ex) {
            System.err.println("Problem kod upisa u datoteku!");
        }
    }

    public static void citajBinarno() {
        try {
            FileInputStream fis = new FileInputStream(imeBinDatoteke);
            int bajt;
            while ((bajt = fis.read()) != -1) {
                System.out.println("Pročitano (1): " + bajt);
                System.out.println("Pročitano (2): " + (char) bajt);
            }
        } catch (Exception e) {
            System.err.println("Dogodila se greška!");
        }
    }
}
