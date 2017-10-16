package td3.bmr.breton.model;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import td3.bmr.breton.view.DatasUI;

/**
 * This class provides methods to manage the user inputs.
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
   
    /**
     * Uses the datas of the user to be able to calculate the BMR and calories.
     * 
     * @param datas the datas inputs.
     */
    public static void useDatasFromUser(DatasUI datas) {
        initiliazeFieldsArray();
        if(verifyIntInput(datas)) {
            assignFieldsValues(fieldsValues);
            setSelectedGender(datas.getRbWomen());
            getSelectedLifeStyleValue(datas.getCbLifestyle());
        }
    }

    /**
     * Verifies if the datas inputs are all integer.
     * 
     * @param datas the datas to verify.
     * @return true if the inputs verified are all integer, else false.
     */
    private static boolean verifyIntInput(DatasUI datas) {
        return verifyIntTextFieldInput(datas.getTfdAge(), 2) 
                && verifyIntTextFieldInput(datas.getTfdWeight(), 1)
                && verifyIntTextFieldInput(datas.getTfdSize(), 0);
    }

    /**
     * Verify if a textfield contains an integer. Recuperates this integer, if 
     * it is not an integer, set the textfield with an error message.
     * 
     * @param textField the textfield to verify the content.
     * @param field a value used as an id to store the value of the specific 
     * textfield in an array.
     * @return true if the content of the textfield is an integer.
     */
    private static boolean verifyIntTextFieldInput(TextField textField, int field){
        String input;
        boolean numeric;
        input = textField.getText();
        
        if (isNumeric(input)) {
            fieldsValues[field] = Integer.valueOf(input); //field should be verified.
            numeric = true;
        } else {
            textField.setText("Insert numeric");
            numeric = false;
        }
        
        return numeric;
    }

    /**
     * Initialize with 0 the array that will contains the values of the 
     * textfields.
     */
    private static void initiliazeFieldsArray() {
        fieldsValues =  new int[3];
        for(int i = 0; i < fieldsValues.length; i++) {
            fieldsValues[i] = 0;
        }
    }
    
    /**
     * Recuperates values of array of textfield values and assign them.
     * 
     * @param fields the array of textfield values.
     */
    private static void assignFieldsValues(int[] fields) {
        setSize(fields[0]);
        setWeight(fields[1]);
        setAge(fields[2]);
    }
    
    /**
     * Verify if a string contains only numerical value.
     * 
     * @param input the string to verify.
     * @return true if the string contains only numerical value, else false.
     */
    private static boolean isNumeric(String input) {
        try {
            double d = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Set the value of women corresponding on the radio button selected.
     * 
     * @param rbWomen the women radio button.
     */
    private static void setSelectedGender(RadioButton rbWomen) {
        setWomen(rbWomen.isSelected());
    }

    /**
     * Get the selected lifestyle in the choice box.
     * Assign the lifestyle to a value.
     * 
     * @param cbLifestyle the choicebox of the lifestyle.
     */
    private static void getSelectedLifeStyleValue(ChoiceBox cbLifestyle) {
        LifeStyle lifestyle;
        lifestyle=(LifeStyle) cbLifestyle.getSelectionModel().getSelectedItem();
        assignLifestyleValue(lifestyle);
    }
    
    /**
     * Assign a value depending on a lifestyle.
     * 
     * @param lifeStyle the lifestyle to assign the corresponding value.
     */
    private static void assignLifestyleValue(LifeStyle lifeStyle) { 
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

    /**
     * Calculate the BMR.
     * 
     * @return the value of the BMR.
     */
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
    
    /**
     * Calculates the daily amounts of calories.
     * 
     * @return the daily calories.
     */
    static double calculateCalories() {
        calories = getBmr() * getLifestyleValue();
        return calories;
    }
    
    /**
     * Gives the size.
     * 
     * @return the size.
     */
    public static Integer getSize() {
        return size;
    }

    /**
     * Gives the weight.
     * 
     * @return the weight.
     */
    public static Integer getWeight() {
        return weight;
    }

    /**
     * Gives the age.
     * 
     * @return the age.
     */
    public static Integer getAge() {
        return age;
    }

    /**
     * Gives the value of women.
     * 
     * @return the value of women.
     */
    public static boolean isWomen() {
        return women;
    }

    /**
     * Gives the lifestyle value.
     * 
     * @return the lifestyle value.
     */
    public static double getLifestyleValue() {
        return lifestyleValue;
    }

    /**
     * Gives the BMR value.
     * 
     * @return the value of the BMR.
     */
    public static double getBmr() {
        return bmr;
    }

    /**
     * Gives the calories value.
     * 
     * @return the calories value.
     */
    public static double getCalories() {
        return calories;
    }
    
    /**
     * Set the age value.
     * 
     * @param age the age to set.
     */
    public static void setAge(Integer age) {
        Datas.age = age;
    }

    /**
     * Set the size value.
     * 
     * @param size the size value.
     */
    public static void setSize(Integer size) {
        Datas.size = size;
    }

    /**
     * Set the weight value.
     * 
     * @param weight the weight to set.
     */
    public static void setWeight(Integer weight) {
        Datas.weight = weight;
    }

    /**
     * Set the women value.
     * 
     * @param women the boolean to set.
     */
    public static void setWomen(boolean women) {
        Datas.women = women;
    }

    /**
     * Set the lifestyle value.
     * 
     * @param lifestyleValue the value to set.
     */
    public static void setLifestyleValue(double lifestyleValue) {
        Datas.lifestyleValue = lifestyleValue;
    }
}
