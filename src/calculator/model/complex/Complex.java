package calculator.model.complex;

import java.util.Objects;

public class Complex {
    private final double re;
    private final double img;

    public double getRe() {
        return re;
    }

    public double getImg() {
        return img;
    }

    public double getAbs2(){
        return Math.pow(re, 2) + Math.pow(img, 2);
    }

    public double getAbs(){
        return Math.sqrt(getAbs2());
    }

    public Complex(){
        this(0.,0.);
    }

    public Complex(double re, double img) {
        this.re = re;
        this.img = img;
    }

    @Override
    public String toString() {
        return String.format("%f + i%f", re, img);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.img, img) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, img);
    }

}
