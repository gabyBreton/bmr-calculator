package td3.bmr.breton.view;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import td3.bmr.breton.model.Lifestyle;

/**
 * This class provides methods to create, init and set the Datas GridPane.
 *
 * @author Gabriel Breton - 43397
 */
class DatasPane extends GridPane {

    //private GridPane datas;    //useless
    private TextField tfdHeight;  
    private TextField tfdWeight;
    private TextField tfdAge;
    private RadioButton rbMen, rbWomen;
    private ChoiceBox cbLifestyle;

    DatasPane() {
        super();
        setGridPane();
        initLabelsTfdButtons();
    }

    /**
     * Initialize and set the components of the GridPane.
     */
    private void initLabelsTfdButtons() {
      //  initGridPane();
        makeTitle();
        makeLabels();
        makeTextFields();
        makeGenderButtons();
        makeLifestyleChoiceBox();
    }

    /**
     * Initialize the Datas GridPane.
     */
    private void setGridPane() {
        this.setPadding(new Insets(5));
        this.setHgap(10);
        this.setVgap(15);
    }

    /**
     * Add the title on the GridPane.
     */
    private void makeTitle() {
        Label datasTitle = new Label("Datas");
        datasTitle.setUnderline(true);
        this.add(datasTitle, 0, 0);
    }

    /**
     * Add all the labels on the GridPane.
     */
    private void makeLabels() {
        Label lblSize = new Label("Size (cm)");
        this.add(lblSize, 0, 1);

        Label lblWeight = new Label("Weight (kg)");
        this.add(lblWeight, 0, 2);

        Label lblAge = new Label("Age (years)");
        this.add(lblAge, 0, 3);

        Label lblSex = new Label("Sex");
        this.add(lblSex, 0, 4);

        Label lblLifeStyle = new Label("Lifestyle");
        this.add(lblLifeStyle, 0, 5);
    }

    /**
     * Add all the texfields on the GridPane.
     */
    private void makeTextFields() {
        makeTextFieldHeight();
        this.add(tfdHeight, 1, 1);

        makeTextFieldWeight();
        this.add(tfdWeight, 1, 2);

        makeTextFieldAge();
        this.add(tfdAge, 1, 3);
    }
    
    /**
     * Makes the textfield age.
     */
    private void makeTextFieldAge() {
        tfdAge = new TextField();
        tfdAge.setPromptText("Age in years");
        filterTfdDouble(tfdAge);
    }
    
    /**
     * Makes the textfield weight.
     */
    private void makeTextFieldWeight() {
        tfdWeight = new TextField();
        tfdWeight.setPromptText("Weight in kg");
        filterTfdDouble(tfdWeight);
    }

    /**
     * Makes the textfield height.
     */
    private void makeTextFieldHeight() {
        tfdHeight = new TextField();
        tfdHeight.setPromptText("Size in cm");
        filterTfdDouble(tfdHeight);
    }

    /**
     * Add a filter to a textfield to get only double values entered.
     * 
     * @param textField the textfield where to add a filter.
     */
    private void filterTfdDouble(TextField textField) {
        textField.textProperty().addListener((ObservableValue<? extends String> 
                                              observable, 
                                              String oldValue, 
                                              String newValue) -> {
            if (!newValue.matches("[0-9]*\\.?[0-9]+")) {
                textField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    /**
     * Add the gender choice buttons on the GridPane.
     */
    private void makeGenderButtons() {
        final ToggleGroup groupChoiceSex = new ToggleGroup();
        rbWomen = new RadioButton("Women");
        rbMen = new RadioButton("Men");

        //put buttons in a group and set selection
        rbWomen.setToggleGroup(groupChoiceSex);
        rbMen.setToggleGroup(groupChoiceSex);
        rbWomen.setSelected(true);

        //put buttons in a box and add box in datas.
        HBox sexChoice = new HBox(20);
        sexChoice.getChildren().addAll(rbWomen, rbMen);
        this.add(sexChoice, 1, 4);
    }

    /**
     * Add the lifestyle choice box on the GridPane.
     */
    private void makeLifestyleChoiceBox() {
        cbLifestyle = new ChoiceBox();
        cbLifestyle.getItems().addAll(Lifestyle.values());
        cbLifestyle.getSelectionModel().selectFirst();
        this.add(cbLifestyle, 1, 5);
    }

//    /**
//     * Gives the Datas GridPane.
//     *
//     * @return the Datas GridPane.
//     */
//    GridPane getDatas() {
//        return datas;
//    }

    /**
     * Gives the textfield tfdHeight.
     *
     * @return the textfield Size.
     */
    double getTfdHeight() {
        return Double.valueOf(tfdHeight.getText());
    }

    /**
     * Gives the value of tfdWeight.
     *
     * @return the value of weight.
     */
    double getTfdWeight() {
        return Double.valueOf(tfdWeight.getText());
    }

    /**
     * Gives the textfield tfdAge.
     *
     * @return the textfield Age.
     */
    double getTfdAge() {
        return Double.valueOf(tfdAge.getText());
    }

    /**
     * Gives the radio button rbWomen.
     *
     * @return the radio button Women.
     */
    RadioButton getRbWomen() {
        return rbWomen;
    }

    /**
     * Gives the choicebox cbLifestyle.
     *
     * @return the choicebox lifestyle.
     */
    ChoiceBox getCbLifestyle() {
        return cbLifestyle;
    }

    /**
     * Clear the datas fields.
     */
    void clearAllFields() {
        tfdHeight.clear();
        tfdWeight.clear();
        tfdAge.clear();
        cbLifestyle.getSelectionModel().selectFirst();
        rbWomen.setSelected(true);
    }
}
