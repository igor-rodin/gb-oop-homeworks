package taskmanager.storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import taskmanager.model.taskboard.TaskBoard;

public class CsvExport implements Exporter {
    private final String delim;

    public CsvExport(String delim) {
        this.delim = delim;
    }

    public CsvExport() {
        this(";");
    }

    @Override
    public void save(final TaskBoard taskBoard, Path pathToFile) {
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile, Charset.forName("UTF-8"))) {
            String lineSep = System.lineSeparator();
            for (var task : taskBoard.items()) {
                String csvLine = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", task.getId(), delim,
                        task.getAuthorFullName(), delim, task.getTitle(), delim, task.getDescription(),
                        delim, task.getPriorityLevel(), delim, task.getStatus(), delim, task.getCreateDate(),
                        delim, task.getCreateTime(), delim,
                        task.getDeadline(), lineSep);
                writer.write(csvLine);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
