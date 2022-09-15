package taskmanager.model.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

public class Task {
    private static final int DEFAULT_DEADLINE_DAYS = 7;
    private final UUID id;
    private Priority priority;
    private String autherFullName;
    private String title;
    private String description;
    private LocalDate deadline;
    private LocalDateTime createDateTime;

    public Task(String autherFullName, String title, String description, Priority priority,
            LocalDate deadline) {
        id = UUID.randomUUID();
        this.autherFullName = autherFullName;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createDateTime = LocalDateTime.now();
        this.deadline = deadline;
    }

    public Task(String autherFullName, String title, String description) {
        this(autherFullName, title, description, new LowPriority(), LocalDate.now().plusDays(DEFAULT_DEADLINE_DAYS));
    }

    public UUID getUuid() {
        return id;
    }

    void setPriority(Priority priority) {
        this.priority = priority;
    }

    public PriorityLevel getPriorityLevel() {
        return priority.getPriorityLevel();
    }

    public PriorityColor getPriorityColor() {
        return priority.getPriorityColor();
    }

    public String getAutherFullName() {
        return autherFullName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public String getCreateDate() {
        return String.format("%02d-%02d-%4d", createDateTime.getDayOfMonth(), createDateTime.getMonthValue(),
                createDateTime.getYear());
    }

    public String getCreateTime() {
        return String.format("%02d:02d", createDateTime.getHour(), createDateTime.getMinute());
    }

    public int daysForDeadline() {
        return Period.between(LocalDate.now(), deadline).getDays();
    }
}
