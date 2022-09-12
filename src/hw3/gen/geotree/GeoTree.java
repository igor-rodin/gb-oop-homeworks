package hw3.gen.geotree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hw3.gen.Person;
import hw3.gen.Relationship;

public class GeoTree implements Genealogical {
    private Map<Person, Node> tree;

    public GeoTree() {
        tree = new HashMap<>();
    }

    public Map<Person, Node> getTree() {
        return tree;
    }

    @Override
    public boolean exist(Person person) {
        return tree.containsKey(person);
    }

    @Override
    public Node getNode(Person person) {
        return tree.get(person);
    }

    @Override
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

    @Override
    public void addNode(Person person) {
        if (person != null) {
            tree.put(person, new GeoNode(person));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var treeEntry : tree.entrySet()) {
            for (var relation : treeEntry.getValue().getPersonRelations()) {
                sb.append(String.format("%s;%s;%s\n", treeEntry.getKey(),
                        treeEntry.getValue().getRelationshipFor(relation), relation.getPerson()));
            }
        }
        return sb.toString();
    }

    @Override
    public List<Person> getAllPersons() {
        return new ArrayList<>(tree.keySet());
    }

    @Override
    public String asString() {
        return toString();
    }
}
