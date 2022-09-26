package taskmanager.view;

import taskmanager.TaskBoardManager;
import taskmanager.model.task.PriorityColor;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View {
    public static final int SIZE_LINE = 80;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final Map<PriorityColor, String> colorMap = Map.of(PriorityColor.BLACK, "\u001B[30m", PriorityColor.RED, "\u001B[31m",
            PriorityColor.GREEN, "\u001B[32m", PriorityColor.ORANGE, "\u001b[31;1m");
    public static final String TASK_ROW_FORMAT = "%-4d%-10s%-10s%-12s%-12s%-12s%-18d";
    public static final String COLUMN_HEADER_FORMAT = "%-4s%-10s%-10s%-12s%-12s%-12s%-18s";
    private final TaskBoardManager taskBoardManager;
    private Scanner in;

    public ConsoleView(TaskBoardManager taskBoardManager) {
        this.taskBoardManager = taskBoardManager;
        in = new Scanner(System.in);
    }

    @Override
    public void showTaskBoard() {
        clearConsole();
        printLineWithSymbol("=", SIZE_LINE);
        printCaption("Task manager", " ");
        printLineWithSymbol("=", SIZE_LINE);
        printTaskBoardHeader();
        printLineWithSymbol("-", SIZE_LINE);
        for (int i = 0; i < taskBoardManager.getTaskBoard().items().size(); i++) {
            var item = taskBoardManager.getTask(i);
            String row = String.format(TASK_ROW_FORMAT, i + 1, item.getAuthorFullName(), item.getTitle()
                    , item.getCreateDate(), item.getPriorityLevel(), item.getStatus(), item.daysForDeadline());
            PriorityColor displayColor = item.getPriorityColor();
            printColorLine(row, displayColor);
        }
        printLineWithSymbol("-", SIZE_LINE);
    }

    @Override
    public MainMenuCode showMainMenuWithResult() {
        String menu = String.format(
                "%d-[New task]\t%d-[Delete task]\t%d-[Change task priority]\t%d-[Change task status]\n" +
                        "%d-[Sort]\t\t%d-[Import]\t\t%d-[Export]\t\t%d-[Exit]\n",
                MainMenuCode.NEW_TASK.ordinal(), MainMenuCode.DELL_TASK.ordinal(),
                MainMenuCode.PRIORITY_TASK.ordinal(), MainMenuCode.STATUS_TASK.ordinal(),
                MainMenuCode.SORT.ordinal(), MainMenuCode.IMPORT.ordinal(), MainMenuCode.EXPORT.ordinal(),
                MainMenuCode.EXIT.ordinal());
        printLineWithSymbol("=", SIZE_LINE);
        System.out.println("Available actions:");
        System.out.print(menu);
        clearConsole();
        while (true) {
            try {
                System.out.printf("%s (%d - %d): ", "Enter your choice", MainMenuCode.NEW_TASK.ordinal(), MainMenuCode.EXIT.ordinal());
                in = new Scanner(System.in);
                return MainMenuCode.values()[in.nextInt()];
            } catch (ArrayIndexOutOfBoundsException e) {
                printColorLine("Unknown action", PriorityColor.RED);
            } catch (InputMismatchException e) {
                printColorLine("Choice must be a number", PriorityColor.RED);
            }
        }
    }

    @Override
    public boolean addNewTask() {
        return false;
    }

    @Override
    public int removeTask() {
        return -1;
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
        String header = String.format(COLUMN_HEADER_FORMAT, "№", "Author", "Title", "Add date", "Priority", "Status", "Days to deadline");
        System.out.println(header);
    }

    private void printLineWithSymbol(String symbol, int sizeLine) {
        System.out.println(symbol.repeat(sizeLine));
    }

    private void printColorLine(String row, PriorityColor displayColor) {
        System.out.printf("%s%s%s\n", colorMap.get(displayColor), row, ANSI_RESET);
    }

    private void printCaption(String caption, String padSymb) {
        int spaceSize = (SIZE_LINE - caption.length()) / 2;
        String captionLine = padSymb.repeat(spaceSize) + caption + padSymb.repeat(spaceSize);
        System.out.println(captionLine);
    }
}
