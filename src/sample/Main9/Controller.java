package sample.Main9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField Height;

    public void submit(ActionEvent event) {
        String height = Height.getText();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("chiều cao của bạn: " + height + "cm");
        alert.show();
    }
}
