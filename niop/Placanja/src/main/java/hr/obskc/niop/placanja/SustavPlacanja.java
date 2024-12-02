package hr.obskc.niop.placanja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SustavPlacanja {
    private List<MetodaPlacanja> metode;
    
    public SustavPlacanja() {
        metode = new ArrayList<>();
    }
    
    public void dodajMetodu(MetodaPlacanja metoda) {
        metode.add(metoda);
    }
    
    public void prikaziMetode() {
        if (metode.isEmpty()) {
            System.out.println("Nema dostupnih metoda plaćanja.");
        } else {
            System.out.println("Dostupne metode plaćanja:");
            metode.forEach(metoda -> System.out.println("- " + metoda.opisMetode()));
        }
    }
    
    public void procesirajPlacanje(String odabranaMetoda, double iznos) {
        Optional<MetodaPlacanja> metoda = metode.stream()
                .filter(m -> m.opisMetode().equalsIgnoreCase(odabranaMetoda))
                .findFirst();
        
        if (metoda.isPresent()) {
            metoda.get().izvrsiPlacanje(iznos);
        } else {
            throw new IllegalArgumentException("Metoda plaćanja koju ste odabrali ne postoji.");
        }
    }
}
