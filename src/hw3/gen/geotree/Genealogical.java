package hw3.gen.geotree;

import java.util.List;

import hw3.gen.Person;

public interface Genealogical {
    boolean exist(Person person);

    Node getNode(Person person);

    void addNode(Person person);

    void addParentChildRelation(Person parent, Person child);

    List<Person> getAllPersons();

    String asString();
}
