package GameFiles;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;


public class LoteriaTabla {
    private final int n = 4; // 4x4 grid
    private final LoteriaCard[][] grid = new LoteriaCard[n][n];
    private final boolean[][] marked = new boolean[n][n];

    public LoteriaTabla(){
        // Randomly select 16 cards from the 54 available
        LoteriaCard[] allCards = LoteriaCard.values(); //declares all cards in enum to an array
        List<LoteriaCard> cardList = new ArrayList<>(Arrays.asList(allCards)); //convert array to list
        Collections.shuffle(cardList); //shuffle the list to randomize order
        List<LoteriaCard> selectedCards = cardList.subList(0, n * n); //take first 16 cards

        // Arrange them in a 4x4 grid and initialize marked array
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = selectedCards.get(i * n + j);
                marked[i][j] = false;
            }
        }
    }// End of 'LoteriaTabla' Constructor.

    public boolean markCard(LoteriaCard card) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == card) {
                    marked[i][j] = true;
                    return true;
                }
            }
        }
        return false;
    }// End of 'markCard'.

    public LoteriaCard getCard(int row, int col) {
        return grid[row][col];
    }// End of 'getCard'.

    public boolean isMarked(int row, int col) {
        return marked[row][col];
    }// End of 'isMarked'.

    public int getSize() {
        return n;
    }// End of 'getSize'.

    public boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals() || checkFourCorners();
    }// End of 'checkWin'.

    private boolean checkRows() {
        for(int i = 0; i < n; i++) {
            boolean rowComplete = true;
            for(int j = 0; j < n; j++) {
                if(!marked[i][j]) {
                    rowComplete = false;
                    break;
                }
            }
            if(rowComplete) return true;
        }
        return false;
    }// End of 'checkRows'.

    private boolean checkColumns() {
        for(int j = 0; j < n; j++) {
            boolean colComplete = true;
            for(int i = 0; i < n; i++) {
                if(!marked[i][j]) {
                    colComplete = false;
                    break;
                }
            }
            if(colComplete) return true;
        }
        return false;
    }// End of 'checkColumns'.

    private boolean checkDiagonals() {
        // Check top-left to bottom-right diagonal
        boolean diagonal1 = true;
        for(int i = 0; i < n; i++) {
            if(!marked[i][i]) {
                diagonal1 = false;
                break;
            }
        }
        if(diagonal1) return true;

        // Check top-right to bottom-left diagonal
        boolean diagonal2 = true;
        for(int i = 0; i < n; i++) {
            if(!marked[i][n - 1 - i]) {
                diagonal2 = false;
                break;
            }
        }
        return diagonal2;
    }// End of 'checkDiagonals'.

    private boolean checkFourCorners() {
        return marked[0][0] && marked[0][n-1] && marked[n-1][0] && marked[n-1][n-1];
    }// End of 'checkFourCorners'.
}// End of 'LoteriaTabla' Class.
