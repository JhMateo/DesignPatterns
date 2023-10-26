package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InformeTabla extends JFrame implements Observador {

    private DefaultTableModel modelo = new DefaultTableModel();
    private JTable tabla = new JTable(modelo);
    private List<Object[]> historico = new ArrayList<>(); // Historial de datos o historico

    public InformeTabla() {
        crearComponentesIU();
    }

    private void crearComponentesIU() {
        setTitle("Table Report");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 600); // Cambiar el tamaño de la ventana a 800x600

        // Se crea un panel y se establece el diseño
        JPanel panel = new JPanel(new BorderLayout());

        // SE personaliza la apariencia de la tabla
        tabla.setRowHeight(30);
        tabla.setShowGrid(true);
        tabla.getTableHeader().setFont(new Font("Sans-Serif", Font.BOLD, 14));
        tabla.setFont(new Font("Sans-Serif", Font.PLAIN, 12));

        // Aqui se agrgaron las columnas
        modelo.addColumn("ObservationDate");
        modelo.addColumn("Temperature");
        modelo.addColumn("Humidity");
        modelo.addColumn("Pressure");

        // Se Crea un panel de desplazamiento y agregamos la tabla a el
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Agrega el panel de desplazamiento al panel principal
        panel.add(scrollPane, BorderLayout.CENTER);

        // Establecemos el contenido del marco como el panel principal
        setContentPane(panel);

        // Establecemos la ubicación en el centro de la pantalla
        //setLocationRelativeTo(null); // Esto centrará la ventana en la pantalla
        setVisible(true);
    }

    @Override
    public void actualizar(SensorData data) {
        Object[] rowData = {
                data.obtenerObservacionFecha().toString(), // fecha
                data.obtenerTemperatura(),
                data.obtenerHumedad(),
                data.obtenerPresion()
        };
        historico.add(rowData);
        actualizarTabla();

        // Desplazar automáticamente hacia abajo para mostrar la última fila
        SwingUtilities.invokeLater(() -> {
            Rectangle rect = tabla.getCellRect(tabla.getRowCount() - 1, 0, true);
            tabla.scrollRectToVisible(rect);
        });
    }

    private void actualizarTabla() {
        modelo.setRowCount(0); // Limpiamos la tabla antes de llenarla con los datos historicos.
        for (Object[] rowData : historico) {
            modelo.addRow(rowData);
        }
    }
}
