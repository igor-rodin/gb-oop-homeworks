package hw1.pets;

public class Pets {
    public static void main(String[] args) {
        Human master = new Human("Хозяин");
        master.addPet(new Cat("Юлий"));
        master.addPet(new Dog("Цезарь"));
        master.addPet(new Snake("Маугли"));

        for (var animal : master.getPets()) {
            master.petAnimal(animal, "Кис-кис...");
            master.giveAportCommand(animal, "Тапок");
            System.out.println();
        }
    }
}
