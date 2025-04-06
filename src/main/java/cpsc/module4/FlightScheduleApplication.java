package cpsc.module4;

import cpsc.module4.data.AirlineDatabase;
import cpsc.module4.data.AirlineDatabaseIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


import java.io.*;

public class FlightScheduleApplication extends Application {

    private static final String DB_FILENAME = "flight-db.ser";
    private AirlineDatabase database;

    @Override
    public void start(Stage primaryStage) {
        // Load the database from file
        File dbFile = new File(DB_FILENAME);
        if (dbFile.exists()) {
            try (FileInputStream fis = new FileInputStream(dbFile)) {
                database = AirlineDatabaseIO.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                database = new AirlineDatabase();
            }
        } else {
            database = new AirlineDatabase();
        }

        try {

            // Load FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("flight_schedule.fxml"));
            BorderPane root = loader.load();

            // Get controller
            cpsc.module4.controller.FlightScheduleController controller = loader.getController();
            controller.setDatabase(database);

            // Start scene
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Flight Schedule Application");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        // Save the database when closing the app
        try (FileOutputStream fos = new FileOutputStream(DB_FILENAME)) {
            AirlineDatabaseIO.save(database, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
