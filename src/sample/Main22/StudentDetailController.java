package sample.Main22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
        emailLabel.setText(Student.getEmail());
        nameLabel.setText(Student.getName());
        ageLabel.setText(String.valueOf(Student.getAge()));

    }


    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
}