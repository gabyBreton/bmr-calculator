package td3.bmr.breton.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ChoiceBox;
import td3.bmr.breton.util.Observable;
import td3.bmr.breton.util.Observer;

/**
 * This class calculates the BMR and the calories.
 *
 * @author Gabriel Breton - 43397
 */
public class BMRCalculator implements Observable {

    private double age;
    private double height;
    private double weight;
    private boolean women;
    private double lifestyleValue;
    private double bmr;
    private double calories;
    private final List<Observer> listObs;

    public BMRCalculator() {
        listObs = new ArrayList<>();
    }

    /**
     * Calculates the BMR.
     */
    private void calculateBMR() {
        if (women) {
            bmr = (9.6 * weight) + (1.8 * height) - (4.7 * age) + 655;
        } else {
            bmr = (13.7 * weight) + (5 * height) - (6.8 * age) + 66;
        }
    }

    /**
     * Calculates the daily amounts of calories.
     */
    public void calculateCalories() {
        calculateBMR();
        calories = bmr * lifestyleValue;
        notifyObservers();
    }

    /**
     * Gives the BMR value.
     *
     * @return the value of the BMR.
     */
    public double getBmr() {
        return bmr;
    }

    /**
     * Gives the calories value.
     *
     * @return the calories value.
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Set the age value.
     *
     * @param age the age to set.
     */
    public void setAge(Double age) {
        this.age = age;
    }

    /**
     * Set the height value.
     *
     * @param height the height value.
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * Set the weight value.
     *
     * @param weight the weight to set.
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Set the women value.
     *
     * @param women the boolean to set.
     */
    public void setWomen(boolean women) {
        this.women = women;
    }

    /**
     * Get the selected lifestyle in the choice box. Assign the lifestyle to a
     * value.
     *
     * @param cbLifestyle the choicebox of the lifestyle.
     */
    public void setLifestyle(ChoiceBox cbLifestyle) {
        Lifestyle lifestyle;
        lifestyle=(Lifestyle) cbLifestyle.getSelectionModel().getSelectedItem();
        assignLifestyleValue(lifestyle);
    }

    /**
     * Assign the value corresponding to a lifestyle.
     *
     * @param lifeStyle the lifestyle to assign the corresponding value.
     */
    private void assignLifestyleValue(Lifestyle lifeStyle) {
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
    private void setLifestyleValue(double lifestyleValue) {
        this.lifestyleValue = lifestyleValue;
    }
    
    /**
     * Gives the value of age.
     * 
     * @return the value of age.
     */
    public double getAge() {
        return age;
    }

    /**
     * Gives the value of height.
     * 
     * @return the value of height.
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Gives the value of weight.
     * 
     * @return the value of weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gives the value of women.
     * 
     * @return true if women, or else false.
     */
    public boolean isWomen() {
        return women;
    }

    /**
     * Add an observer in the list of observers.
     * 
     * @param o the observer to add.
     */
    @Override
    public void addObserver(Observer o) {
        if (!listObs.contains(o)) {
            listObs.add(o);
        }
    }

    /**
     * Add a variable number of observers.
     * 
     * @param o the differents observers.
     */
    @Override
    public void addAllObserver(Observer... o) {
        for (Observer obs : o) {
            addObserver(obs);
        }
    }

    /**
     * Deletes an observer from the list of observers.
     * 
     * @param o the observer to delete.
     */
    @Override
    public void deleteObserver(Observer o) {
        listObs.remove(o);
    }

    /**
     * Notifies of an update the observers of the list.
     */
    private void notifyObservers() {
        listObs.forEach((obs) -> {
            obs.update(this);
        });
    }
}
