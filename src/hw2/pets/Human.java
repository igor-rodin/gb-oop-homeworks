package hw2.pets;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String fullName;
    private List<PetAnimal> pets;

    public Human(String fullName) {
        this.fullName = fullName;
        pets = new ArrayList<>();
    }

    public List<PetAnimal> getPets() {
        return pets;
    }

    public void addPet(PetAnimal animal) {
        if (animal != null) {
            pets.add(animal);
        }
    }

    public void petAnimal(PetAnimal animal, String petMessage) {
        animal.pet(petMessage);
    }

    public void giveAportCommand(PetAnimal animal, String item) {
        System.out.printf("%s, принеси %s\n", animal, item);
        animal.aport(item);
    }

    @Override
    public String toString() {
        return fullName;
    }
}
