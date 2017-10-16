package td3.bmr.breton.view;

import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import td3.bmr.breton.model.LifeStyle;


/**
 *
 * @author Gabriel Breton - 43397
 */
public class DatasUI {
    
    private GridPane datas;
    private TextField tfdSize;
    private TextField tfdWeight;
    private TextField tfdAge;
    private RadioButton rbMen, rbWomen;
    private ChoiceBox cbLifestyle;

    private void initGridPane (){
        datas = new GridPane(); //datas of user
        datas.setPadding(new Insets(5));
        datas.setHgap(10);
        datas.setVgap(15);  
    }

    private void addTitle() {
        Label datasTitle = new Label("Datas");
        datasTitle.setUnderline(true);
        datas.add(datasTitle, 0, 0);        
    }
    
    private void addLabels() {
        Label lblSize = new Label("Size (cm)");
        datas.add(lblSize, 0, 1);
        
        Label lblWeight = new Label("Weight (kg)");
        datas.add(lblWeight, 0, 2);

        Label lblAge = new Label("Age (years)");
        datas.add(lblAge, 0, 3);        
        
        Label lblSex = new Label("Sex");
        datas.add(lblSex, 0, 4);        
        
        Label lblLifeStyle = new Label("Lifestyle");
        datas.add(lblLifeStyle, 0, 5);
    }
    
    private void addTextFields() {
        tfdSize = new TextField();
        tfdSize.setPromptText("Size in cm");
        datas.add(tfdSize, 1, 1);
        
        tfdWeight = new TextField();
        tfdWeight.setPromptText("Weight in kg");
        datas.add(tfdWeight, 1, 2);
        
        tfdAge = new TextField();
        tfdAge.setPromptText("Age in years");
        datas.add(tfdAge, 1, 3);
    }

    private void addGenderButtons() {
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
        datas.add(sexChoice, 1, 4);
    }
    
    private void addLifestyleChoiceBox() {
        cbLifestyle = new ChoiceBox();
        cbLifestyle.getItems().addAll(LifeStyle.values());
        cbLifestyle.getSelectionModel().selectFirst();
        datas.add(cbLifestyle, 1, 5);   
    }

    void initAndSet() {
        initGridPane();
        addTitle();
        addLabels();
        addTextFields();
        addGenderButtons();
        addLifestyleChoiceBox();
    }
    
    public GridPane getDatas() {
        return datas;
    }

//    public void setDatas(GridPane datas) {
//        this.datas = datas;
//    }

    public TextField getTfdSize() {
        return tfdSize;
    }

    public TextField getTfdWeight() {
        return tfdWeight;
    }

    public TextField getTfdAge() {
        return tfdAge;
    }

    public RadioButton getRbMen() {
        return rbMen;
    }

    public RadioButton getRbWomen() {
        return rbWomen;
    }

    public ChoiceBox getCbLifestyle() {
        return cbLifestyle;
    }
}
