package cpsc.module7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class ChecklistViewController {

    @FXML
    private ListView<String> needToPackList;

    @FXML
    private ListView<String> packedList;

    private final ObservableList<String> needToPackItems = FXCollections.observableArrayList();
    private final ObservableList<String> packedItems = FXCollections.observableArrayList();


    private String csvFileName = "/packing_list.csv";

    public void setCsvFileName(String fileName) {
        this.csvFileName = fileName;
        loadChecklistData();
    }

    @FXML
    public void initialize() {
        needToPackList.setItems(needToPackItems);
        packedList.setItems(packedItems);
    }

    private void loadChecklistData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream(csvFileName))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String item = line.trim();
                if (!item.isEmpty()) {
                    needToPackItems.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAddToPacked() {
        String selected = needToPackList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            needToPackItems.remove(selected);
            packedItems.add(selected);
        }
    }

    @FXML
    public void handleRemoveFromPacked() {
        String selected = packedList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            packedItems.remove(selected);
            needToPackItems.add(selected);
        }
    }
}
