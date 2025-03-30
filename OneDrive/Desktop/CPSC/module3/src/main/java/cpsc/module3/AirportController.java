package cpsc.module3;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.io.*;
import java.util.*;

public class AirportController {

    @FXML private TextField identField, iataField, localField;
    @FXML private TextField typeField, nameField, elevationField;
    @FXML private TextField countryField, regionField, municipalityField;
    @FXML private WebView mapView;

    private List<Airport> airportList;

    @FXML
    public void initialize() {
        try {
            airportList = Airport.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TEMP: Load Pittsburgh Airport as a test (PIT)
        String lat = "40.49150085";
        String lon = "-80.23290253";
        String url = "https://www.windy.com/?" + lat + "," + lon + ",12";
        mapView.getEngine().load(url);
    }


    @FXML
    private void handleSearch() {
        String ident = identField.getText().trim();
        String iata = iataField.getText().trim();
        String local = localField.getText().trim();

        Airport found = null;

        if (!ident.isEmpty()) {
            found = findByIdent(ident);
        } else if (!iata.isEmpty()) {
            found = findByIata(iata);
        } else if (!local.isEmpty()) {
            found = findByLocal(local);
        }

        if (found != null) {
            updateFields(found);
            updateMap(found);
        }
    }

    private Airport findByIdent(String ident) {
        return airportList.stream().filter(a -> a.getIdent().equalsIgnoreCase(ident)).findFirst().orElse(null);
    }

    private Airport findByIata(String iata) {
        return airportList.stream().filter(a -> a.getIataCode().equalsIgnoreCase(iata)).findFirst().orElse(null);
    }

    private Airport findByLocal(String local) {
        return airportList.stream().filter(a -> a.getLocalCode().equalsIgnoreCase(local)).findFirst().orElse(null);
    }

    private void updateFields(Airport airport) {
        typeField.setText(airport.getType());
        nameField.setText(airport.getName());
        elevationField.setText(airport.getElevationFt() != null ? airport.getElevationFt().toString() : "");
        countryField.setText(airport.getIsoCountry());
        regionField.setText(airport.getIsoRegion());
        municipalityField.setText(airport.getMunicipality());
    }

    private void updateMap(Airport airport) {
        String[] coords = airport.getCoordinates().split(",");
        if (coords.length == 2) {
            String lat = coords[1].trim();
            String lon = coords[0].trim();
            String url = "https://www.windy.com/?" + lat + "," + lon + ",12";
            mapView.getEngine().load(url);
        }
    }
}
