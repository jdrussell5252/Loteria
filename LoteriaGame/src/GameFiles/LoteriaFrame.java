package GameFiles;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.io.File;

public class LoteriaFrame extends BorderPane {

    private final Controller controller = new Controller();
    private Label currentCardLabel;

    public LoteriaFrame() {
        buildFrame();
    }

    private void buildFrame() {
        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: lightblue;");

        // Top: Title and current card
        VBox topSection = createTopSection();
        this.setTop(topSection);

        // Center: The two player boards will go here
        HBox centerSection = createCenterSection();
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
        VBox player1Section = createPlayerSection("Player 1");
        
        // Right side - Player 2 with tabla
        VBox player2Section = createPlayerSection("Player 2");
        
        centerSection.getChildren().addAll(player1Section, player2Section);
        return centerSection;
    }
    
    // Create a player section with label and tabla grid
    private VBox createPlayerSection(String playerName) {
        VBox section = new VBox(10);
        section.setAlignment(Pos.CENTER);
        
        // Player name label
        Label playerLabel = new Label(playerName);
        playerLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Create a simple 4x4 grid to show the tabla
        GridPane tablaGrid = new GridPane();
        tablaGrid.setHgap(0);  // No space between columns
        tablaGrid.setVgap(0);  // No space between rows
        
        // Create a tabla
        LoteriaTabla tabla = new LoteriaTabla();
        
        // Fill the grid with cards from the tabla
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                LoteriaCard card = tabla.getCard(row, col);
                
                // Try to load the image
                VBox cardBox = new VBox();
                cardBox.setAlignment(Pos.CENTER);
                cardBox.setStyle("-fx-border-color: black; -fx-border-width: 2; " +
                               "-fx-min-width: 80; -fx-min-height: 80;");
                
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
                            // Fallback to colored rectangle
                            VBox cardContent = new VBox(5);
                            cardContent.setAlignment(Pos.CENTER);
                            Rectangle rect = new Rectangle(70, 70);
                            rect.setFill(Color.LIGHTBLUE);
                            rect.setStroke(Color.BLACK);
                            rect.setStrokeWidth(1);
                            Label nameLabel = new Label(card.getName());
                            nameLabel.setStyle("-fx-font-size: 10px;");
                            cardContent.getChildren().addAll(rect, nameLabel);
                            cardBox.getChildren().add(cardContent);
                        }
                    } catch (Exception e) {
                        System.out.println("Error loading image for " + card.getName() + ": " + e.getMessage());
                        // Fallback to colored rectangle
                        VBox cardContent = new VBox(5);
                        cardContent.setAlignment(Pos.CENTER);
                        Rectangle rect = new Rectangle(70, 70);
                        rect.setFill(Color.LIGHTBLUE);
                        rect.setStroke(Color.BLACK);
                        rect.setStrokeWidth(1);
                        Label nameLabel = new Label(card.getName());
                        nameLabel.setStyle("-fx-font-size: 10px;");
                        cardContent.getChildren().addAll(rect, nameLabel);
                        cardBox.getChildren().add(cardContent);
                    }
                } else {
                    // No image path - use colored rectangle
                    VBox cardContent = new VBox(5);
                    cardContent.setAlignment(Pos.CENTER);
                    Rectangle rect = new Rectangle(70, 70);
                    rect.setFill(Color.LIGHTBLUE);
                    rect.setStroke(Color.BLACK);
                    rect.setStrokeWidth(1);
                    Label nameLabel = new Label(card.getName());
                    nameLabel.setStyle("-fx-font-size: 10px;");
                    cardContent.getChildren().addAll(rect, nameLabel);
                    cardBox.getChildren().add(cardContent);
                }
                
                // Add to grid at row, col position
                tablaGrid.add(cardBox, col, row);
            }
        }
        
        section.getChildren().addAll(playerLabel, tablaGrid);
        return section;
    }
    
    private HBox createBottomSection() {
        HBox bottomSection = new HBox(20);
        bottomSection.setAlignment(Pos.CENTER);
        bottomSection.setPadding(new Insets(15));

        Button callCardButton = new Button("Call Card");
        callCardButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 30;");
        callCardButton.setOnAction(e -> {
            System.out.println("Call Card clicked!");
            LoteriaCard card = controller.nextCard();
            if (card != null) {
                currentCardLabel.setText("Called: " + card.getName());
            } else {
                currentCardLabel.setText("No more cards!");
            }
        });

        Button restartButton = new Button("Restart Game");
        restartButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 30;");
        restartButton.setOnAction(e -> {
            System.out.println("Restart clicked!");
            controller.startGame();
            currentCardLabel.setText("Click 'Call Card' to start");
        });

        bottomSection.getChildren().addAll(callCardButton, restartButton);
        return bottomSection;
    }
}

