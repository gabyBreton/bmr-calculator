package td3.bmr.breton.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This class provides methods to create, init and set the Results GridPane.
 *
 * @author Gabriel Breton - 43397
 */
public class ResultsUI {

    private GridPane results;
    private TextField tfdBMR;
    private TextField tfdCalories;
    
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
     * Initialize and set the components of the GridPane.
     */
    void initAndSet() {
        initGridPane();
        addTitle();
        addLabels();
        addTextFields();
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
     * Gives the Results GridPane.
     * 
     * @return the Results GridPane.
     */
    public GridPane getResults() {
        return results;
    }

    /**
     * Gives the textfield BMR.
     * 
     * @return the textfield BMR.
     */
    public TextField getTfdBMR() {
        return tfdBMR;
    }

    /**
     * Gives the textfield Calories.
     * 
     * @return the textfield Calories.
     */
    public TextField getTfdCalories() {
        return tfdCalories;
    }
}
