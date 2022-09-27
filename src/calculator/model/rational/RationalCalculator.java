package calculator.model.rational;

import calculator.model.Calculator;

public class RationalCalculator implements Calculator<Double> {
    @Override
    public Double sum(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double diff(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double mul(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double div(Double a, Double b) {
        return a / b;
    }
}
