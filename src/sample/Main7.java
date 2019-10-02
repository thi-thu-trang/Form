package sample;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main7 {
    public static void main(String[] args) {

        IntegerProperty a = new SimpleIntegerProperty();
        IntegerProperty b = new SimpleIntegerProperty();
        System.out.println(b.getValue());
        b.bind(a.add(3));
        //ràng buộc giá trị của a cho  b
        a.setValue(12);
        System.out.println(b.getValue());
        a.setValue(30);
        System.out.println(b.getValue());
       //????// System.out.println(b.getBean());
    }
}
