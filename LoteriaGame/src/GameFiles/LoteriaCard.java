package GameFiles;


public enum LoteriaCard {
    CARD1("Yoda", "Images\\yoda.jpg"),
    CARD2("Darth Vader", ""),
    CARD3("Luke Skywalker", ""),
    CARD4("Leia Organa", "Images\\princess_leia.jpg"),
    CARD5("Han Solo", ""),
    CARD6("Chewbacca", "Images\\chewbacca.jpg"),
    CARD7("R2-D2", ""),
    CARD8("C-3PO", ""),
    CARD9("Boba Fett", ""),
    CARD10("Kylo Ren", ""),

    CARD11("Padmé Amidala", ""),
    CARD12("Mace Windu", ""),
    CARD13("Qui-Gon Jinn", ""),
    CARD14("Anakin Skywalker", ""),
    CARD15("Ahsoka Tano", ""),
    CARD16("Rey", ""),
    CARD17("Finn", ""),
    CARD18("Poe Dameron", ""),
    CARD19("BB-8", ""),
    CARD20("Jyn Erso", ""),

    CARD21("Cassian Andor", ""),
    CARD22("K-2SO", ""),
    CARD23("Saw Gerrera", ""),
    CARD24("Bodhi Rook", ""),
    CARD25("Chirrut Îmwe", ""),
    CARD26("Baze Malbus", ""),
    CARD27("Jyn Erso", ""),
    CARD28("Orson Krennic", ""),
    CARD29("Director Krennic", ""),
    CARD30("Galen Erso", ""),

    CARD31("Bodhi Rook", ""),
    CARD32("Chirrut Îmwe", ""),
    CARD33("Baze Malbus", ""),
    CARD34("Jyn Erso", ""),
    CARD35("CloneTrooper1", "Images\\clonetrooper.jpg"),
    CARD36("CloneTrooper2", "Images\\clonetrooper.jpg"),
    CARD37("CloneTrooper3", "Images\\clonetrooper.jpg"),
    CARD38("CloneTrooper4", "Images\\clonetrooper.jpg"),
    CARD39("CloneTrooper5", "Images\\clonetrooper.jpg"),
    CARD40("CloneTrooper6", "Images\\clonetrooper.jpg"),

    CARD41("CloneTrooper7", "Images\\clonetrooper.jpg"),
    CARD42("CloneTrooper8", "Images\\clonetrooper.jpg"),
    CARD43("CloneTrooper9", "Images\\clonetrooper.jpg"),
    CARD44("CloneTrooper10", "Images\\clonetrooper.jpg"),
    CARD45("CloneTrooper11", "Images\\clonetrooper.jpg"),
    CARD46("CloneTrooper12", "Images\\clonetrooper.jpg"),
    CARD47("CloneTrooper13", "Images\\clonetrooper.jpg"),
    CARD48("CloneTrooper14", "Images\\clonetrooper.jpg"),
    CARD49("CloneTrooper15", "Images\\clonetrooper.jpg"),
    CARD50("CloneTrooper16", "Images\\clonetrooper.jpg"),

    CARD51("CloneTrooper17", "Images\\clonetrooper.jpg"),
    CARD52("CloneTrooper18", "Images\\clonetrooper.jpg"),
    CARD53("CloneTrooper19", "Images\\clonetrooper.jpg"),
    CARD54("CloneTrooper20", "Images\\clonetrooper.jpg");

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
