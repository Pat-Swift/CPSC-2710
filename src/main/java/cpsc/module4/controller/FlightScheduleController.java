package cpsc.module4.controller;

import cpsc.module4.model.ScheduledFlight;
import cpsc.module4.data.AirlineDatabase;
import cpsc.module4.data.AirlineDatabaseIO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleButton;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class FlightScheduleController {

    @FXML private TableView<ScheduledFlight> flightTableView;
    @FXML private TableColumn<ScheduledFlight, String> flightDesignatorColumn;
    @FXML private TableColumn<ScheduledFlight, String> departureAirportColumn;
    @FXML private TableColumn<ScheduledFlight, String> arrivalAirportColumn;
    @FXML private TableColumn<ScheduledFlight, String> daysOfWeekColumn;

    @FXML private TextField flightDesignatorField;
    @FXML private TextField departureAirportField;
    @FXML private TextField arrivalAirportField;

    @FXML private ToggleButton mondayToggle;
    @FXML private ToggleButton tuesdayToggle;
    @FXML private ToggleButton wednesdayToggle;
    @FXML private ToggleButton thursdayToggle;
    @FXML private ToggleButton fridayToggle;
    @FXML private ToggleButton saturdayToggle;
    @FXML private ToggleButton sundayToggle;

    @FXML private Button addUpdateButton;
    @FXML private Button newButton;
    @FXML private Button deleteButton;

    private AirlineDatabase database;

    private static final String DB_FILENAME = "flight-db.ser";

    public void setDatabase(AirlineDatabase db) {
        this.database = db;
        refreshTable();
    }

    @FXML
    public void initialize() {
        // Table column bindings
        flightDesignatorColumn.setCellValueFactory(new PropertyValueFactory<>("flightDesignator"));
        departureAirportColumn.setCellValueFactory(new PropertyValueFactory<>("departureAirportIdent"));
        arrivalAirportColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalAirportIdent"));
        daysOfWeekColumn.setCellValueFactory(cellData -> {
            Set<DayOfWeek> days = cellData.getValue().getDaysOfWeek();
            StringBuilder sb = new StringBuilder();
            for (DayOfWeek day : DayOfWeek.values()) {
                if (days.contains(day)) {
                    sb.append(dayToChar(day));
                }
            }
            return new javafx.beans.property.SimpleStringProperty(sb.toString());
        });


        // Table selection listener
        flightTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        populateForm(newSelection);
                        addUpdateButton.setText("Update");
                    }
                }
        );


        // Button actions
        addUpdateButton.setOnAction(e -> handleAddOrUpdate());
        newButton.setOnAction(e -> clearForm());
        deleteButton.setOnAction(e -> handleDelete());
    }


    private void refreshTable() {
        var flights = new ArrayList<>(database.getScheduledFlights());
        Collections.reverse(flights); // Reverse so newest goes on top
        flightTableView.getItems().setAll(flights);
    }


    private void populateForm(ScheduledFlight flight) {
        flightDesignatorField.setText(flight.getFlightDesignator());
        departureAirportField.setText(flight.getDepartureAirportIdent());
        arrivalAirportField.setText(flight.getArrivalAirportIdent());

        Set<DayOfWeek> days = flight.getDaysOfWeek();
        mondayToggle.setSelected(days.contains(DayOfWeek.MONDAY));
        tuesdayToggle.setSelected(days.contains(DayOfWeek.TUESDAY));
        wednesdayToggle.setSelected(days.contains(DayOfWeek.WEDNESDAY));
        thursdayToggle.setSelected(days.contains(DayOfWeek.THURSDAY));
        fridayToggle.setSelected(days.contains(DayOfWeek.FRIDAY));
        saturdayToggle.setSelected(days.contains(DayOfWeek.SATURDAY));
        sundayToggle.setSelected(days.contains(DayOfWeek.SUNDAY));
    }

    private void clearForm() {
        flightTableView.getSelectionModel().clearSelection();
        flightDesignatorField.clear();
        departureAirportField.clear();
        arrivalAirportField.clear();
        mondayToggle.setSelected(false);
        tuesdayToggle.setSelected(false);
        wednesdayToggle.setSelected(false);
        thursdayToggle.setSelected(false);
        fridayToggle.setSelected(false);
        saturdayToggle.setSelected(false);
        sundayToggle.setSelected(false);
        addUpdateButton.setText("Add");
    }

    private void handleAddOrUpdate() {
        try {
            String designator = flightDesignatorField.getText().trim();
            String departure = departureAirportField.getText().trim();
            String arrival = arrivalAirportField.getText().trim();

            Set<DayOfWeek> days = new HashSet<>();
            if (mondayToggle.isSelected()) days.add(DayOfWeek.MONDAY);
            if (tuesdayToggle.isSelected()) days.add(DayOfWeek.TUESDAY);
            if (wednesdayToggle.isSelected()) days.add(DayOfWeek.WEDNESDAY);
            if (thursdayToggle.isSelected()) days.add(DayOfWeek.THURSDAY);
            if (fridayToggle.isSelected()) days.add(DayOfWeek.FRIDAY);
            if (saturdayToggle.isSelected()) days.add(DayOfWeek.SATURDAY);
            if (sundayToggle.isSelected()) days.add(DayOfWeek.SUNDAY);

            ScheduledFlight flight = new ScheduledFlight(
                    designator, departure, LocalTime.of(0, 0),
                    arrival, LocalTime.of(0, 0), new HashSet<>(days)
            );

            if (flightTableView.getSelectionModel().getSelectedItem() != null) {
                database.updateScheduledFlight(flight);
            } else {
                database.addScheduledFlight(flight);
            }

            saveDatabase();
            refreshTable();
            clearForm();

        } catch (Exception e) {
            showAlert("Error", "Failed to add/update flight: " + e.getMessage());
        }
    }

    private void handleDelete() {
        ScheduledFlight selected = flightTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            database.removeScheduledFlight(selected);
            saveDatabase();
            refreshTable();
            clearForm();
        }
    }

    private void saveDatabase() {
        try (FileOutputStream fos = new FileOutputStream(DB_FILENAME)) {
            AirlineDatabaseIO.save(database, fos);
        } catch (IOException e) {
            showAlert("Error", "Failed to save database: " + e.getMessage());
        }
    }

    private char dayToChar(DayOfWeek day) {
        return switch (day) {
            case MONDAY -> 'M';
            case TUESDAY -> 'T';
            case WEDNESDAY -> 'W';
            case THURSDAY -> 'R'; // R for Thursday
            case FRIDAY -> 'F';
            case SATURDAY -> 'S';
            case SUNDAY -> 'U'; // U for Sunday
        };
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
