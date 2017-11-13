package td3.bmr.breton.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import td3.bmr.breton.model.BMRCalculator;


//TO-DO: REMOVE ALERTS AND SAY INVALID FIELDS !
//NO EXCEPTIONS THROWED.

/**
 * This class provides methods to create, set and launch the BMR calculator.
 *
 * @author Gabriel Breton - 43397
 */
public class BMRfx extends Application {

    private BMRCalculator person;
    private DatasPane datas;
    private ResultsPane results;
    private LineCharts lineChart;

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
        setStage(primaryStage);
        BorderPane root = new BorderPane();
        VBox dataResultBtnZone = makeDataResultBtnZone(); 
        VBox zoneButtons = makeZoneButtons(); 
        HBox infosBox = makeInfosBox(); // zone with users datas & results

        datas = new DatasPane(); //datas-zone of user
        results = new ResultsPane(); //results-zone of user
        person = new BMRCalculator();
        lineChart = new LineCharts("BMR Index Vs Weight", "Weight (kg)", "BMR");
        
        person.addAllObserver(results, lineChart);

        Alert alert = makeAlert();
        Button btnCalcul = makeButtonCalcul(alert);
        Button btnClear = makeButtonClear();
        MenuBar menuBar = makeMenuBar();

        zoneButtons.getChildren().addAll(btnCalcul, btnClear);
        infosBox.getChildren().addAll(datas.getDatas(), results.getResults());
        dataResultBtnZone.getChildren().addAll(infosBox, zoneButtons);
        
        root.setTop(menuBar);
        root.setLeft(dataResultBtnZone);
        root.setCenter(lineChart.getLineChart());
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setStage(Stage primaryStage) {
        primaryStage.setTitle("BMR Calculator");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
    }

    private HBox makeInfosBox() {
        HBox infosBox = new HBox(); 
        infosBox.setPadding(new Insets(7));
        return infosBox;
    }

    private VBox makeZoneButtons() {
        VBox zoneButtons = new VBox();
        zoneButtons.setSpacing(11);
        return zoneButtons;
    }

    private VBox makeDataResultBtnZone() {
        VBox dataResultBtnZone = new VBox();
        dataResultBtnZone.setPadding(new Insets(6));
        return dataResultBtnZone;
    }

    private MenuBar makeMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        
        MenuItem exit = makeActionExit();
        menuFile.getItems().add(exit);
        menuBar.getMenus().add(menuFile);
        return menuBar;
    }

    private MenuItem makeActionExit() {
        MenuItem exit = new MenuItem("Exit");
        
        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });
        
        return exit;
    }

    private Button makeButtonClear() {
        Button btnClear = new Button("Clear");
        btnClear.setMaxWidth(Double.MAX_VALUE);
        
        btnClear.setOnAction((ActionEvent event) -> {
            datas.clearAllFields();
            results.clearAllFields();
        });
        
        return btnClear;
    }

    private Alert makeAlert() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Encoding error");
        alert.setContentText("Enter a value strictly superior to zero.");
        return alert;
    }

    private Button makeButtonCalcul(Alert alert) {
        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        btnCalcul.setOnAction((ActionEvent event) -> {
            try {
                person.setHeight(datas.getHeight());
            } catch (NumberFormatException nbrException) {
                alertHeight(alert);
            }

            try {
                person.setWeight(datas.getWeight());
            } catch (NumberFormatException nbrException) {
                alertWeight(alert);
            }

            try {
                person.setAge(datas.getAge());
                person.setGender(datas.getRbWomen());
                person.setLifestyle(datas.getCbLifestyle());
                person.calculateCalories();
            } catch (NumberFormatException nbrException) {
                alertAge(alert);
            }
        });
        return btnCalcul;
    }

    private void alertAge(Alert alert) {
        alert.setHeaderText("Value of the age incorrect.");
        alert.showAndWait();
        results.showErrorsMessages();
    }

    private void alertWeight(Alert alert) {
        alert.setHeaderText("Value of the weight incorrect.");
        alert.showAndWait();
        results.showErrorsMessages();
    }

    private void alertHeight(Alert alert) {
        alert.setHeaderText("Value of the height incorrect.");
        alert.showAndWait();
        results.showErrorsMessages();
    }
}
