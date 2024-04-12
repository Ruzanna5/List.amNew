package enums;

public enum Region {
    YEREVAN("Երևան"),
    AJAPNYAK("Աջափնյակ"),
    ARABKIR ("Արաբկիր"),
    AVAN("Ավան"),
    DAVITASHEN("Դավիթաշեն"),
    EREBUNI("Էրեբունի"),
    QANAQER_ZEYTUN("Քանաքեռ զեյթուն"),
    KENTRON("Կենտրոն"),
    MALATIA_SEBASTIA("Մալաթիա սեբաստիա"),
    NOR_NORK("Նոր նորք"),
    SHENGAVIT("Շենգավիթ"),
    NORK_MARASH ("Նորք մարաշ"),
    NORAPAT ("Նորապատ"),
    NORAVAN ("Նորավան"),
    PARAKAR ("Փարաքար"),
    PTGHNI ("Պտղունք"),
    TAIROV ("Թաիրով"),
    AGHAVNATUN ("Աղավնատուն"),
    AKNALICH ("Ակնալիճ"),
    AKNASHEN  ("Ակնաշեն"),
    ALASHKERT("Ալաշկերտ"),
    AMASIA ("Ամասիա"),
    AMBERD("Ամբերդ"),
    APAGA("Ապագա"),
    ARAGATS("Արագած"),
    ARATASHEN("Արատաշեն"),
    ARAXADZOR("Արազափ");

    private final String value;
    Region(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static Region getElementByValue(String value){
        for (Region element: values()){
            if (element.value.equals(value)){
                return element;
            }
        }
        return null;
    }
}