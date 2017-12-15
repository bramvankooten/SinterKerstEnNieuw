import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class CategorySelectionController {
    public void algemeenClicked() {
        QuestionScreenController.setInfo(Data.algemeen.next(), "Algemeen");
        changeScene();
    }

    public void dierenClicked() {
        QuestionScreenController.setInfo(Data.dieren.next(), "Dieren");
        changeScene();
    }

    public void etenClicked() {
        QuestionScreenController.setInfo(Data.eten.next(), "Eten");
        changeScene();
    }

    public void geografieClicked() {
        QuestionScreenController.setInfo(Data.geografie.next(), "Geografie");
        changeScene();
    }

    public void geschiedenisClicked() {
        QuestionScreenController.setInfo(Data.geschiedenis.next(), "Geschiedenis");
        changeScene();
    }

    public void muziekClicked() {
        QuestionScreenController.setInfo(Data.muziek.next(), "Muziek");
        changeScene();
    }

    public void nederlandClicked() {
        QuestionScreenController.setInfo(Data.nederland.next(), "Nederland");
        changeScene();
    }

    public void sportClicked() {
        QuestionScreenController.setInfo(Data.sport.next(), "Sport");
        changeScene();
    }

    public void technologieClicked() {
        QuestionScreenController.setInfo(Data.technologie.next(), "Technologie");
        changeScene();
    }

    public void tvClicked() {
        QuestionScreenController.setInfo(Data.tv.next(), "TV");
        changeScene();
    }

    public void vervoerClicked() {
        QuestionScreenController.setInfo(Data.vervoer.next(), "Vervoer");
        changeScene();
    }

    public void backClicked() {
        Pane pane = new Pane();
        try {
            pane = FXMLLoader.load(getClass().getClassLoader().getResource("mainmenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.setScene(pane);
    }

    private void changeScene() {
        Pane pane = new Pane();
        try {
            pane = FXMLLoader.load(getClass().getClassLoader().getResource("questionScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.setScene(pane);
    }
}
