package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class TableReport extends JFrame implements Observador {

    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);

    public TableReport() {
        createUIComponents();
    }

    private void createUIComponents() {
        this.setTitle("Table Report");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        // Create a panel and set a modern layout
        JPanel panel = new JPanel(new BorderLayout());

        // Customize table appearance
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.getTableHeader().setFont(new Font("Sans-Serif", Font.BOLD, 14));
        table.setFont(new Font("Sans-Serif", Font.PLAIN, 12));

        // Add table columns
        model.addColumn("Measure");
        model.addColumn("Value");

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        this.setContentPane(panel);

        // Set location to top left corner
        this.setLocation(0, 0);
        this.setVisible(true);
    }

    @Override
    public void actualizar(Map<String, SensorData> data) {
        model.setRowCount(0);

        for (Map.Entry<String, SensorData> entry : data.entrySet()) {
            SensorData sensorData = entry.getValue();

            addRow("Temperature", sensorData.getTemperature());
            addRow("Humidity", sensorData.getHumidity());
            addRow("Pressure", sensorData.getPressure());
            // TODO: Aquí siempre pide que sea double, why? :v
            //  por eso no deja imprimir la fecha
            // addRow("ObservationDate", sensorData.getObservationDate());

        }
    }

    private void addRow(String measure, Double value) {
        model.addRow(new Object[]{measure, value});
    }
}
