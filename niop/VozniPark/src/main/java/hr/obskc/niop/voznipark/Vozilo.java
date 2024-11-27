package hr.obskc.niop.voznipark;

enum Stanje {
    NOVO,
    RABLJENO,
    OSTECENO
}

abstract class Vozilo {

    private String marka;
    private String model;
    private int godinaProizvodnje;
    private Stanje stanje;

    public Vozilo(String marka, String model, int godinaProizvodnje, Stanje stanje) {
        this.marka = marka;
        this.model = model;
        this.godinaProizvodnje = godinaProizvodnje;
        this.stanje = stanje;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public Stanje getStanje() {
        return stanje;
    }

    public abstract String getTip();

    @Override
    public String toString() {
        return String.format("Tip: %s, Marka: %s, Model: %s, Godina: %s, Stanje: %s",
                getTip(), marka, model, godinaProizvodnje, stanje);
    }

}