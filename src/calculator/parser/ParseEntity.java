package calculator.parser;

import calculator.model.MathOperations;

public record ParseEntity<T>(T leftOperand, T rightOperand, MathOperations operation) {
}
