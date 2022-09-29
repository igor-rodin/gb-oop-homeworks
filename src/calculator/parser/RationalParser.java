package calculator.parser;

import java.text.ParseException;
import calculator.model.MathOperations;

public class RationalParser implements Parser<Double> {
    @Override
    public ParseEntity<Double> parse(final String mathExpr) throws ParseException{
        String expr = mathExpr.trim();
        int operIndex = -1;
        MathOperations oper = null;
        for (MathOperations value : MathOperations.values()) {
            operIndex = expr.indexOf(value.getOperationName());
            if (operIndex == 0) {
                continue;
            }
            if (operIndex != -1){
                oper = value;
                break;
            }
        }
        if (operIndex == -1){
            throw new ParseException(String.format("Некорректное выражение -> '%s'", mathExpr), 0);
        }

        double leftOperand = Double.parseDouble(expr.substring(0, operIndex).trim());
        double rightOperand = Double.parseDouble(expr.substring(operIndex + 1).trim());

        return new ParseEntity<>(leftOperand, rightOperand, oper);
    }
}
