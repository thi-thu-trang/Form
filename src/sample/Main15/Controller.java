package sample.Main15;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class Controller {
    public void action (ActionEvent event){
        Platform.exit();
        System.exit(0);
    }
}
