package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GraphReport extends JFrame implements Observador {

    private DefaultCategoryDataset datasetPressure;
    private DefaultCategoryDataset datasetHumidity;
    private DefaultCategoryDataset datasetTemperature;
    private ChartPanel chartPanelTemperture;
    private ChartPanel chartPanelHumidity;
    private ChartPanel chartPanelPressure;

    public GraphReport() {
        createUIComponents();
    }

    private void createUIComponents() {

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Graphic Report");
        this.setSize(700, 500);

        datasetPressure = new DefaultCategoryDataset();
        datasetHumidity = new DefaultCategoryDataset();
        datasetTemperature = new DefaultCategoryDataset();

        JFreeChart chartPressure = getBarChart(datasetPressure);
        JFreeChart chartHumidity = getBarChart(datasetHumidity);
        JFreeChart chartTemperature = getBarChart(datasetTemperature);

        chartHumidity.getCategoryPlot().getRangeAxis().setRange(0, 60);
        chartTemperature.getCategoryPlot().getRangeAxis().setRange(0, 30);
        chartPressure.getCategoryPlot().getRangeAxis().setRange(0, 1000);

        // set colors
        chartPressure.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.BLUE);
        chartHumidity.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.GREEN);
        chartTemperature.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);

        // Look more modern and minimalistic
        chartPressure.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Sans-Serif", Font.PLAIN, 12));
        chartPressure.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Sans-Serif", Font.PLAIN, 12));
        chartHumidity.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Sans-Serif", Font.PLAIN, 12));

        // Bar look more modern and minimalistic, because default looks like 3D

        chartPanelPressure = new ChartPanel(chartPressure);
        chartPanelHumidity = new ChartPanel(chartHumidity);
        chartPanelTemperture = new ChartPanel(chartTemperature);

        panel1.add(chartPanelPressure);
        panel1.add(chartPanelHumidity);
        panel1.add(chartPanelTemperture);

        setContentPane(panel1);

        this.setVisible(true);
        // Set location in right top corner
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth(), 0);
    }

    private JFreeChart getBarChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Sensor Data",
                "Measure",
                "Value",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
    }

    @Override
    public void actualizar(SensorData data) {
        datasetPressure.clear();
        datasetHumidity.clear();
        datasetTemperature.clear();

        datasetPressure.addValue(data.getPressure(), "Pressure", "Pressure");
        datasetHumidity.addValue(data.getHumidity(), "Humidity", "Humidity");
        datasetTemperature.addValue(data.getTemperature(), "Temperature", "Temperature");

        chartPanelPressure.repaint();
        chartPanelHumidity.repaint();
        chartPanelTemperture.repaint();
    }
}
