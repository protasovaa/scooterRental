package dao;
import entity.UserPenalty;
import java.util.List;

public interface UserPenaltyDAO {
    //create
    void add(UserPenalty userPenalty);

    //read
    List<UserPenalty> getAll();

    UserPenalty getById(Long id);

    //update
    void update(UserPenalty userPenalty);

    //delete
    void remove(Long id);
}
