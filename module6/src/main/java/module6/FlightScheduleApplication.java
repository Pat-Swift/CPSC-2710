package edu.au.cpsc.module6;

import edu.au.cpsc.module6.data.AirlineDatabase;
import edu.au.cpsc.module6.data.AirlineDatabaseIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;

public class FlightScheduleApplication extends Application {
    private static final String DB_FILENAME = "flight-db.ser";
    private AirlineDatabase database;

    @Override
    public void start(Stage primaryStage) {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/module6/flight_schedule.fxml"));
            BorderPane root = loader.load();

            FlightScheduleController controller = loader.getController();
            controller.setDatabase(database);

            Scene scene = new Scene(root);
            primaryStage.setTitle("Flight Schedule Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
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