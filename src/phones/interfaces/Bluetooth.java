package phones.interfaces;

import java.io.File;
import java.util.List;

public interface Bluetooth {
    void sendFiles(String... fileNames);
    List<File> getFiles();
}
