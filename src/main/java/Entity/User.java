package Entity;

import java.sql.Date;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String eMail;
    private Date dateOfBirth;
    private String login;
    private String password;
    private boolean isBlocked;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String e_mail) {
        this.eMail = e_mail;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean is_blocked) {
        this.isBlocked = is_blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && isBlocked == user.isBlocked && name.equals(user.name) && eMail.equals(user.eMail) && dateOfBirth.equals(user.dateOfBirth) && login.equals(user.login) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eMail, dateOfBirth, login, password, isBlocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
