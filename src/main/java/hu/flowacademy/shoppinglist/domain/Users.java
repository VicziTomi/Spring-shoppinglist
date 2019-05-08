package hu.flowacademy.shoppinglist.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column(name = "full_name")
    private String fullName;

    public Users() {
    }

    public Users(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
