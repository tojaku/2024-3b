package hr.obskc.niop.zivotinje;

public class Cat extends Animal implements Movable {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says: Meow!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is jumping.");
    }

}
