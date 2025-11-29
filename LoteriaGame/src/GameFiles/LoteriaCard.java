package GameFiles;


public enum LoteriaCard {
    CARD1("Yoda", "Images\\yoda.jpg"),
    CARD2("Darth Vader", "Images\\darthvader.jpg"),
    CARD3("Luke Skywalker", "Images\\lukeskywalker.jpg"),
    CARD4("Leia Organa", "Images\\princess_leia.jpg"),
    CARD5("Han Solo", "Images\\hansolo.jpg"),
    CARD6("Chewbacca", "Images\\chewbacca.jpg"),
    CARD7("R2-D2", "Images\\r2d2.jpg"),
    CARD8("C-3PO", "Images\\c3po.jpg"),
    CARD9("Boba Fett", "Images\\bobafett.jpg"),
    CARD10("Kylo Ren", "Images\\kyloren.jpg"),

    CARD11("Padmé Amidala", "Images\\padme.jpg"),
    CARD12("Mace Windu", "Images\\macewindu.jpg"),
    CARD13("Qui-Gon Jinn", "Images\\quigon.jpg"),
    CARD14("Anakin Skywalker", "Images\\anakin.jpg"),
    CARD15("Ahsoka Tano", "Images\\ahsoka.jpg"),
    CARD16("Rey", "Images\\rey.jpg"),
    CARD17("Finn", "Images\\finn.jpg"),
    CARD18("Poe Dameron", "Images\\poedameron.jpg"),
    CARD19("BB-8", "Images\\bb8.jpg"),
    CARD20("Jyn Erso", "Images\\jynerso.jpg"),

    CARD21("Cassian Andor", "Images\\cassianandor.jpg"),
    CARD22("K-2SO", "Images\\k2so.jpg"),
    CARD23("Saw Gerrera", "Images\\sawgerrera.jpg"),
    CARD24("Bodhi Rook", "Images\\bodhirook.jpg"),
    CARD25("Chirrut Îmwe", "Images\\chirrutimwe.jpg"),
    CARD26("Baze Malbus", "Images\\bazemalbus.jpg"),
    CARD27("Darth Maul", "Images\\darthmaul.jpg"),
    CARD28("Orson Krennic", "Images\\orsonkrennic.jpg"),
    CARD29("Palpatine", "Images\\palpatine.jpg"),
    CARD30("Jango Fett", "Images\\jangofett.jpg"),

    CARD31("Jabba the Hutt", "Images\\jabbathehutt.jpg"),
    CARD32("Admiral Ackbar", "Images\\admiralackbar.jpg"),
    CARD33("Uncle Owen", "Images\\uncleowen.jpg"),
    CARD34("Greedo", "Images\\greedo.jpg"),
    CARD35("CloneTrooper1", "Images\\clonetrooper.jpg"),
    CARD36("CloneTrooper2", "Images\\clonetrooper.jpg"),
    CARD37("CloneTrooper3", "Images\\clonetrooper.jpg"),
    CARD38("Jar Jar", "Images\\jarjar.jpg"),
    CARD39("ATST", "Images\\atst.jpg"),
    CARD40("AT-AT", "Images\\atat.jpg"),

    CARD41("Cal Kestis", "Images\\calkestis.jpg"),
    CARD42("Lando Calrissian", "Images\\landocalrissian.jpg"),
    CARD43("Obi-Wan Kenobi", "Images\\obiwankenobi.jpg"),
    CARD44("Ewok", "Images\\ewok.jpg"),
    CARD45("Mandalorian", "Images\\mandalorian.jpg"),
    CARD46("Vicrul", "Images\\vicrul.jpg"),
    CARD47("Kuruk", "Images\\kuruk.jpg"),
    CARD48("Trudgen", "Images\\trudgen.jpg"),
    CARD49("Cardo", "Images\\cardo.jpg"),
    CARD50("Ushar", "Images\\ushar.jpg"),

    CARD51("Ap'Lek", "Images\\aplek.jpg"),
    CARD52("Droidekas", "Images\\droidekas.jpg"),
    CARD53("Super Battle Droid", "Images\\superbattledroid.jpg"),
    CARD54("Droid", "Images\\droid.jpg");

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
