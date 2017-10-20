package td3.bmr.breton.model;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;

/**
 * This class calculates the BMR and the calories.
 *
 * @author Gabriel Breton - 43397
 */
public class BMRCalculator {

    private static double age;
    private static double height;
    private static double weight;
    private static boolean women;
    private static double lifestyleValue;
    private static double bmr;
    private static double calories;

    /**
     * Calculate the BMR.
     *
     * @return the value of the BMR.
     */
    private static void calculateBMR() {
        if (isWomen()) {
            bmr = (9.6 * getWeight()) + (1.8 * getHeight()) - (4.7 * getAge())
                    + 655;
        } else {
            bmr = (13.7 * getWeight()) + (5 * getHeight()) - (6.8 * getAge())
                    + 66;
        }
    }

    /**
     * Calculates the daily amounts of calories.
     *
     * @return the daily calories.
     */
    private static void calculateCalories() {
        calories = getBmr() * getLifestyleValue();
    }

    /**
     * Gives the height.
     *
     * @return the height.
     */
    private static double getHeight() {
        return height;
    }

    /**
     * Gives the weight.
     *
     * @return the weight.
     */
    private static double getWeight() {
        return weight;
    }

    /**
     * Gives the age.
     *
     * @return the age.
     */
    private static double getAge() {
        return age;
    }

    /**
     * Gives the value of women.
     *
     * @return the value of women.
     */
    private static boolean isWomen() {
        return women;
    }

    /**
     * Gives the lifestyle value.
     *
     * @return the lifestyle value.
     */
    private static double getLifestyleValue() {
        return lifestyleValue;
    }

    /**
     * Gives the BMR value.
     *
     * @return the value of the BMR.
     */
    public static double getBmr() {
        calculateBMR();
        return bmr;
    }

    /**
     * Gives the calories value.
     *
     * @return the calories value.
     */
    public static double getCalories() {
        calculateCalories();
        return calories;
    }

    /**
     * Set the age value.
     *
     * @param age the age to set.
     */
    public static void setAge(Double age) {
        BMRCalculator.age = age;
    }

    /**
     * Set the height value.
     *
     * @param height the size value.
     */
    public static void setHeight(Double height) {
        BMRCalculator.height = height;
    }

    /**
     * Set the weight value.
     *
     * @param weight the weight to set.
     */
    public static void setWeight(Double weight) {
        BMRCalculator.weight = weight;
    }

    /**
     * Set the value of women corresponding on the radio button selected.
     *
     * @param rbWomen the women radio button.
     */
    public static void setGender(RadioButton rbWomen) {
        setWomen(rbWomen.isSelected());
    }

    /**
     * Set the women value.
     *
     * @param women the boolean to set.
     */
    private static void setWomen(boolean women) {
        BMRCalculator.women = women;
    }

    /**
     * Get the selected lifestyle in the choice box. Assign the lifestyle to a
     * value.
     *
     * @param cbLifestyle the choicebox of the lifestyle.
     */
    public static void setLifestyle(ChoiceBox cbLifestyle) {
        Lifestyle lifestyle;
        lifestyle = (Lifestyle) cbLifestyle.getSelectionModel().getSelectedItem();
        assignLifestyleValue(lifestyle);
    }

    /**
     * Assign the value corresponding to a lifestyle.
     *
     * @param lifeStyle the lifestyle to assign the corresponding value.
     */
    private static void assignLifestyleValue(Lifestyle lifeStyle) {
        switch (lifeStyle) {
            case SEDENTARY:
                setLifestyleValue(1.2);
                break;
            case LOW_ACTIV:
                setLifestyleValue(1.375);
                break;
            case ACTIV:
                setLifestyleValue(1.55);
                break;
            case VERY_ACTIV:
                setLifestyleValue(1.725);
                break;
            case EXTREM_ACTIV:
                setLifestyleValue(1.9);
                break;
        }
    }

    /**
     * Set the lifestyle value.
     *
     * @param lifestyleValue the value to set.
     */
    private static void setLifestyleValue(double lifestyleValue) {
        BMRCalculator.lifestyleValue = lifestyleValue;
    }
}
