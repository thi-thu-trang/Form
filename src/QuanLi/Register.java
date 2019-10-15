package QuanLi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class Register {
    @FXML
    protected TextField passwordTest;
    @FXML
    protected TextField usernameTest;

    protected List<AccountSV> accountList = Memory.getInstance().getAccounts();


    public void add(ActionEvent e) {
        AccountSV account = new AccountSV("Trang", "trang123", 14, "trangoi122", 2000, "danang");
        account.setUsername(usernameTest.getText());
        account.setPassword(passwordTest.getText());
        boolean check = false;
        for (AccountSV acc : accountList)
            if (acc.getUsername().equals(account.getUsername())) {
                check = true;
                break;
            }
        if (check) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("username da ton tai");
            alert.show();
        } else {
            accountList.add(account);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Register success");
            alert.show();
        }
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
