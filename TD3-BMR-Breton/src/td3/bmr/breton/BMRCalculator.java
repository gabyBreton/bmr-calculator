package td3.bmr.breton;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calcul du BMR"); // to center.
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        
        //create layouts
        VBox root = new VBox(4);        
        HBox infosZone = new HBox();
        GridPane datas = new GridPane();
        GridPane results = new GridPane();
        
    //create components for datas gridpane
        //labels
        Label datasTitle = new Label("Données");
        Label lblSize = new Label("Taille (cm)");
        Label lblWeight = new Label("Poids (kg)");
        Label lblAge = new Label("Age (années)");
        Label lblSex = new Label("Sexe");
        Label lblLifeStyle = new Label("Style de vie");
        
        //fields
        TextField tfdSize = new TextField("Taille en cm");
        TextField tfdWeight = new TextField("Poids en kg");
        TextField tfdAge = new TextField("Age en années");
        
        //for the radio buttons
        final ToggleGroup groupChoiceSex = new ToggleGroup();
        
        RadioButton rbWomen = new RadioButton("Femme");
        rbWomen.setToggleGroup(groupChoiceSex);
        rbWomen.setSelected(true);
        
        RadioButton rbMen = new RadioButton("Homme");
        rbMen.setToggleGroup(groupChoiceSex);
        
        
        //create components for results gridpane
        Label resultsTitle = new Label("Résultats");
        
        //add components
        datas.add(datasTitle, 0, 0);
        results.add(resultsTitle, 0, 0);

        //add layouts
        root.getChildren().add(infosZone);
        infosZone.getChildren().addAll(datas, results);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
    
   
}
