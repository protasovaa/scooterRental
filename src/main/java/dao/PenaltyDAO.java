package dao;
import entity.Penalty;
import java.util.List;

public interface PenaltyDAO {
    //create
    void add(Penalty penalty);

    //read
    List<Penalty> getAll();

    Penalty getById(Long id);

    //update
    void update(Penalty penalty);

    //delete
    void remove(Long id);
}
