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
}
