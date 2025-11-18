package GameFiles;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players;
    private LoteriaCard lastCalledCard;
    private boolean gameActive;

    public Game() {
        this.players = new ArrayList<>();
        this.lastCalledCard = null;
        this.gameActive = false;
    }// End of 'Game' Constructor.

    public void addPlayer(Player player) {
        this.players.add(player);
    }// End of 'addPlayer'.

    public List<Player> getPlayers() {
        return this.players;
    }// End of 'getPlayers'.

    public Player getPlayer(int index) {
        if(index >= 0 && index < players.size()) {
            return players.get(index);
        }
        return null;
    }// End of 'getPlayer'.

    public void setLastCalledCard(LoteriaCard card) {
        this.lastCalledCard = card;
    }// End of 'setLastCalledCard'.

    public LoteriaCard getLastCalledCard() {
        return this.lastCalledCard;
    }// End of 'getLastCalledCard'.

    public void startGame() {
        this.gameActive = true;
        this.lastCalledCard = null;
    }// End of 'startGame'.

    public void endGame() {
        this.gameActive = false;
    }// End of 'endGame'.

    public boolean isGameActive() {
        return this.gameActive;
    }// End of 'isGameActive'.

    public Player checkForWinner() {
        for(Player player : players) {
            if(player.hasWon()) {
                return player;
            }
        }
        return null;
    }// End of 'checkForWinner'.
}// End of 'Game' Class.
