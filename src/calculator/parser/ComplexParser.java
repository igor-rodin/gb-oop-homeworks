package calculator.parser;

import calculator.model.MathOperations;
import calculator.model.complex.Complex;
import calculator.model.exeption.CalculataorExeption;
import calculator.model.exeption.InvalidMathExpression;

public class ComplexParser implements Parser <Complex>{

    public static final String RIGHT_BRACKET = ")";
    public static final String LEFT_BRACKET = "(";

    @Override
    public ParseEntity<Complex> parse(final String mathExpr) throws CalculataorExeption {
        String expr = mathExpr.trim();
        int rightBracketPos = mathExpr.indexOf(RIGHT_BRACKET);
        int lastLeftBracketPos = mathExpr.lastIndexOf(LEFT_BRACKET);
        String leftExpr = expr.substring(1, rightBracketPos).trim();
        String rightExpr = expr.substring(lastLeftBracketPos + 1, mathExpr.length() - 1).trim();
        String operation = mathExpr.substring(rightBracketPos + 1, lastLeftBracketPos).trim();

        for (MathOperations value : MathOperations.values()) {
            if (value.getOperationName().equals(operation)){
                return new ParseEntity<>(Complex.parseComplex(leftExpr), Complex.parseComplex(rightExpr), value);
            }
        }
        throw new InvalidMathExpression("Неверное выражение");
    }
}
