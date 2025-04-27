package edu.au.cpsc.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;

public class LauncherApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/launcher/launcher-app.fxml"));
        Parent root = loader.load();


        URL testUrl = getClass().getClassLoader().getResource("images/airport.png");
        System.out.println("Resolved image URL: " + testUrl);


        // 🎯 Lookup buttons from the FXML and apply icons
        Button airportsBtn = (Button) root.lookup("#airportsBtn");
        Button seatReservationsBtn = (Button) root.lookup("#seatReservationsBtn");
        Button flightScheduleBtn = (Button) root.lookup("#flightScheduleBtn");
        Button aircraftBtn = (Button) root.lookup("#aircraftBtn");

        setIcon(airportsBtn, "images/airport.png");
        setIcon(seatReservationsBtn, "images/seat.png");
        setIcon(flightScheduleBtn, "images/flight.png");
        setIcon(aircraftBtn, "images/aircraft.png");


        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("/edu/au/cpsc/launcher/style/launcher-style.css").toExternalForm());

        stage.setTitle("Part 2");
        stage.setScene(scene);
        stage.show();
    }

    private void setIcon(Button btn, String resourcePath) {
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(resourcePath));
        ImageView view = new ImageView(image);
        view.setFitWidth(24);
        view.setFitHeight(24);
        view.setPreserveRatio(true);
        btn.setGraphic(view);
    }



    public static void main(String[] args) {
        launch();
    }
}
