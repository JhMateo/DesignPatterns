package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VistaArchivo implements Observador {
    private String archivoNombre;

    public VistaArchivo(String archivoNombre) {
        this.archivoNombre = archivoNombre;
        limpiarArchivo(archivoNombre);
    }

    @Override
    public void actualizar(Map<String, SensorData> estado) {
        try (FileWriter writer = new FileWriter(archivoNombre, true)) {
            for (Map.Entry<String, SensorData> entry : estado.entrySet()) {
                SensorData sensorData = entry.getValue();

                writer.write("Id: " + sensorData.getId() + "\n");
                writer.write("Temperatura: " + sensorData.getTemperature() + "\n");
                writer.write("Humedad: " + sensorData.getHumidity() + "\n");
                writer.write("Presión: " + sensorData.getPressure() + "\n");
                writer.write("Fecha de Observación: " + sensorData.getObservationDate() + "\n\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private void limpiarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}