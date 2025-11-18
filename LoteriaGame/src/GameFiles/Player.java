package GameFiles;

public class Player {
    private final String name;
    private final LoteriaTabla tabla;

    public Player(String name) {
        this.name = name;
        this.tabla = new LoteriaTabla();
    }// End of 'Player' Constructor.

    public String getName() {
        return this.name;
    }// End of 'getName'.

    public LoteriaTabla getTabla() {
        return this.tabla;
    }// End of 'getTabla'.

    public boolean markCard(LoteriaCard card) {
        return this.tabla.markCard(card);
    }// End of 'markCard'.

    public boolean hasWon() {
        return this.tabla.checkWin();
    }// End of 'hasWon'.
}// End of 'Player' Class.
