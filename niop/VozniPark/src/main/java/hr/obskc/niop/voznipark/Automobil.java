package hr.obskc.niop.voznipark;

class Automobil extends Vozilo {

    public Automobil(String marka, String model, int godinaProizvodnje, Stanje stanje) {
        super(marka, model, godinaProizvodnje, stanje);
    }

    @Override
    public String getTip() {
        return "Automobil";
    }

}
