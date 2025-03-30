package cpsc.module3;

import java.io.*;
import java.util.*;

public class Airport {
    private String ident;
    private String type;
    private String name;
    private Integer elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private String coordinates;

    public Airport(String ident, String type, String name, Integer elevationFt, String continent,
                   String isoCountry, String isoRegion, String municipality, String gpsCode,
                   String iataCode, String localCode, String coordinates) {
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.elevationFt = elevationFt;
        this.continent = continent;
        this.isoCountry = isoCountry;
        this.isoRegion = isoRegion;
        this.municipality = municipality;
        this.gpsCode = gpsCode;
        this.iataCode = iataCode;
        this.localCode = localCode;
        this.coordinates = coordinates;
    }

    public String getIdent() { return ident; }
    public String getType() { return type; }
    public String getName() { return name; }
    public Integer getElevationFt() { return elevationFt; }
    public String getContinent() { return continent; }
    public String getIsoCountry() { return isoCountry; }
    public String getIsoRegion() { return isoRegion; }
    public String getMunicipality() { return municipality; }
    public String getGpsCode() { return gpsCode; }
    public String getIataCode() { return iataCode; }
    public String getLocalCode() { return localCode; }
    public String getCoordinates() { return coordinates; }

    @Override
    public String toString() {
        return name + " (" + ident + ")";
    }

    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();
        try (InputStream inputStream = Airport.class.getClassLoader().getResourceAsStream("airport-codes.csv")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found: airport-codes.csv");
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                br.readLine(); // Skip the header line
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String ident = values[0];
                    String type = values[1];
                    String name = values[2];
                    Integer elevationFt = values[3].isEmpty() ? null : Integer.parseInt(values[3]);
                    String continent = values[4];
                    String isoCountry = values[5];
                    String isoRegion = values[6];
                    String municipality = values[7];
                    String gpsCode = values[8];
                    String iataCode = values[9];
                    String localCode = values[10];
                    String coordinates = values[11];

                    airports.add(new Airport(ident, type, name, elevationFt, continent, isoCountry,
                            isoRegion, municipality, gpsCode, iataCode, localCode, coordinates));
                }
            }
        }
        return airports;
    }
}