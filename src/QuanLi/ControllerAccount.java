package QuanLi;

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

public class ControllerAccount {
    @FXML
    private TextField nameText;
    @FXML
    private TextField passText;
    @FXML
    private Label button;

    private List<AccountSV> accounts = Memory.getInstance().getAccounts();

    public void registere(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Register.fxml"));
        Parent dulieu1 = loader.load();
        Scene scene1 = new Scene(dulieu1);
        stage.setScene(scene1);
    }

    public void signIn(ActionEvent e) throws IOException {
        String user = nameText.getText();
        String pass = passText.getText();
        boolean isSuccess = false;
        if (accounts.size() == 0) {
            isSuccess = false;
        } else {
            for (AccountSV account : accounts) {
                if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                    isSuccess = true;
                    break;
                }
            }
        }

        if (isSuccess) {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LogIn.fxml"));
            Parent dulieu1 = loader.load();
            Scene scene1 = new Scene(dulieu1);
            stage.setScene(scene1);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("LOGIN");
            alert.setHeaderText("LOGIN FAIL");
            alert.showAndWait();
        }
    }
}
