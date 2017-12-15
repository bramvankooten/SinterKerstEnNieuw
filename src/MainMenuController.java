import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainMenuController {

    public void quitButtonClicked() {
        System.exit(0);
    }

    public void startButtonClicked() {
        Pane pane = new Pane();
        try {
            pane = FXMLLoader.load(getClass().getClassLoader().getResource("categorySelection.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.setScene(pane);
    }
}
