package calculator.model;

public enum MathOperations {
    PLUS("+"),
    MINUS("-"),
    MULL("*"),
    DIV("/");

    private final String operationName;
    MathOperations(String s) {
        operationName = s;
    }

    public String getOperationName() {
        return operationName;
    }
}
