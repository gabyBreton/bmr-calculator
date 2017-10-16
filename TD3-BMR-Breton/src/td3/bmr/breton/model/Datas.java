package td3.bmr.breton.model;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import td3.bmr.breton.view.DatasUI;

/**
 *
 * @author Gabriel Breton - 43397
 */
public class Datas {
    private static Integer age;
    private static Integer size;
    private static Integer weight;
    private static int[] fields;
//    private RadioButton rbMen, rbWomen;
//  private ChoiceBox cbLifeStyle;
    
    public static void useDatasInFields(DatasUI datas) {
        initiliazeFieldsArray();
        verifyIntTextFieldInput(datas.getTfdSize(), 0);
        verifyIntTextFieldInput(datas.getTfdWeight(), 1);
        verifyIntTextFieldInput(datas.getTfdAge(), 2);
        assignFieldsValues(fields);
    }

    private static void verifyIntTextFieldInput(TextField textField, int field) {
        String input;
        input = textField.getText();
        
        if (isNumeric(input)) {
            fields[field] = Integer.valueOf(input); //field should be verified.
        } else {
            System.out.println(input + " is not numeric.");
        }
    }

    private static void initiliazeFieldsArray() {
        fields =  new int[3];
        for(int i = 0; i < fields.length; i++) {
            fields[i] = 0;
        }
    }
    private static void assignFieldsValues(int[] fields) {
        setSize(fields[0]);
        setWeight(fields[1]);
        setAge(fields[2]);
    }
    
    private static boolean isNumeric(String input) {
        try {
            double d = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static Integer getSize() {
        
        return size;
    }

    public static Integer getWeight() {
        return weight;
    }

    public static Integer getAge() {
        return age;
    }

    public static void setAge(Integer age) {
        Datas.age = age;
    }

    public static void setSize(Integer size) {
        Datas.size = size;
    }

    public static void setWeight(Integer weight) {
        Datas.weight = weight;
    }
    
    
}
