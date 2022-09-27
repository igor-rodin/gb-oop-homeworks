package calculator.parser;

import calculator.model.exeption.CalculataorExeption;

public interface Parser <T> {
    ParseEntity<T> parse(final String mathExpr) throws CalculataorExeption;
}
