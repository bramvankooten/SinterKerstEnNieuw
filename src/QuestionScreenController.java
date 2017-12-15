import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionScreenController implements Initializable {
    @FXML
    public Label categorieLabel;
    public Label vraagLabel;
    public Label antwoordLabel;
    public Button antwoord;
    public Button next;

    public static Question currentQuestion;
    public static String currentCategorie;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categorieLabel.setText(currentCategorie);
        vraagLabel.setText(currentQuestion.getVraag());
        antwoordLabel.setText(currentQuestion.getAntwoord());
    }

    public static void setInfo(Question question, String categorie) {
        currentQuestion = question;
        currentCategorie = categorie;
    }

    public void antwoordButtonClicked() {
        antwoordLabel.setVisible(true);
        antwoord.setVisible(false);
        next.setVisible(true);
    }

    public void nextClicked() {
        Pane pane = new Pane();
        try {
            pane = FXMLLoader.load(getClass().getClassLoader().getResource("categorySelection.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.setScene(pane);
    }
}
