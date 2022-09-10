package hw3.gen.georesearch;

import java.util.ArrayList;
import java.util.List;

import hw3.gen.Person;
import hw3.gen.Relationship;
import hw3.gen.geotree.Genealogical;
import hw3.gen.geotree.Node;

public class GeoResearch implements Research {
    private final Genealogical tree;

    public GeoResearch(Genealogical geoTree) {
        if (geoTree == null) {
            throw new IllegalArgumentException("Пустое (null) дерево");
        }
        tree = geoTree;
    }

    @Override
    public void print() {
        System.out.println("-----Genealogical tree------");
        System.out.println(tree);
    }

    // *Получает список всех людей в нереалогическом дереве */
    @Override
    public List<Person> allPersons() {
        return tree.getAllPersons();
    }

    // *Находит персону p по имени fullName */
    @Override
    public Person getPersonByName(String fullName) {
        for (var person : allPersons()) {
            if (fullName.equalsIgnoreCase(person.getFullName())) {
                return new Person(fullName, person.getGender());
            }
        }
        return null;
    }

    // *Находит отношения re персоны p */
    @Override
    public List<Person> getPersonRelations(Person p, Relationship re) {
        if (p == null) {
            return List.of();
        }
        Node personNode = tree.getNode(p);
        return personNode.getPersonRelationsWith(re);
    }

    // *Находит все отношения персоны p */
    @Override
    public List<Person> getPersonRelations(Person p) {
        if (p == null) {
            return List.of();
        }
        Node personNode = tree.getNode(p);
        List<Person> result = new ArrayList<>();

        for (var node : personNode.getPersonRelations()) {
            result.add(node.getPerson());
        }
        return result;
    }
}
