package td3.bmr.breton.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import td3.bmr.breton.model.BMRCalculator;

/**
 * This class provides methods to create, set and launch the BMR calculator.
 * 
 * @author Gabriel Breton - 43397
 */
public class BMRfx extends Application {

    private DatasPane datas;
    private ResultsPane results;
    
    /**
     * Launch the window of the BMR Calculator.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start the application.
     * 
     * @param primaryStage the stage where start the application
     * @throws Exception 
     */
    @Override //FIX-ME: Should use start() only to start the application. 
    public void start(Stage primaryStage) throws Exception {
        //Stage params
        primaryStage.setTitle("BMR Calculator"); 
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
        
        //create layouts
        VBox root = new VBox();      
        root.setPadding(new Insets(6));
        
        HBox infosBox = new HBox(); // zone with user datas & results
        infosBox.setPadding(new Insets(7));
        
        datas = new DatasPane(); //datas zone of user
        results = new ResultsPane();//results zone of user

        //datas.initAndSet();
      //  results.initAndSet();
    
        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        
        btnCalcul.setOnAction((ActionEvent event) -> {
            BMRCalculator.useDatasFromUser(datas);
            BMRCalculator.giveResultsToFields(results);
        });
        
        //add layouts
        infosBox.getChildren().addAll(datas.getDatas(), results.getResults());
        root.getChildren().addAll(infosBox, btnCalcul);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
}
