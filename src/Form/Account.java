package Form;

import javafx.fxml.Initializable;

public class Account {
    private String username;
    private String password;
    private Integer Age;
    private String Email;
    private Integer Birth;
    private String Birthplace;


    public Account(String username, String password, Integer age, String email, Integer birth, String birthplace) {
        this.username = username;
        this.password = password;
        Age = age;
        Email = email;
        Birth = birth;
        Birthplace = birthplace;
    }

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
       this.Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public Integer getBirth() {
        return Birth;
    }

    public void setBirth(Integer birth) {
        this.Birth = birth;
    }

    public String getBirthplace() {
        return Birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.Birthplace = birthplace;
    }


}
