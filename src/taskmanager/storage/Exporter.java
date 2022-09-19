package taskmanager.storage;

import java.nio.file.Path;

import taskmanager.model.taskboard.TaskBoard;

public interface Exporter {
    void save(final TaskBoard taskBoard, Path pathToFile);
}
