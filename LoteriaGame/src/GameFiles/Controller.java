package GameFiles;

public class Controller {

    private final Caller caller;
    private final Game game;

    public Controller(){
        DeckOfCards<LoteriaCard> deck = new DeckOfCards<>(LoteriaCard.class);
        this.caller = new Caller(deck);
        this.game = new Game();
        
        // Initialize two players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        game.addPlayer(player1);
        game.addPlayer(player2);
    }

    // Start game and shuffle the deck
    public void startGame(){
        caller.reshuffle();
        game.startGame();
        System.out.println("Game Started");
    }

    // Move to next card
    public LoteriaCard nextCard(){
        LoteriaCard card = caller.callNext();
        if(card != null) {
            game.setLastCalledCard(card);
        }
        return card;
    }

    // Get the game object
    public Game getGame(){
        return this.game;
    }

    // Auto-mark the called card for all players
    public void autoMarkCalledCard(LoteriaCard card) {
        for(Player player : game.getPlayers()) {
            player.markCard(card);
        }
    }

    // Check if a player has won when they call "Loteria!"
    public boolean handleLoteria(int playerIndex){
        System.out.println("Handling loteria for player " + playerIndex);
        Player player = game.getPlayer(playerIndex);
        if(player != null && player.hasWon()) {
            game.endGame();
            System.out.println(player.getName() + " has won!");
            return true;
        }
        System.out.println("False alarm - no win pattern!");
        return false;
    }

}// End of 'Controller' Class.
