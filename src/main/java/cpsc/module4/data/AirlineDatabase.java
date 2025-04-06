package cpsc.module4.data;

import cpsc.module4.model.ScheduledFlight;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<ScheduledFlight> flights;

    public AirlineDatabase() {
        this.flights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return new ArrayList<>(flights); // Return copy to prevent external mutation
    }

    public void addScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null.");
        }
        flights.add(sf);
    }

    public void removeScheduledFlight(ScheduledFlight sf) {
        flights.remove(sf);
    }

    public void updateScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            throw new IllegalArgumentException("ScheduledFlight cannot be null.");
        }

        for (int i = 0; i < flights.size(); i++) {
            ScheduledFlight current = flights.get(i);
            if (current.getFlightDesignator().equals(sf.getFlightDesignator())) {
                flights.set(i, sf); // Replace the first matching flight
                return;
            }
        }

        // If not found, treat it as an add (or skip this depending on requirements)
        flights.add(sf);
    }
}
