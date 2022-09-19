package taskmanager.storage;

import java.nio.file.Path;

import taskmanager.model.taskboard.TaskBoard;

public interface Importer {
    TaskBoard load(Path fileName);
}
