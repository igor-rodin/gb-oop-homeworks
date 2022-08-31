package hw1.practice2;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person firstPerson = new Person("Иванов Иван Иванович");
        Person secondPerson = new Person("Петров Петр Петрович");
        Person thirdPerson = new Person("Васильев Василий Васильевич");
        Person forthPerson = new Person("Сидоров Сидор Сидорович");

        firstPerson.appendToFamily(secondPerson);
        firstPerson.appendToFamily(thirdPerson);
        secondPerson.appendToFamily(firstPerson);
        secondPerson.appendToFamily(forthPerson);

        view(firstPerson);
    }

    private static final Set<Person> visitedPersons = new HashSet<>();

    static void view(Person rootPerson) {
        if (rootPerson == null) {
            return;
        }
        System.out.println(rootPerson.fullName);
        visitedPersons.add(rootPerson);
        var family = rootPerson.getFamily();
        for (Person person : family) {
            if (person != null && !visitedPersons.contains(person)) {
                view(person);
            }
        }
    }
}
