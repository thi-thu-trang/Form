package sample.Main19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    TextField CSharpID,JavaID,PythonID;
    @FXML
    PieChart pieChart;

    public void Load(ActionEvent event){
        try{
            int CSharpValue = Integer.parseInt(CSharpID.getText());
            int JavaValue = Integer.parseInt(JavaID.getText());
            int PythonValue = Integer.parseInt(PythonID.getText());
            PieChart.Data CSharp = new PieChart.Data("C#",CSharpValue);
            PieChart.Data Java = new PieChart.Data("Java",JavaValue);
            PieChart.Data Python = new PieChart.Data("Python",PythonValue);
            pieChart.getData().clear();// xoas những giá trị cũ
            pieChart.getData().addAll(CSharp,Java,Python);
            for(PieChart.Data data : pieChart.getData()){
                data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,event1 -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Data");
                    alert.setContentText(data.getName()+":"+data.getPieValue());
                    alert.showAndWait();
                });
            }
        }catch (Exception e){

        }

    }
}
