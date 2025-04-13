package edu.au.cpsc.launcher;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LauncherController {

    @FXML private Button airportsBtn;
    @FXML private Button seatReservationsBtn;
    @FXML private Button flightScheduleBtn;
    @FXML private Button aircraftBtn;

    @FXML
    public void initialize() {
        loadIcon(airportsBtn, "/edu.au.cpsc.launcher/style/images/airport.png");
        loadIcon(seatReservationsBtn, "/edu.au.cpsc.launcher/style/images/seat.png");
        loadIcon(flightScheduleBtn, "/edu.au.cpsc.launcher/style/images/flight.png");
        loadIcon(aircraftBtn, "/edu.au.cpsc.launcher/style/images/aircraft.png");
    }

    private void loadIcon(Button button, String path) {
        Image img = new Image(getClass().getResourceAsStream(path));
        ImageView icon = new ImageView(img);
        icon.setFitWidth(24);
        icon.setFitHeight(24);
        icon.setPreserveRatio(true);
        button.setGraphic(icon);
    }
}
