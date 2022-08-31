package hw1.gen;

import java.util.ArrayList;
import java.util.List;

public class GeoWithResearch {
    public static void main(String[] args) {
        StorageGen storageGen = new StorageGen("gen.txt");
        GeoTree gt = storageGen.load();

        Research researchGeo = new Research(gt);
        System.out.println(researchGeo.getAllPersons());
        researchGeo.printGeoTree();

        Person lena = researchGeo.getPersonByName("Лена");
        Person irina = researchGeo.getPersonByName("Ирина");
        Person jane = researchGeo.getPersonByName("Jane");
        Person vasya = researchGeo.getPersonByName("Вася");
        Person masha = researchGeo.getPersonByName("Маша");

        System.out.printf("Parents of %s -> %s\n", irina.getFullName(),
                researchGeo.parentsOfPerson(irina));
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
