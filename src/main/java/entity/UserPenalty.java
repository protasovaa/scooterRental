package entity;

import java.util.Objects;

public class UserPenalty {
    private Long id;
    private Long idPenaltyFK;
    private Long idUserFK;
    private boolean is_paid;

    public UserPenalty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPenaltyFK() {
        return idPenaltyFK;
    }

    public void setIdPenaltyFK(Long idPenaltyFK) {
        this.idPenaltyFK = idPenaltyFK;
    }

    public Long getIdUserFK() {
        return idUserFK;
    }

    public void setIdUserFK(Long idUserFK) {
        this.idUserFK = idUserFK;
    }

    public boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPenalty that = (UserPenalty) o;
        return id == that.id && idPenaltyFK == that.idPenaltyFK && idUserFK == that.idUserFK && is_paid == that.is_paid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPenaltyFK, idUserFK, is_paid);
    }

    @Override
    public String toString() {
        return "UserPenalty{" +
                "id=" + id +
                ", idPenaltyFK=" + idPenaltyFK +
                ", idUserFK=" + idUserFK +
                ", is_paid=" + is_paid +
                '}';
    }
}
