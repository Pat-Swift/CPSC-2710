package cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        
        scene.getStylesheets().add(MainApplication.class.getResource("/styles.css").toExternalForm());

        stage.setTitle("Camping Checklist App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
