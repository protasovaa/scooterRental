package entity;

import java.util.Objects;

public class Penalty {
    private Long id;
    private String type;
    private int amount;

    public Penalty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Penalty penalty = (Penalty) o;
        return id == penalty.id && amount == penalty.amount && type.equals(penalty.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount);
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
