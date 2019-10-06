package Form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class information implements Initializable {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    Label timeLabel = new Label(LocalTime.now().format(dtf));
    @FXML
    private TableView<Account> table;
    @FXML
    private TableColumn<Account, String> usernameColumn;
    @FXML
    private TableColumn<Account, String> passColumn;
    @FXML
    private TableColumn<Account, Integer> AgeColumn;
    @FXML
    private TableColumn<Account, String> EmailColumn;
    @FXML
    private TableColumn<Account, Integer> BirthColumn;
    @FXML
    private TableColumn<Account, String> BirthplaceColumn;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField passwordText;
    @FXML
    private TextField AgeText;
    @FXML
    private TextField EmailText;
    //    @FXML
//    private DatePicker dateofBirth;
    @FXML
    private TextField BirthText;
    @FXML
    private TextField BirthplaceText;

    private ObservableList<Account> accountList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountList = FXCollections.observableArrayList(
                new Account("Trang", "trang1706", 19, "thithutrang1706@gmail.com", 17 / 06 / 2000, "Đà Nẵng")
        );
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
        passColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("password"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("Age"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("Email"));
        BirthColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("Birth"));
        BirthplaceColumn.setCellValueFactory(new PropertyValueFactory<Account, String>(" Birthplace"));
        table.setItems(accountList);
    }

    public void del(ActionEvent e) {
        Account selected = table.getSelectionModel().getSelectedItem();
        accountList.remove(selected);
    }

    public void add(ActionEvent e) {
        Account newAccount = new Account();
        newAccount.setUsername(usernameText.getText());
        newAccount.setPassword(passwordText.getText());
        newAccount.setEmail(EmailText.getText());
        newAccount.setBirth(Integer.parseInt(BirthText.getText()));
        newAccount.setBirthplace(BirthplaceText.getText());
        newAccount.setAge(Integer.parseInt(AgeText.getText()));
        accountList.add(newAccount);
    }

//    @FXML
//    private void showAge(){
//        Calendar now = Calendar.getInstance();
//        int year = now.get(Calendar.YEAR);
//        int birthYear = (dateofBirth.getValue().getYear());
//        int age = year - birthYear;
//        AgeText.setText(Integer.toString(age)+"years");
//    }

    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("formRegister.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
}
