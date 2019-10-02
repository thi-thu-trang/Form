package sample.Main20;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javax.print.attribute.standard.NumberUp;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    LineChart<String,Number> lineChart;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<String,Number> series =  new XYChart.Series<>();
        XYChart.Data<String, Number> jan = new XYChart.Data<>("jan",300);
        XYChart.Data<String, Number> fer = new XYChart.Data<>("fer",400);
        XYChart.Data<String, Number> mar = new XYChart.Data<>("mar",600);
        XYChart.Data<String, Number> apr = new XYChart.Data<>("apr",900);
        series.getData().addAll(jan,fer,mar,apr);
        series.setName("Salary per month of Trang");
        lineChart.getData().add(series);

        XYChart.Series<String,Number> series1 =  new XYChart.Series<>();
        XYChart.Data<String, Number> jan1 = new XYChart.Data<>("jan",122);
        XYChart.Data<String, Number> fer1 = new XYChart.Data<>("fer",344);
        XYChart.Data<String, Number> mar1 = new XYChart.Data<>("mar",566);
        XYChart.Data<String, Number> apr1 = new XYChart.Data<>("apr",800);
        series1.getData().addAll(jan1,fer1,mar1,apr1);
        series1.setName("Salary per month of kkk");
        lineChart.getData().add(series1);

    }
}
