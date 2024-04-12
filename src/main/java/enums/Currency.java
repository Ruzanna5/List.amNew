package enums;

public enum Currency {
    AMD("AMD"),

    USD("USD");


    private final String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Currency getElementByValue(String value) {
        for (Currency elem : values()) {
            if (elem.value.equals(value)) {
                return elem;
            }
        }
        return null;
    }


}
