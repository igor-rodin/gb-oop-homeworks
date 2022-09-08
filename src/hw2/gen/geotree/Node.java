package hw2.gen.geotree;

import java.util.List;
import java.util.Set;

import hw2.gen.Person;
import hw2.gen.Relationship;

public interface Node {
    Person getPerson();

    boolean hasRelations();

    void addPersonRelation(Node node, Relationship re);

    Relationship getRelationshipFor(Node node);

    Set<Node> getPersonRelations();

    List<Person> getPersonRelationsWith(Relationship re);
}
