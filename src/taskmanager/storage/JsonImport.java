package taskmanager.storage;

import java.nio.file.Path;

import taskmanager.model.taskboard.TaskBoard;

public class JsonImport implements Importer {

    @Override
    public TaskBoard load(Path fileName) {
        throw new UnsupportedOperationException("Импорт в Json формате еще не реализовано");
    }

}
