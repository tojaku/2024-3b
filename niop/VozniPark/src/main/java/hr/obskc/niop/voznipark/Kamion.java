package hr.obskc.niop.voznipark;

class Kamion extends Vozilo {

    public Kamion(String marka, String model, int godinaProizvodnje, Stanje stanje) {
        super(marka, model, godinaProizvodnje, stanje);
    }

    @Override
    public String getTip() {
        return "Kamion";
    }

}
