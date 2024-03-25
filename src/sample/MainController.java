package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public Button selectionButton;

    public void toSelectionSorting() throws IOException {
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("SelectionSort.fxml"));
        Parent root = (Parent) fxmloader.load();

        Stage mStage = new Stage();
        Scene mScene = new Scene(root);

        mStage.setScene(mScene);
        mStage.setTitle("Selection Sort");
        mStage.show();

        Stage stage = (Stage) selectionButton.getScene().getWindow();
        stage.close();
    }

    public void toBubbleSorting() throws IOException {
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("BubbleSort.fxml"));
        Parent root = (Parent) fxmloader.load();

        Stage mStage = new Stage();
        Scene mScene = new Scene(root);

        mStage.setScene(mScene);
        mStage.setTitle("Bubble Sort");
        mStage.show();

        Stage stage = (Stage) selectionButton.getScene().getWindow();
        stage.close();
    }

}
