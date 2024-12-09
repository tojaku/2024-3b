package hr.obskc.niop.zivotinje;

public class Clam extends Animal {

    public Clam(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says: Bloop!");
    }

}
