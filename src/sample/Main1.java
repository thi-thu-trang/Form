package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main1 extends Application  {
    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("hello world");
        button = new Button();
        button.setText("say hello world");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello Trang");
            }
        });
//        Button button1 = new Button();
//        button1.setText("say ");
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene =  new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


}
