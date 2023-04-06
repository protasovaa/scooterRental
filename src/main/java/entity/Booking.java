package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Booking {
    private Long id;
    private Long idScooterFK;
    private Long idUserFK;
    private Timestamp timeOfBooking;
    private Timestamp timeOfStart;
    private Timestamp timeOfFinish;

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdScooterFK() {
        return idScooterFK;
    }

    public void setIdScooterFK(Long idScooterFK) {
        this.idScooterFK = idScooterFK;
    }

    public Long getIdUserFK() {
        return idUserFK;
    }

    public void setIdUserFK(Long idUserFK) {
        this.idUserFK = idUserFK;
    }

    public Timestamp getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(Timestamp timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public Timestamp getTimeOfStart() {
        return timeOfStart;
    }

    public void setTimeOfStart(Timestamp timeOfStart) {
        this.timeOfStart = timeOfStart;
    }

    public Timestamp getTimeOfFinish() {
        return timeOfFinish;
    }

    public void setTimeOfFinish(Timestamp timeOfFinish) {
        this.timeOfFinish = timeOfFinish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && idScooterFK == booking.idScooterFK && idUserFK == booking.idUserFK && timeOfBooking.equals(booking.timeOfBooking) && timeOfStart.equals(booking.timeOfStart) && timeOfFinish.equals(booking.timeOfFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idScooterFK, idUserFK, timeOfBooking, timeOfStart, timeOfFinish);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", idScooterFK=" + idScooterFK +
                ", idUserFK=" + idUserFK +
                ", timeOfBooking=" + timeOfBooking +
                ", timeOfSstart=" + timeOfStart +
                ", timeOfFinish=" + timeOfFinish +
                '}';
    }
}
