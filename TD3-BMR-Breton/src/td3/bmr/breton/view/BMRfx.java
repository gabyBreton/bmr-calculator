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
    @Override 
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BMR Calculator");        
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);

        VBox root = new VBox();        
        root.setPadding(new Insets(6));
        
        HBox infosBox = new HBox(); // zone with user datas & results
        infosBox.setPadding(new Insets(7));
        
        datas = new DatasPane(); //datas zone of user
        results = new ResultsPane();//results zone of user

        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        
        btnCalcul.setOnAction((ActionEvent event) -> {
            try {
                BMRCalculator.setHeight(datas.getHeight());
                BMRCalculator.setWeight(datas.getWeight());
                BMRCalculator.setAge(datas.getAge());
                BMRCalculator.setGender(datas.getRbWomen());
                BMRCalculator.setLifestyle(datas.getCbLifestyle());
                results.setBMR(BMRCalculator.getBmr());
                results.setCalories(BMRCalculator.getCalories());
            } catch (NumberFormatException nbrException) {
                results.setErrorTfdBMR("Failed !");
                results.setErrorTfdCalories("Failed !");
            }
        });

        infosBox.getChildren().addAll(datas.getDatas(), results.getResults());
        root.getChildren().addAll(infosBox, btnCalcul);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);        
        primaryStage.show();
    }
}
