package hw2.pets;

public class Dog extends PetAnimal {
    public Dog(String dogName) {
        super(dogName);
    }

    @Override
    public void aport(String item) {
        System.out.println(String.format("Woof woof, держи хозяин %s", item));
    }

    @Override
    public void pet(String message) {
        super.pet(message);
        System.out.println("Woof woof");
    }
}
