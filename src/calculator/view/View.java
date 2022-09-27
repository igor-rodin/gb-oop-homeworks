package calculator.view;

import calculator.CalcMode;

public interface View {
    String getExpression();
    void showResult(String result);
    CalcMode showMenu();
}
