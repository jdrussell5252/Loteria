package GameFiles;

import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;


public class LoteriaFrame extends BorderPane {
    public LoteriaFrame() {
        buildFrame();
    }

    private void buildFrame() {
        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: lightblue;");

        //Top Section - title and current card
        VBox topSection = createTopSection();
        this.setTop(topSection);

        //Center Section - main game area
        HBox centerSection = createCenterSection();
        this.setCenter(centerSection);
    }

    private VBox createTopSection() {
        VBox topSection = new VBox(10);
        topSection.setAlignment(Pos.CENTER);
        topSection.setPadding(new Insets(10));
        
        Label titleLabel = new Label("Lotería Game");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        topSection.getChildren().add(titleLabel);

        return topSection;
    }

    private HBox createCenterSection() {
        HBox centerSection = new HBox(10);
        centerSection.setAlignment(Pos.CENTER);
        centerSection.setPadding(new Insets(10));
        return centerSection;
    }

}
