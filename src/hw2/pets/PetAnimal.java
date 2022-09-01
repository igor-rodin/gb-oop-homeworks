package hw2.pets;

public abstract class PetAnimal {
    protected String petName;

    public PetAnimal(String petName) {
        this.petName = petName;
    }

    public String getPetName() {
        return petName;
    }

    public void pet(String message) {
        System.out.printf("%s, %s\n", petName, message);
    };

    public abstract void aport(String item);

    @Override
    public String toString() {
        return petName;
    }
}
