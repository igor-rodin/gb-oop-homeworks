package hw1.pets;

public abstract class PetAnimal {
    private String petName;

    public PetAnimal(String petName) {
        this.petName = petName;
    }

    public String getPetName() {
        return petName;
    }
}
