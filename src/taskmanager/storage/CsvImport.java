package taskmanager.storage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import taskmanager.model.task.LowPriority;
import taskmanager.model.task.MiddlePriority;
import taskmanager.model.task.ImmediatePriority;
import taskmanager.model.task.Priority;
import taskmanager.model.task.Task;
import taskmanager.model.task.Task.Status;
import taskmanager.model.taskboard.TaskBoard;

public class CsvImport implements Importer {
    private final String delim;

    public CsvImport(String delim) {
        this.delim = delim;
    }

    public CsvImport() {
        this(";");
    }

    @Override
    public TaskBoard load(Path pathToFile) {
        TaskBoard taskBoard = new TaskBoard();
        try {
            List<String> csvLines = Files.readAllLines(pathToFile, Charset.forName("UTF-8"));
            for (String line : csvLines) {
                Task task = parseLine(line);
                taskBoard.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return taskBoard;
        }
        return taskBoard;
    }

    private Task parseLine(String line) {
        String[] taskProps = line.split(delim);
        UUID id = UUID.fromString(taskProps[0]);

        Priority.Level level = Priority.Level.valueOf(taskProps[4]);
        Priority priority = switch (level) {
            case LOW -> new LowPriority();
            case MIDDLE -> new MiddlePriority();
            case IMMEDIATE -> new ImmediatePriority();
            default -> throw new IllegalArgumentException("Не известный уровень приоритета");
        };

        String dateTime = taskProps[6] + ":" + taskProps[7];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm");
        LocalDateTime createDateTime = LocalDateTime.parse(dateTime, formatter);

        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate deadlineDate = LocalDate.parse(taskProps[8], formatter);

        Task task = new Task(id, taskProps[1], taskProps[2], taskProps[3], priority, deadlineDate);
        task.setCreateDateTime(createDateTime);
        task.setStatus(Status.valueOf(taskProps[5]));
        return task;
    }

}
