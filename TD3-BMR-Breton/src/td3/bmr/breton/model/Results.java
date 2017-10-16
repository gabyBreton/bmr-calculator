package td3.bmr.breton.model;

import td3.bmr.breton.view.ResultsUI;

/**
 * This class provides method to manage the results of the calculations.
 * @author Gabriel Breton - 43397
 */
public class Results {
    private static String bmrString;
    private static String caloriesString;
    
    /**
     * Set the values of the textfields for the results of the calculations of
     * BMR and calories.
     * 
     * @param results the Results GridPane where to show the results of the 
     * calculations.
     */
    public static void giveResultsToFields(ResultsUI results) {
        bmrString = Double.toString(Datas.calculateBMR());
        caloriesString = Double.toString(Datas.calculateCalories());
        
        results.getTfdBMR().setText(bmrString);
        results.getTfdCalories().setText(caloriesString);
    }
}
