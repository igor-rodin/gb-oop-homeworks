package hw3.gen.georesearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hw3.gen.Person;
import hw3.gen.Printable;
import hw3.gen.Relationship;

public interface Research extends Printable {
    // *Находит персону p по имени fullName */
    Person getPersonByName(String fullName);

    // *Получает список всех людей в нереалогическом дереве */
    List<Person> allPersons();

    // *Находит отношения re персоны p */
    List<Person> getPersonRelations(Person p, Relationship re);

    // *Находит все отношения персоны p */
    List<Person> getPersonRelations(Person p);

    // *Находит всех предков ancestors персоны p */
    default void ancestorsOfPerson(Person p, List<Person> ancestors) {
        List<Person> parents = parentsOfPerson(p);
        if (parents.isEmpty()) {
            return;
        }
        ancestors.addAll(parents);
        for (Person person : parents) {
            ancestorsOfPerson(person, ancestors);
        }
    };

    // *Находит всех наследников descendant персоны p */
    default void descendantsOfPerson(Person p, List<Person> descendant) {
        List<Person> childs = childsOfPerson(p);
        if (childs.isEmpty()) {
            return;
        }
        descendant.addAll(childs);
        for (Person person : childs) {
            descendantsOfPerson(person, descendant);
        }
    };

    // *Находит братьев и сестер персоны p */
    default List<Person> siblingsOfPerson(Person p) {
        Set<Person> siblings = new HashSet<>();
        for (var parent : parentsOfPerson(p)) {
            siblings.addAll(childsOfPerson(parent));
        }
        siblings.remove(p);

        return new ArrayList<>(siblings);
    };

    // *Находит родителей персоны p */
    default List<Person> parentsOfPerson(Person p) {
        return getPersonRelations(p, Relationship.PARENT);
    };

    // *Находит детей персоны p */
    default List<Person> childsOfPerson(Person p) {
        return getPersonRelations(p, Relationship.CHILD);
    };
}
