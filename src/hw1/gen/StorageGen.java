package hw1.gen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StorageGen {
    private final Path pathFileStorage;

    public StorageGen(String fileStorage) {
        if (fileStorage.isBlank()) {
            throw new IllegalArgumentException("Имя файла не должно быть пустым");
        }
        this.pathFileStorage = Path.of(System.getProperty("user.dir"), fileStorage);
    }

    public void save(GeoTree gTree) {
        String treeRelations = gTree.getGeoTreeAsString();
        try {
            BufferedWriter writer = Files.newBufferedWriter(pathFileStorage, Charset.forName("UTF-8"));
            writer.write(treeRelations);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GeoTree load() {
        GeoTree gTree = new GeoTree();
        try {
            List<String> allTreeRelations = Files.readAllLines(pathFileStorage, Charset.forName("UTF-8"));
            for (String treeLine : allTreeRelations) {
                String[] treeElem = treeLine.split(";");
                Person p1 = new Person(treeElem[0], Gender.valueOf(treeElem[1]));
                Person p2 = new Person(treeElem[3], Gender.valueOf(treeElem[4]));
                if (Relationship.valueOf(treeElem[2]) == Relationship.PARENT) {
                    gTree.addParentChildRelation(p2, p1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gTree;
    }
}
