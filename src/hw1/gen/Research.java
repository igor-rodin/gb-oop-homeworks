package hw1.gen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Research {
    private final GeoTree tree;

    public Research(GeoTree geoTree) {
        if (geoTree == null) {
            throw new IllegalArgumentException("Пустое (null) дерево");
        }
        tree = geoTree;
    }

    public void printGeoTree() {
        System.out.println("-----Genealogical tree------");
        System.out.println(tree.getGeoTreeAsString());
    }

    // *Получает список всех людей в нереалогическом дереве */
    public List<Person> getAllPersons() {
        return new ArrayList<>(tree.getTree().keySet());
    }

    // *Находит персону p по имени fullName */
    public Person getPersonByName(String fullName) {
        for (var person : getAllPersons()) {
            if (fullName.equalsIgnoreCase(person.getFullName())) {
                return new Person(fullName, person.getGender());
            }
        }
        return null;
    }

    // *Находит всех предков ancestors персоны p */
    public void ancestorsOfPerson(Person p, List<Person> ancestors) {
        List<Person> parents = parentsOfPerson(p);
        if (parents.isEmpty()) {
            return;
        }
        ancestors.addAll(parents);
        for (Person person : parents) {
            ancestorsOfPerson(person, ancestors);
        }

    }

    // *Находит всех наследников descendant персоны p */
    public void descendantsOfPerson(Person p, List<Person> descendant) {
        List<Person> childs = childsOfPerson(p);
        if (childs.isEmpty()) {
            return;
        }
        descendant.addAll(childs);
        for (Person person : childs) {
            descendantsOfPerson(person, descendant);
        }
    }

    // *Находит братьев и сестер персоны p */
    public List<Person> siblingsOfPerson(Person p) {
        Set<Person> siblings = new HashSet<>();
        for (var parent : parentsOfPerson(p)) {
            siblings.addAll(childsOfPerson(parent));
        }
        siblings.remove(p);

        return new ArrayList<>(siblings);
    }

    // *Находит родителей персоны p */
    public List<Person> parentsOfPerson(Person p) {
        return getPersonRelations(p, Relationship.PARENT);
    }

    // *Находит детей персоны p */
    public List<Person> childsOfPerson(Person p) {
        return getPersonRelations(p, Relationship.CHILD);
    }

    // *Находит отношения re персоны p */
    private List<Person> getPersonRelations(Person p, Relationship re) {
        Node personNode = tree.getNode(p);
        return personNode.getPersonRelationsWith(re);
    }

    // *Находит все отношения персоны p */
    private List<Person> getPersonRelations(Person p) {
        Node personNode = tree.getNode(p);
        List<Person> result = new ArrayList<>();

        for (var node : personNode.getPersonRelations()) {
            result.add(node.getPerson());
        }
        return result;
    }
}
