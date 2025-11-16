package GameFiles;

public class Controller {

    private final Caller caller;

    public Controller(){
        DeckOfCards<LoteriaCard> deck = new DeckOfCards<>(LoteriaCard.class);
        this.caller = new Caller(deck);
    }

    // Start game and shuffle the deck
    public void startGame(){
        caller.reshuffle();
        System.out.println("Game Started");
    }

    // Move to next card
    public LoteriaCard nextCard(){
        return caller.callNext();
    }

    // Check for winner
    public void checkWin(){
        System.out.println("Game Won");
    }

    public boolean handleLoteria(Player player){
        System.out.println("handling loteria");
        return false;
    }

}
