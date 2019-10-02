package sample.Main22;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentDetailController {
    @FXML
    Label idLabel;
    @FXML
    Label nameLabel;
    @FXML
    Label emailLabel;
    @FXML
    Label ageLabel;

    public void setStudent(Student Student) {
        idLabel.setText(String.valueOf(Student.getId()));
        idLabel.setText(Student.getEmail());
        idLabel.setText(Student.getName());
        idLabel.setText(String.valueOf(Student.getAge()));

    }
}
