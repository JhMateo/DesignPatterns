package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableReport extends JFrame implements Observador {

    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);
    private List<Object[]> dataHistory = new ArrayList<>(); // Historial de datos o historico

    public TableReport() {
        createUIComponents();
    }

    private void createUIComponents() {
        setTitle("Table Report");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Se crea un panel y se establece el diseño
        JPanel panel = new JPanel(new BorderLayout());

        // SE personaliza la apariencia de la tabla
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.getTableHeader().setFont(new Font("Sans-Serif", Font.BOLD, 14));
        table.setFont(new Font("Sans-Serif", Font.PLAIN, 12));

        // Aqui se agrgaron las columnas
        model.addColumn("ObservationDate");
        model.addColumn("Temperature");
        model.addColumn("Humidity");
        model.addColumn("Pressure");

        // Se Crea un panel de desplazamiento y agregamos la tabla a el
        JScrollPane scrollPane = new JScrollPane(table);

        // Agrega el panel de desplazamiento al panel principal
        panel.add(scrollPane, BorderLayout.CENTER);

        // Establecemos el contenido del marco como el panel principal
        setContentPane(panel);

        // Establecemos la ubicación en la esquina superior izquierda
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actualizar(SensorData data) {
        Object[] rowData = {
                data.getObservationDate().toString(), // fecha
                data.getTemperature(),
                data.getHumidity(),
                data.getPressure()
        };
        dataHistory.add(rowData);
        refreshTable();
    }

    private void refreshTable() {
        model.setRowCount(0); // Limpiamos la tabla antes de llenarla con los datos historicos.
        for (Object[] rowData : dataHistory) {
            model.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableReport();
        });
    }
}
