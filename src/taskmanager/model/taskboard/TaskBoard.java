package taskmanager.model.taskboard;

import java.util.ArrayList;
import java.util.List;

import taskmanager.model.task.Task;

public class TaskBoard {
    private final List<Task> taskBoard = new ArrayList<>();

    public List<Task> items() {
        return taskBoard;
    }

    public boolean isEmpty() {
        return taskBoard.isEmpty();
    }

    public void add(Task task) {
        if (!taskBoard.contains(task)) {
            taskBoard.add(task);
        }
    }

    public boolean remove(Task task) {
        if (taskBoard.contains(task)) {
            taskBoard.remove(task);
            return true;
        }
        return false;
    }

    public Task getTask(int index) {
        if (index >= taskBoard.size() || index < 0) {
            return null;
        }
        return taskBoard.get(index);
    }
}
