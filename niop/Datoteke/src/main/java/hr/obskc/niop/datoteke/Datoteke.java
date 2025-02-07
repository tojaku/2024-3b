package hr.obskc.niop.datoteke;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Datoteke {

    private static String imeTxtDatoteke = "primjer.txt";
    private static String imeBinDatoteke = "primjer.dat";

    public static void main(String[] args) {
        pisiTekst();
        citajTekst();
        pisiBinarno();
        citajBinarno();
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
            while((bajt = fis.read()) != -1) {
                System.out.println("Pročitano (1): " + bajt);
                System.out.println("Pročitano (2): " + (char) bajt);
            }
        } catch (Exception e) {
            System.err.println("Dogodila se greška!");
        }
    }
}
