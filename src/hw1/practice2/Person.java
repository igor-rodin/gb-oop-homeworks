package hw1.practice2;

import java.util.ArrayList;

public class Person {
    public String fullName;
    private ArrayList<Person> family = new ArrayList<>();

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public void appendToFamily(Person person) {
        if (person != null && person != this && !family.contains(person)) {
            family.add(person);
        }
    }

    public ArrayList<Person> getFamily() {
        return family;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj instanceof Person person) {
            return fullName.equals(person.fullName);
        }
        return false;
    }
}
