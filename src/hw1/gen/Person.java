package hw1.gen;

public class Person {
    private String fullName;

    private Gender gender;

    public Person(String fullName, Gender gender) {
        this.fullName = fullName;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMale() {
        return gender == Gender.MALE;
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fullName, gender);
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
            return person.getFullName() == fullName;
        }
        return false;
    }
}
