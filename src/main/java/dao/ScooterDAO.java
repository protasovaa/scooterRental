package dao;
import entity.Scooter;
import java.util.List;

public interface ScooterDAO {
    //create
    void add(Scooter scooter);

    //read
    List<Scooter> getAll();

    Scooter getById(Long id);

    //update
    void update(Scooter scooter);

    //delete
    void remove(Long id);
}
