package GameFiles;
import java.util.*;

public class DeckOfCards<T extends Enum<T>> {
    private final List<T> deckList;
    private int index;

    public DeckOfCards(Class<T> enumType) {
        this.deckList = new ArrayList<>(EnumSet.allOf(enumType));
        this.index = 0;
        this.shuffle();
    }// End of 'DeckOfCards' Constructor.

    public void shuffle() {
        Collections.shuffle(this.deckList);
        this.index = 0;
    }// End of 'shuffle'.

    public T draw() {
        if(!hasNext()) {
            return null;
        }
        return this.deckList.get(this.index++);
    }// End of 'draw'.

    public boolean hasNext() {
        return this.index < this.deckList.size();
    }// End of 'hasNext'.
    
}// End of 'DeckOfCards' Class.
