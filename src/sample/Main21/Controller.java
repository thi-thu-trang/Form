package sample.Main21;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, Integer> nameColumn;

    @FXML
    private TableColumn<Student, Integer> emailColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField ageText;

    private ObservableList<Student> studentList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentList = FXCollections.observableArrayList(
                new Student(1, "Phương", "phuong@gmail.com", 19),
                new Student(2, "trang", "trang@gmail.com", 20)
        );
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("email"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        table.setItems(studentList);
    }

    public void add(ActionEvent e) {
        Student newStudent = new Student();
        newStudent.setId(Integer.parseInt(idText.getText()));
        newStudent.setName(nameText.getText());
        newStudent.setEmail(emailText.getText());
        newStudent.setAge(Integer.parseInt(ageText.getText()));
        studentList.add(newStudent);
    }

    public void del(ActionEvent e) {
        Student selected = table.getSelectionModel().getSelectedItem();
        studentList.remove(selected);
    }

}
