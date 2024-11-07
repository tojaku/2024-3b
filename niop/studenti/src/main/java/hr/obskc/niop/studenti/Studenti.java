package hr.obskc.niop.studenti;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Studenti {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studenti = new ArrayList<>();

        System.out.println("Koliko studenata želite unijeti?");
        int brojStudenata = 0;
        try {
            brojStudenata = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Pogrešan unos! Dopušten unos cijelih brojeva!");
            return;
        }

        for (int i = 0; i < brojStudenata; i++) {
            System.out.println("Unesite podatke za studenta " + (i + 1));
            System.out.print("Ime: ");
            String ime = scanner.nextLine();
            System.out.print("Prezime: ");
            String prezime = scanner.nextLine();
            int godinaStudija = 0;
            double prosjekOcjena = 0.0;
            try {
                System.out.print("Godina studija: ");
                godinaStudija = scanner.nextInt();
                System.out.print("Prosjek ocjena: ");
                prosjekOcjena = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Pogrešan unos! Dopušten unos brojeva!");
                scanner.nextLine();
                i--;
                continue;
            }
            
            try {
                Student student = new Student(ime, prezime, godinaStudija, prosjekOcjena);
                studenti.add(student);
            } catch (Exception ex) {
                System.out.println("Pogrešan unos! Godina studija i/ili prosjek ocjena moraju biti u ispravnom obliku!");
                scanner.nextLine();
                i--;
                continue;
            }
        }
        
        System.out.println("Podaci o unesenim studentima");
        for (Student s : studenti) {
            s.ispisiPodatke();
            System.out.println("");
        }
        
        scanner.close();
    }
}
