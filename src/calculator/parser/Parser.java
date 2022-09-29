package calculator.parser;

import java.text.ParseException;

public interface Parser<T> {
    ParseEntity<T> parse(final String mathExpr) throws ParseException;
}
