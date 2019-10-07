package javafxcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXCalculator extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}