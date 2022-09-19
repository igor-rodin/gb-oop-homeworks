package taskmanager.storage;

import java.nio.file.Path;

import taskmanager.model.taskboard.TaskBoard;

public class JsonExport implements Exporter {

    @Override
    public void save(final TaskBoard taskBoard, Path pathToFile) {
        throw new UnsupportedOperationException("Экспорт в Json формат еще не реализовано");
    }

}
