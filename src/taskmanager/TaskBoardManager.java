package taskmanager;

import java.nio.file.Path;
import java.util.Comparator;

import taskmanager.model.task.Priority;
import taskmanager.model.task.Task;
import taskmanager.model.taskboard.TaskBoard;
import taskmanager.storage.Importer;
import taskmanager.storage.CsvExport;
import taskmanager.storage.CsvImport;
import taskmanager.storage.Exporter;

public class TaskBoardManager {
    private TaskBoard taskBoard;
    private final Path storageFile;

    public TaskBoardManager(Path storageFile) {
        this.storageFile = storageFile;
        taskBoard = new TaskBoard();
    }

    public TaskBoard getTaskBoard() {
        return taskBoard;
    }

    public Task getTask(int index) {
        return taskBoard.getTask(index);
    }

    public void changePriority(int index, Priority newPriority) {
        Task task = taskBoard.getTask(index);
        if (task != null) {
            task.setPriority(newPriority);
        }
    }

    public void changeStatus(int index, Task.Status newStatus) {
        Task task = taskBoard.getTask(index);
        if (task != null) {
            task.setStatus(newStatus);
        }
    }

    public void sort(Comparator<Task> comparator) {
        taskBoard.items().sort(comparator);
    }

    public void importFrom(Path fileName, Importer importer) {
        taskBoard = importer.load(fileName);
    }

    public void exportTo(Path fileName, Exporter exporter) {
        exporter.save(taskBoard, fileName);
    }

    public void load() {
        importFrom(storageFile, new CsvImport());
    }

    public void save() {
        exportTo(storageFile, new CsvExport());
    }
}
