package cpsc.module_2;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SeatReservationApplication extends Application {
    private SeatReservation seatReservation = new SeatReservation();
    private TextField flightDesignatorField;
    private DatePicker flightDatePicker;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField numberOfBagsField;
    private CheckBox flyingWithInfantCheckBox;
    private TextField numberOfPassengersField;

    public SeatReservationApplication() {
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Edit Seat Reservation");
        this.seatReservation.setFlightDate((LocalDate)null);
        this.seatReservation.setFirstName("");
        this.seatReservation.setLastName("");
        this.seatReservation.setNumberOfBags(0);
        this.seatReservation.makeNotFlyingWithInfant();
        this.flightDesignatorField = new TextField();
        this.flightDatePicker = new DatePicker();
        this.firstNameField = new TextField();
        this.lastNameField = new TextField();
        this.numberOfBagsField = new TextField();
        this.flyingWithInfantCheckBox = new CheckBox();
        this.numberOfPassengersField = new TextField("1");
        this.numberOfPassengersField.setEditable(false);
        this.flyingWithInfantCheckBox.setOnAction((e) -> {
            if (this.flyingWithInfantCheckBox.isSelected()) {
                this.numberOfPassengersField.setText("2");
            } else {
                this.numberOfPassengersField.setText("1");
            }

        });
        GridPane grid = new GridPane();
        grid.setPadding(new Insets((double)20.0F));
        grid.setVgap((double)10.0F);
        grid.setHgap((double)10.0F);
        grid.add(new Label("Flight Designator:"), 0, 0);
        grid.add(this.flightDesignatorField, 1, 0);
        grid.add(new Label("Flight Date:"), 0, 1);
        grid.add(this.flightDatePicker, 1, 1);
        grid.add(new Label("First Name:"), 0, 2);
        grid.add(this.firstNameField, 1, 2);
        grid.add(new Label("Last Name:"), 0, 3);
        grid.add(this.lastNameField, 1, 3);
        grid.add(new Label("Number of Bags:"), 0, 4);
        grid.add(this.numberOfBagsField, 1, 4);
        grid.add(new Label("Flying with Infant:"), 0, 5);
        grid.add(this.flyingWithInfantCheckBox, 1, 5);
        grid.add(new Label("Number of Passengers:"), 0, 6);
        grid.add(this.numberOfPassengersField, 1, 6);
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        saveButton.setOnAction((e) -> {
            try {
                this.seatReservation.setFlightDesignator(this.flightDesignatorField.getText());
                this.seatReservation.setFlightDate((LocalDate)this.flightDatePicker.getValue());
                this.seatReservation.setFirstName(this.firstNameField.getText());
                this.seatReservation.setLastName(this.lastNameField.getText());
                this.seatReservation.setNumberOfBags(Integer.parseInt(this.numberOfBagsField.getText()));
                if (this.flyingWithInfantCheckBox.isSelected()) {
                    this.seatReservation.makeFlyingWithInfant();
                } else {
                    this.seatReservation.makeNotFlyingWithInfant();
                }

                System.out.println("Reservation Saved:");
                System.out.println(this.seatReservation.toString());
                Platform.exit();
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Unexpected error: " + ex.getMessage());
            }

        });
        cancelButton.setOnAction((e) -> {
            System.out.println("Cancel clicked");
            Platform.exit();
        });
        HBox buttonBox = new HBox((double)10.0F, new Node[]{cancelButton, saveButton});
        buttonBox.setPadding(new Insets((double)10.0F));
        buttonBox.setAlignment(Pos.TOP_RIGHT);
        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setBottom(buttonBox);
        this.updateUI();
        Scene scene = new Scene(root, (double)400.0F, (double)400.0F);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateUI() {
        this.flightDesignatorField.setText(this.seatReservation.getFlightDesignator());
        this.flightDatePicker.setValue(this.seatReservation.getFlightDate());
        this.firstNameField.setText(this.seatReservation.getFirstName());
        this.lastNameField.setText(this.seatReservation.getLastName());
        this.numberOfBagsField.setText(String.valueOf(this.seatReservation.getNumberOfBags()));
        this.flyingWithInfantCheckBox.setSelected(this.seatReservation.isFlyingWithInfant());
        this.numberOfPassengersField.setText(this.seatReservation.isFlyingWithInfant() ? "2" : "1");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
