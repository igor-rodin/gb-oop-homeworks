package hw2.pets.cats;

import hw2.pets.PetAnimal;

public class PetCat extends PetAnimal implements Cat {

    public PetCat(String petName) {
        super(petName);
    }

    @Override
    public void pet(String message) {
        System.out.println("Мур-мур...., еще");

    }

    @Override
    public void makeVoice() {
        System.out.println("Мяу-Мяу");
    }
}
