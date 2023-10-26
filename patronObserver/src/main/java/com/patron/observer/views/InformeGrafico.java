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

public class InformeGrafico extends JFrame implements Observador {

    private DefaultCategoryDataset conjuntoDatosPresion;
    private DefaultCategoryDataset conjuntoDatosHumedad;
    private DefaultCategoryDataset conjuntoDatosTemperatura;
    private ChartPanel panelGraficoTemperatura;
    private ChartPanel panelGraficoHumedad;
    private ChartPanel panelGraficoPresion;

    public InformeGrafico() {
        crearComponentesIU();
    }

    private void crearComponentesIU() {

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Graphic Report");
        this.setSize(700, 500);

        conjuntoDatosPresion = new DefaultCategoryDataset();
        conjuntoDatosHumedad = new DefaultCategoryDataset();
        conjuntoDatosTemperatura = new DefaultCategoryDataset();

        JFreeChart graficoPresion = obtenerGraficoBarras(conjuntoDatosPresion);
        JFreeChart graficoHumedad = obtenerGraficoBarras(conjuntoDatosHumedad);
        JFreeChart graficoTemperatura = obtenerGraficoBarras(conjuntoDatosTemperatura);



        graficoHumedad.getCategoryPlot().getRangeAxis().setRange(0, 60);
        graficoTemperatura.getCategoryPlot().getRangeAxis().setRange(0, 30);
        graficoPresion.getCategoryPlot().getRangeAxis().setRange(0, 1000);

        // set colors
        graficoPresion.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.BLUE);
        graficoHumedad.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.GREEN);
        graficoTemperatura.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);

        // Look more modern and minimalistic
        graficoPresion.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Sans-Serif", Font.PLAIN, 12));
        graficoPresion.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("Sans-Serif", Font.PLAIN, 12));
        graficoHumedad.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("Sans-Serif", Font.PLAIN, 12));

        // Bar look more modern and minimalistic, because default looks like 3D

        panelGraficoPresion = new ChartPanel(graficoPresion);
        panelGraficoHumedad = new ChartPanel(graficoHumedad);
        panelGraficoTemperatura = new ChartPanel(graficoTemperatura);

        panel1.add(panelGraficoPresion);
        panel1.add(panelGraficoHumedad);
        panel1.add(panelGraficoTemperatura);

        setContentPane(panel1);

        this.setVisible(true);
        // Set location in right top corner
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth(), 0);
    }

    private JFreeChart obtenerGraficoBarras(DefaultCategoryDataset dataset) {
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
        conjuntoDatosPresion.clear();
        conjuntoDatosHumedad.clear();
        conjuntoDatosTemperatura.clear();

        conjuntoDatosPresion.addValue(data.obtenerPresion(), "Pressure", "Pressure");
        conjuntoDatosHumedad.addValue(data.obtenerHumedad(), "Humidity", "Humidity");
        conjuntoDatosTemperatura.addValue(data.obtenerTemperatura(), "Temperature", "Temperature");

        panelGraficoPresion.repaint();
        panelGraficoHumedad.repaint();
        panelGraficoTemperatura.repaint();
    }
}
