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
public class DatasGridPane {
    
    private GridPane datas;
    
    void initGridPane (){
        datas = new GridPane(); //datas of user
        datas.setPadding(new Insets(5));
        datas.setHgap(10);
        datas.setVgap(15);  
    }

    void addTitle() {
        Label datasTitle = new Label("Données");
        datasTitle.setUnderline(true);
        datas.add(datasTitle, 0, 0);        
    }
    
    void addLabels() {
        Label lblSize = new Label("Taille (cm)");
        datas.add(lblSize, 0, 1);
        
        Label lblWeight = new Label("Poids (kg)");
        datas.add(lblWeight, 0, 2);

        Label lblAge = new Label("Age (années)");
        datas.add(lblAge, 0, 3);        
        
        Label lblSex = new Label("Sexe");
        datas.add(lblSex, 0, 4);        
        
        Label lblLifeStyle = new Label("Style de vie");
        datas.add(lblLifeStyle, 0, 5);
    }
    
    void addTextFields() {
        TextField tfdSize = new TextField();
        tfdSize.setPromptText("Taille en cm");
        datas.add(tfdSize, 1, 1);
        
        TextField tfdWeight = new TextField();
        tfdWeight.setPromptText("Poids en kg");
        datas.add(tfdWeight, 1, 2);
        
        TextField tfdAge = new TextField();
        tfdAge.setPromptText("Age en années");
        datas.add(tfdAge, 1, 3);
    }
    
    void addLifeStyleChoiceBox() {
        ChoiceBox cbLifeStyle = new ChoiceBox();
        cbLifeStyle.getItems().addAll(LifeStyle.values());
        cbLifeStyle.getSelectionModel().selectFirst();
        datas.add(cbLifeStyle, 1, 5);   
    }

    void addGenderButtons() {
        //create radio button group
        final ToggleGroup groupChoiceSex = new ToggleGroup();

        RadioButton rbWomen = new RadioButton("Femme");
        RadioButton rbMen = new RadioButton("Homme");
        rbWomen.setToggleGroup(groupChoiceSex);
        rbMen.setToggleGroup(groupChoiceSex);
        rbWomen.setSelected(true);

        HBox sexChoice = new HBox(20);
        sexChoice.getChildren().addAll(rbWomen, rbMen);
        datas.add(sexChoice, 1, 4);
    }



    
    public GridPane getDatas() {
        return datas;
    }

    public void setDatas(GridPane datas) {
        this.datas = datas;
    }
    
    
}
