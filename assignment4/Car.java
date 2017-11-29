package assignment4;

public class Car implements Comparable<Car>{
     String plate;
     int date;

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.date,car.date);
    }

    public Car(String plate, int date) {
        this.plate = plate;
        this.date = date;
    }

    public Car(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (date != car.date) return false;
        return plate != null ? plate.equals(car.plate) : car.plate == null;
    }

    @Override
    public int hashCode() {
        int result = plate != null ? plate.hashCode() : 0;
        result = 31 * result + date;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", date=" + date +
                '}';
    }
}
