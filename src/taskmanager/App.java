package taskmanager;

import taskmanager.view.ConsoleView;
import taskmanager.view.View;

import java.nio.file.Path;

public class App {
    public static void run() {
        TaskBoardManager taskBoardManager = new TaskBoardManager(Path.of(System.getProperty("user.dir"), Config.fileDb));
        taskBoardManager.load();
        View view = new ConsoleView(taskBoardManager);
        view.showTaskBoard();
        while (true) {
            View.MainMenuCode code = view.showMainMenuWithResult();
            view.showTaskBoard();
            switch (code) {
                case NEW_TASK -> {
                    boolean result = view.addNewTask();
                    String resMessage = result ? "Created new task" : "Failed creating new task";
                    System.out.println(resMessage);
                }
                case DELL_TASK -> {
                    int removedTaskIndex = view.removeTask();
                    String resMessage = removedTaskIndex > -1  ? "Remove task " + removedTaskIndex : "Failed removing task";
                    System.out.println(resMessage);
                }
                case PRIORITY_TASK -> {
                    System.out.println("Set new priority for task...");
                }
                case STATUS_TASK -> {
                    System.out.println("Set new status for task...");
                }
                case SORT -> {
                    System.out.println("Sort task board...");
                }
                case IMPORT -> {
                    System.out.println("Import task board...");
                }
                case EXPORT -> {
                    System.out.println("Export task board from file...");
                }
                case EXIT -> {
                    taskBoardManager.save();
                    System.out.println("See you... )");
                    return;
                }
            }
        }
    }
}
