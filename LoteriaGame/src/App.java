import GameFiles.LoteriaFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        LoteriaFrame gameFrame = new LoteriaFrame();
        Scene scene = new Scene(gameFrame, 1200, 700);
        stage.setTitle("Lotería!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
