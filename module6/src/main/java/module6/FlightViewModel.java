package edu.au.cpsc.module6;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;

public class FlightViewModel {
    private final StringProperty flightDesignator = new SimpleStringProperty();
    private final StringProperty departureIdent = new SimpleStringProperty();
    private final StringProperty arrivalIdent = new SimpleStringProperty();

    private final BooleanProperty validFlightDesignator = new SimpleBooleanProperty(false);
    private final BooleanProperty validDepartureIdent = new SimpleBooleanProperty(false);
    private final BooleanProperty validArrivalIdent = new SimpleBooleanProperty(false);

    private final BooleanBinding allValid = validFlightDesignator
            .and(validDepartureIdent)
            .and(validArrivalIdent);

    public FlightViewModel() {
        flightDesignator.addListener((obs, oldVal, newVal) -> {
            validFlightDesignator.set(newVal != null && !newVal.trim().isEmpty());
        });
        departureIdent.addListener((obs, oldVal, newVal) -> {
            validDepartureIdent.set(newVal != null && !newVal.trim().isEmpty());
        });
        arrivalIdent.addListener((obs, oldVal, newVal) -> {
            validArrivalIdent.set(newVal != null && !newVal.trim().isEmpty());
        });
    }

    public StringProperty flightDesignatorProperty() { return flightDesignator; }
    public StringProperty departureIdentProperty() { return departureIdent; }
    public StringProperty arrivalIdentProperty() { return arrivalIdent; }

    public BooleanProperty validFlightDesignatorProperty() { return validFlightDesignator; }
    public BooleanProperty validDepartureIdentProperty() { return validDepartureIdent; }
    public BooleanProperty validArrivalIdentProperty() { return validArrivalIdent; }

    public BooleanBinding allValidBinding() { return allValid; }

    public void clear() {
        flightDesignator.set("");
        departureIdent.set("");
        arrivalIdent.set("");
    }
}