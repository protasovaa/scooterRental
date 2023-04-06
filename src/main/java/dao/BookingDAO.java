package dao;
import entity.Booking;
import java.util.List;

public interface BookingDAO {
    //create
    void add(Booking booking);
    //read
    List<Booking> getAll();

    Booking getById(Long id);

    //update
    void update(Booking booking);

    //delete
    void remove(Long id);

}
