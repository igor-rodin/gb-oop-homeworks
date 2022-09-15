package taskmanager.model.task;

public interface Priority {

    PriorityLevel getPriorityLevel();

    PriorityColor getPriorityColor();

    void setDisplayColor(PriorityColor color);
}
