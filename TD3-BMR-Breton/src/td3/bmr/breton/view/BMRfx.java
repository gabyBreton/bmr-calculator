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

        makeAttributs();
        person.addAllObserver(results, chartTabs.getChartWeightBMR(), 
                              chartTabs.getChartWeightCal(), 
                              chartTabs.getChartHeightBMR());

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

    private void makeAttributs() {
        datas = new DatasPane(); //datas-zone of user
        results = new ResultsPane(); //results-zone of user
        person = new BMRCalculator();
        chartTabs = new ChartTabPane();
    }

    /**
     * Set the stage of the application.
     * 
     * @param primaryStage the primary stage of the application.
     */
    private void setStage(Stage primaryStage) {
        primaryStage.setTitle("BMR Calculator");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
    }

    /**
     * Makes the box for the infos (datas and results)
     * 
     * @return the new box.
     */
    private HBox makeInfosBox() {
        HBox infosBox = new HBox();
        infosBox.setPadding(new Insets(7));
        return infosBox;
    }

    /**
     * Makes the box that will contains the buttons (clear and calculate)
     * 
     * @return the new box.
     */
    private VBox makeZoneButtons() {
        VBox zoneButtons = new VBox();
        zoneButtons.setSpacing(11);
        return zoneButtons;
    }

    /**
     * Makes the box that will contains the boxes for the buttons and the infos.
     * 
     * @return the new box.
     */
    private VBox makeDataResultBtnZone() {
        VBox dataResultBtnZone = new VBox();
        dataResultBtnZone.setPadding(new Insets(6));
        return dataResultBtnZone;
    }

    /**
     * Makes the menu bar.
     * 
     * @return the new menu bar.
     */
    private MenuBar makeMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");

        MenuItem exit = makeItemExit();
        menuFile.getItems().add(exit);
        menuBar.getMenus().add(menuFile);
        return menuBar;
    }

    /**
     * Makes the menu item exit.
     * 
     * @return the new menu item.
     */
    private MenuItem makeItemExit() {
        MenuItem exit = new MenuItem("Exit");

        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        return exit;
    }

    /**
     * Makes the button to clear the datas and results.
     * 
     * @return the new button.
     */
    private Button makeButtonClear() {
        Button btnClear = new Button("Clear");
        btnClear.setMaxWidth(Double.MAX_VALUE);

        btnClear.setOnAction((ActionEvent event) -> {
            datas.clearAllFields();
            results.clearAllFields();
            //CLEAR SERIES
        });

        return btnClear;
    }

    /**
     * Makes the button to calculate the BMR.
     * 
     * @return the new button.
     */
    private Button makeButtonCalcul() {
        Button btnCalcul = new Button("Calculate the BMR");
        btnCalcul.setMaxWidth(Double.MAX_VALUE);
        btnCalcul.setOnAction((ActionEvent event) -> {
            setPersonAttributs();
            person.calculateCalories();
        });
        return btnCalcul;
    }

    /**
     * Set the attributs of the person, based on the datas.
     */
    private void setPersonAttributs() {
        person.setHeight(datas.getTfdHeight());
        person.setWeight(datas.getTfdWeight());
        person.setAge(datas.getTfdAge());
        person.setWomen(datas.getRbWomen().isSelected());
        person.setLifestyle(datas.getCbLifestyle());
    }
}
