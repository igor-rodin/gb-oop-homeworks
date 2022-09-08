package hw2.pets;

import hw2.pets.cats.PetCat;
import hw2.pets.dogs.PetDog;
import hw2.pets.snakes.PetSnake;

public class Main {
    public static void main(String[] args) {
        Human master = new Human("Хозяин");
        master.addPet(new PetCat("Юлий"));

        master.addPet(new PetDog("Цезарь"));
        master.addPet(new PetSnake("Маугли"));

        for (var animal : master.getPets()) {
            master.callAnimal(animal, "Кис-кис...");
            master.feedAnimal(animal, "Еда");
            System.out.println();
        }
    }
}
