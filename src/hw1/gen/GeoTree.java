package hw1.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoTree {
    private Map<Person, Node> tree = new HashMap<>();

    public Map<Person, Node> getTree() {
        return tree;
    }

    public boolean exist(Person person) {
        return tree.containsKey(person);
    }

    public Node getNode(Person person) {
        return tree.get(person);
    }

    public void addParentChildRelation(Person parent, Person child) {
        if (!tree.containsKey(parent)) {
            addNode(parent);
        }

        if (!tree.containsKey(child)) {
            addNode(child);
        }

        tree.get(parent).addPersonRelation(tree.get(child), Relationship.CHILD);
        tree.get(child).addPersonRelation(tree.get(parent), Relationship.PARENT);

    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();

        for (var person : tree.keySet()) {
            persons.add(person);
        }

        return persons;
    }

    private void addNode(Person person) {
        tree.put(person, new Node(person));
    }

}
