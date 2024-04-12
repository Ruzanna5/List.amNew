package enums;

public enum Engines {
    BENZIN("Բենզին"),
    DISEL("Դիզել"),
    HIBRYD("Հիբրիդ"),
    ELECTRO("էլեկտրական"),
    VAZGEN("Վազգեն");



    private final String value;

     Engines(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Engines getElementByValue(String value) {
        for (Engines elem : values()) {
            if (elem.value.equals(value)) {
                return elem;
            }
        }
        return null;
    }
}
