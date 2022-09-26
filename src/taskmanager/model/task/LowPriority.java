package taskmanager.model.task;

public class LowPriority extends AbstractPriority {
    public LowPriority() {
        super(PriorityColor.GREEN, Level.LOW);
    }
}
