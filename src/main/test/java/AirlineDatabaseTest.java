

import cpsc.module4.model.ScheduledFlight;
import cpsc.module4.data.AirlineDatabase;

import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AirlineDatabaseTest {

    private ScheduledFlight createSampleFlight(String designator) {
        HashSet<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.MONDAY);
        return new ScheduledFlight(
                designator, "KPIT", LocalTime.of(10, 0),
                "KATL", LocalTime.of(11, 30), days
        );
    }

    @Test
    public void testAddAndGetFlights() {
        AirlineDatabase db = new AirlineDatabase();
        ScheduledFlight flight = createSampleFlight("DL100");
        db.addScheduledFlight(flight);

        List<ScheduledFlight> flights = db.getScheduledFlights();
        assertEquals(1, flights.size());
        assertEquals("DL100", flights.get(0).getFlightDesignator());
    }

    @Test
    public void testRemoveFlight() {
        AirlineDatabase db = new AirlineDatabase();
        ScheduledFlight flight = createSampleFlight("DL100");
        db.addScheduledFlight(flight);
        db.removeScheduledFlight(flight);

        assertTrue(db.getScheduledFlights().isEmpty());
    }

    @Test
    public void testUpdateFlightReplacesExisting() {
        AirlineDatabase db = new AirlineDatabase();
        ScheduledFlight flight1 = createSampleFlight("DL100");
        db.addScheduledFlight(flight1);

        ScheduledFlight updated = new ScheduledFlight(
                "DL100", "KJFK", LocalTime.of(12, 0),
                "KBOS", LocalTime.of(13, 15), new HashSet<>(List.of(DayOfWeek.FRIDAY))
        );

        db.updateScheduledFlight(updated);

        List<ScheduledFlight> flights = db.getScheduledFlights();
        assertEquals(1, flights.size());
        assertEquals("KJFK", flights.get(0).getDepartureAirportIdent());
        assertTrue(flights.get(0).getDaysOfWeek().contains(DayOfWeek.FRIDAY));
    }

    @Test
    public void testUpdateAddsIfNotFound() {
        AirlineDatabase db = new AirlineDatabase();
        ScheduledFlight flight = createSampleFlight("NEW123");
        db.updateScheduledFlight(flight); // Should add if not found

        assertEquals(1, db.getScheduledFlights().size());
    }
}
