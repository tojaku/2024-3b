package hr.obskc.niop.placanja;

public class OnlinePlacanje implements MetodaPlacanja {

    @Override
    public void izvrsiPlacanje(double iznos) {
        System.out.println("Molimo, uplatite na naš IBAN iznos od " + iznos + " EUR.");
    }

    @Override
    public String opisMetode() {
        return "Online";
    }  
}
