package hr.obskc.niop.voznipark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class VozniPark {

    private List<Vozilo> vozila;

    public VozniPark() {
        vozila = new ArrayList<>();
    }

    public void dodajVozilo(Vozilo vozilo) {
        vozila.add(vozilo);
    }

    public void prikaziSvaVozila() {
        vozila.forEach(System.out::println);
        // vozila.forEach(vozilo -> System.out.println(vozilo));
    }

    public List<Vozilo> pretraziPoTipu(String tip) {
        return vozila.stream()
                .filter(vozilo -> vozilo.getTip().equalsIgnoreCase(tip))
                .collect(Collectors.toList());
    }

    public List<Vozilo> filtrirajPoStanju(Stanje stanje) {
        return vozila.stream()
                .filter(vozilo -> vozilo.getStanje() == stanje)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        VozniPark vozniPark = new VozniPark();

        vozniPark.dodajVozilo(new Automobil("Toyota", "Corolla", 2020, Stanje.NOVO));
        vozniPark.dodajVozilo(new Kamion("MAN", "TGX", 2018, Stanje.RABLJENO));
        vozniPark.dodajVozilo(new Motocikl("Yamaha", "R1", 2021, Stanje.NOVO));
        vozniPark.dodajVozilo(new Automobil("Ford", "Fiesta", 2015, Stanje.OSTECENO));

        System.out.println("Sva vozila u voznom parku:");
        vozniPark.prikaziSvaVozila();

        System.out.println("Pretraživanje po tipu (Automobili):");
        List<Vozilo> automobili = vozniPark.pretraziPoTipu("Automobil");
        automobili.forEach(System.out::println);

        System.out.println("Filtriranje po stanju (NOVO):");
        List<Vozilo> novi = vozniPark.filtrirajPoStanju(Stanje.NOVO);
        novi.forEach(System.out::println);
    }
}
