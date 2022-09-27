package calculator.model;

public interface Calculator <T>{
    T sum(T a, T b);
    T diff(T a, T b);
    T mul(T a, T b);
    T div(T a, T b);
}
