package calculator;

import calculator.model.Calculator;
import calculator.model.complex.ComplexCalculator;
import calculator.model.rational.RationalCalculator;
import calculator.parser.ComplexParser;
import calculator.parser.ParseEntity;
import calculator.parser.Parser;
import calculator.parser.RationalParser;
import calculator.view.ConsoleVew;
import calculator.view.View;

import java.text.ParseException;

public class App {

    private final View view = new ConsoleVew();

    public void run() {
        CalcLogger.initLogger();
        CalcLogger.LOGGER.info("Калькулятор запущен");
        CalcMode mode = view.showMenu();
        switch (mode) {
            case RATIONAL -> {
                CalcLogger.LOGGER.info(String.format("Режим - %s", mode.getModeName()));
                System.out.printf("Режим - %s, для выхода нажмиту q[Q]\n", mode.getModeName());
                calc(new RationalCalculator(), new RationalParser());
            }
            case COMPLEX -> {
                CalcLogger.LOGGER.info(String.format("Режим - %s", mode.getModeName()));
                System.out.printf("Режим - %s, для выхода нажмиту q[Q]\n\n", mode.getModeName());
                System.out.println("Комлексные числа записываются в формате (re + iimg) (re - вещественая часть, " +
                        "img - мнимая часть),\nнапример, '(1.5 + i2) * (i), (i2 + 4.25) / (2.4)'");
                calc(new ComplexCalculator(), new ComplexParser());
            }
        }
    }

    private <T> void calc(Calculator<T> calculator, Parser<T> parser) {
        while (true) {
            String mathExpr = view.getExpression();
            if (mathExpr.equalsIgnoreCase("q")) {
                CalcLogger.LOGGER.info("Завершение работы");
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
                String logMessage = String.format("Выражение: %s: Значение: %s\n ", mathExpr, result);
                CalcLogger.LOGGER.info(logMessage);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
