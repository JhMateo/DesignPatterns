package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;
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
        this.setSize(400, 300);

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
    public void actualizar(SensorData data) {
        model.setRowCount(0);

        addRow("Temperature", Double.toString(data.getTemperature()));
        addRow("Humidity", Double.toString(data.getHumidity()));
        addRow("Pressure", Double.toString(data.getPressure()));
        addRow("ObservationDate", data.getObservationDate().toString());

    }

    private void addRow(String measure, String value) {
        model.addRow(new Object[]{measure, value});
    }
}
