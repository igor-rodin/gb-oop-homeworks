package taskmanager.view;

import taskmanager.TaskBoardManager;
import taskmanager.model.task.PriorityColor;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View {
    public static final int SIZE_LINE = 75;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final Map<PriorityColor, String> colorMap = Map.of(PriorityColor.BLACK, "\u001B[30m", PriorityColor.RED, "\u001B[31m",
            PriorityColor.GREEN, "\u001B[32m", PriorityColor.ORANGE, "\u001b[31;1m");
    private final TaskBoardManager taskBoardManager;
    private final Scanner in;
    public ConsoleView(TaskBoardManager taskBoardManager) {
        this.taskBoardManager = taskBoardManager;
        in = new Scanner(System.in);
    }

    @Override
    public void showTaskBoard() {
        clearConsole();
        printLineWithSymbol("=", SIZE_LINE);
        printTaskBoardHeader();
        for (int i = 0; i < taskBoardManager.getTaskBoard().items().size(); i++) {
            var item = taskBoardManager.getTask(i);
            String row = String.format("%5d%20s%15s%5d%10s%10s%10s\n", i + 1, item.getAutherFullName(), item.getTitle(),
                    item.daysForDeadline(), item.getCreateDate(), item.getPriorityLevel(), item.getStatus());
            PriorityColor displayColor = item.getPriorityColor();
            printColorLine(row, displayColor);
            printLineWithSymbol("-", SIZE_LINE);
        }
    }

    @Override
    public int ShowMainMenuWithResult() {
        String menu = String.format("%d - New task, %d - Delete task, %d - Change task priority, %d - Change task status, %d - Sort\n",
                MainMenuCode.NEW_TASK, MainMenuCode.DELL_TASK, MainMenuCode.PRIORITY_TASK, MainMenuCode.STATUS_TASK, MainMenuCode.SORT);

        while (true) {
            System.out.print("Enter your choice: ");
            try {
                int choice = in.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                printColorLine("Choice must a number value", PriorityColor.RED);
            }
        }
    }

    @Override
    public String getTitle() {
        System.out.print("Title: ");
        return in.nextLine();
    }

    @Override
    public String getAuthorName() {
        System.out.print("Author full name: ");
        return in.nextLine();
    }

    @Override
    public String getDescription() {
        System.out.print("Description: ");
        return in.nextLine();
    }

    private void clearConsole() {
        System.out.print("\033[H\033[J");
    }

    private void printTaskBoardHeader() {
        String header = "№\tAuthor\tTitle\tDays to deadline\tAdded date\tPriority\tStatus";
        System.out.println(header);
    }

    private void printLineWithSymbol(String symbol, int sizeLine) {
        System.out.println(symbol.repeat(sizeLine));
    }

    private void printColorLine(String row, PriorityColor displayColor) {
        System.out.printf("%s%s%s\n", colorMap.get(displayColor), row, ANSI_RESET);
    }

    public enum MainMenuCode {
        NEW_TASK,
        DELL_TASK,
        PRIORITY_TASK,
        STATUS_TASK,
        SORT
    }
}
