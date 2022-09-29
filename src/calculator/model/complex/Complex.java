package calculator.model.complex;

import java.util.Objects;

public class Complex {
    private final double re;
    private final double img;

    public Complex() {
        this(0., 0.);
    }

    public Complex(double re, double img) {
        this.re = re;
        this.img = img;
    }

    public static Complex parseComplex(String expr) {
        if (expr.indexOf("i") == -1) {
            return new Complex(Double.parseDouble(expr), 0);
        }
        String[] tokens = expr.split("i");
        if (tokens.length == 0){
            return new Complex(0., 1.);
        }
        Double imgPart = tokens.length == 1 ? 1 : Double.parseDouble(tokens[1].trim());
        String leftPart = tokens[0].trim();
        if (leftPart.isBlank()){
           return new Complex(0., imgPart);
        }
        else{
            String sign = leftPart.substring(leftPart.length() - 1);
            if (sign.equals("-")) {
                imgPart *= -1;
            }
            Double rePart = 0.;
            if (leftPart.length() > 1) {
                rePart = Double.parseDouble(leftPart.substring(0, leftPart.length() - 1));
            }
            return new Complex(rePart, imgPart);
        }
    }

    public double getRe() {
        return re;
    }

    public double getImg() {
        return img;
    }

    public double getAbs2() {
        return Math.pow(re, 2) + Math.pow(img, 2);
    }

    public double getAbs() {
        return Math.sqrt(getAbs2());
    }

    @Override
    public String toString() {
        if (img >= 0) {
            return String.format("%f + i%f", re, img);
        } else {
            return String.format("%f - i%f", re, Math.abs(img));
        }
    }
}
