package hw3.gen;

import java.util.ArrayList;
import java.util.List;

import hw3.gen.georesearch.GeoResearch;
import hw3.gen.georesearch.Research;
import hw3.gen.geotree.Genealogical;

public class Main {
    public static void main(String[] args) {
        Storage storageGen = new GenStorage("gen.txt");
        Genealogical gt = storageGen.load();

        Research researchGeo = new GeoResearch(gt);
        System.out.println(researchGeo.allPersons());
        researchGeo.print();

        Person lena = researchGeo.getPersonByName("Лена");
        Person irina = researchGeo.getPersonByName("Ирина");
        Person jane = researchGeo.getPersonByName("Jane");
        Person vasya = researchGeo.getPersonByName("Вася");
        Person masha = researchGeo.getPersonByName("Маша");

        System.out.printf("Родителиf %s -> %s\n", irina.getFullName(),
                researchGeo.parentsOfPerson(irina));
        System.out.printf("Родители %s -> %s\n", jane.getFullName(), researchGeo.parentsOfPerson(jane));
        System.out.printf("Дети %s -> %s\n", vasya.getFullName(), researchGeo.childsOfPerson(vasya));
        System.out.printf("Дети %s -> %s\n", masha.getFullName(), researchGeo.childsOfPerson(masha));

        List<Person> descendants = new ArrayList<>();
        researchGeo.descendantsOfPerson(vasya, descendants);
        System.out.printf("Наследники %s -> %s\n", vasya.getFullName(), descendants);

        List<Person> ancestors = new ArrayList<>();
        researchGeo.ancestorsOfPerson(jane, ancestors);
        System.out.printf("Предки %s -> %s\n", jane.getFullName(), ancestors);

        System.out.printf("Братья и сёстры %s -> %s\n", lena.getFullName(), researchGeo.siblingsOfPerson(lena));

        List<Person> femaileAncestors = researchGeo.ancestorsOfPersonByGender(jane, Gender.FEMAILE);
        System.out.printf("Предки по женской линии %s: ", jane.getFullName());
        researchGeo.printGenLine(femaileAncestors);
        List<Person> maleDescendants = researchGeo.descendantsOfPersonByGender(vasya, Gender.MALE);
        System.out.printf("Наследники по мужской линии %s: ", vasya.getFullName());
        researchGeo.printGenLine(maleDescendants);
        System.out.printf("Наследники по женской линии %s: ", vasya.getFullName());
        researchGeo.printGenLine(researchGeo.descendantsOfPersonByGender(vasya, Gender.FEMAILE));
        // storageGen.save(gt);
    }
}
