package calculator;

public enum CalcMode {
    RATIONAL("Вещественный"),
    COMPLEX("Комплексный");

    private final String modeName;
    CalcMode(String modeName) {
        this.modeName = modeName;
    }

    public String getModeName() {
        return modeName;
    }
}
