package taskmanager.model.task;

public abstract class AbstractPriority implements Priority {
    private PriorityColor displayColor = PriorityColor.BLACK;
    private final Level priorityLevel;

    protected AbstractPriority(PriorityColor displayColor, Level priorityLevel) {
        this.displayColor = displayColor;
        this.priorityLevel = priorityLevel;
    }

    public AbstractPriority() {
        this(PriorityColor.BLACK, Level.NONE);
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
    public Level getPriorityLevel() {
        return priorityLevel;
    }

}
