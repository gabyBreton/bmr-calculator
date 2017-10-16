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
    private static int[] fieldsValues;
    private static boolean women;
    private static double lifestyleValue;
    private static double bmr;
    private static double calories;
    
    public static void useDatasFromUser(DatasUI datas) {
        initiliazeFieldsArray();
        verifyIntTextFieldInput(datas.getTfdSize(), 0);
        verifyIntTextFieldInput(datas.getTfdWeight(), 1);
        verifyIntTextFieldInput(datas.getTfdAge(), 2);
        assignFieldsValues(fieldsValues);
        getSelectedGender(datas.getRbWomen());
        getSelectedLifeStyleValue(datas.getCbLifestyle());
    }

    private static void verifyIntTextFieldInput(TextField textField, int field){
        String input;
        input = textField.getText();
        
        if (isNumeric(input)) {
            fieldsValues[field] = Integer.valueOf(input); //field should be verified.
        } else {
            System.out.println(input + " is not numeric.");
        }
    }

    private static void initiliazeFieldsArray() {
        fieldsValues =  new int[3];
        for(int i = 0; i < fieldsValues.length; i++) {
            fieldsValues[i] = 0;
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

    private static void getSelectedGender(RadioButton rbWomen) {
        setWomen(rbWomen.isSelected());
    }

    private static void getSelectedLifeStyleValue(ChoiceBox cbLifestyle) {
        LifeStyle lifestyle;
        lifestyle=(LifeStyle) cbLifestyle.getSelectionModel().getSelectedItem();
        assignLifestyleValue(lifestyle);
    }
    
    private static void assignLifestyleValue(LifeStyle lifeStyle) { //TODO VERIF IF GOOD VALUES
	switch (lifeStyle) {
	    case SEDENTARY : setLifestyleValue(1.2);
                             break;
	    case LOW_ACTIV : setLifestyleValue(1.375);
                             break;
	    case ACTIV : setLifestyleValue(1.55);
	                 break;
	    case VERY_ACTIV : setLifestyleValue(1.725);
                              break;
	    case EXTREM_ACTIV : setLifestyleValue(1.9);
                                break;
        }
    }

    static double calculateBMR() {
        if(isWomen()){
            bmr = (9.6 * getWeight()) + (1.8 * getSize()) - (4.7 * getAge()) 
                  + 655;
        } else {
            bmr = (13.7 * getWeight()) + (5 * getSize()) - (6.8 * getAge())
                  + 66;
        }
        return bmr;
    }
    
    static double calculateCalories() {
        calories = getBmr() * getLifestyleValue();
        return calories;
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

    public static boolean isWomen() {
        return women;
    }

    public static double getLifestyleValue() {
        return lifestyleValue;
    }

    public static double getBmr() {
        return bmr;
    }

    public static double getCalories() {
        return calories;
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

    public static void setWomen(boolean women) {
        Datas.women = women;
    }

    public static void setLifestyleValue(double lifestyleValue) {
        Datas.lifestyleValue = lifestyleValue;
    }

    public static void setBmr(double bmr) {
        Datas.bmr = bmr;
    }

    public static void setCalories(double calories) {
        Datas.calories = calories;
    }
    
    
}
