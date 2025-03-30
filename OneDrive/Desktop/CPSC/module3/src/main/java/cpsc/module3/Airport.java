package cpsc.module3;

public class Airport {
    private String name;
    private String code;

    // Constructor
    public Airport(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    // Optional: toString
    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}
