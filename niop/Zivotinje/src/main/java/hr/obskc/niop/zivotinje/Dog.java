package hr.obskc.niop.zivotinje;

public class Dog extends Animal implements Movable {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says: Woof!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is running.");
    }
    
}
