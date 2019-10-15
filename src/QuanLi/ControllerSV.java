package QuanLi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSV implements Initializable {

    @FXML
    private TableView<AccountSV> table;
    @FXML
    private TableColumn<AccountSV, String> usernameColumn;
    @FXML
    private TableColumn<AccountSV, String> passColumn;
    @FXML
    private TableColumn<AccountSV, Integer> AgeColumn;
    @FXML
    private TableColumn<AccountSV, String> EmailColumn;
    @FXML
    private TableColumn<AccountSV, Integer> BirthColumn;
    @FXML
    private TableColumn<AccountSV, String> BirthplaceColumn;
    @FXML
    private TableColumn<AccountSV,CheckBox> selectColumn;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField passwordText;
    @FXML
    private TextField AgeText;
    @FXML
    private TextField EmailText;
    @FXML
    private TextField BirthText;
    @FXML
    private TextField BirthplaceText;

    private ObservableList<AccountSV> accountList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


//            CheckBox ch = new CheckBox();
            accountList.add(new AccountSV("Trang", "trang1706", 19, "thithutrang1706@gmail.com", 2000, "Đà Nẵng"));

//        for (int i = 0;i<10;i++){
//            CheckBox ch = new CheckBox();
//            accountList.add(new AccountSV("Trang","trang123",14,"trangoi122",2000,"danang",ch));
//        }
     table.setItems(accountList);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<AccountSV, String>("username"));
        passColumn.setCellValueFactory(new PropertyValueFactory<AccountSV, String>("password"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<AccountSV, Integer>("Age"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<AccountSV, String>("Email"));
        BirthColumn.setCellValueFactory(new PropertyValueFactory<AccountSV, Integer>("Birth"));
        BirthplaceColumn.setCellValueFactory(new PropertyValueFactory<AccountSV, String>(" Birthplace"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<AccountSV,CheckBox>("checkBox"));

    }

    public void del(ActionEvent e) {
        AccountSV selected = table.getSelectionModel().getSelectedItem();
        accountList.remove(selected);
    }

    public void add(ActionEvent e) {
        AccountSV newAccount = new AccountSV();
        newAccount.setUsername(usernameText.getText());
        newAccount.setPassword(passwordText.getText());
        newAccount.setEmail(EmailText.getText());
        newAccount.setBirth(Integer.parseInt(BirthText.getText()));
        newAccount.setBirthplace(BirthplaceText.getText());
        newAccount.setAge(Integer.parseInt(AgeText.getText()));
        boolean check = false;
        for (AccountSV acc : accountList)
            if (acc.getUsername().equals(newAccount.getUsername())) {
                check = true;
                break;
            }
        if (check) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Ma so sinh vien nay da ton tai");
            alert.show();
        } else {
            accountList.add(newAccount);
        }
    }

    public  void fix(ActionEvent event){
        usernameText.setText(usernameText.getText());

    }
    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LogIn.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
    public void clickITem(MouseEvent event){
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                AccountSV selected = table.getSelectionModel().getSelectedItem();
                usernameText.setText(selected.getUsername());
                passwordText.setText(selected.getPassword());
                AgeText.setText(String.valueOf(selected.getAge()));
                EmailText.setText(selected.getEmail());
                BirthText.setText(String.valueOf(selected.getBirth()));
                BirthplaceText.setText(selected.getBirthplace());
            }
        });
    }

}
