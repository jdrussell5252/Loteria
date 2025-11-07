package GameFiles;

public class Caller {
    private final DeckOfCards<LoteriaCard> deck;

    public Caller(DeckOfCards<LoteriaCard> deck) {
        this.deck = deck;
    }// End of 'Caller' Constructor.

    public LoteriaCard callNext() {
        if(!this.deck.hasNext()) {
            System.out.println("No more cards left.");
            return null;
        }
        LoteriaCard next = this.deck.draw();
        System.out.println("Caller shouts: " + next);
        return next;
    }// End of 'callNext'.

    public void reshuffle() {
        this.deck.shuffle();
    }// End of 'reshuffle'.
}// End of 'Caller' Class.
