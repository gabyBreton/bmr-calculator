package td3.bmr.breton.view;

import td3.bmr.breton.model.LifeStyle;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class provides methods to create, set and launch the BMR calculator.
 * 
 * @author Gabriel Breton - 43397
 */
public class BMRCalculator extends Application {

    private DatasGridPane datas;
    private ResultsGridPane results;
    
    /**
     * Launch the window of the BMR Calculator.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Stage params
        primaryStage.setTitle("Calcul du BMR"); 
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
        
        //create layouts
        VBox root = new VBox();      
        root.setPadding(new Insets(6));
        
        HBox infosZone = new HBox(); // zone with user datas & results
        infosZone.setPadding(new Insets(7));
        
        datas.initGridPane();
        datas.addTitle();
        datas.addLabels();
        datas.addTextFields();
        datas.addGenderButtons();
        datas.addLifeStyleChoiceBox();
        
        results.initGridPane();
        results.addTitle();
        results.addLabels();
        results.addTextFields();
    
        Button btnCalcul = new Button("Calcul du BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        
        //add layouts
        infosZone.getChildren().addAll(datas.getDatas(), results.getResults());
        root.getChildren().addAll(infosZone, btnCalcul);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
}
