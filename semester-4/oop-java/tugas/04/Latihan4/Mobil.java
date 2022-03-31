package Latihan4;

public class Mobil {
    // property.....
    private String model;
    private Integer maxSpeed;

    // behavior/method..............
    public void setModel(String param1) {
        model = param1;
    }

    public void setSpeed(Integer param2) {
        maxSpeed = param2;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return maxSpeed;
    }
}
