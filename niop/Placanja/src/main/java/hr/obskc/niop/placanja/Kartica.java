package hr.obskc.niop.placanja;

public class Kartica implements MetodaPlacanja {

    @Override
    public void izvrsiPlacanje(double iznos) {
        System.out.println("Vaša kartica terećena je za iznos " + iznos + " EUR.");
    }

    @Override
    public String opisMetode() {
        return "Kartica";
    }
    
}
