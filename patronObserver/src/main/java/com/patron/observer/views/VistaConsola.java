package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import java.util.Map;

public class VistaConsola implements Observador {
    @Override
    public void actualizar(Map<String, SensorData> estado) {
        System.out.println("\nDatos recibidos:");

        for (Map.Entry<String, SensorData> entry : estado.entrySet()) {
            SensorData sensorData = entry.getValue();

            System.out.println("Id: " + sensorData.getId());
            System.out.println("Temperatura: " + sensorData.getTemperature());
            System.out.println("Humedad: " + sensorData.getHumidity());
            System.out.println("Presión: " + sensorData.getPressure());
            System.out.println("Fecha de Observación: " + sensorData.getObservationDate());
            System.out.println();
        }
    }
}