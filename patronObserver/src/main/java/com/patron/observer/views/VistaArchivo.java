package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

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
    public void actualizar(SensorData estado) {
        try (FileWriter writer = new FileWriter(archivoNombre, true)) {
                writer.write("Id: " + estado.getId() + "\n");
                writer.write("Temperatura: " + estado.obtenerTemperatura() + "\n");
                writer.write("Humedad: " + estado.obtenerHumedad() + "\n");
                writer.write("Presión: " + estado.obtenerPresion() + "\n");
                writer.write("Fecha de Observación: " + estado.obtenerObservacionFecha() + "\n\n");
            }
        catch (IOException e) {
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