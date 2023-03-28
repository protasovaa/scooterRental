package Entity;

import java.util.Objects;

public class Scooter {
    private int id;
    private String location;
    private boolean isBlocked;
    private double priceForMin;

    public Scooter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isIs_blocked() {
        return isBlocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.isBlocked = is_blocked;
    }

    public double getPrice_for_min() {
        return priceForMin;
    }

    public void setPrice_for_min(double price_for_min) {
        this.priceForMin = price_for_min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return id == scooter.id && isBlocked == scooter.isBlocked && Double.compare(scooter.priceForMin, priceForMin) == 0 && location.equals(scooter.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, isBlocked, priceForMin);
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", isBlocked=" + isBlocked +
                ", priceForMin=" + priceForMin +
                '}';
    }
}
