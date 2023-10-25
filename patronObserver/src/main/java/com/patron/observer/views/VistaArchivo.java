package com.patron.observer.views;

import com.patron.observer.implementation.Observador;

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
    public void actualizar(Map<String, Double> estado) {
        try (FileWriter writer = new FileWriter(archivoNombre, true)) {
            writer.write(estado + "\n");
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