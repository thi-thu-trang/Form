package QuanLi;

public class AccountSV {
    private String username;
    private String password;
    private Integer Age;
    private String Email;
    private Integer Birth;
    private String Birthplace;
//    private CheckBox checkBox;


    public AccountSV() {
    }

    public AccountSV(String username, String password, Integer age, String email, Integer birth, String birthplace) {
        this.username = username;
        this.password = password;
        Age = age;
        Email = email;
        Birth = birth;
        Birthplace = birthplace;
        //  this.checkBox = checkBox;
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
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getBirth() {
        return Birth;
    }

    public void setBirth(Integer birth) {
        Birth = birth;
    }

    public String getBirthplace() {
        return Birthplace;
    }

    public void setBirthplace(String birthplace) {
        Birthplace = birthplace;
    }

//    public CheckBox getCheckBox() {
//        return checkBox;
//    }
//
//    public void setCheckBox(CheckBox checkBox) {
//        this.checkBox = checkBox;
//    }
}
