package td3.bmr.breton.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
/**
 * This class provides methods to create, set and launch the BMR calculator.
 *
 * @author Gabriel Breton - 43397
 */
public class BMRfx extends Application {

    private BMRCalculator person;
    private DatasPane datas;
    private ResultsPane results;
    private ChartTabPane chartTabs;
    
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
     */
    @Override
    public void start(Stage primaryStage) {
        setStage(primaryStage);
        BorderPane root = new BorderPane();
        VBox dataResultBtnZone = makeDataResultBtnZone();
        VBox zoneButtons = makeZoneButtons();
        HBox infosBox = makeInfosBox(); // zone with users datas & results

        datas = new DatasPane(); //datas-zone of user
        results = new ResultsPane(); //results-zone of user
        person = new BMRCalculator();
        chartTabs = new ChartTabPane();
        
        person.addAllObserver(results, chartTabs.getChartWeightBMR(), 
                            chartTabs.getChartWeightCal(), chartTabs.getChartHeightBMR());

        Button btnCalcul = makeButtonCalcul();
        Button btnClear = makeButtonClear();
        MenuBar menuBar = makeMenuBar();

        zoneButtons.getChildren().addAll(btnCalcul, btnClear);
        infosBox.getChildren().addAll(datas, results);
        dataResultBtnZone.getChildren().addAll(infosBox, zoneButtons);

        root.setTop(menuBar);
        root.setLeft(dataResultBtnZone);
        root.setCenter(chartTabs);

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

    private Button makeButtonCalcul() {
        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        btnCalcul.setOnAction((ActionEvent event) -> {
            person.setHeight(datas.getHeight());
            person.setWeight(datas.getTfdWeight());
            person.setAge(datas.getTfdAge());
            person.setGender(datas.getRbWomen());
            person.setLifestyle(datas.getCbLifestyle());
            person.calculateCalories();
        });
        return btnCalcul;
    }
}
