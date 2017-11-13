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
public class LineCharts implements Observer {

    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart lineChart;
    private Series womenSeries;
    private Series menSeries;

    @Override
    public void update(BMRCalculator person) {
        if (person.isWomen()) {
            womenSeries.getData().add(new XYChart.Data((int) person.getWeight(), 
                                                       person.getBmr())); 
        } else {
            menSeries.getData().add(new XYChart.Data((int) person.getWeight(), 
                                                     person.getBmr()));
        }
    }

    LineCharts(String title, String xLabel, String yLabel) {
        xAxis = new NumberAxis();
        xAxis.setLabel(xLabel);

        yAxis = new NumberAxis(0, 2250, 250);
        yAxis.setLabel(yLabel);

        womenSeries = makeWomenSeries();
        menSeries = makeMenSeries();
        
        lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle(title);
        lineChart.getData().add(menSeries);
        lineChart.getData().add(womenSeries);
    }

    public LineChart getLineChart() {
        return lineChart;
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
