package td3.bmr.breton.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        primaryStage.setTitle("BMR Calculator"); 
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
        
        //create layouts
        VBox root = new VBox();      
        root.setPadding(new Insets(6));
        
        HBox infosZone = new HBox(); // zone with user datas & results
        infosZone.setPadding(new Insets(7));
        
        datas = new DatasGridPane(); //datas zone of user
        results = new ResultsGridPane();//results zone of user

        datas.initAndSet();
        results.initAndSet();
    
        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        
        //add layouts
        infosZone.getChildren().addAll(datas.getDatas(), results.getResults());
        root.getChildren().addAll(infosZone, btnCalcul);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
}
