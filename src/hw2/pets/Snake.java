package hw2.pets;

public class Snake extends PetAnimal {
    public Snake(String snakeName) {
        super(snakeName);
    }

    @Override
    public void aport(String item) {
        System.out.println("Шииииии..");
    }

    @Override
    public void pet(String message) {
        super.pet(message);
        System.out.println("Шииииии..");
    }

}
