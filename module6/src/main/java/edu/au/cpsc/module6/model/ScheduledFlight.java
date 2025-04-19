package edu.au.cpsc.module6.model;




import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class ScheduledFlight implements Serializable {
    private static final long serialVersionUID = 1L;
    private String flightDesignator;
    private String departureAirportIdent;
    private LocalTime departureTime;
    private String arrivalAirportIdent;
    private LocalTime arrivalTime;
    private Set<DayOfWeek> daysOfWeek;

    // Constructor
    public ScheduledFlight(String flightDesignator, String departureAirportIdent, LocalTime departureTime,
                           String arrivalAirportIdent, LocalTime arrivalTime, Set<DayOfWeek> daysOfWeek) {
        setFlightDesignator(flightDesignator);
        setDepartureAirportIdent(departureAirportIdent);
        setDepartureTime(departureTime);
        setArrivalAirportIdent(arrivalAirportIdent);
        setArrivalTime(arrivalTime);
        setDaysOfWeek(daysOfWeek);
    }


    // Getters and Setters with Validation

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
            throw new IllegalArgumentException("Flight designator cannot be null.");
        }
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null) {
            throw new IllegalArgumentException("Departure airport ident cannot be null.");
        }
        this.departureAirportIdent = departureAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) {
            throw new IllegalArgumentException("Departure time cannot be null.");
        }
        this.departureTime = departureTime;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null) {
            throw new IllegalArgumentException("Arrival airport ident cannot be null.");
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) {
            throw new IllegalArgumentException("Arrival time cannot be null.");
        }
        this.arrivalTime = arrivalTime;
    }

    public HashSet<DayOfWeek> getDaysOfWeek() {
        return new HashSet<>(daysOfWeek); // Defensive copy
    }

    public void setDaysOfWeek(Set<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException("Days of week cannot be null.");
        }
        this.daysOfWeek = new HashSet<>(daysOfWeek); // still create a defensive copy
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduledFlight)) return false;
        ScheduledFlight that = (ScheduledFlight) o;
        return flightDesignator.equals(that.flightDesignator) &&
                departureAirportIdent.equals(that.departureAirportIdent) &&
                arrivalAirportIdent.equals(that.arrivalAirportIdent) &&
                departureTime.equals(that.departureTime) &&
                arrivalTime.equals(that.arrivalTime) &&
                daysOfWeek.equals(that.daysOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDesignator, departureAirportIdent, departureTime,
                arrivalAirportIdent, arrivalTime, daysOfWeek);
    }

    @Override
    public String toString() {
        return flightDesignator + " from " + departureAirportIdent + " to " +
                arrivalAirportIdent + " departs at " + departureTime + " arrives at " +
                arrivalTime + " on " + daysOfWeek;
    }
}