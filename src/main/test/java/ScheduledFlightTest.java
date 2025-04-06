package cpsc.module4;

import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import cpsc.module4.model.ScheduledFlight;


import static org.junit.jupiter.api.Assertions.*;

public class ScheduledFlightTest {

    @Test
    public void testConstructorAndGetters() {
        HashSet<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.MONDAY);
        days.add(DayOfWeek.WEDNESDAY);

        ScheduledFlight flight = new ScheduledFlight(
                "DL1331", "KPIT", LocalTime.of(13, 30),
                "KATL", LocalTime.of(15, 0), days
        );

        assertEquals("DL1331", flight.getFlightDesignator());
        assertEquals("KPIT", flight.getDepartureAirportIdent());
        assertEquals(LocalTime.of(13, 30), flight.getDepartureTime());
        assertEquals("KATL", flight.getArrivalAirportIdent());
        assertEquals(LocalTime.of(15, 0), flight.getArrivalTime());
        assertTrue(flight.getDaysOfWeek().contains(DayOfWeek.MONDAY));
    }

    @Test
    public void testNullSettersThrowException() {
        ScheduledFlight flight = new ScheduledFlight(
                "DL100", "KJFK", LocalTime.NOON,
                "KLAX", LocalTime.of(15, 30), new HashSet<>()
        );

        assertThrows(IllegalArgumentException.class, () -> flight.setFlightDesignator(null));
        assertThrows(IllegalArgumentException.class, () -> flight.setDepartureAirportIdent(null));
        assertThrows(IllegalArgumentException.class, () -> flight.setArrivalAirportIdent(null));
        assertThrows(IllegalArgumentException.class, () -> flight.setDepartureTime(null));
        assertThrows(IllegalArgumentException.class, () -> flight.setArrivalTime(null));
        assertThrows(IllegalArgumentException.class, () -> flight.setDaysOfWeek(null));
    }
}
