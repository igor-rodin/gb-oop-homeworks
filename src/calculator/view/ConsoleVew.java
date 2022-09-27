package calculator.view;

import calculator.CalcMode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleVew implements View {
    public static final int LINE_SIZE = 60;
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
        printCalcHeader("Калькулятор");
        System.out.printf("%d - [%s]\t%d - [%s]\n",
                CalcMode.RATIONAL.ordinal(), CalcMode.RATIONAL, CalcMode.COMPLEX.ordinal(), CalcMode.COMPLEX);
        while (true) {
            System.out.print("Выберитие режим калькулятора: ");
            try {
                in = new Scanner(System.in);
                return CalcMode.values()[in.nextInt()];
            }
            catch (final ArrayIndexOutOfBoundsException e){
                System.out.println("Неизвестный режим");
            }
            catch (final InputMismatchException e){
                System.out.println("Режим работы должен быть числом");
            }
        }
    }

    private void printCalcHeader(String caption) {
        String lineSym = "=";
        int spaceSize = (LINE_SIZE - caption.length()) / 2;
        printLineWith(lineSym, LINE_SIZE);
        System.out.println(" ".repeat(spaceSize) + caption + " ".repeat(spaceSize));
        System.out.println("Калькулятор может работать с вещественными\n" +
                "и комплексными числами.");
        System.out.println("Поддержиываемые операции: +, - , *, /\n" +
                "Выражение для вычисления записывается в виде: 'a (+[-,*,/]) b'.");
        printLineWith(lineSym, LINE_SIZE);
    }

    private void printLineWith(String symbol, int size) {
        System.out.println(symbol.repeat(size));
    }
}
