package hw2.pets.snakes;

import hw2.pets.PetAnimal;

public class PetSnake extends PetAnimal implements Snake {

    public PetSnake(String petName) {
        super(petName);
    }

    @Override
    public void crawl() {
        System.out.println(String.format("%s crawls", petName));
    }

    @Override
    public void makeVoice() {
        System.out.println("Шииииии..");
    }

}
