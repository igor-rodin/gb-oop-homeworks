package hw2.pets.dogs;

import hw2.pets.PetAnimal;

public class PetDog extends PetAnimal implements Dog {

    public PetDog(String petName) {
        super(petName);
    }

    @Override
    public void aport(String item) {
        System.out.println(String.format("Woof woof, держи хозяин %s", item));
    }

    @Override
    public void makeVoice() {
        System.out.println("Гаф-гаф");
    }
}
