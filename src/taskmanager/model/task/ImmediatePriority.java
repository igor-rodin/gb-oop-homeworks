package taskmanager.model.task;

public class ImmediatePriority extends AbstractPriority {
    public ImmediatePriority() {
        super(PriorityColor.RED, PriorityLevel.IMMEDIATE);
    }
}
