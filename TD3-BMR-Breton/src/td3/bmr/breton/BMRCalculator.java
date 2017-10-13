package td3.bmr.breton;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        
        primaryStage.setTitle("Calcul du BMR"); // to center.
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        
        //create layouts
        VBox root = new VBox(4);      
        HBox infosZone = new HBox();

        GridPane datas = new GridPane();
        datas.setBorder(border);
        datas.setPadding(new Insets(20));
        datas.setHgap(10);
        datas.setVgap(15);
        
        GridPane results = new GridPane();
        
        
    //create components for datas gridpane
        //labels
        
        Label datasTitle = new Label("Données");
        datas.add(datasTitle, 0, 0);
        
        
        Label lblSize = new Label("Taille (cm)");
        datas.add(lblSize, 0, 1);
        TextField tfdSize = new TextField("Taille en cm");
        datas.add(tfdSize, 1, 1);
        
        Label lblWeight = new Label("Poids (kg)");
        datas.add(lblWeight, 0, 2);
        TextField tfdWeight = new TextField("Poids en kg");
        datas.add(tfdWeight, 1, 2);
        
        Label lblAge = new Label("Age (années)");
        datas.add(lblAge, 0, 3);
        TextField tfdAge = new TextField("Age en années");
        datas.add(tfdAge, 1, 3);
        
        
        final ToggleGroup groupChoiceSex = new ToggleGroup();

        RadioButton rbWomen = new RadioButton("Femme");
        rbWomen.setToggleGroup(groupChoiceSex);
        rbWomen.setSelected(true);
        
        RadioButton rbMen = new RadioButton("Homme");
        rbMen.setToggleGroup(groupChoiceSex);
        
        Label lblSex = new Label("Sexe");
        datas.add(lblSex, 0, 4);
        //datas.add(groupChoiceSex, 4, 4);
        
        Label lblLifeStyle = new Label("Style de vie");
        datas.add(lblLifeStyle, 0, 5);

        ChoiceBox cbLifeStyle = new ChoiceBox();
        cbLifeStyle.getItems().addAll(LifeStyle.values());
        datas.add(cbLifeStyle, 1, 5);        
        
        //choicebox datas


        
        //create components for results gridpane
        Label resultsTitle = new Label("Résultats");
        results.add(resultsTitle, 0, 0);


        //add layouts
        root.getChildren().add(infosZone);
        infosZone.getChildren().addAll(datas, results);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
    
   
}
