package calculator.model.complex;

import calculator.model.Calculator;

public class ComplexCalculator implements Calculator<Complex> {
    @Override
    public Complex sum(Complex a, Complex b) {
        return new Complex(a.getRe() + b.getRe(), a.getImg() + b.getImg());
    }

    @Override
    public Complex diff(Complex a, Complex b) {
        return new Complex(a.getRe() - b.getRe(), a.getImg() - b.getImg());
    }

    @Override
    public Complex mul(Complex a, Complex b) {
        double re = a.getRe() * b.getRe() - a.getImg() * b.getImg();
        double img = a.getRe() * b.getImg() + a.getImg() * b.getRe();
        return new Complex(re, img);
    }

    @Override
    public Complex div(Complex a, Complex b) {
        double re = (a.getRe() * b.getRe() + a.getImg() * b.getImg()) / b.getAbs2();
        double img = (b.getRe() * a.getImg() - b.getImg() * a.getRe()) / b.getAbs2();
        return new Complex(re, img);
    }
}
