package taskmanager.view;

public interface View {
    enum MainMenuCode {
        NEW_TASK,
        DELL_TASK,
        PRIORITY_TASK,
        STATUS_TASK,
        SORT,
        IMPORT,
        EXPORT,
        EXIT
    }
    void showTaskBoard();

    MainMenuCode showMainMenuWithResult();
    boolean addNewTask();
    int removeTask();

    String getTitle();

    String getAuthorName();

    String getDescription();
}
