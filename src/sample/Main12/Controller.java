package sample.Main12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ComboBox<String> comboBox;

    @FXML
    public Label label;

    ObservableList<String> List = FXCollections.observableArrayList("Java","C#","Python");
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox.setItems(List);
    }
    public void ComboboxChanged (ActionEvent event) {
        label.setText(comboBox.getValue());
    }
}
