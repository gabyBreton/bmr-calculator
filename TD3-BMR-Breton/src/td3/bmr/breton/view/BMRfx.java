package td3.bmr.breton.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
     * @throws NumberFormatException if a entered datas is not a string
     * representing a number.
     */
    @Override
    public void start(Stage primaryStage) throws NumberFormatException {
        primaryStage.setTitle("BMR Calculator");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);

        VBox root = new VBox();

        VBox rootScene = new VBox();
        rootScene.setPadding(new Insets(6));

        VBox zoneButtons = new VBox();
        zoneButtons.setSpacing(11);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");

        HBox infosBox = new HBox(); // zone with user datas & results
        infosBox.setPadding(new Insets(7));

        datas = new DatasPane(); //datas zone of user
        results = new ResultsPane();//results zone of user

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);

        Button btnClear = new Button("Clear");
        btnClear.setMaxWidth(Double.MAX_VALUE);
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Encoding error");
        alert.setContentText("Enter a value strictly superior to zero.");        
        
        btnCalcul.setOnAction((ActionEvent event) -> {
            try {
                BMRCalculator.setHeight(datas.getHeight());
            } catch (NumberFormatException nbrException) {
                alert.setHeaderText("Value of the height incorrect.");
                alert.showAndWait();
                results.showErrorsMessages();
            }

            try {
                BMRCalculator.setWeight(datas.getWeight());
            } catch (NumberFormatException nbrException) {
                alert.setHeaderText("Value of the weight incorrect.");
                alert.showAndWait();
                results.showErrorsMessages();
            }

            try {
                BMRCalculator.setAge(datas.getAge());
                BMRCalculator.setGender(datas.getRbWomen());
                BMRCalculator.setLifestyle(datas.getCbLifestyle());
                results.setBMR(BMRCalculator.getBmr());
                results.setCalories(BMRCalculator.getCalories());
            } catch (NumberFormatException nbrException) {
                alert.setHeaderText("Value of the age incorrect.");
                alert.showAndWait();
                results.showErrorsMessages();
            }
        });

        btnClear.setOnAction((ActionEvent event) -> {
            datas.clearAllFields();
            results.clearAllFields();
        });

        menuFile.getItems().add(exit);
        menuBar.getMenus().add(menuFile);

        zoneButtons.getChildren().addAll(btnCalcul, btnClear);
        infosBox.getChildren().addAll(datas.getDatas(), results.getResults());
        rootScene.getChildren().addAll(infosBox, zoneButtons);

        root.getChildren().addAll(menuBar, rootScene);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
