package td3.bmr.breton.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import td3.bmr.breton.model.BMRCalculator;
import td3.bmr.breton.util.Observer;

/**
 *
 * @author Gabriel Breton - 43397
 */
class LineCharts extends LineChart implements Observer {

    private Series womenSeries;
    private Series menSeries;

    @Override
    public void update(BMRCalculator person) {
        
        if (this.getTitle().matches("Height (cm) Vs BMR")) {
            setSeries(person.isWomen(), person.getHeight(), person.getBmr());
        } 
        
        if (this.getTitle().matches("Weight (kg) Vs Calories")) {
            setSeries(person.isWomen(), person.getWeight(), 
                      person.getCalories());
        }
            
        if (this.getTitle().matches("Weight(kg) Vs BMR")) {
            setSeries(person.isWomen(), person.getWeight(), person.getBmr());
        }
    }

    private void setSeries(boolean isWomen, Double data, Double result) {
        if (isWomen) {
            womenSeries.getData().add(new XYChart.Data(data, result));
        } else {
            menSeries.getData().add(new XYChart.Data(data, result));
        }
    }

    LineCharts(String title, NumberAxis xAxis, NumberAxis yAxis) {
        super(xAxis, yAxis);
        this.setTitle(title);

        womenSeries = makeWomenSeries();
        menSeries = makeMenSeries();
        this.getData().addAll(menSeries, womenSeries);
    }

    private Series makeWomenSeries() {
        womenSeries = new Series();
        womenSeries.setName("WomenData");

        return womenSeries;
    }

    private Series makeMenSeries() {
        menSeries = new Series();
        menSeries.setName("MenData");

        return menSeries;
    }

}
