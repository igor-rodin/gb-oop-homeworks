package hw2.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Node {
    private Person person;
    private Map<Node, Relationship> personRelations;

    public Node(Person p) {
        person = p;
        personRelations = new HashMap<>();
    }

    public Person getPerson() {
        return person;
    }

    public boolean hasRelations() {
        return !personRelations.isEmpty();
    }

    public void addPersonRelation(Node node, Relationship re) {
        if (personRelations.containsKey(node)) {
            String errorMessage = String.format("%s уже добавлен как %s", node.person, re);
            throw new IllegalArgumentException(errorMessage);
        }
        personRelations.put(node, re);
    }

    public Relationship getRelationship(Node node) {
        return personRelations.get(node);
    }

    public Set<Node> getPersonRelations() {
        return personRelations.keySet();
    }

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
