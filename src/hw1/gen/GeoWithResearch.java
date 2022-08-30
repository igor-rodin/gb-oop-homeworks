package hw1.gen;

import java.util.ArrayList;
import java.util.List;

public class GeoWithResearch {
    public static void main(String[] args) {
        StorageGen storageGen = new StorageGen("gen.txt");
        // GeoTree gt = storageGen.load();
        GeoTree gt = new GeoTree();

        Person lena = new Person("Лена", Gender.FEMAILE);
        Person irina = new Person("Ирина", Gender.FEMAILE);
        Person vasya = new Person("Вася", Gender.MALE);
        Person jack = new Person("Ivan", Gender.MALE);
        Person ivan = new Person("Jack", Gender.MALE);
        Person masha = new Person("Маша", Gender.FEMAILE);
        Person jane = new Person("Jane", Gender.FEMAILE);
        gt.addParentChildRelation(vasya, irina);
        gt.addParentChildRelation(masha, irina);
        gt.addParentChildRelation(vasya, lena);
        gt.addParentChildRelation(masha, lena);
        gt.addParentChildRelation(vasya, ivan);
        gt.addParentChildRelation(masha, ivan);

        gt.addParentChildRelation(irina, jane);
        gt.addParentChildRelation(jack, jane);

        System.out.println(gt.getAllPersons());
        Research researchGeo = new Research(gt);
        researchGeo.printGeoTree();

        System.out.printf("Parents of %s -> %s\n", irina.getFullName(), researchGeo.parentsOfPerson(irina));
        System.out.printf("Parents of %s -> %s\n", jane.getFullName(), researchGeo.parentsOfPerson(jane));
        System.out.printf("Childs of %s -> %s\n", vasya.getFullName(), researchGeo.childsOfPerson(vasya));
        System.out.printf("Childs of %s -> %s\n", masha.getFullName(), researchGeo.childsOfPerson(masha));

        List<Person> descendants = new ArrayList<>();
        researchGeo.descendantsOfPerson(vasya, descendants);
        System.out.printf("Descendants of %s -> %s\n", vasya.getFullName(), descendants);

        List<Person> ancestors = new ArrayList<>();
        researchGeo.ancestorsOfPerson(jane, ancestors);
        System.out.printf("Ancestors of %s -> %s\n", jane.getFullName(), ancestors);

        System.out.printf("Siblings of %s -> %s\n", lena.getFullName(), researchGeo.siblingsOfPerson(lena));

        // storageGen.save(gt);
    }
}
