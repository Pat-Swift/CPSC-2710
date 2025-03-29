package cpsc.module3;

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

    // Constructor
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

    // Getters and Setters
    public String getIdent() { return ident; }
    public void setIdent(String ident) { this.ident = ident; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getElevationFt() { return elevationFt; }
    public void setElevationFt(Integer elevationFt) { this.elevationFt = elevationFt; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getIsoCountry() { return isoCountry; }
    public void setIsoCountry(String isoCountry) { this.isoCountry = isoCountry; }

    public String getIsoRegion() { return isoRegion; }
    public void setIsoRegion(String isoRegion) { this.isoRegion = isoRegion; }

    public String getMunicipality() { return municipality; }
    public void setMunicipality(String municipality) { this.municipality = municipality; }

    public String getGpsCode() { return gpsCode; }
    public void setGpsCode(String gpsCode) { this.gpsCode = gpsCode; }

    public String getIataCode() { return iataCode; }
    public void setIataCode(String iataCode) { this.iataCode = iataCode; }

    public String getLocalCode() { return localCode; }
    public void setLocalCode(String localCode) { this.localCode = localCode; }

    public String getCoordinates() { return coordinates; }
    public void setCoordinates(String coordinates) { this.coordinates = coordinates; }
}
