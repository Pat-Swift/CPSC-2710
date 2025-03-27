package cpsc.module_2;

import java.time.LocalDate;

public class SeatReservation {
    private String flightDesignator;
    private LocalDate flightDate;
    private String firstName;
    private String lastName;
    private int numberOfBags;
    private boolean flyingWithInfant;

    public SeatReservation() {
    }

    public String getFlightDesignator() {
        return this.flightDesignator;
    }

    public void setFlightDesignator(String fd) {
        if (fd != null && fd.length() >= 4 && fd.length() <= 6) {
            this.flightDesignator = fd;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public LocalDate getFlightDate() {
        return this.flightDate;
    }

    public void setFlightDate(LocalDate date) {
        this.flightDate = date;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    public int getNumberOfBags() {
        return this.numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        if (numberOfBags < 0) {
            throw new IllegalArgumentException("Number of bags cannot be negative.");
        } else {
            this.numberOfBags = numberOfBags;
        }
    }

    public boolean isFlyingWithInfant() {
        return this.flyingWithInfant;
    }

    public void makeFlyingWithInfant() {
        this.flyingWithInfant = true;
    }

    public void makeNotFlyingWithInfant() {
        this.flyingWithInfant = false;
    }

    public String toString() {
        String var10000 = this.flightDesignator != null && !this.flightDesignator.isEmpty() ? this.flightDesignator : "null";
        return "SeatReservation{flightDesignator=" + var10000 + ", flightDate=" + String.valueOf(this.flightDate == null ? "null" : this.flightDate) + ", firstName=" + (this.firstName != null && !this.firstName.isEmpty() ? this.firstName : "null") + ", lastName=" + (this.lastName != null && !this.lastName.isEmpty() ? this.lastName : "null") + ", numberOfBags=" + this.numberOfBags + ", flyingWithInfant=" + this.flyingWithInfant + "}";
    }
}