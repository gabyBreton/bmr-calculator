package td3.bmr.breton;

import javafx.application.Application;
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
        primaryStage.setTitle("Calcul du BMR");
        VBox root = new VBox();
        
        HBox infosZone = new HBox();
        GridPane userInfos = new GridPane();
        GridPane userBMR = new GridPane();
        
        root.getChildren().add(infosZone);
        infosZone.getChildren().addAll(userInfos, userBMR);
        
        primaryStage.show();
    }
}
