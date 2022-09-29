package calculator.view;

import calculator.CalcMode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleVew implements View {
    public static final int LINE_SIZE = 60;
    public static final String APP_TITLE = "Калькулятор";
    private Scanner in;

    public ConsoleVew() {
        this.in = new Scanner(System.in);
    }

    @Override
    public String getExpression() {
        in = new Scanner(System.in);
        System.out.print(":> ");
        return in.nextLine();
    }

    @Override
    public void showResult(String result) {
        System.out.println(result);
    }

    @Override
    public CalcMode showMenu() {
        printCalcHeader(APP_TITLE);
        while (true) {
            String menuMessage = String.format("Выберитие режим калькулятора (%d - [%s]\t%d - [%s]): ",
                    CalcMode.RATIONAL.ordinal(), CalcMode.RATIONAL.getModeName(), CalcMode.COMPLEX.ordinal(), CalcMode.COMPLEX.getModeName());
            System.out.print(menuMessage);
            try {
                in = new Scanner(System.in);
                return CalcMode.values()[in.nextInt()];
            } catch (final ArrayIndexOutOfBoundsException | InputMismatchException e) {
                String message = String.format("Допустимые значения: %d, %d", CalcMode.RATIONAL.ordinal(), CalcMode.COMPLEX.ordinal());
                System.out.println(message);
            }
        }
    }

    private void printCalcHeader(String caption) {
        String lineSym = "=";
        int spaceSize = (LINE_SIZE - caption.length()) / 2;
        printLineWith(lineSym, LINE_SIZE);
        System.out.println(" ".repeat(spaceSize) + caption + " ".repeat(spaceSize));
        System.out.println("Работает с вещественными и комплексными числами.");
        System.out.println("Поддержиываемые операции: +, - , *, /\n" + "Выражение для вычисления записывается в виде: 'a (+[-,*,/]) b'.");
        printLineWith(lineSym, LINE_SIZE);
    }

    private void printLineWith(String symbol, int size) {
        System.out.println(symbol.repeat(size));
    }
}
