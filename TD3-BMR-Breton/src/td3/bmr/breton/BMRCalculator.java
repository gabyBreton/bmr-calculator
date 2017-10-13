package td3.bmr.breton;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        Border border =
               new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3)));
        
        primaryStage.setTitle("Calcul du BMR"); 
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
        
        //create layouts
        VBox root = new VBox();      
        root.setPadding(new Insets(6));
        HBox infosZone = new HBox();
        infosZone.setPadding(new Insets(7));
        
        GridPane datas = new GridPane();
        datas.setPadding(new Insets(5));
        datas.setHgap(10);
        datas.setVgap(15);
        
        GridPane results = new GridPane();
        results.setPadding(new Insets(5));
        results.setHgap(10);
        results.setVgap(15);
        
        //create components for datas gridpane
        Label datasTitle = new Label("Données");
        datasTitle.setUnderline(true);
        datas.add(datasTitle, 0, 0);
        
        Label lblSize = new Label("Taille (cm)");
        datas.add(lblSize, 0, 1);
        TextField tfdSize = new TextField();
        tfdSize.setPromptText("Taille en cm");
        datas.add(tfdSize, 1, 1);
        
        Label lblWeight = new Label("Poids (kg)");
        datas.add(lblWeight, 0, 2);
        TextField tfdWeight = new TextField();
        tfdWeight.setPromptText("Poids en kg");
        datas.add(tfdWeight, 1, 2);
        
        Label lblAge = new Label("Age (années)");
        datas.add(lblAge, 0, 3);
        TextField tfdAge = new TextField();
        tfdAge.setPromptText("Age en années");
        datas.add(tfdAge, 1, 3);
        
        Label lblSex = new Label("Sexe");
        datas.add(lblSex, 0, 4);
      
        final ToggleGroup groupChoiceSex = new ToggleGroup();

        RadioButton rbWomen = new RadioButton("Femme");
        rbWomen.setToggleGroup(groupChoiceSex);
        rbWomen.setSelected(true);
        
        RadioButton rbMen = new RadioButton("Homme");
        rbMen.setToggleGroup(groupChoiceSex);
        HBox sexChoice = new HBox(20);
        sexChoice.getChildren().addAll(rbWomen, rbMen);
        datas.add(sexChoice, 1, 4);
        
        Label lblLifeStyle = new Label("Style de vie");
        datas.add(lblLifeStyle, 0, 5);

        ChoiceBox cbLifeStyle = new ChoiceBox();
        cbLifeStyle.getItems().addAll(LifeStyle.values());
        cbLifeStyle.getSelectionModel().selectFirst();;
        datas.add(cbLifeStyle, 1, 5);        
        
        //create components for results gridpane
        Label resultsTitle = new Label("Résultats");
        resultsTitle.setUnderline(true);
        results.add(resultsTitle, 0, 0);
        
        Label lblBMR = new Label("BMR");
        results.add(lblBMR, 0, 1);
        
        TextField tfdBMR = new TextField();
        tfdBMR.setPromptText("Résultats du BMR");
        results.add(tfdBMR, 1, 1);
        
        Label lblCalories = new Label("Calories");
        results.add(lblCalories, 0, 2);
        
        TextField tfdCalories = new TextField();
        tfdCalories.setPromptText("Dépenses en calories");
        results.add(tfdCalories, 1, 2);
        
        Button btnCalcul = new Button("Calcul du BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        
        //add layouts
        infosZone.getChildren().addAll(datas, results);
        root.getChildren().addAll(infosZone, btnCalcul);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
    
   
}
