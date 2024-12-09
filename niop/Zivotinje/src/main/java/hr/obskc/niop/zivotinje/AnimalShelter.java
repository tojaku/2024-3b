package hr.obskc.niop.zivotinje;

import java.util.ArrayList;

public class AnimalShelter {

    private ArrayList<Animal> animals;

    public AnimalShelter() {
        animals = new ArrayList<>();
    }
    
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the shelter.");
            return;
        }

        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge());
            animal.sound();
        }
    }

    public Animal findAnimalByName(String name) throws Exception {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }

        throw new Exception("Animal with name " + name + " not found.");
    }

}
