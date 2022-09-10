package hw3.gen.geotree;

import java.util.List;
import java.util.Set;

import hw3.gen.Person;
import hw3.gen.Relationship;

public interface Node {
    Person getPerson();

    boolean hasRelations();

    void addPersonRelation(Node node, Relationship re);

    Relationship getRelationshipFor(Node node);

    Set<Node> getPersonRelations();

    List<Person> getPersonRelationsWith(Relationship re);
}
