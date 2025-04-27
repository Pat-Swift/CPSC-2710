package cpsc.module7;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ChecklistItem {
    private final SimpleStringProperty item;
    private final SimpleBooleanProperty packed;

    public ChecklistItem(String item, boolean packed) {
        this.item = new SimpleStringProperty(item);
        this.packed = new SimpleBooleanProperty(packed);
    }

    public String getItem() { return item.get(); }
    public void setItem(String value) { item.set(value); }

    public boolean isPacked() { return packed.get(); }
    public void setPacked(boolean value) { packed.set(value); }

    public SimpleStringProperty itemProperty() { return item; }
    public SimpleBooleanProperty packedProperty() { return packed; }
}
