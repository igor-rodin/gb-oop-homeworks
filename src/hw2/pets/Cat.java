package hw2.pets;

public class Cat extends PetAnimal {
    public Cat(String catName) {
        super(catName);
    }

    @Override
    public void pet(String message) {
        super.pet(message);
        System.out.println("Мур-мур...., еще");
    }

    @Override
    public void aport(String item) {
        System.out.println("???, сам принеси...");
    }
}
