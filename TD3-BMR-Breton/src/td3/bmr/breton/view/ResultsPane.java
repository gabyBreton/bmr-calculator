package td3.bmr.breton.view;

import td3.bmr.breton.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import td3.bmr.breton.model.BMRCalculator;

/**
 * This class provides methods to create, init and set the Results GridPane.
 *
 * @author Gabriel Breton - 43397
 */
public class ResultsPane implements Observer {
    private GridPane results;
    private TextField tfdBMR;
    private TextField tfdCalories;
    
    ResultsPane() {
        initAndSet();
    }
    
    /**
     * Initialize and set the components of the GridPane.
     */
    private void initAndSet() {
        initGridPane();
        addTitle();
        addLabels();
        addTextFields();
    }

    /**
     * Initialize the Results GridPane.
     */
    private void initGridPane() {
        results = new GridPane(); //results of calculs
        results.setPadding(new Insets(5));
        results.setHgap(10);
        results.setVgap(15);
    }

    /**
     * Add the title on the GridPane.
     */
    private void addTitle() {
        Label resultsTitle = new Label("Results");
        resultsTitle.setUnderline(true);
        results.add(resultsTitle, 0, 0);
    }

    /**
     * Add all the labels on the GridPane.
     */
    private void addLabels() {
        Label lblBMR = new Label("BMR");
        results.add(lblBMR, 0, 1);

        Label lblCalories = new Label("Calories");
        results.add(lblCalories, 0, 2);
    }

    /**
     * Add all the texfields on the GridPane.
     */
    private void addTextFields() {
        tfdBMR = new TextField();
        tfdBMR.setPromptText("BMR results");
        results.add(tfdBMR, 1, 1);

        tfdCalories = new TextField();
        tfdCalories.setPromptText("Calories expenses");
        results.add(tfdCalories, 1, 2);
    }

    /**
     * Gives the results GridPane.
     *
     * @return the results GridPane.
     */
    GridPane getResults() {
        return results;
    }

    /**
     * Set the BMR textfield.
     *
     * @param bmr the value of bmr.
     */
    void setBMR(Double bmr) {
        tfdBMR.setStyle("-fx-text-inner-color: black;");
        long roundedBMR = Math.round(bmr);
        tfdBMR.setText(Double.toString(roundedBMR));
    }

    /**
     * Set the calories textfield.
     *
     * @param calories the value of calories.
     */
    void setCalories(Double calories) {
        tfdCalories.setStyle("-fx-text-inner-color: black;");
        long roundedCalories = Math.round(calories);
        tfdCalories.setText(Long.toString(roundedCalories));
    }

    /**
     * Set the error messages in the results fields.
     */
    void showErrorsMessages() {
        setErrorTfdBMR("Failed !");
        setErrorTfdCalories("Failed !");
    }

    /**
     * Set an red error message in the BMR field.
     *
     * @param BMRString The error message.
     */
    private void setErrorTfdBMR(String BMRString) {
        tfdBMR.setStyle("-fx-text-inner-color: red;");
        tfdBMR.setText(BMRString);
    }

    /**
     * Set an red error message in the calories field.
     *
     * @param caloriesString The error message.
     */
    private void setErrorTfdCalories(String caloriesString) {
        tfdCalories.setStyle("-fx-text-inner-color: red;");
        tfdCalories.setText(caloriesString);
    }

    /**
     * Clear the results fields.
     */
    void clearAllFields() {
        tfdBMR.clear();
        tfdCalories.clear();
    }

    @Override
    public void update(BMRCalculator person) {
        setBMR(person.getBmr());
        setCalories(person.getCalories());
    }
}
