package hr.obskc.niop.placanja;

public class Gotovina implements MetodaPlacanja {

    @Override
    public void izvrsiPlacanje(double iznos) {
        System.out.println("Plaćanje u gotovini izvršeno. Iznos: " + iznos + " EUR.");
    }

    @Override
    public String opisMetode() {
        return "Gotovina";
    }
    
}
