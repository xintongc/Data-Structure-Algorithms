package assignment4;

import java.util.ArrayList;

public class CarNode {

     String key;
     Car car;

    public CarNode() {
    }

    public CarNode(String key, Car car) {
        this.key = key;
        this.car = car;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
