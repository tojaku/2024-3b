package hr.obskc.niop.placanja;

import java.util.Scanner;

public class Placanja {

    public static void main(String[] args) {
        SustavPlacanja sustav = new SustavPlacanja();
        
        sustav.dodajMetodu(new Gotovina());
        sustav.dodajMetodu(new Kartica());
        sustav.dodajMetodu(new OnlinePlacanje());
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Odaberite opciju:");
            System.out.println("1. Prikaži dostupne metode plaćanja");
            System.out.println("2. Procesiraj plaćanje");
            System.out.println("3. Izlaz");
            
            int opcija = scanner.nextInt();
            
            if (opcija == 3) {
                System.out.println("Hvala na korištenju.");
                break;
            }
            
            switch (opcija) {
                case 1 -> sustav.prikaziMetode();
                case 2 -> {
                    System.out.println("Odaberite metodu plaćanja (gotovina, kartica ili online).");
                    scanner.nextLine();
                    String odabranaMetoda = scanner.nextLine();
                    System.out.print("Unesite iznos za plaćanje: ");
                    double iznos = scanner.nextDouble();
                    
                    try {
                        sustav.procesirajPlacanje(odabranaMetoda, iznos);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Dogodila se greška: " + e.getMessage());
                    }
                }
                default -> System.out.println("Nepoznata opcija, pokušajte ponovno.");
            }
        }
        
        scanner.close();
    }
}
