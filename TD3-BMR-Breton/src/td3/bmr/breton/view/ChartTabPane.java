package td3.bmr.breton.view;

import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * This class is used to create and manage the tabpane for the line charts.
 *
 * @author Gabriel Breton - 43397
 */
class ChartTabPane extends TabPane {

    private LineCharts chartHeightBMR;
    private LineCharts chartWeightBMR;
    private LineCharts chartWeightCal;
    
    private Tab tabHeightBMR;    
    private Tab tabWeightBMR;    
    private Tab tabWeightCal;    
    
    ChartTabPane() {
        super();
        initChartHeightBMR();
        initChartWeightBMR();
        initChartWeightCal();
        makeTabs();
        this.getTabs().addAll(tabWeightBMR, tabWeightCal, tabHeightBMR);
    }

    private void makeTabs() {
        tabWeightBMR = new Tab("Weight (kg) Vs BMR");
        tabWeightCal = new Tab("Weight (kg) Vs Calories");
        tabHeightBMR = new Tab("Height (cm) Vs BMR");        
        addChartsToTabs();
    }

    private void addChartsToTabs() {
        tabWeightBMR.setContent(chartWeightBMR);
        tabWeightCal.setContent(chartWeightCal);
        tabHeightBMR.setContent(chartHeightBMR);
        
    }

    private void initChartHeightBMR() {
        NumberAxis xAxis = makeXAxis("Height (cm)");
        NumberAxis yAxis = makeYAxis("BMR");
        chartHeightBMR = new LineCharts("Height (cm) Vs BMR", xAxis, yAxis);
    }
    
    private void initChartWeightBMR() {
        NumberAxis xAxis = makeXAxis("Weight (kg)");
        NumberAxis yAxis = makeYAxis("BMR");
        chartWeightBMR = new LineCharts("Weight (kg) Vs BMR", xAxis, yAxis);
    }
    
    private void initChartWeightCal() {
        NumberAxis xAxis = makeXAxis("Weight (kg)");
        NumberAxis yAxis = makeYAxis("Calories");
        chartWeightCal = new LineCharts("Weight (kg) Vs Calories", xAxis, yAxis);
    }
    
    private NumberAxis makeXAxis(String label) {
        NumberAxis xAxis = new NumberAxis(0, 200, 25);
        xAxis.setLabel(label);
        return xAxis;
    }
    
    private NumberAxis makeYAxis(String label) {
        NumberAxis yAxis = new NumberAxis(0, 3000, 250);
        yAxis.setLabel(label);
        return yAxis;
    }

    LineCharts getChartHeightBMR() {
        return chartHeightBMR;
    }
    
    LineCharts getChartWeightBMR() {
        return chartWeightBMR;
    }
    
    LineCharts getChartWeightCal() {
        return chartWeightCal;
    }
}
