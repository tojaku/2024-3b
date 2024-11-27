package hr.obskc.niop.voznipark;

class Motocikl extends Vozilo {

    public Motocikl(String marka, String model, int godinaProizvodnje, Stanje stanje) {
        super(marka, model, godinaProizvodnje, stanje);
    }

    @Override
    public String getTip() {
        return "Motocikl";
    }

}
