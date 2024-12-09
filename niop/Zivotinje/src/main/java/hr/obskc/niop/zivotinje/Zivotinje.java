package hr.obskc.niop.zivotinje;

public class Zivotinje {

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.addAnimal(new Dog("Ben", 3));
        shelter.addAnimal(new Dog("Luna", 6));
        shelter.addAnimal(new Cat("Miki", 10));
        shelter.addAnimal(new Cat("Fensi", 5));
        shelter.addAnimal(new Dog("Zlica", 8));
        shelter.addAnimal(new Dog("Bongo", 8));
        shelter.addAnimal(new Clam("Julio", 1));

        shelter.showAllAnimals();

        try {
            Animal foundAnimal = shelter.findAnimalByName("Julio");
            System.out.println("Found: " + foundAnimal.getName());
            foundAnimal.sound();

            if (foundAnimal instanceof Movable) {
                ((Movable) foundAnimal).move();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
