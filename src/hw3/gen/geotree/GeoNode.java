package hw2.gen.geotree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hw2.gen.Person;
import hw2.gen.Relationship;

public class GeoNode implements Node {
    private Person person;
    private Map<Node, Relationship> personRelations;

    public GeoNode(Person p) {
        person = p;
        personRelations = new HashMap<>();
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public boolean hasRelations() {
        return !personRelations.isEmpty();
    }

    @Override
    public void addPersonRelation(Node node, Relationship re) {
        if (personRelations.containsKey(node)) {
            String errorMessage = String.format("%s уже добавлен как %s", node.getPerson(), re);
            throw new IllegalArgumentException(errorMessage);
        }
        personRelations.put(node, re);
    }

    @Override
    public Relationship getRelationshipFor(Node node) {
        return personRelations.get(node);
    }

    public Set<Node> getPersonRelations() {
        return personRelations.keySet();
    }

    @Override
    public List<Person> getPersonRelationsWith(Relationship re) {
        List<Person> result = new ArrayList<>();

        for (var entry : personRelations.entrySet()) {
            if (entry.getValue() == re) {
                result.add(entry.getKey().getPerson());
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(person.getFullName()).append(": <");

        for (var relation : personRelations.entrySet()) {
            String rel = String.format(" (%s - %s) ", relation.getKey(), relation.getValue());
            sb.append(rel);
        }
        sb.append(">");
        return sb.toString();
    }
}
