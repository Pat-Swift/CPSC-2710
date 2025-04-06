import org.junit.jupiter.api.Test;

import cpsc.module4.model.ScheduledFlight;
import cpsc.module4.data.AirlineDatabase;
import cpsc.module4.data.AirlineDatabaseIO;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AirlineDatabaseIOTest {

    private ScheduledFlight createTestFlight() {
        HashSet<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.MONDAY);
        return new ScheduledFlight(
                "DL200", "KPIT", LocalTime.of(14, 30),
                "KATL", LocalTime.of(16, 0), days
        );
    }

    @Test
    public void testSaveAndLoad() {
        AirlineDatabase originalDb = new AirlineDatabase();
        ScheduledFlight flight = createTestFlight();
        originalDb.addScheduledFlight(flight);

        try {
            // Use in-memory byte stream for the test
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            AirlineDatabaseIO.save(originalDb, baos);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            AirlineDatabase loadedDb = AirlineDatabaseIO.load(bais);

            List<ScheduledFlight> loadedFlights = loadedDb.getScheduledFlights();

            assertEquals(1, loadedFlights.size());
            ScheduledFlight loadedFlight = loadedFlights.get(0);
            assertEquals("DL200", loadedFlight.getFlightDesignator());
            assertEquals("KPIT", loadedFlight.getDepartureAirportIdent());
            assertEquals("KATL", loadedFlight.getArrivalAirportIdent());
            assertEquals(LocalTime.of(14, 30), loadedFlight.getDepartureTime());
            assertTrue(loadedFlight.getDaysOfWeek().contains(DayOfWeek.MONDAY));

        } catch (Exception e) {
            fail("Exception occurred during save/load test: " + e.getMessage());
        }
    }
}

