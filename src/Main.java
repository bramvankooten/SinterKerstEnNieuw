import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Data.loadCategories();
        mainStage = primaryStage;
        Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("mainmenu.fxml"));
        mainStage.setScene(new Scene(pane));
        mainStage.setFullScreen(true);
        mainStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        mainStage.show();
    }

    public static void setScene(Pane pane) {
        mainStage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
