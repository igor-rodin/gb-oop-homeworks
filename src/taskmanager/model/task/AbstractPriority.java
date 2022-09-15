package taskmanager.model.task;

public abstract class AbstractPriority implements Priority {
    private PriorityColor displayColor = PriorityColor.BLACK;
    private final PriorityLevel priorityLevel;

    protected AbstractPriority(PriorityColor displayColor, PriorityLevel priorityLevel) {
        this.displayColor = displayColor;
        this.priorityLevel = priorityLevel;
    }

    public AbstractPriority() {
        this(PriorityColor.BLACK, PriorityLevel.NONE);
    }

    @Override
    public PriorityColor getPriorityColor() {
        return displayColor;
    }

    @Override
    public void setDisplayColor(PriorityColor color) {
        displayColor = color;
    }

    @Override
    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

}
