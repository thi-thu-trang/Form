package Form;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Register {
    @FXML
    protected TextField passwordTest;
    @FXML
    protected TextField usernameTest;
    @FXML
    private TextField AgeText;
    @FXML
    private TextField EmailText;
    @FXML
    private TextField BirthText;
    @FXML
    private TextField BirthplaceText;
    protected List<Account> accountList = Memory.getInstance().getAccounts();
    @FXML
    private Label username;
    @FXML
    private Label password;


    public void add(ActionEvent e) {
        Account account = new Account();
        account.setUsername(usernameTest.getText());
        account.setPassword(passwordTest.getText());
        account.setAge(Integer.parseInt(AgeText.getText()));
        account.setBirth(Integer.parseInt(BirthText.getText()));
        account.setEmail(EmailText.getText());
        account.setBirthplace(BirthplaceText.getText());
        accountList.add(account);
       // table.setItems((ObservableList<Account>) accountList);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Register");
        alert.setHeaderText("Register Success ");
        alert.showAndWait();
        System.out.println(accountList);
    }


    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }

    public void Information(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("infor.fxml"));
        Parent dulieu2 = loader.load();
        Scene scene2 = new Scene(dulieu2);
        stage.setScene(scene2);
    }
}

//        if(account.setUsername(String.valueOf(username.getText()== null))){
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Register ");
//            alert.setHeaderText("Register Fail ");
//            alert.showAndWait();
//        }
//        else {
//            for (Account account1 :accountList){
//               if (account1.getUsername().equals(account.getUsername())){
//                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                   alert.setTitle("Register ");
//                   alert.setHeaderText("Register Fail");
//                   alert.showAndWait();
//               }
//               else {
//                   accountList.add(account);
//                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                   alert.setTitle("Register ");
//                   alert.setHeaderText("Register Success");
//                   alert.showAndWait();
//               }
//            }
//        }
