package dataFunction;

public class DroneTypes {
    private int control_range;
    private int max_carriage;
    private int weight;
    private int max_speed;
    private int id;
    private int battery_capacity;
    private String typename;
    private String manufacturer;

    // Constructor
    public DroneTypes(int control_range, int max_carriage, int weight, int max_speed, int id, int battery_capacity, String typename, String manufacturer) {
        this.control_range = control_range;
        this.max_carriage = max_carriage;
        this.weight = weight;
        this.max_speed = max_speed;
        this.id = id;
        this.battery_capacity = battery_capacity;
        this.typename = typename;
        this.manufacturer = manufacturer;
    }

    public int getControl_range() {
        return control_range;
    }

    public void setControl_range(int control_range) {
        this.control_range = control_range;
    }

    public int getMax_carriage() {
        return max_carriage;
    }

    public void setMax_carriage(int max_carriage) {
        this.max_carriage = max_carriage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(int battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
