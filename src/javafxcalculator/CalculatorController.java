package javafxcalculator;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class CalculatorController implements Initializable
{
    @FXML
    TextArea textOutput;
    @FXML
    Button buttonDelete;

    private ArrayList values = new ArrayList();
    private boolean reset = true;
    private boolean hasOperator = false;
    double[] temporary = {0, 0};
    private Boolean[] operator = new Boolean[4];

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }

    @FXML
    private void onKeyReleased(KeyEvent event)
    {

        switch(event.getCode())
        {
            case ENTER:
                finalCalculation();
                break;
            case DIGIT0:
            case NUMPAD0:
                pressKey("0");
                break;
            case DIGIT1:
            case NUMPAD1:
                pressKey("1");
                break;
            case DIGIT2:
            case NUMPAD2:
                pressKey("2");
                break;
            case DIGIT3:
            case NUMPAD3:
                pressKey("3");
                break;
            case DIGIT4:
            case NUMPAD4:
                pressKey("4");
                break;
            case DIGIT5:
            case NUMPAD5:
                pressKey("5");
                break;
            case DIGIT6:
            case NUMPAD6:
                pressKey("6");
                break;
            case DIGIT7:
            case NUMPAD7:
                pressKey("7");
                break;
            case DIGIT8:
            case NUMPAD8:
                pressKey("8");
                break;
            case DIGIT9:
            case NUMPAD9:
                pressKey("9");
                break;
            case PLUS:
            case ADD:
                pressOperator("+");
                break;
            case MINUS:
            case SUBTRACT:
                pressOperator("-");
                break;
            case MULTIPLY:
                pressOperator("*");
                break;
            case DIVIDE:
                pressOperator("/");
                break;
            default:
                break;
        }
    }

    @FXML public void delete(Event event) {
        buttonDelete.setText("CL");
        textOutput.setText("0");
        for(int i = 0; i < 2; i++) {
            temporary[i] = 0;
        }
        for(int i = 0; i<4; i++) {
            operator[i] = false;
        }
    }

    @FXML
    private void keypadAction(ActionEvent event)
    {
        Button button = (Button)event.getSource();
        String buttonText = button.getText();
        pressKey(buttonText);

    }

    @FXML
    private void operatorAction(ActionEvent event)
    {
        Button button = (Button)event.getSource();
        String operatorText = button.getText();
        pressOperator(operatorText);

    }

    private void pressOperator(String operator)
    {
        if(!"=".equals(operator))
        {
            if(values.size() == 0 || isOperator(values.get(values.size()-1).toString()) )
            {
                return;
            }

            values.add(operator);

            hasOperator = true;
            addToOutput(operator);
        }
        else
        {
            finalCalculation();
        }
    }
    private void pressKey(String key)
    {
        if(reset)
        {
            textOutput.setText("");
            values.clear();
            reset = false;
            hasOperator = false;
        }

        values.add(key);
        addToOutput(key);
    }

    private void finalCalculation()
    {
        double result = 0;
        String stringOperator = "";
        String stringValue1 = "";
        String stringValue2 = "";

        try
        {
            if(values.size() == 0 || isOperator(values.get(values.size()-1).toString()) || !hasOperator)
            {
                return;
            }
            for(Iterator<String> i = values.iterator(); i.hasNext();)
            {
                String item = i.next();

                if(isOperator(item))
                {
                    if(!"".equals(stringOperator))
                    {

                        result = calculate(Double.parseDouble(stringValue1), Double.parseDouble(stringValue2), stringOperator);
                        stringValue1 = result + "";
                        stringValue2 = "";
                    }
                    stringOperator = item;
                }
                else
                {
                    if("".equals(stringOperator))
                    {
                        stringValue1 = stringValue1 + item;
                    }
                    else
                    {
                        stringValue2 = stringValue2 + item;
                    }
                }
                if(!i.hasNext())
                {
                    result = calculate(Double.parseDouble(stringValue1), Double.parseDouble(stringValue2), stringOperator);
                }
            }

            textOutput.setText(result + "");
            values.clear();

            reset = true;
            hasOperator = false;

        }
        catch(Exception ex)
        {
            textOutput.setText(0 + "");
            values.clear();
            reset = true;
            hasOperator = false;
        }
    }

    public double calculate(double num1, double num2, String operator)
    {
        switch(operator)
        {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if(num2 == 0)
                {
                    return 0;
                }
                return num1 / num2;
            case "%":
                return num1 % num2;
            default:
                System.out.println("Undefined operator pressed: " + operator);
                return 0;
        }
    }
    private boolean isOperator(String operator)
    {
        switch(operator)
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return true;
            default:
                return false;
        }
    }

    private void addToOutput(String text)
    {
        if("0".equals(textOutput.getText()) )
        {
            textOutput.setText("");
        }
        textOutput.setText(textOutput.getText() + text);
    }


    @FXML
    private void menuQuit(ActionEvent event)
    {
        Platform.exit();
        System.exit(0);
    }
}