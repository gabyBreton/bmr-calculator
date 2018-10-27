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

    /**
     * Creates a new tab pane that contains line charts.
     */
    ChartTabPane() {
        super();
        makeLineCharts();
        makeTabs();
        addChartsToTabs();
        this.getTabs().addAll(tabWeightBMR, tabWeightCal, tabHeightBMR);
    }

    /**
     * Creates the 3 line charts.
     */
    private void makeLineCharts() {
        initChartWeightBMR();
        initChartWeightCal();
        initChartHeightBMR();
    }

    /**
     * Initialize the 'Weight Vs BMR' line chart.
     */
    private void initChartWeightBMR() {
        NumberAxis xAxis = makeXAxis("Weight (kg)");
        NumberAxis yAxis = makeYAxis("BMR");
        chartWeightBMR = new LineCharts("Weight (kg) Vs BMR", xAxis, yAxis);
    }

    /**
     * Initialize the 'Weight Vs Calories' line chart.
     */
    private void initChartWeightCal() {
        NumberAxis xAxis = makeXAxis("Weight (kg)");
        NumberAxis yAxis = makeYAxis("Calories");
        chartWeightCal = new LineCharts("Weight (kg) Vs Calories", xAxis, yAxis);
    }

    /**
     * Initialize the 'Height Vs BMR' line chart.
     */
    private void initChartHeightBMR() {
        NumberAxis xAxis = makeXAxis("Height (cm)");
        NumberAxis yAxis = makeYAxis("BMR");
        chartHeightBMR = new LineCharts("Height (cm) Vs BMR", xAxis, yAxis);
    }

    /**
     * Makes an XAxis for a line chart.
     * 
     * @param label the label of the axis.
     * @return the new axis.
     */
    private NumberAxis makeXAxis(String label) {
        NumberAxis xAxis = new NumberAxis(0, 200, 25);
        xAxis.setLabel(label);
        return xAxis;
    }

    /**
     * Makes an YAxis for a line chart.
     * 
     * @param label the label of the axis.
     * @return the new axis.
     */
    private NumberAxis makeYAxis(String label) {
        NumberAxis yAxis = new NumberAxis(0, 3000, 250);
        yAxis.setLabel(label);
        return yAxis;
    }

    /**
     * Makes tabs.
     */
    private void makeTabs() {
        tabWeightBMR = new Tab("Weight (kg) Vs BMR");
        tabWeightCal = new Tab("Weight (kg) Vs Calories");
        tabHeightBMR = new Tab("Height (cm) Vs BMR");
    }

    /**
     * Adds line charts to tabs.
     */
    private void addChartsToTabs() {
        tabWeightBMR.setContent(chartWeightBMR);
        tabWeightCal.setContent(chartWeightCal);
        tabHeightBMR.setContent(chartHeightBMR);

    }

    /**
     * Return the line chart 'Height Vs BMR'.
     * 
     * @return the line chart 'Height Vs BMR'.
     */
    LineCharts getChartHeightBMR() {
        return chartHeightBMR;
    }

    /**
     * Return the line chart 'Weight Vs BMR'.
     * 
     * @return the line chart 'Weight Vs BMR'.
     */    
    LineCharts getChartWeightBMR() {
        return chartWeightBMR;
    }

    /**
     * Return the line chart 'Weight Vs Calories'.
     * 
     * @return the line chart 'Weight Vs Calories.
     */    
    LineCharts getChartWeightCal() {
        return chartWeightCal;
    }
}
