package hw1.gen;

import java.util.ArrayList;
import java.util.List;

public class GeoWithResearch {
    public static void main(String[] args) {
        Person lena = new Person("Лена");
        Person irina = new Person("Ирина");
        Person vasya = new Person("Вася");
        Person masha = new Person("Маша");
        Person jane = new Person("Jane");
        Person jack = new Person("Jack");
        Person ivan = new Person("Ваня");

        GeoTree gt = new GeoTree();
        gt.addParentChildRelation(vasya, irina);
        gt.addParentChildRelation(masha, irina);
        gt.addParentChildRelation(vasya, lena);
        gt.addParentChildRelation(masha, lena);
        gt.addParentChildRelation(vasya, ivan);
        gt.addParentChildRelation(masha, ivan);

        gt.addParentChildRelation(irina, jane);
        gt.addParentChildRelation(jack, jane);

        Research researchGeo = new Research(gt);

        System.out.printf("Parents of %s -> %s\n", irina, researchGeo.parentsOfPerson(irina));
        System.out.printf("Parents of %s -> %s\n", jane, researchGeo.parentsOfPerson(jane));
        System.out.printf("Childs of %s -> %s\n", vasya, researchGeo.childsOfPerson(vasya));
        System.out.printf("Childs of %s -> %s\n", masha, researchGeo.childsOfPerson(masha));

        List<Person> descendants = new ArrayList<>();
        researchGeo.descendantsOfPerson(vasya, descendants);
        System.out.printf("Descendants of %s -> %s\n", vasya, descendants);

        List<Person> ancestors = new ArrayList<>();
        researchGeo.ancestorsOfPerson(jane, ancestors);
        System.out.printf("Ancestors of %s -> %s\n", jane, ancestors);

        System.out.printf("Siblings of %s -> %s\n", lena, researchGeo.siblingsOfPerson(lena));
    }
}
