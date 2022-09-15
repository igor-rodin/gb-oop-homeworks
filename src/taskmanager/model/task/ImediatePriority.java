package taskmanager.model.task;

public class ImediatePriority extends AbstractPriority {
    public ImediatePriority() {
        super(PriorityColor.RED, PriorityLevel.IMMEDIATE);
    }
}
