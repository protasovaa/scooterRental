package Entity;

import java.sql.Date;
import java.util.Objects;

public class Booking {
    private int id;
    private int idScooterFK;
    private int idUserFK;
    private Date timeOfBooking;
    private Date timeOfSstart;
    private Date timeOfFinish;

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdScooterFK() {
        return idScooterFK;
    }

    public void setIdScooterFK(int idScooterFK) {
        this.idScooterFK = idScooterFK;
    }

    public int getIdUserFK() {
        return idUserFK;
    }

    public void setIdUserFK(int idUserFK) {
        this.idUserFK = idUserFK;
    }

    public Date getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(Date timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public Date getTimeOfSstart() {
        return timeOfSstart;
    }

    public void setTimeOfSstart(Date timeOfSstart) {
        this.timeOfSstart = timeOfSstart;
    }

    public Date getTimeOfFinish() {
        return timeOfFinish;
    }

    public void setTimeOfFinish(Date timeOfFinish) {
        this.timeOfFinish = timeOfFinish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && idScooterFK == booking.idScooterFK && idUserFK == booking.idUserFK && timeOfBooking.equals(booking.timeOfBooking) && timeOfSstart.equals(booking.timeOfSstart) && timeOfFinish.equals(booking.timeOfFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idScooterFK, idUserFK, timeOfBooking, timeOfSstart, timeOfFinish);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", idScooterFK=" + idScooterFK +
                ", idUserFK=" + idUserFK +
                ", timeOfBooking=" + timeOfBooking +
                ", timeOfSstart=" + timeOfSstart +
                ", timeOfFinish=" + timeOfFinish +
                '}';
    }
}
