package hw2.pets;

public abstract class PetAnimal {
    protected String petName;

    public PetAnimal(String petName) {
        this.petName = petName;
    }

    public String getPetName() {
        return petName;
    }

    public abstract void makeVoice();

    public void feed(String food) {
        System.out.printf("%s ест %s\n", petName, food);
    }

    @Override
    public String toString() {
        return petName;
    }
}
