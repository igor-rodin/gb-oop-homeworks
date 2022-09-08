package hw2.gen.geotree;

import java.util.List;

import hw2.gen.Person;

public interface Genealogical {
    boolean exist(Person person);

    Node getNode(Person person);

    void addNode(Person person);

    void addParentChildRelation(Person parent, Person child);

    List<Person> getAllPersons();

    String asString();
}
