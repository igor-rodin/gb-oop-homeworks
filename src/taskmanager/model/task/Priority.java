package taskmanager.model.task;

public interface Priority {
    public enum Level {
        NONE,
        LOW,
        MIDDLE,
        IMMEDIATE
    }

    Level getPriorityLevel();

    PriorityColor getPriorityColor();

    void setDisplayColor(PriorityColor color);
}
