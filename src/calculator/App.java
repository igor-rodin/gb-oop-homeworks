package calculator;

import calculator.model.Calculator;
import calculator.model.complex.Complex;
import calculator.model.complex.ComplexCalculator;
import calculator.model.exeption.CalculataorExeption;
import calculator.model.rational.RationalCalculator;
import calculator.parser.ComplexParser;
import calculator.parser.ParseEntity;
import calculator.parser.Parser;
import calculator.parser.RationalParser;
import calculator.view.ConsoleVew;
import calculator.view.View;

public class App {

    private final View view = new ConsoleVew();

    public void run() {

        CalcMode mode = view.showMenu();
        switch (mode) {
            case RATIONAL -> {
                System.out.printf("Режим - %s, для выхода нажмиту q[Q]\n", "RATIONAL");
                calc(new RationalCalculator(), new RationalParser());
            }
            case COMPLEX -> {
                System.out.printf("Режим - %s, для выхода нажмиту q[Q]\n\n", "COMPLEX");
                System.out.println("(Комлексные числа должны быть в формате re + i img, re - вещественая часть,\n" +
                        "img - мнимая. i записывается как i1");
                System.out.println("И записаны внутри скобок, например, (1.5 + i2) * (i1) )");
                calc(new ComplexCalculator(), new ComplexParser());
            }
        }
    }

    private <T> void calc(Calculator<T> calculator, Parser<T> parser) {
        while (true) {
            String mathExpr = view.getExpression();
            if (mathExpr.equalsIgnoreCase("q")) {
                System.out.println("Завершение работы...");
                return;
            }
            try {
                ParseEntity<T> parseEntity = parser.parse(mathExpr);
                T result = switch (parseEntity.operation()) {
                    case PLUS -> calculator.sum(parseEntity.leftOperand(), parseEntity.rightOperand());
                    case MINUS -> calculator.diff(parseEntity.leftOperand(), parseEntity.rightOperand());
                    case MULL -> calculator.mul(parseEntity.leftOperand(), parseEntity.rightOperand());
                    case DIV -> calculator.div(parseEntity.leftOperand(), parseEntity.rightOperand());
                };

                view.showResult(result.toString());
            } catch (CalculataorExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
