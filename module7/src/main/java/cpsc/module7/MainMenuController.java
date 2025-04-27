package cpsc.module7;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;


public class MainMenuController {

    @FXML
    private Parent rootPane;

    @FXML
    public void initialize() {
        rootPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.getAccelerators().put(
                        new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN),
                        this::openPackingList
                );
                newScene.getAccelerators().put(
                        new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN),
                        this::openDogList
                );
                newScene.getAccelerators().put(
                        new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN),
                        this::openFoodList
                );
            }
        });
    }


    private void openChecklistWindow(String title, String csvPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChecklistView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

            ChecklistViewController controller = loader.getController();
            controller.setCsvFileName(csvPath);

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
            // Apply fade-in animation
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), root);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openPackingList() {
        openChecklistWindow("Packing List", "/packing_list.csv");
    }

    @FXML
    public void openDogList() {
        openChecklistWindow("Dog List", "/dog_list.csv");
    }

    @FXML
    public void openFoodList() {
        openChecklistWindow("Food List", "/food_list.csv");
    }
}
