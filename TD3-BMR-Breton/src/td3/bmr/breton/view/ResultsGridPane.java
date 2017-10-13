package td3.bmr.breton.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This class provides methods to create and set the results GridPane.
 * 
 * @author Gabriel Breton - 43397
 */
public class ResultsGridPane {
    
    private GridPane results;

    void initGridPane() {
        results = new GridPane(); //results of calculs
        results.setPadding(new Insets(5));
        results.setHgap(10);
        results.setVgap(15);
    }

    void addLabels() {
        addTitle();
        
        Label lblBMR = new Label("BMR");
        results.add(lblBMR, 0, 1);
        
        Label lblCalories = new Label("Calories");
        results.add(lblCalories, 0, 2);
    }
    
    void addTitle() {
        Label resultsTitle = new Label("Résultats");
        resultsTitle.setUnderline(true);
        results.add(resultsTitle, 0, 0);
    }
    
    void addTextFields() {
        TextField tfdBMR = new TextField();
        tfdBMR.setPromptText("Résultats du BMR");
        results.add(tfdBMR, 1, 1);
        
        TextField tfdCalories = new TextField();
        tfdCalories.setPromptText("Dépenses en calories");
        results.add(tfdCalories, 1, 2);        
    }
    
    public GridPane getResults() {
        return results;
    }

    public void setResults(GridPane results) {
        this.results = results;
    }
}
