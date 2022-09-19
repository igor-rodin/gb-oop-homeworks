package taskmanager;

import java.nio.file.Path;

import taskmanager.model.task.ImmediatePriority;
import taskmanager.model.task.Task;
import taskmanager.model.taskboard.TaskBoard;
import taskmanager.storage.CsvExport;
import taskmanager.storage.CsvImport;

public class Main {
    public static void main(String[] args) {
        TaskBoard taskBoard = new TaskBoard();

        Task task = new Task("Igor", "First", "Я люблю тебя, Лена!");
        Task task2 = new Task("Lena", "Second", "Я люблю тебя, Игорь!");

        taskBoard.add(task);
        taskBoard.add(task2);
        System.out.println("=======================");
        for (var elem : taskBoard.items()) {
            System.out.printf("%s - %s\n", elem.getAutherFullName(), elem.getDescription());
        }
        System.out.println("=======================");
        {
            Task task3 = taskBoard.getTask(1);
            System.out.printf("%s - %s\n", task3.getAutherFullName(), task3.getDescription());
            task3.setDescription("Я люблю тебя, Игорь:)!!");
            System.out.printf("%s - %s [после]\n", task3.getAutherFullName(), task3.getDescription());
        }
        System.out.printf("%s - %s [после 2]\n", taskBoard.getTask(1).getAutherFullName(),
                taskBoard.getTask(1).getDescription());
        System.out.println("=======================");

        System.out.println(task.getPriorityLevel());
        System.out.println(task.getPriorityColor());
        String message = task.getDescription();
        System.out.printf("\u001B[32m%s\u001B[0m\n", message);
        System.out.println(task.getCreateDate());
        System.out.println(task.getStatus());
        System.out.println(task.getCreateTime());
        task.setPriority(new ImmediatePriority());
        task.setStatus(Task.Status.IN_WORK);
        System.out.println(task.getPriorityLevel());
        System.out.println(task.getPriorityColor());
        System.out.println(task.getStatus());
        System.out.println(task.daysForDeadline());
        CsvExport csvExport = new CsvExport(";");
        csvExport.save(taskBoard, Path.of(System.getProperty("user.dir"), Config.fileDb));

        CsvImport csvImport = new CsvImport();
        TaskBoard taskBoard2 = csvImport.load(Path.of(System.getProperty("user.dir"), Config.fileDb));
        System.out.println("=====After Import========");
        for (var elem : taskBoard2.items()) {
            System.out.printf("\u001B[32m%s - %s\u001B[0m\n", elem.getAutherFullName(), elem.getDescription());
        }
        System.out.println("=======================");
    }
}
