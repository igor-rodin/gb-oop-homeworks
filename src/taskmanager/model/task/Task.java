package taskmanager.model.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

public class Task implements Cloneable {
    public static enum Status {
        START,
        IN_WORK,
        CLOSED
    }

    private static final int DEFAULT_DAYS_TO_DEADLINE = 7;
    private final UUID id;
    private String autherFullName;
    private Priority priority;
    private Status status;
    private String title;
    private String description;
    private LocalDate deadline;
    private LocalDateTime createDateTime;

    public Task(UUID id, String autherFullName, String title, String description, Priority priority,
            LocalDate deadline) {
        this.id = id;
        this.autherFullName = autherFullName;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createDateTime = LocalDateTime.now();
        this.deadline = deadline;
        status = Status.START;
    }

    public Task(String autherFullName, String title, String description, Priority priority,
            LocalDate deadline) {
        this(UUID.randomUUID(), autherFullName, title, description, priority, deadline);
    }

    public Task(String autherFullName, String title, String description) {
        this(autherFullName, title, description, new LowPriority(), LocalDate.now().plusDays(DEFAULT_DAYS_TO_DEADLINE));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof Task)) {
            return false;
        }
        Task task = (Task) obj;
        return task.id == this.id;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result += result + 31 * createDateTime.hashCode();
        result += result + 31 * autherFullName.hashCode();
        result += result + 31 * title.hashCode();
        result += result + 31 * description.hashCode();
        result += result + 31 * priority.hashCode();
        result += result + 31 * deadline.hashCode();
        return result;
    }

    public UUID getId() {
        return id;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public PriorityLevel getPriorityLevel() {
        return priority.getPriorityLevel();
    }

    public PriorityColor getPriorityColor() {
        return priority.getPriorityColor();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status newStatus) {
        status = newStatus;
    }

    public String getAutherFullName() {
        return autherFullName;
    }

    public void setTitle(String newValue) {
        title = newValue;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String newValue) {
        description = newValue;
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
        return String.format("%02d:%02d", createDateTime.getHour(), createDateTime.getMinute());
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getDeadline() {
        return String.format("%02d-%02d-%4d", deadline.getDayOfMonth(), deadline.getMonthValue(),
                deadline.getYear());
    }

    public int daysForDeadline() {
        return Period.between(LocalDate.now(), deadline).getDays();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
