package sample.Main18;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private TextField adddressBar;
    private WebEngine engine;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            engine = webView.getEngine();
            engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
                if (newState == Worker.State.SUCCEEDED){
                    adddressBar.setText(engine.getLocation());
                }
            });
    }
    public void keyHandle (KeyEvent ke){
        if(ke.getCode().equals(KeyCode.ENTER));
        String address = adddressBar.getText();
        engine.load(address);
    }

    public  void backHandle(ActionEvent e){
        if(engine.getHistory().getCurrentIndex()>0){
            engine.getHistory().go(-1);
        }
    }
    public  void forwardHandle(ActionEvent e){
        if(engine.getHistory().getCurrentIndex()+1 < engine.getHistory().getEntries().size());
        engine.getHistory().go(1);
    }

}
