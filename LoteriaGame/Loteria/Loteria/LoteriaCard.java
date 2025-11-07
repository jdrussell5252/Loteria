package Loteria;


public enum LoteriaCard {
    CARD1("", ""),
    CARD2("", ""),
    CARD3("", ""),
    CARD4("", ""),
    CARD5("", ""),
    CARD6("", ""),
    CARD7("", ""),
    CARD8("", ""),
    CARD9("", ""),
    CARD10("", ""),

    CARD11("", ""),
    CARD12("", ""),
    CARD13("", ""),
    CARD14("", ""),
    CARD15("", ""),
    CARD16("", ""),
    CARD17("", ""),
    CARD18("", ""),
    CARD19("", ""),
    CARD20("", ""),

    CARD21("", ""),
    CARD22("", ""),
    CARD23("", ""),
    CARD24("", ""),
    CARD25("", ""),
    CARD26("", ""),
    CARD27("", ""),
    CARD28("", ""),
    CARD29("", ""),
    CARD30("", ""),

    CARD31("", ""),
    CARD32("", ""),
    CARD33("", ""),
    CARD34("", ""),
    CARD35("", ""),
    CARD36("", ""),
    CARD37("", ""),
    CARD38("", ""),
    CARD39("", ""),
    CARD40("", ""),

    CARD41("", ""),
    CARD42("", ""),
    CARD43("", ""),
    CARD44("", ""),
    CARD45("", ""),
    CARD46("", ""),
    CARD47("", ""),
    CARD48("", ""),
    CARD49("", ""),
    CARD50("", ""),

    CARD51("", ""),
    CARD52("", ""),
    CARD53("", ""),
    CARD54("", "");

    private final String name;
    private final String imagePath;

    LoteriaCard(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }// End of 'LoteriaCard' Constructor.

    public String getName() {
        return this.name;
    }// End of 'getName'.

    public String getImagePath() {
        return this.imagePath;
    }// End of 'getImagePath'.
}
