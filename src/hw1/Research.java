package hw1;

import java.util.ArrayList;
import java.util.List;

public class Research {
    List<String> result = new ArrayList<>();
    List<Node> tree;

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public List<String> spend(Person p, Relationship re) {
        for (Node t : tree) {
            if (t.p1.fullName == p.fullName && t.re == re) {
                result.add(t.p2.fullName);
            }
        }
        return result;
    }
}
