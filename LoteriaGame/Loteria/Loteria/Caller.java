package Loteria;

public class Caller {
    private final DeckOfCards deck;

    public Caller(DeckOfCards deck) {
        this.deck = deck;
    }// End of 'Caller' Constructor.

    public Card callNext() {
        return this.deck.draw();
    }// End of 'callNext'.

    public void reshuffle() {
        this.deck.shuffle();
    }// End of 'reshuffle'.
}// End of 'Caller' Class.
