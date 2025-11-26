package GameFiles;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.io.File;

public class LoteriaFrame extends BorderPane {

    private final Controller controller = new Controller();
    private Label currentCardLabel;
    private HBox centerSection;

    public LoteriaFrame() {
        buildFrame();
        controller.startGame();
    }

    private void buildFrame() {
        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: lightblue;");

        // Top: Title and current card
        VBox topSection = createTopSection();
        this.setTop(topSection);

        // Center: The two player boards will go here
        centerSection = createCenterSection();
        this.setCenter(centerSection);
        
        // Bottom: Buttons
        HBox bottomSection = createBottomSection();
        this.setBottom(bottomSection);
    }

    private VBox createTopSection() {
        VBox topSection = new VBox(10);
        topSection.setAlignment(Pos.CENTER);
        topSection.setPadding(new Insets(10));
        
        Label titleLabel = new Label("🎲 Lotería Game 🎲");
        titleLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold;");
        
        currentCardLabel = new Label("Click 'Call Card' to start");
        currentCardLabel.setStyle("-fx-font-size: 18px; -fx-padding: 10;");
        
        topSection.getChildren().addAll(titleLabel, currentCardLabel);
        return topSection;
    }

    private HBox createCenterSection() {
        HBox centerSection = new HBox(30);
        centerSection.setAlignment(Pos.CENTER);
        centerSection.setPadding(new Insets(20));
        
        // Left side - Player 1 with tabla
        VBox player1Section = createPlayerSection(0);
        
        // Right side - Player 2 with tabla
        VBox player2Section = createPlayerSection(1);
        
        centerSection.getChildren().addAll(player1Section, player2Section);
        return centerSection;
    }
    
    // Create a player section with label and tabla grid
    private VBox createPlayerSection(int playerIndex) {
        VBox section = new VBox(10);
        section.setAlignment(Pos.CENTER);
        
        Player player = controller.getGame().getPlayer(playerIndex);
        
        // Player name label
        Label playerLabel = new Label(player.getName());
        playerLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Create a simple 4x4 grid to show the tabla
        GridPane tablaGrid = new GridPane();
        tablaGrid.setHgap(0);  // No space between columns
        tablaGrid.setVgap(0);  // No space between rows
        
        // Get the player's tabla
        LoteriaTabla tabla = player.getTabla();
        
        // Fill the grid with cards from the tabla
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                LoteriaCard card = tabla.getCard(row, col);
                
                // Create a StackPane to overlay marker on card
                StackPane cardStack = new StackPane();
                cardStack.setAlignment(Pos.CENTER);
                
                // Create the card box
                VBox cardBox = new VBox();
                cardBox.setAlignment(Pos.CENTER);
                cardBox.setStyle("-fx-border-color: black; -fx-border-width: 2; " +
                               "-fx-min-width: 80; -fx-min-height: 80; " +
                               "-fx-background-color: white;");
                
                String imagePath = card.getImagePath();
                
                // Try to load image if path exists
                if (!imagePath.isEmpty()) {
                    try {
                        File imageFile = new File(imagePath);
                        if (imageFile.exists()) {
                            // Use ImageIO to load the image, then convert to JavaFX Image
                            java.awt.image.BufferedImage bufferedImage = ImageIO.read(imageFile);
                            Image fxImage = SwingFXUtils.toFXImage(bufferedImage, null);
                            
                            ImageView imageView = new ImageView(fxImage);
                            imageView.setFitWidth(75);
                            imageView.setFitHeight(75);
                            imageView.setPreserveRatio(true);
                            
                            cardBox.getChildren().add(imageView);
                        } else {
                            // Fallback to text label only
                            Label nameLabel = new Label(card.getName());
                            nameLabel.setStyle("-fx-font-size: 10px;");
                            cardBox.getChildren().add(nameLabel);
                        }
                    } catch (Exception e) {
                        System.out.println("Error loading image for " + card.getName() + ": " + e.getMessage());
                        // Fallback to text label only
                        Label nameLabel = new Label(card.getName());
                        nameLabel.setStyle("-fx-font-size: 10px;");
                        cardBox.getChildren().add(nameLabel);
                    }
                } else {
                    // No image path - use text label only
                    Label nameLabel = new Label(card.getName());
                    nameLabel.setStyle("-fx-font-size: 10px;");
                    cardBox.getChildren().add(nameLabel);
                }
                
                // Create marker (initially invisible)
                Circle marker = new Circle(15);
                marker.setFill(Color.rgb(255, 0, 0, 0.7));
                marker.setStroke(Color.DARKRED);
                marker.setStrokeWidth(2);
                marker.setVisible(false);
                
                // Add card and marker to stack
                cardStack.getChildren().addAll(cardBox, marker);
                
                // Update marker visibility based on card marked status
                if(tabla.isMarked(row, col)) {
                    marker.setVisible(true);
                }
                
                // Add to grid at row, col position
                tablaGrid.add(cardStack, col, row);
            }
        }
        
        section.getChildren().addAll(playerLabel, tablaGrid);
        return section;
    }
    
    private void showWinnerAlert(String playerName) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("¡LOTERÍA!");
        alert.setHeaderText("🎉 " + playerName + " WINS! 🎉");
        alert.setContentText("Congratulations! " + playerName + " has won the game!");
        alert.showAndWait();
    }
    
    private HBox createBottomSection() {
        HBox bottomSection = new HBox(20);
        bottomSection.setAlignment(Pos.CENTER);
        bottomSection.setPadding(new Insets(15));

        Button callCardButton = new Button("Call Card");
        callCardButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 30;");
        callCardButton.setOnAction(e -> {
            if(controller.getGame().isGameActive()) {
                System.out.println("Call Card clicked!");
                LoteriaCard card = controller.nextCard();
                if (card != null) {
                    currentCardLabel.setText("Called: " + card.getName());
                    // Auto-mark the card for all players and refresh display
                    controller.autoMarkCalledCard(card);
                    refreshPlayerBoards();
                    
                    // Check for automatic win after marking
                    checkForWinner();
                } else {
                    currentCardLabel.setText("No more cards!");
                }
            }
        });

        Button restartButton = new Button("Restart Game");
        restartButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 30;");
        restartButton.setOnAction(e -> {
            System.out.println("Restart clicked!");
            restartGame();
        });

        bottomSection.getChildren().addAll(callCardButton, restartButton);
        return bottomSection;
    }
    
    private void restartGame() {
        controller.resetGame();
        currentCardLabel.setText("Click 'Call Card' to start");
        
        // Clear the old center section first
        this.getChildren().remove(centerSection);
        
        // Rebuild the center section with new tablas
        centerSection = createCenterSection();
        this.setCenter(centerSection);
    }
    
    // Method to refresh player boards when cards are marked
    private void refreshPlayerBoards() {
        // Clear the old center section first
        this.getChildren().remove(centerSection);
        
        // Rebuild the center section
        centerSection = createCenterSection();
        this.setCenter(centerSection);
    }
    
    // Check if any player has won automatically
    private void checkForWinner() {
        for(int i = 0; i < controller.getGame().getPlayers().size(); i++) {
            Player player = controller.getGame().getPlayer(i);
            if(player != null && player.hasWon()) {
                controller.getGame().endGame();
                showWinnerAlert(player.getName());
                break;
            }
        }
    }
}// End of 'LoteriaFrame' Class.


