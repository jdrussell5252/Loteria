package Loteria;
import java.util.*;

public class DeckOfCards {
    private final List<Card> cards = new ArrayList<>();
    private int index = 0;

    public DeckOfCards() {
        buildDeck();
        shuffle();
    }// End of 'DeckOfCards' Constructor.

    public void shuffle() {
        Collections.shuffle(cards);
        this.index = 0;
    }// End of 'shuffle'.

    private void buildDeck() {
        cards.clear();
        cards.add(new Card(1, "Storm Trooper", null));
        // ...
        // cards.add(new Card(54, , ))
    }// End of 'buildDeck'.

    public Card draw() {
        if(!hasNext()) {
            return null;
        }
        return cards.get(index++);
    }// End of 'draw'.

    public boolean hasNext() {
        return this.index < cards.size();
    }// End of 'hasNext'.
    
}// End of 'DeckOfCards' Class.
