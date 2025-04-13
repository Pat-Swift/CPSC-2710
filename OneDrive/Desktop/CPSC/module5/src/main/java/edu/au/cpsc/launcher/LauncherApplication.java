package edu.au.cpsc.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader loader = new FXMLLoader(
                LauncherApplication.class.getResource("/edu/au/cpsc/launcher/launcher-app.fxml")
        );
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(
                getClass().getResource("/edu/au/cpsc/launcher/style/main.css").toExternalForm()
        );

        System.out.println("Stylesheets: " + scene.getStylesheets());


        stage.setTitle("Part 2");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

